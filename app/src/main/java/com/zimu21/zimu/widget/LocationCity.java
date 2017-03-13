package com.zimu21.zimu.widget;

import android.content.Context;
import android.util.Log;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.zimu21.zimu.ZimuApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/6.
 */

public class LocationCity {
    public AMapLocationClient mLocationClient = null;
    public AMapLocationListener mLocationListener = new AMapLocation();
    public AMapLocationClientOption mLocationOption = null;
    private Context mContext;
    public String city ;

    private static LocationCity mLocationCity;

    public static LocationCity  getLocation(Context context){
            if (mLocationCity == null){
              mLocationCity =  new LocationCity(context);
            }
        return mLocationCity;
    }

    public LocationCity(Context context) {
        mContext = context;
    }
    public void initLocation(){
      /*  if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions( this, new String[]
                            {Manifest.permission.ACCESS_COARSE_LOCATION},
                    WRITE_COARSE_LOCATION_REQUEST_CODE);
        }*/
        mLocationOption = new AMapLocationClientOption();
        mLocationClient = new AMapLocationClient(ZimuApplication.getApplication());
        mLocationClient.setLocationListener(mLocationListener);
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        mLocationOption.setOnceLocation(true);
        mLocationOption.setOnceLocationLatest(true);
        mLocationOption.setInterval(1000);
        mLocationOption.setNeedAddress(true);
        mLocationOption.setWifiActiveScan(false);
        mLocationOption.setMockEnable(false);
        mLocationOption.setHttpTimeOut(20000);
        mLocationOption.setLocationCacheEnable(false);

        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.startLocation();

    }
    private class AMapLocation implements AMapLocationListener {
        @Override
        public void onLocationChanged(com.amap.api.location.AMapLocation amapLocation) {
            if (amapLocation != null) {
                if (amapLocation.getErrorCode() == 0) {
                }else {
                    Log.e("AmapError","location Error, ErrCode:" + amapLocation.getErrorCode() + ", errInfo:" + amapLocation.getErrorInfo());
                }
            }
            amapLocation.getLocationType();
            amapLocation.getLatitude();
            amapLocation.getLongitude();
            amapLocation.getAccuracy();
            amapLocation.getAddress();
            amapLocation.getCountry();
            amapLocation.getProvince();
            city =amapLocation.getCity();
            amapLocation.getDistrict();
            amapLocation.getStreet();
            amapLocation.getStreetNum();
            amapLocation.getCityCode();
            amapLocation.getAdCode();
            amapLocation.getAoiName();
            amapLocation.getBuildingId();
            amapLocation.getFloor();
            amapLocation.getGpsAccuracyStatus();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(amapLocation.getTime());
            df.format(date);
        }
    };
    public void destroy(){
        mLocationClient.stopLocation();
        mLocationClient.onDestroy();
    }

    public void start(){
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.startLocation();
    }

}
