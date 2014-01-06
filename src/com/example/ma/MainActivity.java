package com.example.ma;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends MyMenuActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    	return super.onOptionsItemSelected(item);
    }
	
	/** Called when the user clicks the Start button */
	public void start(View view) {
		Intent intent = new Intent(this, Explanation.class);
		startActivity(intent);
	}

}
