package com.transcendence.core.base.activity

import android.os.Bundle
import org.greenrobot.eventbus.EventBus

/**
 * @author joephone
 * @date 2023/9/22
 * @desc
 */
abstract class EventActivity : BaseActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isRegisterEventBus()) {
            EventBus.getDefault().register(this)
        }
    }


    override fun onDestroy() {
        // Activity销毁时，提示系统回收
        // System.gc();
        super.onDestroy()
        if (EventBus.getDefault().isRegistered(this)) { //加上判断
            EventBus.getDefault().unregister(this)
        }
    }

    /**
     * 是否注册事件分发，默认不绑定
     */
    protected open fun isRegisterEventBus(): Boolean {
        return false
    }
}