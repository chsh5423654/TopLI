package com.chsh.ex.modules.main.ui.fragment;


import android.view.ViewGroup;


import com.chsh.ex.R;
import com.chsh.ex.base.fragment.BaseWebFragment;



/**
 * Created by Administrator on 2018/6/2.
 */

public class AFragment extends BaseWebFragment {


    @Override
    protected int getResLayout() {
        return R.layout.fragment_a;
    }

    @Override
    protected ViewGroup getRootLayout() {
        return view.findViewById(R.id.content_layout);
    }


    @Override
    protected String getUrl() {
        return "https://www.baidu.com";
    }

    @Override
    protected void initView() {

    }


    @Override
    public boolean onBackPressed() {
        if (mAgentWeb.back()){   //h5界面可以返回， 拦截事件
            return true;
        }else return false;
    }
}
