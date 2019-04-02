package com.example.sis;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class Staffdetails extends Fragment {
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

		View rootView = inflater.inflate(R.layout.activity_staffdetails, container, false);
		return rootView;
	}
	@Override
	public void onViewCreated(View view,  Bundle savedInstanceState) {
		final global globalvariabel = (global)getActivity().getApplicationContext();
		id=(TextView)getView().findViewById(R.id.textView2);
		id.setText(globalvariabel.GetUsername().toString());
		out=(ImageView)getView().findViewById(R.id.imageView1);
		t1=(EditText)getView().findViewById(R.id.search);
		
		db=getActivity().openOrCreateDatabase("sis", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists staff(user varchar, pass varchar, nam varchar,mobile varchar,emid varchar,qual varchar,exper varchar);");
		l = (ListView)getView().findViewById(R.id.listView1);
		final ArrayList<String> list = new ArrayList<String>();
		 list1 = new ArrayList<String>();
		 Cursor res=db.rawQuery("SELECT * FROM staff", null);
		if(res.getCount()!=0)
		{
			while (res.moveToNext())
			{
	            list.add("User Id:   "+res.getString(0)+"\nPassword:   "+res.getString(1)+"\n"+"Nmae:   "+res.getString(2)+"\n"+"Mobile:   "+res.getString(3)+"\n"+"Email:   "+res.getString(4)+"\n"+"Qualification"+res.getString(5)+"\n"+"Experience"+res.getString(6));
	            list1.add(res.getString(1));
			}
		}
		adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
		l.setAdapter(adapter);
	
		// (close)
		
		/// search (start)
		
		t1.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				 Staffdetails.this.adapter.getFilter().filter(s); 
				
			}
			
		});
		
		// (close)
		
		// alert dialog

		l.setAdapter(adapter);
		l.setOnItemClickListener(new OnItemClickListener() {
		@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				 // two buttons (start)
				  // TODO Auto-generated method stub
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
				 
		        // Setting Dialog Title
		        alertDialog.setTitle("Confirm Delete...");
		 
		        // Setting Dialog Message
		        alertDialog.setMessage("Are you sure you want delete this?");
		 
		        // Setting Icon to Dialog
		        alertDialog.setIcon(R.drawable.ic_launcher);
		 
		        // Setting Positive "Yes" Button
		        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog,int which) {
		 
		            // Write your code here to invoke YES event
		            	Cursor c=db.rawQuery("SELECT * FROM staff", null);
		        		if(c.moveToFirst())
		        		{
		        			db.execSQL("DELETE FROM staff WHERE user='"+c.getString(0)+"'");
		        			 Toast.makeText(getActivity(), "User Deleted Successfully", Toast.LENGTH_SHORT).show();
		        			 return;
		        		}	
		            }
		        });
		        
		 
		     // view Button

		        // Setting Negative "NO" Button
			        alertDialog.setNegativeButton("VIEW", new DialogInterface.OnClickListener() {
			            public void onClick(DialogInterface dialog, int which) {
			            // Write your code here to invoke NO event
			            
			            Toast.makeText(getActivity(), "Refreshed Successfully", Toast.LENGTH_SHORT).show();
			            dialog.cancel();
			            }
			        });
		        // Showing Alert Message
		        alertDialog.show();
				
				// (close)
			}
		});
		out.setOnClickListener(new OnClickListener() {
						@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(),FirstActivity.class));
			}
		});
	}
}