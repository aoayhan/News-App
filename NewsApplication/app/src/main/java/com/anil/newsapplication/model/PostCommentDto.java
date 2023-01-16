package com.anil.newsapplication.model;

public class PostCommentDto {
    private String name;
    private String text;
    private String news_id;

    public PostCommentDto(String name, String newsId, String text) {
        this.name = name;
        this.news_id = newsId;
        this.text = text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return
                "PostCommentDto{" +
                        "“name” = '" + name + '\'' +
                        ",“text” = '" + text + '\'' +
                        ",“news_id” = '" + news_id + '\'' +
                        "}";
    }
}
