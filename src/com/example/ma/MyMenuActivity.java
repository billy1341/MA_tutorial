package com.example.ma;

import java.util.Locale;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MyMenuActivity extends Activity{
	
	protected MyVar myvar;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        myvar = (MyVar)getApplicationContext();
	    Locale.setDefault(myvar.locale);
	    Configuration config = new Configuration();
	    config.locale = myvar.locale;
	    getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    		case R.id.language_en:
    			myvar.locale = Locale.ENGLISH;
    			break;
    		case R.id.language_zh_TW:
    			myvar.locale = Locale.TRADITIONAL_CHINESE;
    			break;
    		case R.id.language_zh_CN:
    			myvar.locale = Locale.SIMPLIFIED_CHINESE;
    			break;
    		default:
    			break;
    	}
    	return super.onOptionsItemSelected(item);
    }
}
