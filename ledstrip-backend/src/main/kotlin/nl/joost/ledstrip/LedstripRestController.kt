package nl.joost.ledstrip

import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping ("/")
class LedstripRestController (
        val channelHandler: ChannelHandler
) {

    companion object {
        val logger = LoggerFactory.getLogger(this::class.java)
    }

    @PostMapping (path = ["on/rainbow"], consumes = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun rainbow(@RequestBody color: ColorPattern) {
        runBlocking {
            logger.info("Regenboogje")
            channelHandler.channel.send(Rainbow(color.delay, color.brightness))
        }
    }

    @PostMapping(path = ["on/kitt"], consumes = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun kitt (@RequestBody color: ColorPattern) {
        runBlocking {
            logger.info("Kitt")
            channelHandler.channel.send(Kitt(color))
        }
    }

    @PostMapping(path = ["on/wave"], consumes = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun wave(@RequestBody color: ColorPattern) {
        runBlocking {
            logger.info("Wave")
            channelHandler.channel.send(Wave(color))
        }
    }

    @PostMapping(path = ["on/runninglights"], consumes = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun runningLights(@RequestBody color: ColorPattern) {
        runBlocking {
            logger.info("Running Lights")
            channelHandler.channel.send(RunningLights(color))
        }
    }

    @PostMapping (path = ["on/color"], consumes = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun customColor(@RequestBody color: ColorBrightness) {
        runBlocking {
            logger.info("Custom statisch")
            channelHandler.channel.send(Static(color))
        }
    }
}
