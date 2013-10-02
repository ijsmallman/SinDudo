package com.SmallJoeMan.sindudo;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView diceCount;
	SeekBar diceSlider;
	WebView webview;
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		diceCount = (TextView) findViewById(R.id.diceCount);
		diceSlider = (SeekBar) findViewById(R.id.seekBar);
		
		diceCount.setText(getString(R.string.dice_count) + "30");
		
		webview = (WebView) findViewById(R.id.webView1);
		WebSettings webSettings = webview.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webview.requestFocusFromTouch();
		webview.loadUrl("file:///android_asset/webCode.html"); // Can be used in this way too.
		
		diceSlider.setOnSeekBarChangeListener( new OnSeekBarChangeListener()
		{
			int progressChanged = 0;
			
			
			public void onProgressChanged(SeekBar diceSlider, int progress, boolean fromUser)
			{
				progressChanged = progress;
				diceCount.setText(getString(R.string.dice_count) + Integer.toString(progress));
			}
			public void onStartTrackingTouch(SeekBar diceSlider)
			{
				// TODO Auto-generated method stub
			}
			public void onStopTrackingTouch(SeekBar diceSlider)
			{
				webview.loadUrl("javascript:drawChart(\""+Integer.toString(progressChanged)+"\")");
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected( MenuItem item )
	{
	    boolean ret;
	    final Context context = this;
	    if (item.getItemId() == R.id.action_info)
	    {
	    	Intent intent = new Intent(context, InfoActivity.class);
            startActivity(intent);
	        ret = true;
	    } 
	    else
	    {
	        ret = super.onOptionsItemSelected( item );
	    }
	    return ret;
	}

}
