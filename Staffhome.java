package com.example.sis;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.Toast;

public class Staffhome extends FragmentActivity implements ActionBar.TabListener {

private ViewPager viewPager;
private stafftab mAdapter;
private ActionBar actionBar;
// Tab titles
private String[] tabs = { "STAFFPROFILE", "STAFFTIMETABLE", "SSATTANDANCE" };

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_staffhome);


// Initilization
viewPager = (ViewPager) findViewById(R.id.pager);
actionBar = getActionBar();
mAdapter = new stafftab(getSupportFragmentManager());

viewPager.setAdapter(mAdapter);
actionBar.setHomeButtonEnabled(false);
actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);		

// Adding Tabs
for (String tab_name : tabs) {
	actionBar.addTab(actionBar.newTab().setText(tab_name)
			.setTabListener(this));
}

/**
 * on swiping the viewpager make respective tab selected
 * */
viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

	@Override
	public void onPageSelected(int position) {
		// on changing the page
		// make respected tab selected
		actionBar.setSelectedNavigationItem(position);
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}
});
}

@Override
public void onTabReselected(Tab tab, FragmentTransaction ft) {
}

@Override
public void onTabSelected(Tab tab, FragmentTransaction ft) {
// on tab selected
// show respected fragment view
viewPager.setCurrentItem(tab.getPosition());
}

@Override
public void onTabUnselected(Tab tab, FragmentTransaction ft) {
}
 @Override
public void onBackPressed(){
	 Toast.makeText(getApplicationContext(), "Press Logout Button", Toast.LENGTH_SHORT).show();
}
}
