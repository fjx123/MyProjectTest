package com.test.myprojecttest.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.test.myprojecttest.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.SocializeUtils;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录接口模拟第三方登录
 */
public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.brn_wx)
    Button brnWx;
    @BindView(R.id.brn_qq)
    Button brnQq;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        tvTitle.setText("第三方登录");
        context=this;
    }

    @OnClick({R.id.iv_back, R.id.brn_wx, R.id.brn_qq})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.brn_wx:
                UMShareAPI.get(context).getPlatformInfo(LoginActivity.this, SHARE_MEDIA.WEIXIN,new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA platform) {
                    }

                    @Override
                    public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
                        Toast.makeText(context, "成功了", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onError(SHARE_MEDIA platform, int action, Throwable t) {
                        Toast.makeText(context, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA platform, int action) {
                        Toast.makeText(context, "取消了", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case R.id.brn_qq:
                UMShareAPI.get(context).getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ,new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA platform) {
                    }

                    @Override
                    public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
                        Toast.makeText(context, "成功了", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onError(SHARE_MEDIA platform, int action, Throwable t) {
                        Toast.makeText(context, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA platform, int action) {
                        Toast.makeText(context, "取消了", Toast.LENGTH_LONG).show();
                    }
                });
                break;
        }
    }
}
