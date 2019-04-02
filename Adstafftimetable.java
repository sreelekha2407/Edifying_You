package com.example.sis;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class Adstafftimetable extends Fragment 
{
	TextView id;
	SQLiteDatabase db;
	ListView l;
	Button sub;
	EditText stfid,s1,s2,s3,t1,t2,t3;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.activity_adstafftimetable, container, false);
		return rootView;
	}
	@Override
	public void onViewCreated(View view,  Bundle savedInstanceState) 
	{
		final global globalvariabel = (global)getActivity().getApplicationContext();
		id=(TextView)getView().findViewById(R.id.textView2);
		id.setText(globalvariabel.GetUsername().toString());
		t1=(EditText)getView().findViewById(R.id.editText2);
		t2=(EditText)getView().findViewById(R.id.editText5);
		t3=(EditText)getView().findViewById(R.id.editText7);
		s1=(EditText)getView().findViewById(R.id.editText1);
		s3=(EditText)getView().findViewById(R.id.editText4);
		s2=(EditText)getView().findViewById(R.id.editText6);
		stfid=(EditText)getView().findViewById(R.id.editText3);
		sub=(Button)getView().findViewById(R.id.button1);
		
		db=getActivity().openOrCreateDatabase("sis", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists timetable(stfid varchar, suba varchar,subb varchar,subc varchar,ta varchar,tb varchar,tc varchar,primary key(stfid));");
		sub.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
					if(stfid.getText().toString().trim().length()==0||
			    		   s1.getText().toString().trim().length()==0||
			    		   s2.getText().toString().trim().length()==0||
			    		   s3.getText().toString().trim().length()==0||
			    		   t1.getText().toString().trim().length()==0||
			    		   t2.getText().toString().trim().length()==0||
			    		   t3.getText().toString().trim().length()==0)
			    		{
						Toast.makeText(getActivity(), "Enter All the fields", Toast.LENGTH_SHORT).show();
			    			return;
			    		}
			    		Cursor c=db.rawQuery("SELECT * FROM staff WHERE user='"+stfid.getText()+"'", null);
			    		if(c.moveToFirst())
			    		{
			    			db.execSQL("INSERT INTO timetable VALUES('"+stfid.getText()+"','"+s1.getText()+
				    				   "','"+s2.getText()+"','"+s3.getText()+"','"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"');");
			    			Toast.makeText(getActivity(), "Inserted Success", Toast.LENGTH_SHORT).show();
			    			clr();
			    			return;			    				
			    		}
			    		else
			    		{
			    			Toast.makeText(getActivity(), "Invalid Staff ID", Toast.LENGTH_SHORT).show();
			    			clr();
			    			return;	
			    		}		    		
			}
		});		
	}
	public void clr() 
	{
		stfid.setText(" ");
		s1.setText(" ");
		s2.setText(" ");
		s3.setText(" ");
		t1.setText(" ");
		t2.setText(" ");
		t3.setText(" ");
	}
}