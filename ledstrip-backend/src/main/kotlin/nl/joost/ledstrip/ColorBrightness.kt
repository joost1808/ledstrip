package nl.joost.ledstrip

import com.github.mbelling.ws281x.Color

data class ColorBrightness(
    val r: Int,
    val g: Int,
    val b: Int,
    val brightness: Int
    ): Color(r, g, b)
