package nl.joost.ledstrip

sealed class Pattern
class Rainbow (val delay: Long?): Pattern()
class Kitt (val r: Int, val g: Int, val b: Int, val delay: Long?): Pattern()
class Wave (val r: Int, val g: Int, val b: Int, val delay: Long?): Pattern()
class Static (val r: Int, val g: Int, val b: Int): Pattern()
class RunningLights (val r: Int, val g: Int, val b: Int, val delay: Long?): Pattern()
