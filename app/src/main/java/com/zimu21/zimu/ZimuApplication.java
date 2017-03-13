package com.zimu21.zimu;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zimu21.zimu.widget.LocationCity;

public class ZimuApplication extends Application {

    private static ZimuApplication sApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        this.sApplication = this;
        Fresco.initialize(this);
        LocationCity.getLocation(getApplication()).initLocation();
    }
    public static ZimuApplication getApplication(){
        return sApplication;
    }


}
