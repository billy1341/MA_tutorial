package com.example.ma;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Step2 extends MyMenuActivity {
	
	MyVar var;
	LinearLayout layout;
	EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_step2);
		
		TextView textView = (TextView)findViewById(R.id.text_question);
		var = (MyVar)getApplicationContext();
		textView.setText(var.question);
		editText = (EditText) findViewById(R.id.edit_main_var);
		
		layout = (LinearLayout)findViewById(R.id.layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	finish();
        Intent intent = new Intent(this, Step2.class);
        startActivity(intent);
    	return super.onOptionsItemSelected(item);
    }
	
	public void next(View view) {
		Intent intent = new Intent(this, Step3.class);
		startActivity(intent);
	}
	
	public void add(View view){
		String str = editText.getText().toString();
		if(var.main_var_num < MyVar.main_var_num_limit){
			if(str!=null && !str.trim().equals("")){
				var.main_var[var.main_var_num++] = str;
				TextView textView = new TextView(this);
				textView.setText(str);
				layout.addView(textView);
				editText.setText("");
			}
		}
		return;
	}

}
