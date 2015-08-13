package com.example.less20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

	
	//константы для ID пунктов меню
	final int MENU_ALPHA_ID=1;
	final int MENU_SCALE_ID=2;
	final int MENU_TRANSLATE_ID=3;
	final int MENU_ROTATE_ID=4;
	final int MENU_COMBO_ID=5;
	
	TextView tv;
	
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
     tv = (TextView) findViewById(R.id.tv);
     
     
     //регистрируем контекснтое меню для компонента tv
     
     registerForContextMenu(tv);        
    }
    
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
    {
    	
    	switch(v.getId())
    	{
    	case R.id.tv:
    		//добавляем пункты
    		menu.add(0,MENU_ALPHA_ID, 0 , "alpha");
    		menu.add(0,MENU_SCALE_ID,0,"scale");
    		menu.add(0,MENU_TRANSLATE_ID,0,"translate");
    		menu.add(0,MENU_ROTATE_ID,0,"rotate");
    		menu.add(0,MENU_COMBO_ID,0,"combo");
    		break;  	
    	}
    	super.onCreateContextMenu(menu, v, menuInfo);
    	    	
    }


    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
    	
    	Animation anim = null;
    	//определяем какой пункт бы нажат
    	switch(item.getItemId())
    	{
    	case MENU_ALPHA_ID:
    		//создаем объект анимации из файла anim/myalpha
    		anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
    		break;
    	case MENU_SCALE_ID:
    		anim= AnimationUtils.loadAnimation(this, R.anim.myscale);
    		break;
    	case MENU_TRANSLATE_ID:
    		anim= AnimationUtils.loadAnimation(this, R.anim.mytrans);
    		break;
    	case MENU_ROTATE_ID:
    		anim=AnimationUtils.loadAnimation(this, R.anim.myrotate);
    		break;
    	case MENU_COMBO_ID:
    		anim=AnimationUtils.loadAnimation(this, R.anim.mycombo);
    		break;
    	   	
    	
    	}
		//запускаем анмацию для компонента tv
    	tv.startAnimation(anim);
    	
    	
    	return super.onContextItemSelected(item);
    	
    	
    	
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
