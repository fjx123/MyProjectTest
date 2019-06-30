package com.test.myprojecttest;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.test.myprojecttest.activity.FixedTabActivity;
import com.test.myprojecttest.activity.LoginActivity;
import com.test.myprojecttest.activity.MoreTabActivity;
import com.test.myprojecttest.fragment.FirstFragment;
import com.test.myprojecttest.fragment.FourthFragment;
import com.test.myprojecttest.fragment.SecondFragment;
import com.test.myprojecttest.fragment.ThirdFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    ThirdFragment thirdFragment;
    FourthFragment fourthFragment;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        initFragment();
    }

    private void initFragment() {

        radioGroup.check(R.id.rb1);
        radioGroup.setOnCheckedChangeListener(this);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        firstFragment = new FirstFragment();
        transaction.add(R.id.fragment_container, firstFragment);
        transaction.commitAllowingStateLoss();
    }

    @OnClick({R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab:
                //Toast.makeText(MainActivity.this, "点击了fab", Toast.LENGTH_SHORT).show();
                //点击浮动按钮fab跳到登录接口
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_item) {//固定Tab
            startActivity(new Intent(MainActivity.this, FixedTabActivity.class));
            return true;
        } else if (id == R.id.action_item1) {//多项Tab
            startActivity(new Intent(MainActivity.this, MoreTabActivity.class));
            return true;
        } else if (id == R.id.action_item2) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
        } else if (id == R.id.nav_gallery) {
        } else if (id == R.id.nav_slideshow) {
        } else if (id == R.id.nav_tools) {
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (checkedId) {
            case R.id.rb1:
                if (firstFragment == null) {
                    firstFragment = new FirstFragment();
                    transaction.add(R.id.fragment_container, firstFragment);
                } else {
                    transaction.show(firstFragment);
                }
                break;
            case R.id.rb2:
                if (secondFragment == null) {
                    secondFragment = new SecondFragment();
                    transaction.add(R.id.fragment_container, secondFragment);
                } else {
                    transaction.show(secondFragment);
                }
                break;
            case R.id.rb3:
                if (thirdFragment == null) {
                    thirdFragment = new ThirdFragment();
                    transaction.add(R.id.fragment_container, thirdFragment);
                } else {
                    transaction.show(thirdFragment);
                }
                break;
            case R.id.rb4:
                if (fourthFragment == null) {
                    fourthFragment = new FourthFragment();
                    transaction.add(R.id.fragment_container, fourthFragment);
                } else {
                    transaction.show(fourthFragment);
                }
                break;

        }
        transaction.commitAllowingStateLoss();

    }
    private void hideFragments(FragmentTransaction transaction) {
        if(firstFragment!=null){
            transaction.hide(firstFragment);
        }
        if(secondFragment!=null){
            transaction.hide(secondFragment);
        }
        if(thirdFragment!=null){
            transaction.hide(thirdFragment);
        }
        if(fourthFragment!=null){
            transaction.hide(fourthFragment);
        }
    }
}
