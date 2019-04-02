package com.example.sis;

import java.util.ArrayList;
import android.os.Bundle;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
public class Stafftimetable extends Fragment 
{
	TextView id;
	//ImageView out;
	//TextView aaa;
	SQLiteDatabase db;
	ListView l;
	EditText t1;
	 ArrayList<String> list1;
	 ArrayAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.activity_stafftimetable, container, false);
		return rootView;
	}
	@Override
	public void onViewCreated(View view,  Bundle savedInstanceState) 
	{
		final global globalvariabel = (global)getActivity().getApplicationContext();
		id=(TextView)getView().findViewById(R.id.textView2);
		id.setText(globalvariabel.GetUsername().toString());
		//out=(ImageView)getView().findViewById(R.id.imageView1);
		
		db=getActivity().openOrCreateDatabase("sis", Context.MODE_PRIVATE, null);
		l = (ListView)getView().findViewById(R.id.listView1);
		final ArrayList<String> list = new ArrayList<String>();
		 list1 = new ArrayList<String>();
		 Cursor res=db.rawQuery("SELECT * FROM timetable where stfid='"+id.getText().toString()+"'", null);
			if(res.getCount()!=0)
			{
				while (res.moveToNext())
				{
					list.add(res.getString(1)+"     "+res.getString(4)+"\n"+res.getString(2)+"        "+res.getString(5)+"\n"+res.getString(3)+"       "+res.getString(6));
		            list1.add(res.getString(1));
				}
			}
			adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
			l.setAdapter(adapter);		
		/*		out.setOnClickListener(new OnClickListener() {
						@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(),Login.class));
			}
		});*/
	}
}