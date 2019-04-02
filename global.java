package com.example.sis;
import android.app.Application;

public class global extends Application{
	public String UserName;
	public String Password;
	public String Id;
	public String GetUsername()
	{
		return UserName;
	}
	public void Setusername(String _susername)
	{
		UserName=_susername;
	}
	public String GetPassword()
	{
		return Password;
	}
	public void Setpassword(String _spassword)
	{
		Password=_spassword;
	}
}