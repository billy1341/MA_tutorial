package com.example.ma;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Explanation extends MyMenuActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_explanation);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	finish();
        Intent intent = new Intent(this, Explanation.class);
        startActivity(intent);
    	return super.onOptionsItemSelected(item);
    }
	
	public void next(View view) {
		Intent intent = new Intent(this, Step1.class);
		startActivity(intent);
		return;
	}

}
