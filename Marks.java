package com.example.sis;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
public class Marks extends Fragment 
{
	TextView id,marks;
	SQLiteDatabase db;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.activity_marks, container, false);
		return rootView;
	}
	@Override
	public void onViewCreated(View view,  Bundle savedInstanceState) 
	{
		final global globalvariabel = (global)getActivity().getApplicationContext();
		id=(TextView)getView().findViewById(R.id.textView2);
		marks=(TextView)getView().findViewById(R.id.textView4);
		try
		{
			id.setText(globalvariabel.GetUsername().toString());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		db=getActivity().openOrCreateDatabase("sis", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists student1(user varchar,attendance varchar,marks varchar,primary key(user));");
		Cursor res=db.rawQuery("SELECT * FROM student1 where user='"+id.getText().toString()+"'", null);
		if(res.getCount()!=0)
		{
			while (res.moveToNext())
			{
				try
				{
					marks.setText(res.getString(2).toString());
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
	    }
	}
}