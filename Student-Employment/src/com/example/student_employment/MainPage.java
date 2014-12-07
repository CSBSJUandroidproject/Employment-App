package com.example.student_employment;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;

public class MainPage extends ActionBarActivity {

	//public static String message = "";
	public static final String Use_Pass2 = "com.example.student_employment_main_page";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.Use_Pass);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		System.out.println("MainPage" + message);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
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
	
	public void submitHours(View view){
		Intent intent = new Intent(MainPage.this, Monday.class);
		//intent.putExtra(Use_Pass2, intent.getStringExtra(MainActivity.Use_Pass));
		startActivity(intent);
	}
	public void viewSched(){
		Intent intent = new Intent(MainPage.this, ViewHours.class);
		intent.putExtra(Use_Pass2, intent.getStringExtra(MainActivity.Use_Pass));
		startActivity(intent);
	}
}
