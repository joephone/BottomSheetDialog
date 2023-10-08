package com.transcendence.core.utils

import com.transcendence.core.base.app.CoreApp.Companion.appContext
import com.transcendence.core.base.app.CoreApp

/**
 * @author joephone
 * @date 2023/8/11
 * @desc
 */
object ColorUtils {
    @JvmStatic
    fun getColorIntValue(colorId: Int): Int {
        return appContext!!.getColor(colorId)
    }
}