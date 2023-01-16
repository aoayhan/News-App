package com.anil.newsapplication.model;

import java.util.List;

public class CategoryModel{
	private int serviceMessageCode;
	private String serviceMessageText;
	private List<CategoryItemModel> items;

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

	public void setItems(List<CategoryItemModel> items){
		this.items = items;
	}

	public List<CategoryItemModel> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"CategoryModel{" + 
			"serviceMessageText = '" + serviceMessageText + '\'' + 
			",serviceMessageCode = '" + serviceMessageCode + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}