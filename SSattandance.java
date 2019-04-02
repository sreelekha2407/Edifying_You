package com.example.sis;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class SSattandance extends Fragment {
	TextView id;
	EditText stdid,att,marks;
	SQLiteDatabase db;
	Button sub;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.activity_ssattandance, container, false);
		return rootView;
	}
	@Override
	public void onViewCreated(View view,  Bundle savedInstanceState) 
	{
		final global globalvariabel = (global)getActivity().getApplicationContext();
		id=(TextView)getView().findViewById(R.id.textView2);
		id.setText(globalvariabel.GetUsername().toString());
		stdid=(EditText)getView().findViewById(R.id.editText1);
		att=(EditText)getView().findViewById(R.id.editText2);
		marks=(EditText)getView().findViewById(R.id.editText3);
		sub=(Button)getView().findViewById(R.id.button1);
		db=getActivity().openOrCreateDatabase("sis", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists student1(user varchar,attendance varchar,marks varchar,primary key(user));");
		db.execSQL("create table if not exists student(user varchar, pass varchar, nam varchar,mobile varchar,emid varchar,faname varchar,famo varchar,moname varchar,momo varchar,ssc varchar,inter varchar,eamcet varchar,primary key(user));");
		sub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(stdid.getText().toString().trim().length()==0||
			    		   att.getText().toString().trim().length()==0||
			    		   marks.getText().toString().trim().length()==0)
			    		{
						Toast.makeText(getActivity(), "Enter All the fields", Toast.LENGTH_SHORT).show();
			    			return;
			    		}
			    		Cursor c=db.rawQuery("SELECT * FROM student WHERE user='"+stdid.getText()+"'", null);
			    		if(c.moveToFirst())
			    		{
			    			db.execSQL("INSERT INTO student1 VALUES('"+stdid.getText()+"','"+att.getText()+
				    				   "','"+marks.getText()+"');");
			    			
			    			Toast.makeText(getActivity(), "inserted Success", Toast.LENGTH_SHORT).show();
			    			return;
			    		}
			    		else
			    		{
			    			Toast.makeText(getActivity(), "Invalid Student ID", Toast.LENGTH_SHORT).show();
			    			return;
			    		}			    		
			}
		});
	}
	public void cler()
	{
		stdid.setText("");
		att.setText("");
		marks.setText("");
	}
}