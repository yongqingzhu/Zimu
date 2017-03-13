package com.zimu21.zimu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.zimu21.zimu.R;
import com.zimu21.zimu.widget.BooksHorizontalScrollView;
import com.zimu21.zimu.widget.HorizontalScrollViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FindBooksActivity extends AppCompatActivity {
    private SliderLayout mSliderLayout;
    private LinearLayout mGallery;
    private BooksHorizontalScrollView mHorizontalScrollView;
    private HorizontalScrollViewAdapter mAdapter;
    private List<Integer> mDatas ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_books);
        initSlider();
        initData();
        initView();


    }

    private void initSlider(){
        mSliderLayout = (SliderLayout) findViewById(R.id.slider);
        TextSliderView textSliderView = new TextSliderView(this);
        textSliderView.image("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
        textSliderView.description("jkslkjhklsdfklh");
        textSliderView.setScaleType(BaseSliderView.ScaleType.Fit);
        mSliderLayout.addSlider(textSliderView);

        TextSliderView textSliderView1 = new TextSliderView(this);
        textSliderView1.image("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
        textSliderView1.description("jkslkjhklsdfklh");
        textSliderView1.setScaleType(BaseSliderView.ScaleType.Fit);
        mSliderLayout.addSlider(textSliderView1);
        TextSliderView textSliderView2 = new TextSliderView(this);
        textSliderView2.image("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
        textSliderView2.description("jkslkjhklsdfklh");
        textSliderView2.setScaleType(BaseSliderView.ScaleType.Fit);
        mSliderLayout.addSlider(textSliderView2);
        TextSliderView textSliderView3 = new TextSliderView(this);
        textSliderView3.image("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
        textSliderView3.description("jkslkjhklsdfklh");
        textSliderView3.setScaleType(BaseSliderView.ScaleType.Fit);
        mSliderLayout.addSlider(textSliderView3);
        TextSliderView textSliderView4 = new TextSliderView(this);
        textSliderView4.image("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
        textSliderView4.description("jkslkjhklsdfklh");
        textSliderView4.setScaleType(BaseSliderView.ScaleType.Fit);
        mSliderLayout.addSlider(textSliderView4);

       /* mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        mSliderLayout.setDuration(3000);
*/

    }

    private void initData() {
        mDatas = new ArrayList<Integer>();
        for (int i =0;i<10;i++){
            mDatas.add(R.mipmap.ic_launcher);
        }
    }
    private void initView() {
        mHorizontalScrollView = (BooksHorizontalScrollView) findViewById(R.id.id_horizontalScrollView);
        mAdapter = new HorizontalScrollViewAdapter(this, mDatas);
        mHorizontalScrollView.initDatas(mAdapter);
        mHorizontalScrollView.setOnItemClickListener(new BooksHorizontalScrollView.OnItemClickListener() {
            @Override
            public void onClick(View view, int pos) {

            }
        });
    }


}
