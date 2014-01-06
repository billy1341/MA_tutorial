package com.example.ma;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Step3 extends MyMenuActivity {

	MyVar var;
	LinearLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_step3);
		
		var = (MyVar)getApplicationContext();
		layout = (LinearLayout)findViewById(R.id.layout);
		
		for(int i=0;i<var.main_var_num;i++){
			View.OnClickListener handler = new View.OnClickListener() {
			    public void onClick(View view) {
			    	var.current_sub_var_index = view.getId();
			    	Intent intent = new Intent(Step3.this, EditSubVar.class);
					startActivity(intent);
			    }
			};
			Button button = new Button(this, null, android.R.attr.buttonStyleSmall);
			button.setId(i);
			button.setText(var.main_var[i]);
			button.setOnClickListener(handler);
			layout.addView(button);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	finish();
        Intent intent = new Intent(this, Step3.class);
        startActivity(intent);
    	return super.onOptionsItemSelected(item);
    }
	
	public void next(View view) {
		Intent intent = new Intent(this, Step4.class);
		startActivity(intent);
	}

}
