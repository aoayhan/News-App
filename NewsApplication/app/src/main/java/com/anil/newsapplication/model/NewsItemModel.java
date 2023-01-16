package com.anil.newsapplication.model;

public class NewsItemModel {
	private String date;
	private String image;
	private int id;
	private String text;
	private String title;
	private String categoryName;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
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

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public String getCategoryName(){
		return categoryName;
	}

	@Override
 	public String toString(){
		return 
			"ItemsItem{" + 
			"date = '" + date + '\'' + 
			",image = '" + image + '\'' + 
			",id = '" + id + '\'' + 
			",text = '" + text + '\'' + 
			",title = '" + title + '\'' + 
			",categoryName = '" + categoryName + '\'' + 
			"}";
		}
}
