package nl.joost.ledstrip

sealed class Pattern
class Rainbow (val delay: Long?, val brightness: Int?): Pattern()
class Kitt (val r: Int, val g: Int, val b: Int, val delay: Long?, val brightness: Int?): Pattern()
class Wave (val r: Int, val g: Int, val b: Int, val delay: Long?, val brightness: Int?): Pattern()
class Static (val r: Int, val g: Int, val b: Int, val a: Int?): Pattern()
class RunningLights (val r: Int, val g: Int, val b: Int, val delay: Long?): Pattern()
