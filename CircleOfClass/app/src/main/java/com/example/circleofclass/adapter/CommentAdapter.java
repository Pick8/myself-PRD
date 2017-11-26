package com.example.circleofclass.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.circleofclass.R;
import com.example.circleofclass.entity.Comment;

import java.util.List;

/**
 * Created by 佩强 on 2017/11/24.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{

    private List<Comment> mCommentList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
        TextView textView;

        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textView);
            fruitName = view.findViewById(R.id.fruit_name);
            fruitImage = view.findViewById(R.id.fruit_image);
        }
    }

    public CommentAdapter(List<Comment> commentList){
        mCommentList = commentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Comment comment = mCommentList.get(position);
        holder.fruitImage.setImageResource(comment.getImageId());
        holder.fruitName.setText(comment.getName());
        holder.textView.setText(comment.getText());
    }

    @Override
    public int getItemCount(){
        return mCommentList.size();
    }

}
