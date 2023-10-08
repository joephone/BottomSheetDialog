package com.transcendence.bottomsheet.window;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.transcendence.bottomsheet.R;

/**
 * Created by Joephone on 2018/7/24 14:40
 * E-Mail Address：joephonechen@gmail.com
 */

public class PopIncome extends PopupWindow {

    private TextView tv_gallery, tv_camera,tv_cancel;
    private View mMenuView;

    public PopIncome(Context context, View.OnClickListener itemsOnClick){
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.pop_income, null);

        tv_gallery = (TextView) mMenuView.findViewById(R.id.tv_gallery);
        tv_camera = (TextView) mMenuView.findViewById(R.id.tv_camera);
        tv_cancel = (TextView) mMenuView.findViewById(R.id.tv_cancel);

        // 取消按钮
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 销毁弹出框
                dismiss();
            }
        });

        // 设置按钮监听
        tv_gallery.setOnClickListener(itemsOnClick);
        tv_camera.setOnClickListener(itemsOnClick);

        // 设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.Animation_Design_BottomSheetDialog);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x3F000000);   //半透明  0xb0000000   透明 0x00FFFFFF
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int height = mMenuView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });

    }

    //00%=FF（不透明）    5%=F2    10%=E5    15%=D8    20%=CC    25%=BF    30%=B2    35%=A5    40%=99    45%=8c    50%=7F
    //55%=72    60%=66    65%=59    70%=4c    75%=3F    80%=33    85%=21    90%=19    95%=0c    100%=00（全透明）

}
