package com.anil.newsapplication.service;

import com.anil.newsapplication.model.CategoryModel;
import com.anil.newsapplication.model.CommentAddedModel;
import com.anil.newsapplication.model.CommentsContentModel;
import com.anil.newsapplication.model.NewsContentModel;
import com.anil.newsapplication.model.PostCommentDto;

import retrofit2.Call;

public class ManagerAll extends BaseManager{

    private  static ManagerAll ourInstance = new ManagerAll();

    public  static synchronized ManagerAll getInstance()
    {
        return  ourInstance;
    }

    public Call<CategoryModel> getCategories()
    {
        Call<CategoryModel> x = getRestApi().getCategories();
        return  x ;
    }

    public Call<NewsContentModel> getNewsByCategory(int categoryId)
    {
        Call<NewsContentModel> x = getRestApi().getNewsByCategory(categoryId);
        return  x ;
    }

    public Call<NewsContentModel> getNewsById(int newsId)
    {
        Call<NewsContentModel> x = getRestApi().getNewsById(newsId);
        return  x ;
    }

    public Call<CommentsContentModel> getCommentsByNewsId(int newsId){
        Call<CommentsContentModel> x = getRestApi().getCommentsByNewsId(newsId);
        return  x ;
    }

    public Call<CommentAddedModel> postComment(PostCommentDto commentDto){
        Call<CommentAddedModel> x = getRestApi().postComment(commentDto);
        return x;
    }
}
