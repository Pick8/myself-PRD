package com.example.circleofclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.circleofclass.adapter.CommentAdapter;
import com.example.circleofclass.entity.Comment;
import com.example.circleofclass.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {

    private List<Comment> commentList = new ArrayList<>();
    private ImageView fruitImage;
    private TextView fruitName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initComments();
        RecyclerView recyclerView = findViewById(R.id.recycler_comment_view);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);
        CommentAdapter adapter = new CommentAdapter(commentList);
        recyclerView.setAdapter(adapter);
        Fruit fruit = (Fruit) getIntent().getSerializableExtra("fruit");
        fruitImage = (ImageView) findViewById(R.id.fruit_image);
        fruitName = (TextView) findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
    }

    private void initComments(){
        for (int i = 0; i < 10; i++){
            Comment c1 = new Comment("Apple", R.mipmap.ic_launcher);
            commentList.add(c1);
            Comment c2 = new Comment("banana", R.mipmap.ic_launcher);
            commentList.add(c2);
            Comment c3 = new Comment("orange", R.mipmap.ic_launcher);
            commentList.add(c3);
        }
    }
}
