package com.anil.newsapplication.model;

public class CommentAddedModel{
	private String serviceMessageText;
	private int serviceMessageCode;
	private Object items;

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

	public void setItems(Object items){
		this.items = items;
	}

	public Object getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"CommentAddedModel{" + 
			"serviceMessageText = '" + serviceMessageText + '\'' + 
			",serviceMessageCode = '" + serviceMessageCode + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}
