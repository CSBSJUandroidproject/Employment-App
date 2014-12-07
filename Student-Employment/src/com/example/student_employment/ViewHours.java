package com.example.student_employment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.appcompat.R;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewHours extends ActionBarActivity {
	public static String dows="";
	private String weekDay="";
	private int wkDay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_hours);
		SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE",Locale.US);
		Calendar calendar = Calendar.getInstance();
		weekDay = dayFormat.format(calendar.getTime());
		if(weekDay.compareTo("Monday")==0){
			wkDay=1;
		}
		else if(weekDay.compareTo("Tuesday")==0){
			wkDay=2;
		}
		else if(weekDay.compareTo("Wednesday")==0){
			wkDay=3;
		}
		else if(weekDay.compareTo("Thursday")==0){
			wkDay=4;
		}
		else if(weekDay.compareTo("Friday")==0){
			wkDay=5;
		}
		else if(weekDay.compareTo("Saturday")==0){
			wkDay=6;
		}
		else if(weekDay.compareTo("Sunday")==0){
			wkDay=7;
		}
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainPage.Use_Pass2);
		String username,password;
		String[] parts=message.split(" ");
		username=parts[0];
		password=parts[1];
		displayTime dt=new displayTime();
		String timeString=DB.doInBackground(username,password);
		String odt=dt.selectDayOfWeek(wkDay,timeString);
		String result=dt.timePeriod(odt);
		Resources res = getResources();
		String text = String.format(
		    res.getString(R.string.display_hours_string),
		    result);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.view_hours, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		//int id = item.getItemId();
		//if (id == R.id.action_settings) {
		//	return true;
		//}
		return super.onOptionsItemSelected(item);
	}
}
