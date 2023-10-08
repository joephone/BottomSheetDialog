package com.transcendence.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import com.transcendence.bottomsheet.fragment.MainFragment
import com.transcendence.bottomsheet.window.PopIncome
import com.transcendence.core.base.activity.AppAc

class MainActivity : AppAc() {

//    lateinit var menuWindow:PopIncome

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container,MainFragment.newInstance())
            .commit()

        //        findViewById<View>(R.id.button).setOnClickListener {
//            DemoBottomSheetDialogFragment().show(supportFragmentManager, "tag")
//        }
//
//        findViewById<View>(R.id.bottom_button).setOnClickListener {
//            menuWindow = PopIncome(this,null)
//            menuWindow.showAsDropDown(it,Gravity.BOTTOM,0,0)
//        }
    }

    override fun loadData() {

    }
}