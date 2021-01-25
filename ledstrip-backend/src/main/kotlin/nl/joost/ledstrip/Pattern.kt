package nl.joost.ledstrip

sealed class Pattern
class Rainbow (val delay: Long?, val brightness: Int?): Pattern()
class Kitt (val colorPattern: ColorPattern): Pattern()
class Wave (val colorPattern: ColorPattern): Pattern()
class Static (val colorBrightness: ColorBrightness): Pattern()
class RunningLights (val colorPattern: ColorPattern): Pattern()
