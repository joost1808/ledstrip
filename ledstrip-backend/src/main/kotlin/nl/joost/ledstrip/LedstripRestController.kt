package nl.joost.ledstrip

import com.github.mbelling.ws281x.Color
import com.github.mbelling.ws281x.LedStrip
import com.github.mbelling.ws281x.LedStripType
import com.github.mbelling.ws281x.Ws281xLedStrip
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
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

    @GetMapping ("on/rainbow")
    fun rainbow(@RequestParam (name="delay", required = false) delay: Long?) {
        runBlocking {
            logger.info("Regenboogje")
            channelHandler.channel.send(Rainbow(delay))
        }
    }

    @GetMapping ("on/kitt")
    fun kitt (@RequestParam (name="color", required = true) color: Color,
              @RequestParam (name="delay", required = false) delay: Long?) {
        runBlocking {
            logger.info("Kitt")
            channelHandler.channel.send(Kitt(color.red, color.green, color.blue, delay))
        }
    }

    @GetMapping ("on/wave")
    fun wave(@RequestParam (name="color", required = true) color: Color,
             @RequestParam (name="delay", required = false) delay: Long?) {
        runBlocking {
            logger.info("Wave")
            channelHandler.channel.send(Wave(color.red, color.green, color.blue, delay))
        }
    }

//    @GetMapping ("on/color")
//    @ResponseStatus(HttpStatus.OK)
//    fun predefinedColor(@RequestParam (name="color", required = true) color: Color,
//                        @RequestParam (name="brightness", required = true) brightness: Int?) {
//        runBlocking {
//            logger.info("Statisch")
//            channelHandler.channel.send(Static(color.red, color.green, color.blue, brightness))
//        }
//    }

    @GetMapping ("on/color")
    fun customColor(
        @RequestParam (name="red", required = true) red: Int,
        @RequestParam (name="green", required = true) green: Int,
        @RequestParam (name="blue", required = true) blue: Int,
        @RequestParam (name="brightness", required = false) brightness: Int?) {
        runBlocking {
            logger.info("Custom statisch")
            channelHandler.channel.send(Static(red, green, blue, brightness))
        }
    }

    @GetMapping ("on/runninglights/{color}", "on/runninglights/{color}/{delay}")
    fun runningLights(@RequestParam (name="color", required = true) color: Color,
                      @RequestParam (name="delay", required = false) delay: Long?) {
        runBlocking {
            logger.info("Running Lights")
            channelHandler.channel.send(RunningLights(color.red, color.green, color.blue, delay))
        }
    }
}
