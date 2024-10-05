/*

Mifflin-St Jeor equation is believed to give the most accurate result and,
is therefore what I used in this calculator. This BMR formula is as follows:

S = + 5 // for males
S = - 161 // for females
BMR = (10 * weight in kg) + (6.25 * height in cm) – (5 * age) ? S

AF = [VL = 1,3 ; L = 1,5 ; M = 1,6 ; H = 1,9]

EER = BMR * AF
*/


package com.ivoxavier.kaltracker.service.repository.utils

import kotlin.math.roundToInt

fun MifflinStJeorEquation(age: Int, weight: Double, height: Double, sex: Int, activity: Int): Int{
    val af: Double
    val bmr: Double

    when (activity) {
        0 -> af = 1.3
        1 -> af = 1.5
        2 -> af = 1.6
        3 -> af = 1.9
        else -> af = 1.3 // Valor padrão para atividade desconhecida
    }

    bmr = if (sex == 0) {
        (10 * weight) + (6.25 * height) - (5 * age) + 5
    } else {
        (10 * weight) + (6.25 * height) - (5 * age) - 161
    }

    val eer = (bmr * af).roundToInt()
    return eer
}