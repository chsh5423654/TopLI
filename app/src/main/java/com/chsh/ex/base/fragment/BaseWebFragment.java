package com.chsh.ex.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.chsh.ex.R;
import com.chsh.ex.modules.main.ui.fragment.HandleBackInterface;
import com.chsh.ex.utii.HandleBackUtil;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.NestedScrollAgentWebView;


public abstract class BaseWebFragment extends Fragment implements HandleBackInterface {


    public View view;
    public AgentWeb mAgentWeb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getResLayout(), null);
        initView();

        WebChromeClient webChromeClient = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        };

        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        NestedScrollAgentWebView mNestedWebView = new NestedScrollAgentWebView(view.getContext());
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(getRootLayout(), layoutParams)
                .useDefaultIndicator()
                .setWebView(mNestedWebView)
                .setWebChromeClient(webChromeClient)
                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)
                .createAgentWeb()
                .ready()
                .go(getUrl());



        return view;
    }

    protected abstract String getUrl();

    protected abstract void initView();

    /**
     * 界面布局
     * @return
     */
    protected abstract int getResLayout();

    /**
     * 根布局
     * @return
     */
    protected abstract ViewGroup getRootLayout();


    @Override
    public void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }


    @Override
    public void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();
    }


    @Override
    public void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }




    @Override
    public boolean onBackPressed() {
        return HandleBackUtil.handleBackPress(this);
    }







}
