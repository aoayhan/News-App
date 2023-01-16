package com.anil.newsapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.anil.newsapplication.model.CommentItemModel;
import com.anil.newsapplication.R;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder> {

    List<CommentItemModel> list;
    Context context;

    public CommentsAdapter(List<CommentItemModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_item_layout, parent, false);
        return new CommentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder holder, int position) {
        holder.commentTitle.setText(list.get(position).getName());
        holder.commentContent.setText(list.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CommentsViewHolder extends RecyclerView.ViewHolder{
        TextView commentTitle, commentContent;
        public CommentsViewHolder(View itemView){
            super(itemView);
            commentTitle = itemView.findViewById(R.id.commentTitle);
            commentContent = itemView.findViewById(R.id.commentContent);
        }
    }

}
