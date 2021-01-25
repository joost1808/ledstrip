package nl.joost.ledstrip

import com.github.mbelling.ws281x.Color

data class ColorPattern(
    val r: Int,
    val g: Int,
    val b: Int,
    val brightness: Int,
    val delay: Long
): Color(r, g, b)
