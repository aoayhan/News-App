package com.anil.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.anil.newsapplication.model.NewsItemModel;
import com.anil.newsapplication.model.NewsContentModel;
import com.anil.newsapplication.service.ManagerAll;
import com.anil.newsapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsDetailsActivity extends AppCompatActivity {

    private List<NewsItemModel> newsList;
    private String newsId;
    private TextView newsDetailsTitle, newsDetailsContent;
    private ImageView newsDetailsImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        tanimla();
        getData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu and add the comments button
        getMenuInflater().inflate(R.menu.menu_comments, menu);
        return true;
    }

    public void tanimla(){
        Toolbar toolbar = findViewById(R.id.toolbarDetails);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        newsId = intent.getStringExtra("newsid").toString();
        newsDetailsTitle = findViewById(R.id.newsDetailsTitle);
        newsDetailsContent = findViewById(R.id.newsDetailsContent);
        newsDetailsImage = findViewById(R.id.newsDetailsImage);
        getSupportActionBar().setTitle("News Details");
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Handle the back button press
        onBackPressed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle the comments button click
        if (item.getItemId() == R.id.action_comments) {
            // Start the comments activity
            Intent intent = new Intent(this, CommentsActivity.class);
            intent.putExtra("newsid", newsId);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getData(){
        Call<NewsContentModel> req  = ManagerAll.getInstance().getNewsById(Integer.parseInt(newsId.toString()));
        req.enqueue(new Callback<NewsContentModel>() {
            @Override
            public void onResponse(Call<NewsContentModel> call, Response<NewsContentModel> response) {
                if (response.body()!=null){
                    //Log.i("gelenVeri", response.body().toString());
                    newsList = response.body().getItems();
                    newsDetailsTitle.setText(newsList.get(0).getTitle());
                    newsDetailsContent.setText(newsList.get(0).getText());
                    newsId = String.valueOf(newsList.get(0).getId());
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