package com.anil.newsapplication.model;

import java.util.List;

public class CommentsContentModel {
	private String serviceMessageText;
	private int serviceMessageCode;
	private List<CommentItemModel> items;

	public void setServiceMessageText(String serviceMessageText){
		this.serviceMessageText = serviceMessageText;
	}

	public String getServiceMessageText(){
		return serviceMessageText;
	}

	public void setServiceMessageCode(int serviceMessageCode){
		this.serviceMessageCode = serviceMessageCode;
	}

	public int getServiceMessageCode(){
		return serviceMessageCode;
	}

	public void setItems(List<CommentItemModel> items){
		this.items = items;
	}

	public List<CommentItemModel> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"NewsContentModel{" + 
			"serviceMessageText = '" + serviceMessageText + '\'' + 
			",serviceMessageCode = '" + serviceMessageCode + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}