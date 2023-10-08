package com.transcendence.core.global

import com.transcendence.core.R

/**
 * @author joephone
 * @date 2023/9/16
 * @desc
 */
class Global {

    companion object {
        val TAG ="wan"
        var PAGE_START: Int = 0
        const val DURATION_SPLASH :Long = 500

        var mBeautyIds = intArrayOf(
            R.drawable.beauty01,
            R.drawable.beauty02,
            R.drawable.beauty03,
            R.drawable.beauty04,
            R.drawable.beauty05,
            R.drawable.beauty06,
            R.drawable.beauty07,
            R.drawable.beauty08,
            R.drawable.beauty09,
            R.drawable.beauty10
        )
    }

    class PUBLIC_INTENT_KEY {
        companion object {
            val URL :String = "url"
            val TITLE :String = "title"
            val NAME :String = "name"
            val INDEX :String = "index"
            val IMG :String = "img"
        }
    }

    class SP_KEY {
        companion object {
            val LOGINBEAN = "login_bean"
            val USERNAME = "username"
            val PASSWORD = "password"
        }
    }


}