package nl.joost.ledstrip

import com.github.mbelling.ws281x.Color
import com.github.mbelling.ws281x.LedStrip
import com.github.mbelling.ws281x.LedStripType
import com.github.mbelling.ws281x.Ws281xLedStrip
import kotlinx.coroutines.delay
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.math.sin

@Service
class LedstripPatternsService (
        private val ledstrip: LedStrip = Ws281xLedStrip(
                300,
                18,
                800000,
                10,
                255,
                0,
                false,
                LedStripType.WS2811_STRIP_GRB,
                false
        )
) {

    companion object {
        val logger = LoggerFactory.getLogger(this::class.java)
    }

    suspend fun rainbow(delay: Long, brightness: Int) {
        while (true) {
            logger.info("Rainbow")
            for (x in 0..256) {
                for (y in 0..ledstrip.ledsCount) {
                    val color: Color = wheel(Position(((y * 256 / ledstrip.ledsCount) + x) and 255))
                    ledstrip.setPixel(y, color.red, color.green, color.blue)
                }
                ledstrip.brightness = brightness
                ledstrip.render()
                delay(delay)
            }
        }
    }

    suspend fun kitt (r: Int, g: Int, b: Int, delay: Long, brightness: Int) {
        while(true) {
            logger.info("Kit")
            for (i in 0..ledstrip.ledsCount-5) {
                ledstrip.setStrip(0,0,0)
                ledstrip.setPixel(i, r/10, g/10, b/10)
                for (j in 1..5) {
                    ledstrip.setPixel(i+j, r, g, b)
                }
                ledstrip.setPixel(i+5+1, r/10, g/10, b/10)
                ledstrip.brightness = brightness
                ledstrip.render()
                delay(delay)
            }
        }
    }

    suspend fun wave(r: Int, g: Int, b: Int, delay: Long, brightness: Int) {
        while (true) {
            logger.info("Wave")
            for (i in 0..ledstrip.ledsCount * 2) {
                for (j in 0..ledstrip.ledsCount) {
                    ledstrip.setPixel(j,
                            ((((sin(((j + i)/3.5)) * 127 + 128) / 355) * r).toInt()),
                            ((((sin(((j + i)/3.5)) * 127 + 128) / 355) * g).toInt()),
                            ((((sin(((j + i)/3.5)) * 127 + 128) / 355) * b).toInt()))
                }
                ledstrip.brightness = brightness
                ledstrip.render()
                delay(delay)
            }
        }
    }

    suspend fun static(r: Int, g: Int, b: Int, brightness: Int) {
        ledstrip.setStrip(r, g, b)
        ledstrip.brightness = brightness
        ledstrip.render()
    }

    suspend fun runningLights(r: Int, g: Int, b: Int, delay: Long, brightness: Int) {
        while (true) {
            logger.info("RunningLights")
            val position = Position(0)
            for (i in 0..ledstrip.ledsCount * 2) {
                position.pos++
                for (j in 0..ledstrip.ledsCount) {
                    ledstrip.setPixel(j,
                            ((((sin((j + position.pos).toDouble()) * 127 + 128) / 255) * r).toInt()),
                            ((((sin((j + position.pos).toDouble()) * 127 + 128) / 255) * g).toInt()),
                            ((((sin((j + position.pos).toDouble()) * 127 + 128) / 255) * b).toInt()))
                }
                ledstrip.brightness = brightness
                ledstrip.render()
                delay(delay)
            }
        }
    }

    suspend fun wheel(position: Position): Color {
        return when {
            position.pos < 85 -> {
                Color(position.pos * 3, 255 - position.pos * 3, 0)
            }
            position.pos in 85..169 -> {
                position.pos -= 85
                Color(255 - position.pos * 3, 0, position.pos * 3)
            }
            else -> {
                position.pos -= 170
                Color(0, position.pos * 3, 255 - position.pos * 3)
            }
        }
    }
}

data class Position(
        var pos: Int
)
