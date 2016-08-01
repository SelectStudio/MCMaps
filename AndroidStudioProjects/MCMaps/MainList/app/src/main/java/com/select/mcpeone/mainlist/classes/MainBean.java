package com.select.mcpeone.mainlist.classes;
import java.util.*;

public class MainBean
{
	private String icon;
	private String title;
	private String subTitle;
	private String pic;
	private String picBg;
	private String userName;
	private ArrayList<ListBean> list;
	private String markLevel;
	private boolean isHide;
	
	public MainBean(String pic){
		this.pic=pic;
	}
	public MainBean(String title,String subTitle,String pic,ArrayList<ListBean> list,boolean isHide){
		this.title=title;
		this.subTitle=subTitle;
		this.pic=pic;
		this.list=list;
		this.isHide=isHide;
	}
	public MainBean(String title,String subTitle,ArrayList<ListBean> list,boolean isHide){
		this.title=title;
		this.subTitle=subTitle;
		this.list=list;
		this.isHide=isHide;
	}
	public MainBean(String title,String subTitle,String userName,String icon,String picBg,ArrayList<ListBean> list,boolean isHide){
		this.title=title;
		this.subTitle=subTitle;
		this.picBg=picBg;
		this.icon=icon;
		this.userName=userName;
		this.list=list;
		this.isHide=isHide;
	}
	public MainBean(String title,String subTitle,String userName,String icon,String pic,String markLevel,boolean isHide){
		this.title=title;
		this.subTitle=subTitle;
		this.userName=userName;
		this.icon=icon;
		this.pic=pic;
		this.markLevel=markLevel;
		this.isHide=isHide;
	}
	public void setPic(String pic){
		this.pic=pic;
	}
	public String getPic(){
		return pic;
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
	public void setList(ArrayList<ListBean> list){
		this.list=list;
	}
	public ArrayList<ListBean> getList(){
		return list;
	}
	public void setIsHide(boolean isHide){
		this.isHide=isHide;
	}
	public boolean getIsHide(){
		return isHide;
	}
	public void setMarkLevel(String markLevel){
		this.markLevel=markLevel;
	}
	public String getMarkLevel(){
		return markLevel;
	}
	public void setIcon(String icon){
		this.icon=icon;
	}
	public String getIcon(){
		return icon;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return userName;
	}
	public void setPicBg(String picBg){
		this.picBg=picBg;
	}
	public String getPicBg(){
		return picBg;
	}
}
