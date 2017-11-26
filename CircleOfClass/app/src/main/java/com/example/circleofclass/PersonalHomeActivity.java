package com.example.circleofclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.circleofclass.adapter.PersonalAdapter;
import com.example.circleofclass.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

public class PersonalHomeActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_home);
        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view2);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);
        PersonalAdapter adapter = new PersonalAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        imageView = (ImageView) findViewById(R.id.image_view);
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
