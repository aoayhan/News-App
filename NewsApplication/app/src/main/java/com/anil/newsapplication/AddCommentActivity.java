package com.anil.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anil.newsapplication.model.CommentAddedModel;
import com.anil.newsapplication.model.PostCommentDto;
import com.anil.newsapplication.service.ManagerAll;
import com.anil.newsapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCommentActivity extends AppCompatActivity {

    EditText commentName, commentText;
    Button postCommentButton;
    String newsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);
        Intent intent = getIntent();
        newsId = intent.getStringExtra("newsid").toString();
        tanimla();
        postCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(commentName.getText() != null && commentText.getText()!=null){
                    PostCommentDto commentDto = new PostCommentDto(commentName.getText().toString(), newsId, commentText.getText().toString());
                    postComment(commentDto);
                }
                else {
                    Toast.makeText(AddCommentActivity.this, "Please Fill The Required Fields", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void tanimla(){
        commentName = findViewById(R.id.commentName);
        commentText = findViewById(R.id.commentText);
        postCommentButton = findViewById(R.id.postCommentButton);
    }

    public void postComment(PostCommentDto dto){
        Call<CommentAddedModel> req =ManagerAll.getInstance().postComment(dto);
        req.enqueue(new Callback<CommentAddedModel>() {
            @Override
            public void onResponse(Call<CommentAddedModel> call, Response<CommentAddedModel> response) {
                Log.i("response", response.body().toString());
                Toast.makeText(AddCommentActivity.this, "Comment Added Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CommentAddedModel> call, Throwable t) {
                Toast.makeText(AddCommentActivity.this, "Comment Couldn't Added", Toast.LENGTH_SHORT).show();
            }
        });
    }

}