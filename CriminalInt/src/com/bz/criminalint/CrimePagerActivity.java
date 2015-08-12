package com.bz.criminalint;

import java.util.ArrayList;
import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class CrimePagerActivity extends FragmentActivity {
	
	//Ёлемент листани€ страниц
	private ViewPager mViewPager;
	private ArrayList<Crime> mCrimes;

@Override
public void onCreate(Bundle savedInstanceState)
{
super.onCreate(savedInstanceState);	

mViewPager = new ViewPager(this);
mViewPager.setId(R.id.viewPager);
setContentView(mViewPager);






//получаем от CrimeLab набор данных - контейнер ArrayList
mCrimes = CrimeLab.get(this).getCrimes();

//ѕолучаем экземпл€р дл€ активности
FragmentManager fm = getSupportFragmentManager();

//___________________________________________________________
//јдаптером назначаетс€ безым€нный экземпл€р FragmentStatePagerAdapter
mViewPager.setAdapter(new FragmentStatePagerAdapter(fm)

{

	@Override
	public Fragment getItem(int pos) {

Crime crime = mCrimes.get(pos);

		return CrimeFragment.newInstance(crime.getId());
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mCrimes.size();
	}}
		
		);
//___________________________________________________________



//___________________________________________________________

mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
	

	//”становить имени страницы номером преступлени€
	//Ётот метом используетс€ жд€ обнаружени€ изменений в странице
	@Override
	public void onPageSelected(int pos) {
		Crime crime = mCrimes.get(pos);
		if(crime.getTitle() != null)
		{setTitle(crime.getTitle());}
		
	}
	
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}
});

//___________________________________________________________




//”станавливаем номер преступлени€ выбранного из списка
UUID crimeId=(UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
for(int i=0; i< mCrimes.size(); i++)
{if(mCrimes.get(i).getId().equals(crimeId))
	{mViewPager.setCurrentItem(i);
	break;}}



}
}
