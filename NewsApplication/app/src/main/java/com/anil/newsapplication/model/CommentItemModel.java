package com.anil.newsapplication.model;

public class CommentItemModel{
	private String name;
	private int id;
	private String text;
	private int newsId;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setNewsId(int newsId){
		this.newsId = newsId;
	}

	public int getNewsId(){
		return newsId;
	}

	@Override
 	public String toString(){
		return 
			"CommentItemModel{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",text = '" + text + '\'' + 
			",news_id = '" + newsId + '\'' + 
			"}";
		}
}
