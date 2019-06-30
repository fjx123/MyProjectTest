package com.test.myprojecttest.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.test.myprojecttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoreTabActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.pager)
    ViewPager pager;
    private String[] array={"要闻", "英雄联盟", "守望先锋", "NBA", "程序员", "电竞", "经济"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_tab);
        ButterKnife.bind(this);
        for(int i=0;i<array.length;i++){
            tabLayout.addTab(tabLayout.newTab().setText(array[i]));
        }
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
