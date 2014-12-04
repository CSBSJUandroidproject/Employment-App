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
	public final static String Use_Pass = "username&password";
	//private EditText username = null;
	//private EditText password = null;
	private Button login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		login = (Button) findViewById(R.id.button1);
		//ImageView image = (ImageView) findViewById(R.id.logo_image);
	}

	public void login(View view) {
		String u = (String)username.getText().toString();
		String p = (String)password.getText().toString();
		//if (doInBackground(u,p).equals("true")) {
			//username carry over to next intent to main page > view hours
			Toast.makeText(getApplicationContext(), "Redirecting...",
					Toast.LENGTH_SHORT).show();
			
			//Count how many times user has logged in
			Intent intent = new Intent(this, MainPage.class);
			EditText username = (EditText) findViewById(R.id.editText1);
			EditText password = (EditText) findViewById(R.id.editText2);
			String message = username.getText().toString()+" " + password.getText().toString();
			startActivity(intent);
			intent.putExtra(Use_Pass, message);
		} /**else {
			Toast.makeText(getApplicationContext(), "Wrong Credentials",
					Toast.LENGTH_SHORT).show();
		}**/
	
	
	protected static String doInBackground(String... arg0) {
		try {
			String username = (String) arg0[0];
			//String username = "admin";
			String password = (String) arg0[1];
			//String password = "admin";
			String link = "http://csbsjustudentemployment.org/app_accessor_php/login.php";
			//String link = "www.csbsjustudentemployment.org/app_accessor_php/login.php";
			String data = URLEncoder.encode("username", "UTF-8") + "="
					+ URLEncoder.encode(username, "UTF-8");
			data += "&" + URLEncoder.encode("password", "UTF-8") + "="
					+ URLEncoder.encode(password, "UTF-8");
			URL url = new URL(link);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			conn.setDoOutput(true);
			
			OutputStreamWriter wr = new OutputStreamWriter(
					conn.getOutputStream());
			System.out.println("here");
			wr.write(data);
			wr.flush();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			// Read Server Response
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				break;
			}
			return sb.toString();
		} catch (Exception e) {
			return new String("Exception: " + e.getMessage());
		}
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
