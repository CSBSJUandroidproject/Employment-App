
package com.example.studentemployment;

import android.support.v7.app.ActionBarActivity;



import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends ActionBarActivity {
	//public final static String EXTRA_MESSAGE = "com.example.studentemployment.MESSAGE";
	private EditText  username=null;
	   private EditText  password=null;
	   private Button login;
	   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button1);
    }

    public void login(View view){
        if(username.getText().toString().equals("admin") && 
        password.getText().toString().equals("admin")){
        Toast.makeText(getApplicationContext(), "Redirecting...", 
        Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Monday.class);
        startActivity(intent);
     }	
     else{
        Toast.makeText(getApplicationContext(), "Wrong Credentials",
        Toast.LENGTH_SHORT).show();

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