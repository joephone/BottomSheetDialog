package com.transcendence.core.base.fragment;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.greenrobot.eventbus.EventBus;

/**
 * @Author Joephone on 2022/6/14 0014 下午 2:27
 * @E-Mail Address：joephonechen@gmail.com
 * @Desc
 * @Edition 1.0
 * @EditionHistory
 */
public abstract class BaseFragment extends Fragment {

    protected View mRootView = null;
    protected boolean mViewCreated = false;

    private Bundle mBundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            final int layoutId = getLayoutId();
            if (layoutId > 0) {
                mRootView = inflater.inflate(getLayoutId(), container, false);
            }
        }
        mViewCreated = true;
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBundle = savedInstanceState;
        init();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mRootView = null;
        mViewCreated = false;
        if (EventBus.getDefault().isRegistered(this)){//加上判断
            EventBus.getDefault().unregister(this);
        }
    }



    protected abstract int getLayoutId();

    protected void init() {
        initView();
        loadData();
        if (isRegisterEventBus()) {
            EventBus.getDefault().register(this);
        }
    }


    /**
     * 是否注册事件分发，默认不绑定
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    protected abstract void initView();

    protected abstract void loadData();

    protected Bundle getBundle(){
        return mBundle;
    }

    @Nullable
    public View getRootView() {
        return mRootView;
    }

    public final <V extends View> V findViewById(@IdRes int id) {
        if (mRootView == null) {
            return null;
        }
        return mRootView.findViewById(id);
    }

    public void finish() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    /**
     * A Tip
     * @param msg
     */
    protected void showMsg(CharSequence msg){
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }
}
