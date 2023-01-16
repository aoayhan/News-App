
package com.anil.newsapplication.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.anil.newsapplication.model.NewsItemModel;
import com.anil.newsapplication.model.NewsContentModel;
import com.anil.newsapplication.service.ManagerAll;
import com.anil.newsapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsDetailsFragment extends Fragment {

    private String newsId;
    private View view;
    private TextView newsDetailsTitle, newsDetailsContent;
    private ImageView newsDetailsImage;

    private List<NewsItemModel> newsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_news_details, container, false);
        //tanimla();
        getData();
        return view;
    }

    public void tanimla(){
        newsId = getArguments().getString("newsid").toString();
        newsDetailsTitle = view.findViewById(R.id.newsDetailsTitle);
        newsDetailsContent = view.findViewById(R.id.newsDetailsContent);
        newsDetailsImage = view.findViewById(R.id.newsDetailsImage);
    }

    public void getData(){
        Call<NewsContentModel> req  = ManagerAll.getInstance().getNewsByCategory(1);
        req.enqueue(new Callback<NewsContentModel>() {
            @Override
            public void onResponse(Call<NewsContentModel> call, Response<NewsContentModel> response) {
                if (response.body()!=null){
                    //Log.i("gelenVeri", response.body().toString());
                    newsList = response.body().getItems();
                    newsDetailsTitle.setText(newsList.get(0).getTitle());
                    newsDetailsContent.setText(newsList.get(0).getText());
                    Picasso.get().load(newsList.get(0).getImage()).into(newsDetailsImage);
                }
                Log.i("gelenVeri", "veri yok");
            }

            @Override
            public void onFailure(Call<NewsContentModel> call, Throwable t) {
                Log.i("basarisiz", t.getMessage());
            }
        });
    }

}