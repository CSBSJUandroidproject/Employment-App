package com.example.student_employment;

import android.support.v7.app.ActionBarActivity;

import 	android.util.Log;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Notification.Action;
import android.content.Intent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MainActivity extends ActionBarActivity {
	//public static String message = "";
	public final static String Use_Pass = "com.example.student_employment.main_activity";
	private EditText username = null;
	private EditText password = null;
	private Button login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		username = (EditText) findViewById(R.id.editText1);
		password = (EditText) findViewById(R.id.editText2);
		login = (Button) findViewById(R.id.button1);
		//ImageView image = (ImageView) findViewById(R.id.logo_image);
	}

	public void login(View view) {
			//username carry over to next intent to main page > view hours
			Toast.makeText(getApplicationContext(), "Redirecting...",
					Toast.LENGTH_SHORT).show();
			
			//Count how many times user has logged in
			Intent intent = new Intent(MainActivity.this, MainPage.class);
			username = (EditText) findViewById(R.id.editText1);
			password = (EditText) findViewById(R.id.editText2);
			String message = username.getText().toString()+" " + password.getText().toString();
			System.out.println("MainActivity" + message);
			intent.putExtra(Use_Pass, message);
			startActivity(intent);
			
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
