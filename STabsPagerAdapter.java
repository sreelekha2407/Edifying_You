package com.example.sis;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class STabsPagerAdapter extends FragmentPagerAdapter {

	public STabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new Profile();
			
		case 1:
			// Games fragment activity
			return new Timetable();
		case 2:
			// Movies fragment activity
			return new Attandance();
		case 3:
			// Movies fragment activity
			return new Marks();
		case 4:
			// Movies fragment activity
			return new Stuexamsch();
		}
		return null;
	}
	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 5 ;
	}
}