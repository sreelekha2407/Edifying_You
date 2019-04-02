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

public class Stureg extends Activity {

	EditText id,ps,na,mob,emid,fn,fm,mn,mm,ssc,inter,eamcet;
	Button sub;
	String email;
	String emailPattern;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stureg);	
		id=(EditText)findViewById(R.id.editText1);
		ps=(EditText)findViewById(R.id.editText3);
		na=(EditText)findViewById(R.id.editText2);
		mob=(EditText)findViewById(R.id.editText5);
		emid=(EditText)findViewById(R.id.editText4);
		fn=(EditText)findViewById(R.id.editText6);
		fm=(EditText)findViewById(R.id.editText7);
		mn=(EditText)findViewById(R.id.editText8);
		mm=(EditText)findViewById(R.id.editText9);
		ssc=(EditText)findViewById(R.id.editText11);
		inter=(EditText)findViewById(R.id.editText12);
		eamcet=(EditText)findViewById(R.id.editText13);
		
		sub=(Button)findViewById(R.id.button1);
		db=openOrCreateDatabase("sis", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists student(user varchar, pass varchar, nam varchar,mobile varchar,emid varchar,faname varchar,famo varchar,moname varchar,momo varchar,ssc varchar,inter varchar,eamcet varchar);");
		
		sub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				email = emid.getText().toString().trim();
				emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
				
				if(id.getText().toString().trim().length()==0||
						ps.getText().toString().trim().length()==0||
						na.getText().toString().trim().length()==0||
						mob.getText().toString().trim().length()==0||
						emid.getText().toString().trim().length()==0||
						fn.getText().toString().trim().length()==0||
						fm.getText().toString().trim().length()==0||
						mn.getText().toString().trim().length()==0||
						mm.getText().toString().trim().length()==0||
						ssc.getText().toString().trim().length()==0||
						inter.getText().toString().trim().length()==0||
						eamcet.getText().toString().trim().length()==0)
				{
					Toast.makeText(getApplicationContext(), "Enter All the Fields", Toast.LENGTH_SHORT).show();
					return;
				
				}
				else if(mob.getText().toString().trim().length()!=10 || fm.getText().toString().trim().length()!=10 || mm.getText().toString().trim().length()!=10)
				{
					Toast.makeText(getApplicationContext(), "Enter 10 Digit Mobile No", Toast.LENGTH_SHORT).show();
					return;
				}
				else if(id.getText().toString().trim().length()!=10)
				{
					Toast.makeText(getApplicationContext(), "Enter 10 Digit Id", Toast.LENGTH_SHORT).show();
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
				db.execSQL("insert into student values('"+id.getText()+"','"+ps.getText()+"','"+na.getText()+"','"+mob.getText()+"','"+emid.getText()+"','"+fn.getText()+"','"+fm.getText()+"','"+mn.getText()+"','"+mm.getText()+"','"+ssc.getText()+"','"+inter.getText()+"','"+eamcet.getText()+"');");
				Toast.makeText(getApplicationContext(), "Registration Successfully", Toast.LENGTH_SHORT).show();
				cler();
				Intent a=new Intent(Stureg.this,FirstActivity.class);
				startActivity(a);
				return;				
			}
		});
	}

	public void cler()
	{
		id.setText("");
		ps.setText("");
		na.setText("");
		mob.setText("");
		emid.setText("");
		fn.setText("");
		fm.setText("");
		mn.setText("");
		mm.setText("");
		ssc.setText("");
		inter.setText("");
		eamcet.setText("");
	}
}