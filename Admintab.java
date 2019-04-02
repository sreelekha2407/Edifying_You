package com.example.sis;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Admintab extends FragmentPagerAdapter {

	public Admintab(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new Staffdetails();
			
		case 1:
			// Games fragment activity
			return new Studentdetails();
		
		case 2:
			// Games fragment activity
			return new Adstafftimetable();
		}
		return null;
	}
	@Override
	public int getCount() 
	{
		// get item count - equal to number of tabs
		return 3 ;
	}
}
