package com.anil.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.anil.newsapplication.adapter.CommentsAdapter;
import com.anil.newsapplication.model.CommentItemModel;
import com.anil.newsapplication.model.CommentsContentModel;
import com.anil.newsapplication.service.ManagerAll;
import com.anil.newsapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsActivity extends AppCompatActivity {

    private List<CommentItemModel> commentsList;
    public String newsId;
    public RecyclerView commentsRecview;
    public CommentsAdapter commentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        tanimla();
        getData();
    }

    public void tanimla(){
        Toolbar toolbar = findViewById(R.id.toolbarComments);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        newsId = intent.getStringExtra("newsid").toString();
        commentsRecview = findViewById(R.id.commentsRecview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        commentsRecview.setLayoutManager(layoutManager);
        commentsList = new ArrayList<>();
        getSupportActionBar().setTitle("Comments");
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    public void getData(){
        Call<CommentsContentModel> req  = ManagerAll.getInstance().getCommentsByNewsId(Integer.parseInt(newsId));
        req.enqueue(new Callback<CommentsContentModel>() {
            @Override
            public void onResponse(Call<CommentsContentModel> call, Response<CommentsContentModel> response) {
                if (response.body()!=null){
                    //Log.i("gelenVeri", response.body().toString());
                    commentsList = response.body().getItems();
                    commentsAdapter = new CommentsAdapter(commentsList, getApplicationContext());
                    commentsRecview.setAdapter(commentsAdapter);
                }
                Log.i("gelenVeri", "veri yok");
            }

            @Override
            public void onFailure(Call<CommentsContentModel> call, Throwable t) {
                Log.i("basarisiz", t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu and add the comments button
        getMenuInflater().inflate(R.menu.menu_add_comment, menu);
        return true;
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
        if (item.getItemId() == R.id.action_add_comment) {
            // Start the comments activity
            Intent intent = new Intent(this, AddCommentActivity.class);
            intent.putExtra("newsid", newsId);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}