package com.bz.criminalint;

import java.util.Date;
import java.util.UUID;

import android.text.format.Time;

public class Crime
{

	private UUID mId;
	private String mTitle;
	
	private Date date;
	private boolean mSolved;
	
	public Crime()
	{//Генерируем уникальный ижентификатор		
		 mId=UUID.randomUUID();
		
		 date = new Date();
		 //time.setToNow();
		 
		 
	}

	public Date getDate() {
		
		
		return date;
	}

	public boolean isSolved() {
		return mSolved;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setSolved(boolean mSolved) {
		this.mSolved = mSolved;
	}

	public UUID getId() {
		return mId;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	
	@Override
	public String toString()
	{return mTitle;}
}

