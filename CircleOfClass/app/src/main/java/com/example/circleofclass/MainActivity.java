package com.example.circleofclass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.circleofclass.acrivityManager.HttpUtil;
import com.example.circleofclass.adapter.FruitAdapter;
import com.example.circleofclass.entity.Fruit;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home_item:
                Intent intent = new Intent(MainActivity.this, PersonalHomeActivity.class);
                startActivity(intent);
                break;
            case R.id.write_item:
                intent = new Intent(MainActivity.this, ShareActivity.class);
                startActivity(intent);
            case R.id.finish_item:
                finish();
                break;
            default:
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        RefreshLayout refreshLayout = (RefreshLayout)findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
            }
        });
        imageView = findViewById(R.id.image_view);
        String url = "http://area.sinaapp.com/bingImg";
        Glide.with(this).load(url).into(imageView);
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++){
            Fruit apple = new Fruit("Apple",R.drawable.ic_launcher_background);
            fruitList.add(apple);
            Fruit banana = new Fruit("banana",R.mipmap.ic_launcher);
            fruitList.add(banana);
            Fruit orange = new Fruit("orange",R.mipmap.ic_launcher);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("watermelon",R.mipmap.ic_launcher);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("pear",R.mipmap.ic_launcher);
            fruitList.add(pear);
            Fruit grape = new Fruit("grape",R.mipmap.ic_launcher);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("pineapple",R.mipmap.ic_launcher);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("strawberry",R.mipmap.ic_launcher);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("cherry",R.mipmap.ic_launcher);
            fruitList.add(cherry);
            Fruit mango = new Fruit("mango",R.mipmap.ic_launcher);
            fruitList.add(mango);

        }
    }

}
