package com.video.accountant;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qq.e.ads.appwall.APPWall;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.umeng.analytics.MobclickAgent;

public class AboutusActivity extends AppCompatActivity {
    LinearLayout recommendApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_aboutus);
        initWindow();
        TextView tv = (TextView) findViewById(R.id.top_title);
        tv.setText("关于我们");
        recommendApp = (LinearLayout) findViewById(R.id.recommend_app);
        recommendApp.setOnClickListener(new View.OnClickListener() {
            //为找到的button设置监听
            @Override
            //重写onClick函数
            public void onClick(View v) {
                myClickMethod(v);
            }
        });

    }
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void myClickMethod(View v) {
        switch (v.getId()) {
            case R.id.recommend_app:
                APPWall wall = new APPWall(this, Constants.APPID, Constants.APPWallPosID);
                wall.setScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                wall.doShowAppWall();
                break;
            default:
                break;
        }
    }

    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorNavBar));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintResource(R.color.colorNavBar);
            tintManager.setStatusBarTintEnabled(true);
        }
    }
}
