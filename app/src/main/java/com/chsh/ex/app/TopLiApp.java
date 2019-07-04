package com.chsh.ex.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.StrictMode;


import com.chsh.ex.BuildConfig;
import com.chsh.ex.core.di.component.DaggerAppComponent;
import com.chsh.ex.core.di.module.AppModule;
import com.chsh.ex.core.di.module.HttpModule;
import com.chsh.library.swipebacklayout.BGASwipeBackHelper;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class TopLiApp extends Application implements HasActivityInjector {

    private static Context context;

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        /**
         * Logger 初始化
         */
        Logger.addLogAdapter(new AndroidLogAdapter());

        /**
         * Dagger2提供依赖注入
         */
        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .httpModule(new HttpModule())
                .build()
                .inject(this);


        /**
         * 必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回
         * 第一个参数：应用程序上下文
         * 第二个参数：如果发现滑动返回后立即触摸界面时应用崩溃，请把该界面里比较特殊的 View 的 class 添加到该集合中，目前在库中已经添加了 WebView 和 SurfaceView
         */
        BGASwipeBackHelper.init(this, null);

        /**
         * chat 配置
         */
        if (BuildConfig.DEBUG){
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());

            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }

    }


    public static Context getContext() {
        return context;
    }


}
