package com.test.myprojecttest.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.test.myprojecttest.R;
import com.test.myprojecttest.fragment.Fragment1;
import com.test.myprojecttest.fragment.Fragment2;
import com.test.myprojecttest.fragment.Fragment3;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FixedTabActivity extends AppCompatActivity {

    // TabLayout app:tabMode="fixed" 不固定就设置为scrollable
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    private String[] array = {"要闻", "电竞", "经济"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed_tab);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        for (int i = 0; i < array.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(array[i]));
        }
        pager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(pager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i = 0; i < array.length; i++) {
                    if (tab == tabLayout.getTabAt(i)) {
                        pager.setCurrentItem(i);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }


    //  自定义适配器
    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 1) {
                return new Fragment2();
            } else if (position == 2) {
                return new Fragment3();
            }
            return new Fragment1();
        }

        @Override
        public int getCount() {
            return array.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return array[position];
        }
    }
}
