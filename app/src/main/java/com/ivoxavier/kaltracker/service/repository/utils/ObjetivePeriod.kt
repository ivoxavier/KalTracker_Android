package com.ivoxavier.kaltracker.service.repository.utils

private const val adiposeTissue1kg = 7700

fun period(factor: Double): Int {
    return (adiposeTissue1kg * factor / 7).toInt()
}

fun periodOne(): Int {
    return period(0.5)
}

fun periodTwo(): Int {
    return period(1.0)
}

fun periodThree(): Int {
    return period(3.0)
}

fun periodFour(): Int {
    return period(4.0)
}