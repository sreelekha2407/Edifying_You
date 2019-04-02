package com.example.sis;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Login extends Activity 
{
	EditText user,pass;
	Button a;
	String u;
	String p;
	SQLiteDatabase db;
	//TextView f;
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		final global globalvariabel = (global)getApplicationContext();
		user = (EditText) findViewById(R.id.editText1);
		pass = (EditText) findViewById(R.id.editText2);
//		f=(TextView) findViewById(R.id.textView2);
//		f.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent a=new Intent(Login.this,Forgotpw.class);
//				startActivity(a);
//
//				
//			}
//		} );
		a=(Button) findViewById(R.id.button1);
		a.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) 
			{
				if(user.getText().toString().equals("")||pass.getText().toString().equals(""))
				{					
					Toast.makeText(Login.this, "PLz enter the fields..!", Toast.LENGTH_LONG).show();
				}
				else
				{	 
					 u = user.getText().toString();
					 p = pass.getText().toString();
					 try
					 {
					        db=openOrCreateDatabase("sis",SQLiteDatabase.CREATE_IF_NECESSARY,null);					    
					 }
					 catch(Exception exception)
					 {
					        exception.printStackTrace();
					 } 
					 try
					 {
						 if(user.getText().toString().equals("admin")&& pass.getText().toString().equals("sisadmin"))
						 {
					       		 Toast.makeText(Login.this, "Welcome To Adminhome "  + u , Toast.LENGTH_LONG).show();
				        		 globalvariabel.Setusername(user.getText().toString().trim());
				        		 globalvariabel.Setpassword(pass.getText().toString().trim());	
					        	 Intent i = new Intent(Login.this,Adminhome.class);
					            startActivity(i);
					            return;
						 }
						 //Student Login
				         Cursor cc = db.rawQuery("select * from student where user='"+u+"' and pass= '"+p+"' ", null);
			        	 if(cc.moveToFirst())
		        		 {
			        		 String temp="";					       
						     if(cc != null)
						     {
						           	if(cc.getCount()>0)
					            	{
						            	//return true;
						           		scan g=new scan();
						           		g.execute();
						            	Toast.makeText(Login.this, "Welcome To Stdhome "  + u ,Toast.LENGTH_LONG).show();
						            	globalvariabel.Setusername(user.getText().toString().trim());
						    			globalvariabel.Setpassword(pass.getText().toString().trim());
						            	Intent i = new Intent(Login.this,Stuhome.class);
						            	startActivity(i);
						            	return;
						            }
						           	else
						           	{
						            	 Toast.makeText(Login.this, "Login Fails..!", Toast.LENGTH_LONG).show();
						            }
						      }
		        		 }
				      // Faculty Login
			        	 Cursor cc1 = db.rawQuery("select * from staff where user = '"+u+"' and pass= '"+p+"' ", null);
			        	 if(cc1.moveToFirst())
				         {
			        		 String temp="";					       
					         if(cc1 != null) 
					         {
					            	if(cc1.getCount() > 0)
					            	{
					            	//return true;
					            		scan g=new scan();
					            		g.execute();
					               		Toast.makeText(Login.this, "Welcome To Fachome "  + u , Toast.LENGTH_LONG).show();
					            		globalvariabel.Setusername(user.getText().toString().trim());
					    				globalvariabel.Setpassword(pass.getText().toString().trim());
					            		Intent intent = new Intent(Login.this,Staffhome.class);
					            		startActivity(intent);
					            		return;
					            	}
					            	else
					            	{
					            		 Toast.makeText(Login.this, "Login Fails..!", Toast.LENGTH_LONG).show();
					            	}
					         }
				        }
					     else
					     {
					      		 Toast.makeText(Login.this, "Login Fails..!", Toast.LENGTH_LONG).show();
					     }
					}
					catch(Exception exception)
					{
					     exception.printStackTrace();
					}
				}	 	
			}
		});
	}
	public class scan extends AsyncTask<String, String, String>
	{
		private ProgressDialog pd;
		protected void onPreExecute() 
		{
			super.onPreExecute();
			pd = new ProgressDialog(Login.this);
			pd.setTitle("Please Wait");
			pd.setMessage("Logging....");
			pd.setMax(200);
			pd.show();
		}
		protected String doInBackground(String... params) 
		{
			return null;
		}		
	}
}
