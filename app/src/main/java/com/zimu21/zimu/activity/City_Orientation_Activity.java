package com.zimu21.zimu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioGroup;

import com.zimu21.zimu.R;
import com.zimu21.zimu.ZimuApplication;
import com.zimu21.zimu.fragment.FragmentForeign;
import com.zimu21.zimu.fragment.FragmentInland;
import com.zimu21.zimu.widge.LocationCity;

/**
 * Created by Administrator on 2017/2/27.
 */

public class City_Orientation_Activity extends FragmentActivity {


    private Fragment mCurrentFragment;
    private FragmentManager mFragmentManager;

    private RadioGroup radioGroup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_orientation_activity);
      initViews();


    }

    public void initViews(){
       final FragmentInland fragmentInland = new FragmentInland();

       final FragmentForeign fragmentForeign = new FragmentForeign();

        mFragmentManager = getSupportFragmentManager();
        showFragment(fragmentInland);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.rb_inland:
                        showFragment(fragmentInland);
                        break;
                    case R.id.rb_foreign:
                        showFragment(fragmentForeign);
                        break;
                    default:
                        break;
                }
            }
        });


    }

    private void showFragment(Fragment fragment) {
        if (fragment == null) {
            Log.e("demo", "fragment is null");
            return;
        }
        //1.开启碎片事务对象并返回事务对象
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        //fragmentTransaction.remove(fragment);
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.add(R.id.framelayout_city, fragment);
        }
        if (mCurrentFragment != null) {
            fragmentTransaction.hide(mCurrentFragment);
        }
        fragmentTransaction.commit();
        mCurrentFragment = fragment;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocationCity.getLocation(ZimuApplication.getApplication()).destroy();

    }
}
