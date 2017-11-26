package com.example.circleofclass.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.circleofclass.CommentActivity;
import com.example.circleofclass.DetailsActivity;
import com.example.circleofclass.OthersHomeActivity;
import com.example.circleofclass.entity.Fruit;
import com.example.circleofclass.R;

import java.util.List;

/**
 * Created by 佩强 on 2017/11/13.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageButton imageButton;
        ImageButton imageButton2;
        ImageView fruitImage;
        TextView fruitName;
        TextView listItem;

        ViewHolder(View view){
            super(view);
            imageButton = view.findViewById(R.id.imageButton);
            imageButton2 = view.findViewById(R.id.imageButton2);
            fruitImage = view.findViewById(R.id.fruit_image);
            fruitName = view.findViewById(R.id.fruit_name);
            listItem = view.findViewById(R.id.list_item);
        }
    }

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),"正在进入评论！",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), CommentActivity.class);
                intent.putExtra("fruit",fruit);
                view.getContext().startActivity(intent);
            }
        });
        holder.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),"已赞！"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),"进入主页！"+fruit.getName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), OthersHomeActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        holder.fruitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),"进入主页！"+fruit.getName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), OthersHomeActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        holder.listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),"进入消息详情页！"+fruit.getName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

}
