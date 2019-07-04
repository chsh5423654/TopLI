package com.chsh.ex.modules.main.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.chsh.ex.R;
import com.chsh.ex.base.fragment.BaseWebFragment;
import com.chsh.ex.modules.main.ui.acitivity.Test2Activity;

/**
 * Created by Jue on 2018/6/2.
 */

public class DFragment extends BaseWebFragment {


    @Override
    protected String getUrl() {
        return "https://www.bilibili.com";
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getResLayout() {
        return R.layout.fragment_d;
    }

    @Override
    protected ViewGroup getRootLayout() {
        return view.findViewById(R.id.content_layout);
    }

    @Override
    public boolean onBackPressed() {
        if (mAgentWeb.back()){   //h5界面可以返回， 拦截事件
            return true;
        }else return false;
    }




}
