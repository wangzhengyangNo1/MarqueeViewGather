package com.wzhy.marqueeviewgather.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017-12-15 0015.
 */

public class MyApp extends Application {

    private static MyApp mApp;

    public static MyApp getApp() {
        return mApp;
    }

    public static Context getAppContext() {
        return mApp.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;

    }
}
