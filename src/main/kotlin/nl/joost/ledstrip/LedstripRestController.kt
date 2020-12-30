package nl.joost.ledstrip

import com.github.mbelling.ws281x.Color
import com.github.mbelling.ws281x.LedStrip
import com.github.mbelling.ws281x.LedStripType
import com.github.mbelling.ws281x.Ws281xLedStrip
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping ("/")
class LedstripRestController (
        val channelHandler: ChannelHandler
) {

    companion object {
        val logger = LoggerFactory.getLogger(this::class.java)
    }

    @GetMapping ("on/rainbow", "on/rainbow/{delay}")
    fun rainbow(@PathVariable delay: Long?) {
        runBlocking {
            logger.info("Regenboogje")
            channelHandler.channel.send(Rainbow(delay))
        }
    }

    @GetMapping ("on/kitt/{color}", "on/kitt/{color}/{delay}")
    fun kitt (@PathVariable color: Color, @PathVariable delay: Long?) {
        runBlocking {
            logger.info("Kitt")
            channelHandler.channel.send(Kitt(color.red, color.green, color.blue, delay))
        }
    }

    @GetMapping ("on/wave/{color}", "on/wave/{color}/{delay}")
    fun wave(@PathVariable color: Color, @PathVariable delay: Long?) {
        runBlocking {
            logger.info("Wave")
            channelHandler.channel.send(Wave(color.red, color.green, color.blue, delay))
        }
    }

    @GetMapping ("on/color/{color}")
    fun predefinedColor(@PathVariable color: Color) {
        runBlocking {
            logger.info("Statisch")
            channelHandler.channel.send(Static(color.red, color.green, color.blue))
        }
    }

    @GetMapping ("on/color/{red}/{green}/{blue}")
    fun customColor(@PathVariable red: Int, @PathVariable green: Int, @PathVariable blue: Int) {
        runBlocking {
            logger.info("Custom statisch")
            channelHandler.channel.send(Static(red, green, blue))
        }
    }

    @GetMapping ("on/runninglights/{color}", "on/runninglights/{color}/{delay}")
    fun runningLights(@PathVariable color: Color, @PathVariable delay: Long?) {
        runBlocking {
            logger.info("Running Lights")
            channelHandler.channel.send(RunningLights(color.red, color.green, color.blue, delay))
        }
    }
}
