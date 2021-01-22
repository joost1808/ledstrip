package nl.joost.ledstrip

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ChannelHandler(
        private val ledstripPatternsService: LedstripPatternsService
) {
    val channel: Channel<Pattern> = Channel()

    companion object {
        val logger = LoggerFactory.getLogger(this::class.java)
    }

    init {
        GlobalScope.launch {
            setState()
        }
    }

    suspend fun setState() {
        coroutineScope {
            for (p in channel) {
                logger.info("Waar ik ben: ${p.javaClass.name}")
                coroutineContext.cancelChildren()
                launch {
                    when (p) {
                        is Rainbow -> {
                            logger.info("Ik ga Rainbow doen")
                            ledstripPatternsService.rainbow(p.delay?: 20)
                        }
                        is Kitt -> {
                            logger.info("Ik ga Kitt doen")
                            ledstripPatternsService.kitt(p.r, p.g, p.b, p.delay?: 20)
                        }
                        is Wave -> {
                            logger.info("k ga Wave doen")
                            ledstripPatternsService.wave(p.r, p.g, p.b, p.delay?: 20)
                        }
                        is Static -> {
                            logger.info("Ik ga Static doen")
                            ledstripPatternsService.static(p.r, p.g, p.b, p.a?: 255)
                        }
                        is RunningLights -> {
                            logger.info("Ik ga RunningLights doen")
                            ledstripPatternsService.runningLights(p.r, p.g, p.b, p.delay?: 20)
                        }
                    }
                }
                logger.info("Na launch")
            }
        }
    }
}
