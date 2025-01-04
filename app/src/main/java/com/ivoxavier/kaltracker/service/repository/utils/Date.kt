package com.ivoxavier.kaltracker.service.repository.utils


import java.text.SimpleDateFormat
import java.util.Locale


//format the timestamp
fun FormatDate(timestamp: Long):String{
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return sdf.format(timestamp)
}