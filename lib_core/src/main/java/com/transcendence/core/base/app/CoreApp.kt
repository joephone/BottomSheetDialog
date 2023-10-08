package com.transcendence.core.base.app

import android.app.Application
import android.content.Context
import android.os.Handler
import com.transcendence.core.base.app.CoreApp
import com.transcendence.core.base.manager.ActivityManager

/**
 * @author joephone
 * @date 2023/9/16
 * @desc
 */
open class CoreApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //对全局属性赋值
        instance = this
        appContext = applicationContext
        init(this)
    }

    private fun init(application: Application) {
        // Activity 栈管理初始化
        ActivityManager.getInstance().init(application)
    }

    companion object {
        //以下属性应用于整个应用程序，合理利用资源，减少资源浪费
        var appContext //上下文
                : Context? = null
            private set
        private var instance: CoreApp? = null
        val mainHandler = Handler() //主线程Handler
        @JvmStatic
        fun getInstance(): CoreApp? {
            if (instance == null) {
                instance = CoreApp()
            }
            return instance
        }

        fun setContext(mContext: Context?) {
            appContext = mContext
        }
    }
}