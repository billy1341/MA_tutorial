package com.example.ma;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Step1 extends MyMenuActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_step1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	finish();
        Intent intent = new Intent(this, Step1.class);
        startActivity(intent);
    	return super.onOptionsItemSelected(item);
    }
	
	public void next(View view) {
		EditText editText = (EditText) findViewById(R.id.edit_question);
		MyVar var;
		var = (MyVar)getApplicationContext();
		var.question = editText.getText().toString();
		Intent intent = new Intent(this, Step2.class);
		startActivity(intent);
	}

}
