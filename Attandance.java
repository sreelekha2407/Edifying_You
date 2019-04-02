package com.example.sis;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
public class Attandance extends Fragment {
	TextView id;
	SQLiteDatabase db;
	ImageView out;
	TextView aaa;
	ListView l;
	EditText t1;
	 ArrayList<String> list1;
	 ArrayAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.activity_attandance, container, false);
		return rootView;
	}
	@Override
	public void onViewCreated(View view,  Bundle savedInstanceState) 
	{
		final global globalvariabel = (global)getActivity().getApplicationContext();
		id=(TextView)getView().findViewById(R.id.textView2);
		//attend=(TextView)getView().findViewById(R.id.textView4);
		try{
		id.setText(globalvariabel.GetUsername().toString());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		db=getActivity().openOrCreateDatabase("sis", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists student1(user varchar,attendance varchar,marks varchar,primary key(user));");
		l = (ListView)getView().findViewById(R.id.listView1);
		final ArrayList<String> list = new ArrayList<String>();
		 list1 = new ArrayList<String>();
		 Cursor res=db.rawQuery("SELECT * FROM student1 where user='"+id.getText().toString()+"'", null);
		if(res.getCount()!=0)
		{
			while (res.moveToNext())
			{
				list.add("Attendance:   "+res.getString(1));
	            list1.add(res.getString(1));
			}
		}
		adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
		l.setAdapter(adapter);
	}
}