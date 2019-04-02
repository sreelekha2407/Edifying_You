package com.example.sis;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstActivity extends Activity {
	Button dept,stu,staff,login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		dept=(Button)findViewById(R.id.button1);
		stu=(Button)findViewById(R.id.button2);
		staff=(Button)findViewById(R.id.button3);
		login=(Button)findViewById(R.id.button4);
		dept.setOnClickListener(new OnClickListener()
		{ 
			@Override
			public void onClick(View v) 
			{
				startActivity(new Intent(FirstActivity.this,Abtdepartments.class));
			}
		});
		stu.setOnClickListener(new OnClickListener(){ 
			@Override
			public void onClick(View v) {
				startActivity(new Intent(FirstActivity.this,Stureg.class));
				
		}
		});
		staff.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				startActivity(new Intent(FirstActivity.this,Staffreg.class));
				
		}
		});
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(FirstActivity.this,Login.class));
			}
		});
		}
		}
	
