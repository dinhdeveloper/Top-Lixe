package com.mobishop.toplixe.common

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.floor

open class CountTime {
    public companion object fun countTime(tim : Double) :String {
        val t = tim

        var hours = t.toInt() / 60
        var minutes = t.toInt() % 60
        val secondsPrecision: BigDecimal =
            BigDecimal((t - floor(t.toDouble())) * 100).setScale(2, RoundingMode.HALF_UP)
        var seconds: Int = secondsPrecision.intValueExact()
        if (seconds > 59) {
            minutes++ //increment minutes by one
            seconds -= 60 //recalculate seconds
        }
        if (minutes > 59) {
            hours++
            minutes -= 60
        }
        val myFormat = if (seconds >= 10) "%d:%02d:%d" else "%d:%02d:0%d"

        return String.format(myFormat, hours, minutes, seconds)
    }
}