package com.example.ma;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class Step5 extends MyMenuActivity {
	
	MyVar var;
	LinearLayout layout;
	private boolean selected = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_step5);
		
		var = (MyVar)getApplicationContext();
		layout = (LinearLayout)findViewById(R.id.layout);
		
		addNext(0,"");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	finish();
        Intent intent = new Intent(this, Step5.class);
        startActivity(intent);
    	return super.onOptionsItemSelected(item);
    }
	
	private boolean addNext(int th,String str){
		if(th >= var.main_var_num){
			return false;
		}else if(var.possible_solution_index_num[th] == 0){
			return addNext(th+1,str);
		}else{
			for(int i=0;i<var.possible_solution_index_num[th];i++){
				if(addNext(th+1,str+var.sub_var[var.possible_solution_index[th*MyVar.sub_var_num_limit+i]]+",") == false){
					CompoundButton.OnCheckedChangeListener handle = new CompoundButton.OnCheckedChangeListener(){
						@Override
						public void onCheckedChanged(CompoundButton arg0,
								boolean arg1) {
							if(arg1 == true){
								var.solution = arg0.getText().toString();
								selected = true;
							}
						}
					};
					RadioButton radioButton = new RadioButton(this);
					radioButton.setText(str+var.sub_var[var.possible_solution_index[th*MyVar.sub_var_num_limit+i]]);
					radioButton.setOnCheckedChangeListener(handle);
					layout.addView(radioButton);
				}
			}
		}
		return true;
	}
	
	public void next(View view) {
		if(selected){
			Intent intent = new Intent(this, Result.class);
			startActivity(intent);
		}
	}

}
