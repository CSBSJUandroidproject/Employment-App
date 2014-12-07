package com.example.student_employment;

import java.text.SimpleDateFormat;
import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.appcompat.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ViewHours extends ActionBarActivity {
	/**
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_view_hours);
		SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE",Locale.US);
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.Use_Pass);
		
		String username,password;
		String[] parts=message.split(" ");
		username=parts[0];
		password=parts[1];
		displayTime dt=new displayTime();
		String timeString=DB.doInBackground(username,password);
		String odt=dt.selectDayOfWeek(1,timeString);
		String result=dt.timePeriod(odt);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
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
	}**/
}
