package nl.joost.ledstrip

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LedstripApplication

fun main(args: Array<String>) {
	runApplication<LedstripApplication>(*args)
}
