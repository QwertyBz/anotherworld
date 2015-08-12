package com.bz.criminalint;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class CrimeListFragment extends ListFragment {

	private ArrayList<Crime> mCrimes;
	String TAG="CrimeListFragment";
	
@Override
public void onCreate(Bundle savedInstanceState)
{super.onCreate(savedInstanceState);
setHasOptionsMenu(true);
//Возвращает активити-хост
//что бы установить там заголовок
getActivity().setTitle(R.string.crimes_title);
mCrimes = CrimeLab.get(getActivity()).getCrimes();
//Создаем экземпляр ArrayAdapter<T> и 
CrimeAdapter adapter = new CrimeAdapter(mCrimes);
//назначаем его адаптером для виджета ListView
setListAdapter(adapter);

}

@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
{super.onCreateOptionsMenu(menu, inflater);
//передаем идентификатор ресурса своего файла меню
inflater.inflate(R.menu.fragment_crime_list, menu);
}


//выбор списка меню
@Override
public boolean onOptionsItemSelected(MenuItem item)
{switch(item.getItemId())
	{case R.id.menu_item_new_crime:
		Crime crime = new Crime();
		CrimeLab.get(getActivity()).addCrime(crime);
		Intent i = new Intent(getActivity(), CrimePagerActivity.class);
		i.putExtra(CrimeFragment.EXTRA_CRIME_ID, crime.getId());
		startActivityForResult(i, 0);
		return true;
		default:
		return super.onOptionsItemSelected(item);}
	}


// Функция щелчка по элементу списка
@Override
public void onListItemClick(ListView l, View v, int position, long id)
{
	
	
	Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);

//Запускаем CrimePagerActivity
	Intent i = new Intent(getActivity(), CrimePagerActivity.class);
	
	//положим  в интент значение какого преступления
	i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
	startActivity(i);
	
}
	
	
	
private class CrimeAdapter extends ArrayAdapter<Crime>
{
	public CrimeAdapter(ArrayList<Crime> crimes)
	{super(getActivity(),0,crimes);}


@Override
public View getView(int position, View convertView, ViewGroup parent)
{
	//Если мы не получили представление, заполняем его
	if(convertView == null)
	{convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
	}
	
	
	//настройка представления для объекта Crime
	Crime c = getItem(position);
	
	TextView titleTextView = (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
	titleTextView.setText(c.getTitle());
	
	
	TextView dateTextView = (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
	dateTextView.setText(c.getDate().toString());
	
	
	CheckBox solvedCheckBox= (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
	solvedCheckBox.setChecked(c.isSolved());
	
	
	return convertView;
	
}




}


//Для возврата и изменения данных
@Override
public void onResume()
{super.onResume();

((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
	}


	
	
	
}
