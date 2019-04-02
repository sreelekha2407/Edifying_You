package com.example.sis;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Stuexamsch extends Fragment {
	TextView a;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_stuexamsch, container, false);
		
		
		return rootView;
	}
	@Override
	public void onViewCreated(View view,  Bundle savedInstanceState) {
		
		a=(TextView)getView().findViewById(R.id.textView2);
		final global globalvariable=(global)getActivity().getApplicationContext();
		try{
			a.setText(globalvariable.GetUsername().toString());
		}
		catch(Exception e)
		{
			System.out.println(e);
	}
	}		
}
