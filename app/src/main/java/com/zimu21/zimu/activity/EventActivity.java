package com.zimu21.zimu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zimu21.zimu.R;
import com.zimu21.zimu.ZimuApplication;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView icon_event,iv_icon1,iv_icon2,iv_icon3,iv_icon4,iv_icon5,iv_down1_event,iv_down2_event;

    private TextView tv_time_event;
    private TextView tv_money_event;
    private TextView tv_time_activity;
    private TextView tv_money_event1,tv_key_apply;
    private TextView tv_location_event,tv_nopoplefull_event;
    private TextView tv_applypople_event,tv_introduce_event,tv_invite_event,tv_poplefull_event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        initViews();
    }
    private void initViews(){
        icon_event = (ImageView) findViewById(R.id.icon_event);
        iv_icon1 = (ImageView) findViewById(R.id.iv_icon1);
        iv_icon2 = (ImageView) findViewById(R.id.iv_icon2);
        iv_icon3 = (ImageView) findViewById(R.id.iv_icon3);
        iv_icon4 = (ImageView) findViewById(R.id.iv_icon4);
        iv_icon5 = (ImageView) findViewById(R.id.iv_icon5);
        iv_down1_event = (ImageView) findViewById(R.id.iv_down1_event);
        iv_down2_event = (ImageView) findViewById(R.id.iv_down2_event);


        tv_time_event = (TextView) findViewById(R.id.tv_time_event);
        tv_money_event = (TextView) findViewById(R.id.tv_money_event);
        tv_time_activity = (TextView) findViewById(R.id.tv_time_activity);
        tv_money_event1 = (TextView) findViewById(R.id.tv_money_event1);
        tv_location_event = (TextView) findViewById(R.id.tv_location_event);
        tv_applypople_event = (TextView) findViewById(R.id.tv_applypople_event);
        tv_introduce_event = (TextView) findViewById(R.id.tv_introduce_event);
        tv_invite_event = (TextView) findViewById(R.id.tv_invite_event);
        tv_poplefull_event = (TextView) findViewById(R.id.tv_poplefull_event);
        tv_nopoplefull_event = (TextView) findViewById(R.id.tv_nopoplefull_event);

        tv_key_apply = (TextView) findViewById(R.id.tv_key_apply);

    }

    @Override
    public void onClick(View v) {

    }
    private void data(){
        String url = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
        Picasso.with(ZimuApplication.getApplication()).load(url).error(R.mipmap.ic_launcher).into(iv_icon1);


    }


}
