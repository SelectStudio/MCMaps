package com.select.mcmaps.bmob.domain;

/*
* create time 2016-8-2
* 用户类，存放单个用户数据
*/
public class Users
{
	String Name;//用户名
	String IDNumber;//用户id
	String HeadIcon;//用户头像。这里只是保存头像地址
	String Signature;//用户签名
	String Sex;//性别
	String Address;//地址

	//构造函数
	public Users()
	{
		
	}

	//拥有所有参数的构造函数
	public Users(String name, String iDNumber, String headIcon, String signature, String sex, String address)
	{
		Name = name;
		IDNumber = iDNumber;
		HeadIcon = headIcon;
		Signature = signature;
		Sex = sex;
		Address = address;
	}
	
	//设置用户名
	public void setName(String name)
	{
		Name = name;
	}

	//得到用户名
	public String getName()
	{
		return Name;
	}

	//设置用户id
	public void setIDNumber(String iDNumber)
	{
		IDNumber = iDNumber;
	}

	//得到用户id号
	public String getIDNumber()
	{
		return IDNumber;
	}

	//设置头像
	public void setHeadIcon(String headIcon)
	{
		HeadIcon = headIcon;
	}

	//得到头像
	public String getHeadIcon()
	{
		return HeadIcon;
	}

	//设置用户签名
	public void setSignature(String signature)
	{
		Signature = signature;
	}

	//得到用户签名
	public String getSignature()
	{
		return Signature;
	}

	//设置性别
	public void setSex(String sex)
	{
		Sex = sex;
	}

	//得到性别
	public String getSex()
	{
		return Sex;
	}

	//设置地址
	public void setAddress(String address)
	{
		Address = address;
	}

	//得到地址
	public String getAddress()
	{
		return Address;
	}

	/*
	*返回用户所有数据
	*/
	@Override
	public String toString()
	{
		return "用户名:"+Name+",ID:"+IDNumber+",用户头像："+HeadIcon+",签名："+Signature+",性别:"+Sex+",地址"+Address;
	}
	
}
