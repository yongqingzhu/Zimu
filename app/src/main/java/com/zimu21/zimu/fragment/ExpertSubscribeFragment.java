package com.zimu21.zimu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.zimu21.zimu.R;

/**
 * Created by Administrator on 2017/2/28.
 */

public class ExpertSubscribeFragment extends Fragment implements View.OnClickListener{

    private RadioButton rbBank;
    private RadioButton rbRange;
    private RadioButton rbMoney;
    private RadioButton rbTime;
    private ImageView arrow1;
    private ImageView arrow2;
    private ImageView arrow3;
    private ImageView arrow4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expert_subscribe,null);
        initViews(view);
        initLinster();
        initTit();

        return view;
    }

    public void initViews(View view) {
        rbBank = (RadioButton)view.findViewById(R.id.rb_locale);
        rbMoney = (RadioButton) view.findViewById(R.id.rb_price);
        rbRange = (RadioButton) view.findViewById(R.id.rb_field);
        rbTime = (RadioButton) view.findViewById(R.id.rb_more);
        arrow1 = (ImageView) view.findViewById(R.id.arrow1);
        arrow2 = (ImageView) view.findViewById(R.id.arrow2);
        arrow3 = (ImageView) view.findViewById(R.id.arrow3);
        arrow4 = (ImageView) view.findViewById(R.id.arrow4);
    }
    private void initLinster(){
        rbMoney.setOnClickListener(this);
        rbTime.setOnClickListener(this);
        rbRange.setOnClickListener(this);
        rbBank.setOnClickListener(this);
    }

    private void initTit() {
        rbBank.setText("杭州");
        rbRange.setText("领域");
        rbMoney.setText("价格");
        rbTime.setText("更多");
    }
    public void clearTextColor(){
        rbTime.setTextColor(getResources().getColor(R.color.black));
        rbMoney.setTextColor(getResources().getColor(R.color.black));
        rbRange.setTextColor(getResources().getColor(R.color.black));
        rbBank.setTextColor(getResources().getColor(R.color.black));
    }
    public void clearArrow(){
        arrow1.setImageResource(R.mipmap.down_arrow);
        arrow2.setImageResource(R.mipmap.down_arrow);
        arrow3.setImageResource(R.mipmap.down_arrow);
        arrow4.setImageResource(R.mipmap.down_arrow);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rb_locale:
                clearArrow();
                clearTextColor();
                rbBank.setTextColor(getResources().getColor(R.color.tv_money_color));
                arrow1.setImageResource(R.mipmap.up_arrow);
             /*  Intent localeIntent = new Intent(ExpertSubscribeActivity.this,City_Orientation_Activity.class);
                startActivity(localeIntent);*/

                break;
            case R.id.rb_price:
                clearArrow();
                clearTextColor();
                rbMoney.setTextColor(getResources().getColor(R.color.tv_money_color));
                arrow3.setImageResource(R.mipmap.up_arrow);
                //sbp.reOpen();
                break;
            case R.id.rb_field:
                clearArrow();
                clearTextColor();
                rbRange.setTextColor(getResources().getColor(R.color.tv_money_color));
                arrow2.setImageResource(R.mipmap.up_arrow);
                // sbp.reOpen();
                break;
            case R.id.rb_more:
                clearArrow();
                clearTextColor();
                rbTime.setTextColor(getResources().getColor(R.color.tv_money_color));
                arrow4.setImageResource(R.mipmap.up_arrow);
                //sbp.reOpen();
                break;
            default:
                break;
        }
    }
}
