package com.zimu21.zimu;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2017/3/1.
 */

public class ZimuApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

    }
}
