package com.example.less18;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class First extends AppCompatActivity implements OnSeekBarChangeListener{
	
	
	SeekBar sbWeight;
	Button btn1, btn2,btn3;
	LinearLayout.LayoutParams lParams1, lParams2, lParams3;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        
        
        sbWeight= (SeekBar)findViewById(R.id.sbWeight);
        sbWeight.setOnSeekBarChangeListener(this);
        lParams1=(LinearLayout.LayoutParams)btn1.getLayoutParams();
        lParams2=(LinearLayout.LayoutParams)btn2.getLayoutParams();
        lParams3=(LinearLayout.LayoutParams)btn3.getLayoutParams();
        
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first, menu);
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

//во время всего перетаскивания ползунка
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {

	
	
	//в зависимости от того где находится ползунок меняем ширину кнопок
	if(progress>33 && progress<66)
	{lParams1.weight=1;
	lParams2.weight=1;
	lParams3.weight=1;} else
		{if(progress < 33)
		{lParams3.weight=33;
		lParams2.weight=100-33-progress;
		lParams1.weight=progress;} else 
										{if(progress>66){lParams1.weight=33;
														 lParams2.weight=progress-33;
														 lParams3.weight=100-33-progress;}}}
	
													
	
	
	//в кнопках пишем значение 
	btn1.setText(String.valueOf(lParams1.weight));
	btn2.setText(String.valueOf(lParams2.weight));
	btn3.setText(String.valueOf(lParams3.weight));
		
		
	}


	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
}
