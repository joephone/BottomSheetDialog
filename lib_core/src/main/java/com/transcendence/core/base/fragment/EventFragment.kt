package com.transcendence.core.base.fragment

import android.os.Bundle
import android.view.View
import org.greenrobot.eventbus.EventBus

/**
 * @author joephone
 * @date 2023/9/22
 * @desc
 */
abstract class EventFragment : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isRegisterEventBus()) {
            if (!EventBus.getDefault().isRegistered(this)) { //加上判断
                EventBus.getDefault().register(this)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (EventBus.getDefault().isRegistered(this)) { //加上判断
            EventBus.getDefault().unregister(this)
        }
    }

    /**
     * 是否注册事件分发，默认不绑定
     */
    override fun isRegisterEventBus(): Boolean {
        return false
    }

}