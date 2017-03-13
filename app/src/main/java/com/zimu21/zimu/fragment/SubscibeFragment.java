package com.zimu21.zimu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.zimu21.zimu.R;

/**
 * Created by Administrator on 2017/3/10.
 */

public class SubscibeFragment extends Fragment {
    private Fragment mCurrentFragment;
    private FragmentManager mFragmentManager;
    private RadioGroup radioGroup;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_subscibe,null);
        initViews(view);
        return view;
    }
    public void initViews(View view){
        final FragmentSubscibeRecommend recommend = new FragmentSubscibeRecommend();
        final FragmentSubscibeOrder fragmentSubscibeOrder  = new FragmentSubscibeOrder();

        mFragmentManager =getActivity().getSupportFragmentManager();
        showFragment(fragmentSubscibeOrder);
        radioGroup = (RadioGroup) view.findViewById(R.id.rg_subscibe);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.rb_subscibe:
                        showFragment(fragmentSubscibeOrder);
                        break;
                    case R.id.rb_subscibe1:
                        showFragment(recommend);
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
            fragmentTransaction.add(R.id.subscibe1, fragment);
        }
        if (mCurrentFragment != null) {
            fragmentTransaction.hide(mCurrentFragment);
        }
        fragmentTransaction.commit();
        mCurrentFragment = fragment;
    }

}
