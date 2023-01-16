package com.anil.newsapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anil.newsapplication.NewsDetailsActivity;
import com.anil.newsapplication.model.NewsItemModel;
import com.anil.newsapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    List<NewsItemModel> list;
    Context context;

    public NewsAdapter(List<NewsItemModel> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.feed_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        holder.haberBaslik.setText(list.get(position).getTitle());
        Picasso.get().load(list.get(position).getImage()).into(holder.haberResim);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NewsDetailsActivity.class);
                intent.putExtra("newsid", String.valueOf(list.get(position).getId()));
                view.getContext().startActivity(intent);
                Log.i("newsid", String.valueOf(list.get(position).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView haberBaslik;
        ImageView haberResim;
        public ViewHolder(View itemView){
            super(itemView);
            haberBaslik = itemView.findViewById(R.id.feedItemTitle);
            haberResim = itemView.findViewById(R.id.feedItemImage);
        }
    }

}
