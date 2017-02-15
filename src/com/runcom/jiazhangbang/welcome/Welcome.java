package com.runcom.jiazhangbang.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.runcom.jiazhangbang.R;
import com.runcom.jiazhangbang.mainActivity.MainActivity;

public class Welcome extends Activity
{
	private EditText name_editText , phoneNumber_editText;
	String name , phoneNumber;

	private Spinner spinner;
	private ArrayAdapter < CharSequence > arrayAdapter;

	private Button login_button;

	String selected;

	@Override
	protected void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

		arrayAdapter = ArrayAdapter.createFromResource(this ,R.array.classes ,android.R.layout.simple_spinner_item);
		arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner = (Spinner) findViewById(R.id.class_spinner);
		spinner.setAdapter(arrayAdapter);
		// spinner.setGravity(Gravity.CENTER_HORIZONTAL);
		// s.setGravity(Gravity.END|Gravity.CENTER_HORIZONTAL);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView < ? > arg0 , View arg1 , int arg2 , long arg3 )
			{
				selected = arg0.getItemAtPosition(arg2).toString();
				// Toast.makeText(Welcome.this ,"what you selected is :" + arg2
				// + "*" + selected ,Toast.LENGTH_LONG).show();
				// Log.d("LOG" ,"what you selected is :" + selected);

			}

			@Override
			public void onNothingSelected(AdapterView < ? > arg0 )
			{
				selected = arg0.getItemAtPosition(0).toString();
			}

		});

		name_editText = (EditText) findViewById(R.id.name_editText);
		phoneNumber_editText = (EditText) findViewById(R.id.phoneNumber_editText);
		login_button = (Button) findViewById(R.id.login_button);

		login_button.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v )
			{
				name = name_editText.getText().toString();
				phoneNumber = phoneNumber_editText.getText().toString();
				Intent intent = new Intent();
				intent.setClass(Welcome.this ,MainActivity.class);
				intent.putExtra("selected" ,selected);
				Log.d("LOG" ,"name: " + name + " class: " + selected + " phoneNumber: " + phoneNumber);

				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu )
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.welcome ,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item )
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		// int id = item.getItemId();
		// if(id == R.id.action_settings)
		// {
		// return true;
		// }
		return super.onOptionsItemSelected(item);
	}
}
