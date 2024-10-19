/*

Considering 1kg of adipose tissue has a stock energy of 7700 calories
see: https://emais.estadao.com.br/blogs/vigilante-da-causa-magra/quer-perder-peso-nutricionista-explica-media-de-reducao-de-calorias-por-dia/

*/

package com.ivoxavier.kaltracker.service.repository.utils

private const val adiposeTissue1kg = 7700

fun periodOne(): Int {
    return ((adiposeTissue1kg * 0.5) / 7).toInt()
}

fun periodTwo(): Int {
    return ((adiposeTissue1kg * 1.0) / 7).toInt()
}

fun periodThree(): Int {
    return ((adiposeTissue1kg * 3.0) / 7).toInt()
}

fun periodFour(): Int {
    return ((adiposeTissue1kg * 4.0) / 7).toInt()
}