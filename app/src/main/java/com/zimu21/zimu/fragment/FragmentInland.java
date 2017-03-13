package com.zimu21.zimu.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zimu21.zimu.Data;
import com.zimu21.zimu.R;
import com.zimu21.zimu.ZimuApplication;
import com.zimu21.zimu.adapter.CitiesAdapter;
import com.zimu21.zimu.bean.CitiesBean;
import com.zimu21.zimu.bean.CityLocation;
import com.zimu21.zimu.http.OkHttpHelper;
import com.zimu21.zimu.view.QuickIndexView;
import com.zimu21.zimu.widget.LocationCity;

import java.util.List;

/**
 * Created by Administrator on 2017/2/27.
 */

public class FragmentInland extends Fragment {
    private final static String ATG = FragmentInland.class.getCanonicalName();
    private QuickIndexView quickIndexView;
    private RecyclerView recyclerView;
    private CitiesAdapter adapter;
    private Context mContext;
    private String locationString, keyString, questURL;
    private OkHttpHelper httpHelper = OkHttpHelper.getInstance();
    private List<CityLocation> mCityLocations;
    private static final int WRITE_COARSE_LOCATION_REQUEST_CODE = 1;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inland, null);
        initView(view);
        initEvent();
        openGPSSettings();
        return view;
    }

    private void initView(View view) {
        quickIndexView = (QuickIndexView) view.findViewById(R.id.quickIndexView);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        Gson gson = new Gson();
        CitiesBean citiesBean = gson.fromJson(Data.citiesJson, CitiesBean.class);
        adapter = new CitiesAdapter(mContext, citiesBean.getDatas());
        recyclerView.setAdapter(adapter);
        adapter.setOnCliclItemListener(new CitiesAdapter.OnCliclItemListener() {
            @Override
            public void onClickItemListener(int position) {
              openGPSSettings();
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initEvent() {
        quickIndexView.setOnIndexChangeListener(new QuickIndexView.OnIndexChangeListener() {
            @Override
            public void onIndexChange(String words) {
                if (words.equals("当") || words.equals("热")) {
                    LinearLayoutManager llm = (LinearLayoutManager) recyclerView
                            .getLayoutManager();
                    llm.scrollToPositionWithOffset(0, 0);
                    return;
                }
                List<CitiesBean.DatasBean> datas = adapter.getData();
                if (datas != null && datas.size() > 0) {
                    int count = 0;
                    for (int i = 0; i < datas.size(); i++) {
                        CitiesBean.DatasBean datasBean = datas.get(i);
                        if (datasBean.getAlifName().equals(words)) {
                            LinearLayoutManager llm = (LinearLayoutManager) recyclerView
                                    .getLayoutManager();
                            llm.scrollToPositionWithOffset(count + 1, 0);
                            return;
                        }
                        count += datasBean.getAddressList().size() + 1;
                    }
                }
            }
        });
    }

    private void openGPSSettings() {
        LocationManager alm = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        if (alm.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)) {
            Toast.makeText(mContext, "GPS模块正常", Toast.LENGTH_SHORT).show();
            getLocation();
            return;
        } else {
            Toast.makeText(mContext, "请开启GPS！", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
            startActivityForResult(intent, 0); // 此为设置完成后返回到获取界面
        }
    }
    public void getLocation(){
        if (ContextCompat.checkSelfPermission(ZimuApplication.getApplication(),
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]
                    {Manifest.permission.ACCESS_COARSE_LOCATION}, WRITE_COARSE_LOCATION_REQUEST_CODE);//自定义的code
        }
            LocationCity.getLocation(ZimuApplication.getApplication()).initLocation();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocationCity.getLocation(ZimuApplication.getApplication()).destroy();
    }
}
