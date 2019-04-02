package com.example.sis;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable(){
      
        		@Override
        		public void run() {
        			try {
        			Thread.sleep(3000);
        			} catch(InterruptedException e) {
        				e.printStackTrace();
        			}
        			Intent i=new Intent(MainActivity.this,FirstActivity.class);
        			startActivity(i);
        		}
        		}).start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
