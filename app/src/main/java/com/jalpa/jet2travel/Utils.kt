package com.jalpa.jet2travel

import android.content.Context
import android.text.format.DateUtils
import android.util.Log
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun getFormatedCount(count: Long): String? {
    if (count < 1000) return "" + count
    val exp = (Math.log(count.toDouble()) / Math.log(1000.0)).toInt()
    Log.e("count",exp.toString() + "..."+count)
    return String.format(
        "%.1f %c",
        count / Math.pow(1000.0, exp.toDouble()),
        "kMGTPE"[exp - 1]
    )
}

fun getFormatedTime(date: String): String? {
    try{
        val pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX"
        val df: DateFormat = SimpleDateFormat(pattern)
        val myDate: Date = df.parse(date)

         var now: Long = System.currentTimeMillis();
         var ago: CharSequence = DateUtils.getRelativeTimeSpanString(myDate.time,now, DateUtils.MINUTE_IN_MILLIS,DateUtils.FORMAT_ABBREV_RELATIVE);
        return ago.toString()
    } catch ( e : ParseException) {
        e.printStackTrace();
        return ""
    }

}