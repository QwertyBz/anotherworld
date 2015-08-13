package com.example.less21;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class TwoActivity extends AppCompatActivity{
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{super.onCreate(savedInstanceState);
	Log.d("tap", "TwoActivity");
	setContentView(R.layout.two);
	
		
	}
	
	

}
