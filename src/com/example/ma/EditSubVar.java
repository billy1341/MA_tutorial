package com.example.ma;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EditSubVar extends MyMenuActivity {
	
	MyVar var;
	LinearLayout layout;
	EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_sub_var);
		
		var = (MyVar)getApplicationContext();
		layout = (LinearLayout)findViewById(R.id.layout);
		editText = (EditText) findViewById(R.id.edit_main_var);
		
		TextView textView= (TextView)findViewById(R.id.text_main_var);
		textView.setText(var.main_var[var.current_sub_var_index]);
		
		for(int i=0;i<var.sub_var_num[var.current_sub_var_index];i++){
			TextView t = new TextView(this);
			t.setText(var.sub_var[var.current_sub_var_index*MyVar.sub_var_num_limit+i]);
			layout.addView(t);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
		finish();
        Intent intent = new Intent(this, EditSubVar.class);
        startActivity(intent);
    	return super.onOptionsItemSelected(item);
    }
	
	public void done(View view) {
		Intent intent = new Intent(this, Step3.class);
		startActivity(intent);
	}
	
	public void add(View view){
		String str = editText.getText().toString();
		if(var.sub_var_num[var.current_sub_var_index] < MyVar.sub_var_num_limit){
			if(str!=null && !str.trim().equals("")){
				var.sub_var[var.current_sub_var_index*MyVar.sub_var_num_limit+var.sub_var_num[var.current_sub_var_index]++] = str;
				TextView textView = new TextView(this);
				textView.setText(str);
				layout.addView(textView);
				editText.setText("");
			}
		}
		return;
	}

}
