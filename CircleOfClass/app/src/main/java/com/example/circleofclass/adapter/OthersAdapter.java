package com.example.circleofclass.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.circleofclass.DetailsActivity;
import com.example.circleofclass.R;
import com.example.circleofclass.entity.Fruit;

import java.util.List;

/**
 * Created by 佩强 on 2017/11/21.
 */

public class OthersAdapter extends RecyclerView.Adapter<OthersAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView listItem;
        ImageView fruitImage;
        TextView fruitName;
        ViewHolder(View view){
            super(view);
            listItem = view.findViewById(R.id.list_item);
            fruitImage = view.findViewById(R.id.fruit_image);
            fruitName = view.findViewById(R.id.fruit_name);
        }
    }

    public OthersAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.others_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(), "进入消息详情页！" + fruit.getName(), Toast.LENGTH_SHORT).show();
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
