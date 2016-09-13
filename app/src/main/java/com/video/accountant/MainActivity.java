package com.video.accountant;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.qq.e.ads.banner.ADSize;
import com.qq.e.ads.banner.AbstractBannerADListener;
import com.qq.e.ads.banner.BannerView;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    BannerView bv;
    ViewGroup bannerContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        initWindow();
        listView = (ListView) findViewById(R.id.category);

        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.list_item,
                new String[]{"title", "img"},
                new int[]{R.id.title, R.id.img}
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String, String> map = (HashMap<String, String>) listView.getItemAtPosition(position);
                String title = map.get("title");

                Bundle bundle = new Bundle();
                bundle.putLong("id", 100 + id);
                Intent intent;

                if (id == 7) {
                     intent = new Intent(MainActivity.this, AboutusActivity.class);
                } else {
                     intent = new Intent(MainActivity.this, CategoryActivity.class);
                }
                bundle.putString("title", title);
                //    int realPosition = (int) id;
                intent.putExtras(bundle);
                startActivity(intent);
                // Toast.makeText(getActivity(), "id = " + id, Toast.LENGTH_SHORT).show();
                //FruitList.this.finish();
            }
        });
        bannerContainer = (ViewGroup) findViewById(R.id.bannerContainer);
        this.initBanner();
        this.bv.loadAD();

    }


    private void initBanner() {
        this.bv = new BannerView(this, ADSize.BANNER, Constants.APPID, Constants.BannerPosID);
        bv.setRefresh(30);

        bv.setADListener(new AbstractBannerADListener() {
            @Override
            public void onNoAD(int arg0) {
                Log.i("AD_DEMO", "BannerNoAD，eCode=" + arg0);
            }

            @Override
            public void onADReceiv() {
                Log.i("AD_DEMO", "ONBannerReceive");
            }
        });

        bannerContainer.addView(this.bv);
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

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "会计从业资格考试");//100
        map.put("img", R.drawable.congye);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "会计初级职称考试");//101
        map.put("img", R.drawable.chuji);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "会计中级职称考试");//102
        map.put("img", R.drawable.zhongji);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "高级会计职称考试");//103
        map.put("img", R.drawable.gaoji);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "注册会计职称考试");//104
        map.put("img", R.drawable.zhuce);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "会计实账培训");//105
        map.put("img", R.drawable.shizhang);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "税务知识培训");//106
        map.put("img", R.drawable.shuiwu);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "关于我们");//107
        map.put("img", R.drawable.aboutus);
        list.add(map);
        return list;
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
