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
	private int type;
	//PIC
	public MainBean(String pic,int type){
		this.pic=pic;
		this.type=type;
	}
	//PICBG
	public MainBean(String title,String subTitle,String picBg,ArrayList<ListBean> list,boolean isHide,int type){
		this.title=title;
		this.subTitle=subTitle;
		this.picBg=picBg;
		this.list=list;
		this.isHide=isHide;
		this.type=type;
	}
	//NORMAL
	public MainBean(String title,String subTitle,ArrayList<ListBean> list,boolean isHide,int type){
		this.title=title;
		this.subTitle=subTitle;
		this.list=list;
		this.isHide=isHide;
		this.type=type;

	}
	//USER
	public MainBean(String userName,String icon,String picBg,ArrayList<ListBean> list,int type){
		this.picBg=picBg;
		this.icon=icon;
		this.userName=userName;
		this.list=list;
		this.type=type;
	}
	//INFO
	public MainBean(String title,String subTitle,String icon,String pic,int type){
		this.title=title;
		this.subTitle=subTitle;
		this.icon=icon;
		this.pic=pic;
		this.type=type;
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
	public void setType(String picBg){
		this.type=type;
	}
	public int getType(){
		return type;
	}
}
