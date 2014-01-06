package com.example.ma;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Step4 extends MyMenuActivity {
	
	MyVar var;
	LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_step4);
		
		var = (MyVar)getApplicationContext();
		layout = (LinearLayout)findViewById(R.id.layout);
		
		for(int i=0;i<var.main_var_num;i++){
			TextView textView = new TextView(this);
			textView.setText(var.main_var[i]);
			layout.addView(textView);
			for(int j=0;j<var.sub_var_num[i];j++){
				CompoundButton.OnCheckedChangeListener handle = new CompoundButton.OnCheckedChangeListener(){
					@Override
					public void onCheckedChanged(CompoundButton arg0,
							boolean arg1) {
						var.probable_solution_set[arg0.getId()] = arg1;
					}
				};
				CheckBox checkBox = new CheckBox(this);
				checkBox.setId(i*MyVar.sub_var_num_limit+j);
				checkBox.setText(var.sub_var[i*MyVar.sub_var_num_limit+j]);
				checkBox.setOnCheckedChangeListener(handle);
				layout.addView(checkBox);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	finish();
        Intent intent = new Intent(this, Step4.class);
        startActivity(intent);
    	return super.onOptionsItemSelected(item);
    }
	
	public void next(View view) {
		for(int i=0;i<var.main_var_num;i++){
			for(int j=0;j<var.sub_var_num[i];j++){
				if(var.probable_solution_set[i*MyVar.sub_var_num_limit+j] == true){
					var.possible_solution_index[i*MyVar.sub_var_num_limit+var.possible_solution_index_num[i]++] = i*MyVar.sub_var_num_limit+j;
				}
			}
		}
		Intent intent = new Intent(this, Step5.class);
		startActivity(intent);
	}

}
