package com.zimu21.zimu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zimu21.zimu.activity.City_Orientation_Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void click(View view){
        Intent intent = new Intent(this, City_Orientation_Activity.class);
        startActivity(intent);

    }
}
