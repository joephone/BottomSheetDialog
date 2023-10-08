package com.transcendence.core.base.activity

import android.content.Intent
import android.widget.Toast
import com.transcendence.core.R

/**
 * @author joephone
 * @date 2023/9/16
 * @desc
 */
open abstract class AppAc :TitleBarActivity() {

    fun showMsg(msg:String){
        Toast.makeText(mActivity,msg,Toast.LENGTH_SHORT).show()
    }

    fun startAc(cls: Class<*>?) {   // java写法 Class<?> cls
        val intent = Intent(this, cls)
        startActivity(intent)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.left_in_activity, R.anim.left_out_activity)
    }
}