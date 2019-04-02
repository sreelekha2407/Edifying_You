package com.example.sis;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Abtdepartments extends Activity {
	
Button cse,it,ecm,civil,mech;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_abtdepartments);
		cse=(Button)findViewById(R.id.button1);
		it=(Button)findViewById(R.id.button2);
		ecm=(Button)findViewById(R.id.button3);
		civil=(Button)findViewById(R.id.button4);
		mech=(Button)findViewById(R.id.button5);
		cse.setOnClickListener(new OnClickListener(){ 
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Abtdepartments.this,Cse.class));
					
		}
			});
		it.setOnClickListener(new OnClickListener(){ 
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Abtdepartments.this,It.class));
					
		}
			});
		ecm.setOnClickListener(new OnClickListener(){ 
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Abtdepartments.this,Ecm.class));
					
		}
			});
		civil.setOnClickListener(new OnClickListener(){ 
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Abtdepartments.this,Civil.class));
					
		}
			});
		mech.setOnClickListener(new OnClickListener(){ 
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Abtdepartments.this,Mech.class));
					
		}
			});
	}
}