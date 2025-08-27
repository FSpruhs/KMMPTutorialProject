package com.spruhs

import android.os.Build
import android.content.res.Resources
import android.util.Log
import kotlin.math.round

actual class Platform() {
    actual val name: String
        get() = "Android"
    actual val osVersion: String
        get() = "${Build.VERSION.SDK_INT}"
    actual val deviceModel: String
        get() = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val density: Int
        get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logSystemInfo() {
        Log.d("SystemInfo", "$name $osVersion $deviceModel $density")
    }
}