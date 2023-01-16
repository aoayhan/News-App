package com.anil.newsapplication.service;

import com.anil.newsapplication.model.CategoryModel;
import com.anil.newsapplication.model.CommentAddedModel;
import com.anil.newsapplication.model.CommentsContentModel;
import com.anil.newsapplication.model.NewsContentModel;
import com.anil.newsapplication.model.PostCommentDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestApi {

    @GET("getallnewscategories")
    Call<CategoryModel> getCategories();

    @GET("getbycategoryid/{categoryId}")
    Call<NewsContentModel> getNewsByCategory(@Path("categoryId") int categoryId);

    @GET("getnewsbyid/{newsId}")
    Call<NewsContentModel> getNewsById(@Path("newsId") int newsId);

    @GET("getcommentsbynewsid/{newsId}")
    Call<CommentsContentModel> getCommentsByNewsId(@Path("newsId") int newsId);

    @POST("savecomment")
    Call<CommentAddedModel> postComment(@Body PostCommentDto commentDto);
}
