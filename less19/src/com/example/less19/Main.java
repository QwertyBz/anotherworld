package com.example.less19;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity implements OnClickListener {
	
	
	EditText etNum1, etNum2;
	Button btnAdd, btnSub, btnMult, btnDiv;
	
	TextView tvResult;
	
	String oper="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		
		//������� ��� ��������
		etNum1= (EditText)findViewById(R.id.etNum1);
		etNum2=(EditText)findViewById(R.id.etNum2);
		
		btnAdd=(Button)findViewById(R.id.btnAdd);
		btnSub=(Button)findViewById(R.id.btnSub);
		btnMult=(Button)findViewById(R.id.btnMult);
		btnDiv=(Button)findViewById(R.id.btnDiv);
		
		tvResult=(TextView)findViewById(R.id.tvResult);
		
		
		//����������� ����������
		btnAdd.setOnClickListener(this);
		btnSub.setOnClickListener(this);
		btnMult.setOnClickListener(this);
		btnDiv.setOnClickListener(this);
		
		
	}
	
	@Override
	public void onClick(View v)
	{
		float num1=0;
		float num2=0;
		float result=0;
		
		//��������� ���� �� �������
		if(TextUtils.isEmpty(etNum1.getText().toString())
			|| TextUtils.isEmpty(etNum2.getText().toString()))
		{return;}
		
		//������ EditText � ��������� ���������� �������
		num1= Float.parseFloat(etNum1.getText().toString());
		num2 = Float.parseFloat(etNum2.getText().toString());
		
		//���������� ������� ������ � ��������� ��������������� ��������
		//� oper ����� �������� , ����� ����� ������������ � ������
		
		switch(v.getId())
		{
		
		case R.id.btnAdd:
			oper = "+";
			result = num1 + num2;
			break;
		case R.id.btnSub:
			oper="-";
			result=num1-num2;
			break;
		case R.id.btnMult:
			oper="*";
			result=num1*num2;
			break;
		case R.id.btnDiv:
		oper="/";
		result=num1/num2;
		break;
		default:
			break;
		
		
		}
		
		//��������� ������ ������
		tvResult.setText(num1+ " "+ oper + " " + num2+ "=" +result);
		
		Toast.makeText(this, R.string.toast_text, Toast.LENGTH_SHORT).show();
		
		
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
