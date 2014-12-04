package com.example.student_employment;

import java.text.SimpleDateFormat;
import java.util.Locale;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ViewHours extends ActionBarActivity {
	public static String dows="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE",Locale.US);
		Intent intent = getIntent();
		String username,password;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		String message = intent.getStringExtra(MainPage.Use_Pass);
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
		getMenuInflater().inflate(R.menu.view, menu);
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
