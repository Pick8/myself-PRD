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
 * Created by 佩强 on 2017/11/18.
 */

public class PersonalAdapter extends RecyclerView.Adapter<PersonalAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView listItem;
        TextView deleteText;
        ImageView fruitImage;
        TextView fruitName;

        ViewHolder(View view){
            super(view);
            listItem = view.findViewById(R.id.list_item);
            deleteText = view.findViewById(R.id.delete_text);
            fruitImage = view.findViewById(R.id.fruit_image);
            fruitName = view.findViewById(R.id.fruit_name);
        }

    }

    public PersonalAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personal_item,parent,false);
         final ViewHolder holder = new ViewHolder(view);
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
        holder.deleteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),"已删除！"+fruit.getName(),Toast.LENGTH_SHORT).show();
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
