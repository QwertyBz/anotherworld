package com.bz.criminalint;

import java.util.Date;
import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;


public class CrimeFragment extends Fragment {
	
	public static final String EXTRA_CRIME_ID= "com.bz.criminalint.crime_id";
	private static final String DIALOG_DATE = "date";
	private static final int REQUEST_DATE = 0;
	private Crime mCrime;
	private EditText mTitleField;
	private Button mDateButton;
	private CheckBox mSolvedCheckBox;
	
	public void updateDate()
	{
		mDateButton.setText(mCrime.getDate().toString());
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{super.onCreate(savedInstanceState);
	mCrime= new Crime();
	
	
	
	UUID crimeId = (UUID) getArguments().getSerializable(EXTRA_CRIME_ID);
	mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
	
	}
	
	
	
	//����������� ������ �������� ���������
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if(resultCode!=Activity.RESULT_OK) return;
		if(requestCode == REQUEST_DATE)
		{
			
			Date date = (Date)data.
		getSerializableExtra(DatePickerFragment.EXTRA_DATE);
		mCrime.setDate(date);
		updateDate();}
	}

	
	//����� ��� ���������� �������� fragment_crime.xml
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,	
			Bundle savedInstanceState)
	{
		
		//��������� ������������� ���������, �������� ������������� ������� ������
		//������ ��������-�������� �������������
		//������ ��������-����� �� �������� ����������� ������������� � ��������
		//�� ����� false, ������ ��� ������������� ����� �������� � ���� ����������
		View v = inflater.inflate(R.layout.fragment_crime,parent,false);
		
		
		mTitleField = (EditText)v.findViewById(R.id.crime_title);
		mTitleField.setText(mCrime.getTitle());
		
		//��������� ���������
		//_____________________________________________________________
		mTitleField.addTextChangedListener(new TextWatcher()
		{
			
			public void onTextChanged(CharSequence c, int start, int before, int count)
			//�������� �������� ���������
			{mCrime.setTitle(c.toString());}

			@Override
			public void afterTextChanged(Editable c) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence c, int start,
					int count, int after) {
				// TODO Auto-generated method stub
				
			}});
		//_____________________________________________________________
		
		
		//������������� ��� ������-������� ����
		//_________________________________________________
		
		
		
		mDateButton = (Button)v.findViewById(R.id.crime_date);
		updateDate();
		
		
		//������� ��� ������������ ����
		mDateButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
				
				DatePickerFragment dialog = DatePickerFragment.newInstance(mCrime.getDate());
				
				
				//����� �������� ��������, ������� ������ ������� � ��� �������
				dialog.setTargetFragment(CrimeFragment.this, REQUEST_DATE);
				System.out.println("������");
				
				dialog.show(fm, DIALOG_DATE);
				
			}
		});
		
	
		//_________________________________________________
		
		
		
		
		//��������� ��������� CheckBox
		//_________________________________________________
		
		mSolvedCheckBox=(CheckBox)v.findViewById(R.id.crime_solved);
		mSolvedCheckBox.setChecked(mCrime.isSolved());
		mSolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		{mCrime.setSolved(isChecked);}
		}	);
		//_________________________________________________
		
		return v;
		
		
	}
	
	
	//���� ����� �������� UUID, ������� ����� ����������, ������� ��������� ���������, � �����
	//������������ ��������� � ���������
	public static CrimeFragment newInstance(UUID crimeId)
	{
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_CRIME_ID, crimeId);
		CrimeFragment fragment = new CrimeFragment();
		fragment.setArguments(args);
		
		return fragment;
	}

}
