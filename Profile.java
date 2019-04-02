package com.example.sis;

import java.util.ArrayList;

import com.example.sis.global;
import com.example.sis.R;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
public class Profile extends Fragment {
	TextView id;
	ImageView out;
	TextView aaa;
	SQLiteDatabase db;
	ListView l;
	EditText t1;
	 ArrayList<String> list1;
	 ArrayAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_profile, container, false);
		return rootView;
	}
	@Override
	public void onViewCreated(View view,  Bundle savedInstanceState) {
		final global globalvariabel = (global)getActivity().getApplicationContext();
		id=(TextView)getView().findViewById(R.id.textView2);
		id.setText(globalvariabel.GetUsername().toString());
		out=(ImageView)getView().findViewById(R.id.imageView1);

		db=getActivity().openOrCreateDatabase("sis", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists student(user varchar, pass varchar, nam varchar,mobile varchar,emid varchar,faname varchar,famo varchar,moname varchar,momo varchar,ssc varchar,inter varchar,eamcet varchar,primary key(user));");
		l = (ListView)getView().findViewById(R.id.listView1);
		final ArrayList<String> list = new ArrayList<String>();
		list1 = new ArrayList<String>();
		Cursor res=db.rawQuery("SELECT * FROM student where user='"+id.getText().toString()+"'", null);
		if(res.getCount()!=0)
		{
			while (res.moveToNext())
			{
	            list.add("User Id:   "+res.getString(0)+"\nPassword:   "+res.getString(1)+"\n"+"Nmae:   "+res.getString(2)+"\n"+"Mobile:   "+res.getString(3)+"\n"+"Email:   "+res.getString(4)+"\n"+"Father's name:"+res.getString(5)+"\n"+"Father's Mobile Number:"+res.getString(6)+"\n"+"Mother's name:"+res.getString(7)+"\n"+"Mother's Mobile Number:"+res.getString(8)+"\n"+"SSC Marks:"+res.getString(9)+"\n"+"Inter Marks:"+res.getString(10)+"\n"+"Eamcet:"+res.getString(11));
	            list1.add(res.getString(1));
			}
		}
		adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
		l.setAdapter(adapter);
		out.setOnClickListener(new OnClickListener() {
			@Override
public void onClick(View v) {
	startActivity(new Intent(getActivity(),FirstActivity.class));
}
});
	}
}
