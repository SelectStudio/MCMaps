package com.select.mcpeone.mainlist.classes;
public class ListBean
{
	private String icon;
	private String title;
	private String subTitle;
	private String markLevel;
	public ListBean(String title,String subTitle,String icon,String markLevel){
		this.title=title;
		this.subTitle=subTitle;
		this.icon=icon;
		this.markLevel=markLevel;
	}
	public void setIcon(String icon){
		this.icon=icon;
	}
	public String getIcon(){
		return icon;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public void setSubTitle(String subTitle){
		this.subTitle=subTitle;
	}
	public String getSubTitle(){
		return subTitle;
	}
	public void setMarkLevel(String markLevel){
		this.markLevel=markLevel;
	}
	public String getMarkLevel(){
		return markLevel;
	}
}
