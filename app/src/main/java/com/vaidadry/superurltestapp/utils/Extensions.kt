package com.vaidadry.superurltestapp.utils

import android.os.Handler

fun runDelayed(delayMillis: Long, action: () -> Unit) {
    Handler().postDelayed(Runnable(action), delayMillis)
}