package com.chsh.ex.modules.main.ui.acitivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.chsh.ex.R;
import com.chsh.ex.base.activity.BaseActivity;
import com.chsh.ex.modules.chat.ui.acitivity.ChatActivity;
import com.chsh.ex.modules.main.ui.fragment.AFragment;
import com.chsh.ex.modules.main.ui.fragment.BFragment;
import com.chsh.ex.modules.main.ui.fragment.CFragment;
import com.chsh.ex.modules.main.ui.fragment.DFragment;
import com.chsh.ex.utii.HandleBackUtil;
import com.chsh.ex.utii.LogUtis;
import com.chsh.fragmentlibray.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;


public class TestActivity extends BaseActivity {

    private EasyNavigationBar navigationBar;
    private View view;

    private String[] tabText = {"首页", "发现", "消息", "我的"};
    //未选中icon
    private int[] normalIcon = {R.mipmap.index, R.mipmap.find,  R.mipmap.message, R.mipmap.me};
    //选中时icon
    private int[] selectIcon = {R.mipmap.index1, R.mipmap.find1,  R.mipmap.message1, R.mipmap.me1};

    private List<Fragment> fragments = new ArrayList<>();


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test);
        LogUtis.e("hello");
        navigationBar = findViewById(R.id.navigationBar);

        view = LayoutInflater.from(this).inflate(R.layout.custom_add_view, null);
    }

    @Override
    protected void setListener() {

//        navigationBar.ononSelectChangeListener(new EasyNavigationBar.OnSelectChangeListener() {
//            @Override
//            public void onSelectChangeListener(int position) {
//                LogUtis.d("hah"+position);
//                if (position == 0)
//                    mSwipeBackHelper.setSwipeBackEnable(true);
//                else mSwipeBackHelper.setSwipeBackEnable(false);
//            }
//        });
    }


    @Override
    protected void onResume() {
        super.onResume();
//        int position = navigationBar.getCurrentPosition();
//        if (position == 0)
//            mSwipeBackHelper.setSwipeBackEnable(true);
//        else mSwipeBackHelper.setSwipeBackEnable(false);
    }


    @Override
    protected void processLogic(Bundle savedInstanceState) {

        initToolbar();

        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());



        navigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .addAsFragment(false)
                .mode(EasyNavigationBar.MODE_ADD_VIEW)
                .addCustomView(view)
                .fragmentManager(getSupportFragmentManager())
                .canScroll(false)
                .onTabClickListener(new EasyNavigationBar.OnTabClickListener() {
                    @Override
                    public boolean onTabClickEvent(View view, int position) {
                        Log.e("Tap->Position", position + "");
                        if (position == 2) {
                            showChatView();
                        }
                        return false;
                    }
                })
                .build();
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        setStatusBarColor(getResources().getColor(R.color.colorPrimary),0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //隐藏左边标题
        setStatusBarTitleVisable(true);
        setStatusBarTitle("测试");

    }


    private void showChatView(){
        LogUtis.d("跳转聊天界面");
        mSwipeBackHelper.setSwipeBackEnable(true);
        mSwipeBackHelper.forward(ChatActivity.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_1:
                tost("我是第一个");
                break;
            case R.id.menu_2:
                tost("我是第二个");
                break;
            case R.id.menu_3:
                tost("我是第三个");
                break;
            case R.id.menu_4:
                tost("我是第四个");
                break;
            case android.R.id.home:  //左上角返回键
                finish();
                break;
        }
        return true;
    }


    public EasyNavigationBar getNavigationBar() {
        return navigationBar;
    }


    @Override
    public void onBackPressed() {
        LogUtis.e("Test 返回");
        if (!HandleBackUtil.handleBackPress(this)) {
            LogUtis.e("Test 返回1");
            super.onBackPressed();
        }
    }
}
