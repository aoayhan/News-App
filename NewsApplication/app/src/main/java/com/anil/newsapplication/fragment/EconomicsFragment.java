
package com.anil.newsapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.anil.newsapplication.adapter.NewsAdapter;
import com.anil.newsapplication.model.NewsItemModel;
import com.anil.newsapplication.model.NewsContentModel;
import com.anil.newsapplication.service.ManagerAll;
import com.anil.newsapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EconomicsFragment extends Fragment {

    private View view;
    private RecyclerView economicsRecyclerView;
    private NewsAdapter newsAdapter;

    private List<NewsItemModel> newsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_economics, container, false);
        tanimla();
        getData();
        return view;
    }

    public void tanimla(){
        economicsRecyclerView = view.findViewById(R.id.economicsRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        economicsRecyclerView.setLayoutManager(layoutManager);
        newsList = new ArrayList<>();
    }

    public void getData(){
        Call<NewsContentModel> req  = ManagerAll.getInstance().getNewsByCategory(1);
        req.enqueue(new Callback<NewsContentModel>() {
            @Override
            public void onResponse(Call<NewsContentModel> call, Response<NewsContentModel> response) {
                if (response.body()!=null){
                    //Log.i("gelenVeri", response.body().toString());
                    newsList = response.body().getItems();
                    newsAdapter = new NewsAdapter(newsList, getContext());
                    economicsRecyclerView.setAdapter(newsAdapter);
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