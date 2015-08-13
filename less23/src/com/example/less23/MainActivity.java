package com.example.less23;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity {

	final static String TAG="Statuses"; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }



    @Override
    protected void onStart()
    {
    	super.onStart();
    	Log.d(TAG,"onStart start");
    	
    	
    }
    
    @Override
    protected void onResume()
    {
    	super.onResume();
    	Log.d(TAG, "onResume start");
    }
    
    @Override
    protected void onPause()
    {
    	super.onPause();
    	Log.d(TAG, "onPause start");
    	
    }
    
    
    @Override
    protected void onStop()
    {
    	super.onStop();
    	Log.d(TAG, "onStop start");
    }



@Override
protected void onDestroy()
{
	super.onDestroy();
	Log.d(TAG, "onDestroy start");

}




}
    
    
    
    
