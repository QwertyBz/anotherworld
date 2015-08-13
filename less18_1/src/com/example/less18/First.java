package com.example.less18;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;


@SuppressLint("NewApi") public class First extends AppCompatActivity implements OnSeekBarChangeListener{
	
	
	SeekBar sbWeight, sbWeight2;
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
        sbWeight2=(SeekBar)findViewById(R.id.sbWeight2);
        sbWeight2.setRotation((float) 180.0);
        //установить изменение сикбара
        sbWeight.setOnSeekBarChangeListener(this);
        sbWeight2.setOnSeekBarChangeListener(this);
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

		
		if (seekBar == sbWeight){
	
	
	//в зависимости от того где находится ползунок меняем ширину кнопок
	if(progress<33)
	{
		
		btn2.setWidth(progress*10);
		
	//lParams2.weight=1;
	//lParams3.weight=1;
	} 
													
	
	
	//в кнопках пишем значение 
	btn1.setText(String.valueOf(btn1.getWidth()));
	btn2.setText(String.valueOf(lParams2.weight));
	btn3.setText(String.valueOf(lParams3.weight));}
		
		
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
