package com.anil.newsapplication.model;

import java.util.List;

public class NewsContentModel{
	private String serviceMessageText;
	private int serviceMessageCode;
	private List<NewsItemModel> items;

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

	public void setItems(List<NewsItemModel> items){
		this.items = items;
	}

	public List<NewsItemModel> getItems(){
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