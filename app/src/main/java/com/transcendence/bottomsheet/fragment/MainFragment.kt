package com.transcendence.bottomsheet.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.transcendence.bottomsheet.R
import com.transcendence.bottomsheet.dialogfragment.BottomDialog
import com.transcendence.core.base.activity.AppAc
import com.transcendence.core.base.fragment.AppFragment
import com.transcendence.core.utils.log.LogUtils

/**
 * @author joephone
 * @date 2023/10/8
 * @desc
 */
class MainFragment : AppFragment() {

    companion object{
        fun newInstance(): MainFragment {
            val args = Bundle()
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initView() {
        val showDialogFragment = view!!.findViewById<View>(R.id.showDialogFragment) as Button
        showDialogFragment.setOnClickListener {
            showDialogFragment()
        }

        val showBottomSheet = view!!.findViewById<View>(R.id.showBottomSheet) as Button
        showBottomSheet.setOnClickListener {
//            showBottomSheet()
        }
    }

    override fun loadData() {

    }

    private fun showDialogFragment() {
        LogUtils.d( "showDialogFragment")
        val dialog: BottomDialog = BottomDialog.newInstance("", arrayOf("相册", "相机"))
        /**
         *
         * BottomDialog dialog = BottomDialog.newInstance("titleText","cancelText",new String[]{"item1","item2"});
         *
         * use public static BottomDialog newInstance(String titleText,String cancelText, String[] items)
         * set cancel text
         */
        dialog.show(childFragmentManager, "dialog")
        dialog.setListener(object : BottomDialog.OnClickListener {
            override fun click(position: Int) {
                Toast.makeText(context, "" + position, Toast.LENGTH_LONG).show()
            }
        })
    }
}