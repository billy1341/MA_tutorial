package com.example.ma;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Result extends MyMenuActivity {
	
	MyVar var;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		var = (MyVar)getApplicationContext();
		
		TextView textView1 = (TextView) findViewById(R.id.text_question);
		TextView textView2 = (TextView) findViewById(R.id.text_solution);
		textView1.setText(var.question);
		textView2.setText(var.solution);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	finish();
        Intent intent = new Intent(this, Result.class);
        startActivity(intent);
    	return super.onOptionsItemSelected(item);
    }
	
	public void restart(View view) {
		var.reset();
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
