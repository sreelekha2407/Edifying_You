package com.example.sis;

import com.example.sis.Staffprofile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class stafftab extends FragmentPagerAdapter {

	public stafftab(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new Staffprofile();
			
		case 1:
			// Games fragment activity
			return new Stafftimetable();
		case 2:
			// Movies fragment activity
			return new SSattandance();
		
		
		
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3 ;
	}

}

