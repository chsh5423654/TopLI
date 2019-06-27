package com.chsh.ex;

import android.content.Intent;
import android.os.Bundle;

import com.chsh.ex.R;
import com.chsh.ex.base.BaseActivity;
import com.chsh.ex.log.LogUtis;


public class TestActivity extends BaseActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test);
        LogUtis.e("hello");
        Intent intent =  getIntent();
        String name =  intent.getStringExtra("test");
        LogUtis.v(name);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        initToolbar();

    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("测试");
        setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

    }
}
