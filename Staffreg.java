package com.example.sis;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Staffreg extends Activity {
	EditText uid,ps,na,mob,emid,exp,qua;
	Button sub;
	 String email;
	 String emailPattern;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_staffreg);
		uid=(EditText)findViewById(R.id.editText1);
		ps=(EditText)findViewById(R.id.editText3);
		na=(EditText)findViewById(R.id.editText2);
		mob=(EditText)findViewById(R.id.editText5);
		emid=(EditText)findViewById(R.id.editText4);
		exp=(EditText)findViewById(R.id.editText7);
		qua=(EditText)findViewById(R.id.editText6);
		
		sub=(Button)findViewById(R.id.button1);
		db=openOrCreateDatabase("sis", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists staff(user varchar, pass varchar, nam varchar,mobile varchar,emid varchar,qual varchar,exper varchar);");
		
		sub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				email = emid.getText().toString().trim();
				emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
				
				if(uid.getText().toString().trim().length()==0||
						ps.getText().toString().trim().length()==0||
						na.getText().toString().trim().length()==0||
						mob.getText().toString().trim().length()==0||
						emid.getText().toString().trim().length()==0||
						exp.getText().toString().trim().length()==0||
						qua.getText().toString().trim().length()==0)
				{
					Toast.makeText(getApplicationContext(), "Enter All the Fields", Toast.LENGTH_SHORT).show();
					return;
				
				}
				else if(mob.getText().toString().trim().length()!=10)
				{
					Toast.makeText(getApplicationContext(), "Enter 10 Digit Mobile No", Toast.LENGTH_SHORT).show();
					return;
				}
				else if(uid.getText().toString().trim().length()!=5)
				{
					Toast.makeText(getApplicationContext(), "Enter 5 Digit Id", Toast.LENGTH_SHORT).show();
					return;
				}
				else if(!email.matches(emailPattern))
				{
					Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
					return;
				}
				else if(ps.getText().toString().trim().length()<6)
				{
					Toast.makeText(getApplicationContext(),"Minimum Password length should be 6", Toast.LENGTH_SHORT).show();
					return;
				}
				db.execSQL("insert into staff values('"+uid.getText()+"','"+ps.getText()+"','"+na.getText()+"','"+mob.getText()+"','"+emid.getText()+"','"+qua.getText()+"','"+exp.getText()+"');");
				Toast.makeText(getApplicationContext(), "Registration Successfully", Toast.LENGTH_SHORT).show();
				cler();
				Intent a=new Intent(Staffreg.this,FirstActivity.class);
				startActivity(a);
				return;				
			}
		});
	}

	public void cler()
	{
		uid.setText("");
		ps.setText("");
		na.setText("");
		mob.setText("");
		emid.setText("");
		qua.setText("");
		exp.setText("");
		
	}

}