package com.zimu21.zimu.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioGroup;

import com.zimu21.zimu.R;
import com.zimu21.zimu.fragment.Correlation_Class;
import com.zimu21.zimu.fragment.MySelf_Message;

/**
 * Created by Administrator on 2017/3/1.
 */

 public class ExpertDetaityActivity extends FragmentActivity {

    private Fragment mCurrentFragment;
    private FragmentManager mFragmentManager;

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_details);
        initViews();
    }


    public void initViews(){
        final Correlation_Class correlation_class = new Correlation_Class();

        final MySelf_Message mySelf_message = new MySelf_Message();

        mFragmentManager = getSupportFragmentManager();
        showFragment(mySelf_message);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.myself_message:
                        showFragment(mySelf_message);

                        break;
                    case R.id.correlation_class:
                        showFragment(correlation_class);
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
            fragmentTransaction.add(R.id.framelayout_ex, fragment);
        }
        if (mCurrentFragment != null) {
            fragmentTransaction.hide(mCurrentFragment);
        }
        fragmentTransaction.commit();
        mCurrentFragment = fragment;
    }
}
