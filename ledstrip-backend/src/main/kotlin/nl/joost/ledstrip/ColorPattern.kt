package nl.joost.ledstrip

import com.github.mbelling.ws281x.Color

data class ColorPattern(
    val r: Int,
    val g: Int,
    val b: Int,
    val delay: Long,
    val brightness: Int
    ): Color(r, g, b)
