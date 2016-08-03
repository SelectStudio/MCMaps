package com.select.mcmaps;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static Context ctx;
    @Override
    public void onCreate(){
        // TODO: Implement this method
        super.onCreate();
        ctx = getApplicationContext(); //获取Context
    }
    //全局获取context
    public static Context getCtx(){return ctx;}
}

