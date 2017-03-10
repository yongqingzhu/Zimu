package com.zimu21.zimu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import com.zimu21.zimu.R;
import com.zimu21.zimu.ZimuApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */

public class SeekActivity extends Activity {
    private RecyclerView mRecyclerView;
    private List<String> mList;
    private SearchView mSearchView;
    private ListView mListView;
    private LinearLayout mLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
         data();
        initViews();

    }
    private void initViews(){
        mLinearLayout = (LinearLayout)findViewById(R.id.seek_list_linear);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_seek);
        mSearchView = (SearchView) findViewById(R.id.searchView);
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mList));
    // mListView.setTextFilterEnabled(true);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    mListView.setFilterText(newText);

                    mLinearLayout.setVisibility(View.VISIBLE);
               }else{
                    mListView.clearTextFilter();
                    mLinearLayout.setVisibility(View.GONE);
                }
                return false;
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(SeekActivity.class.getSimpleName(),""+position);
                Intent intent = new Intent(ZimuApplication.getApplication(), SeekResult.class);
                startActivity(intent);


            }
        });
    }
    private void data(){
        mList = new ArrayList<>(5);
        mList.add("aaaaaaaa");
        mList.add("11111111");
        mList.add("222222222");
        mList.add("cccccccccc");
        mList.add("dddddddddd");

    }

}
