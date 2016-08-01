package com.select.mcmaps;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application{
    private static Context ctx;
    @Override
    public void onCreate(){
        // TODO: Implement this method
        super.onCreate();
        ctx = getApplicationContext(); //获取Context
    }
    //全局获取context
	//评论：尼玛getApplicationContext();得到的不就是这里的context吗。就算这里写成这样到最后还是是得拿Application到处传来传去嘛。还不如直接传activity
    public static Context getCtx(){return ctx;}
}

