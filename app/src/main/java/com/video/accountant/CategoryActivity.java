package com.video.accountant;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_category);
        initWindow();
        Intent intent = getIntent();
        Long id = intent.getLongExtra("id", 1);
        String title = intent.getStringExtra("title");

        TextView textViewTitle = (TextView) findViewById(R.id.list_title);
        textViewTitle.setText(title);
        listView = (ListView) findViewById(R.id.list_category);

        SimpleAdapter adapter = new SimpleAdapter(this, getData(id), R.layout.list_item,
                new String[]{"title", "img"},
                new int[]{R.id.title, R.id.img}
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String, String> map = (HashMap<String, String>) listView.getItemAtPosition(position);
                String title = map.get("title");
                String index = map.get("index");

                Log.i("index", index);

                Intent intent = new Intent(CategoryActivity.this, ListActivity.class);
                Bundle bundle = new Bundle();
                //Toast.makeText(getApplicationContext(), "index = " + index, Toast.LENGTH_SHORT).show();
                bundle.putString("id", index);
                bundle.putString("title", title);
                intent.putExtras(bundle);
                startActivity(intent);
                //Toast.makeText(getActivity(), "id = " + id, Toast.LENGTH_SHORT).show();
                //FruitList.this.finish();
            }
        });

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
    private List<Map<String, Object>> getData(Long id) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        String key = Long.toString(id);
        switch (key) {
            case "100":
                map.put("title", "会计基础");//100
                map.put("img", R.drawable.kuaijichu);
                map.put("index", "11");
                list.add(map);

                map = new HashMap<String, Object>();
                map.put("title", "财经法规与会计职业道德");//101
                map.put("img", R.drawable.caijinfagui);
                map.put("index", "12");
                list.add(map);

                map = new HashMap<String, Object>();
                map.put("title", "电算化");//102
                map.put("img", R.drawable.diansuanhua);
                map.put("index", "13");
                list.add(map);
                break;
            case "101":
                map.put("title", "初级会计实务");//100
                map.put("img", R.drawable.chujikuaijishiwu);
                map.put("index", "21");
                list.add(map);

                map = new HashMap<String, Object>();
                map.put("title", "经济法基础");//102
                map.put("index", "22");
                map.put("img", R.drawable.jinjifajichu);
                list.add(map);
                break;
            case "102":
                map.put("title", "中级会计实务");//100
                map.put("img", R.drawable.zhongjikuaijishiwu);
                map.put("index", "31");
                list.add(map);

                map = new HashMap<String, Object>();
                map.put("title", "财务管理");//102
                map.put("img", R.drawable.caiwuguanli);
                map.put("index", "32");
                list.add(map);
                map = new HashMap<String, Object>();
                map.put("title", "经济法");//102
                map.put("img", R.drawable.jinjifa);
                map.put("index", "33");
                list.add(map);
                break;
            case "103":
                map.put("title", "高级会计实务");//100
                map.put("img", R.drawable.zhongjikuaijishiwu);
                map.put("index", "41");
                list.add(map);

                break;
            case "104":
                map.put("title", "会计");//100
                map.put("img", R.drawable.zhongjikuaijishiwu);
                map.put("index", "51");
                list.add(map);

                map = new HashMap<String, Object>();
                map.put("title", "审计");//102
                map.put("img", R.drawable.caiwuguanli);
                map.put("index", "52");
                list.add(map);
                map = new HashMap<String, Object>();
                map.put("title", "财务成本管理");//102
                map.put("img", R.drawable.jinjifa);
                map.put("index", "53");
                list.add(map);

                map = new HashMap<String, Object>();
                map.put("title", "公司战略与风险管理");//102
                map.put("img", R.drawable.shuiwu);
                map.put("index", "54");
                list.add(map);

                map = new HashMap<String, Object>();
                map.put("title", "经济法");//102
                map.put("img", R.drawable.diansuanhua);
                map.put("index", "55");
                list.add(map);

                map = new HashMap<String, Object>();
                map.put("title", "税法");//102
                map.put("img", R.drawable.shuiwu);
                map.put("index", "56");
                list.add(map);

                break;

            case "105":
                map.put("title", "帐务处理能力提升");//100
                map.put("img", R.drawable.zhangwuchuli);
                map.put("index", "61");
                list.add(map);

                map = new HashMap<String, Object>();
                map.put("title", "税务操作能力提升");//102
                map.put("img", R.drawable.zhongji);
                map.put("index", "62");
                list.add(map);
                map = new HashMap<String, Object>();
                map.put("title", "岗位胜任能力提升");//102
                map.put("index", "63");
                map.put("img", R.drawable.zhongji);
                list.add(map);

                break;
            case "106":
                map.put("title", "合理避税");//100
                map.put("img", R.drawable.congye);
                map.put("index", "71");
                list.add(map);

                map = new HashMap<String, Object>();
                map.put("title", "营改增培训");//102
                map.put("img", R.drawable.zhongji);
                map.put("index", "72");
                list.add(map);
                break;
            case "107":
                map.put("title", "关于我们");//100
                map.put("img", R.drawable.congye);
                map.put("index", "81");
                list.add(map);
                break;
            default:
                break;
        }


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
