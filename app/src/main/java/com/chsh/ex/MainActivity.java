package com.chsh.ex;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.chsh.ex.base.BaseActivity;


public class MainActivity extends BaseActivity {

    /**
     * 主界面不需要支持滑动返回，重写该方法永久禁用当前界面的滑动返回功能
     *
     * @return
     */
    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void setListener() {
        findViewById(R.id.btn_test).setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initToolbar();

    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        setStatusBarColor(getResources().getColor(R.color.colorPrimary));
    }


    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test:
                mSwipeBackHelper.setSwipeBackEnable(true);
                Intent intent = new Intent(this, TestActivity.class);
                intent.putExtra("test","测试");
                mSwipeBackHelper.forward(intent);
                break;
        }
    }
}
