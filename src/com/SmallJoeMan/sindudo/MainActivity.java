package com.SmallJoeMan.sindudo;

import org.achartengine.GraphicalView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView diceCount;
	SeekBar diceSlider;
	GraphicalView gView;
	LineGraph lineGraph;
	LinearLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		diceCount = (TextView) findViewById(R.id.diceCount);
		diceSlider = (SeekBar) findViewById(R.id.seekBar);
		lineGraph = new LineGraph(getDiceProbabilities(diceSlider.getProgress()+1)); //+1 because of bar shift (see change listener)
		gView = (GraphicalView) lineGraph.getView(this);
		layout = (LinearLayout) findViewById(R.id.chart);
		layout.addView(gView);
		diceCount.setText(getString(R.string.dice_count) + "30");

		diceSlider.setOnSeekBarChangeListener( new OnSeekBarChangeListener()
		{
			int progressChanged = 0;
			
			public void onProgressChanged(SeekBar diceSlider, int progress, boolean fromUser)
			{
				progressChanged = progress+1; // add 1 so bar goes from 1-36 rather than 0-35
				diceCount.setText(getString(R.string.dice_count) + Integer.toString(progressChanged));
				lineGraph.setDataset(getDiceProbabilities(progressChanged));
				gView.repaint();
			}
			public void onStartTrackingTouch(SeekBar diceSlider)
			{
				// TODO Auto-generated method stub
			}
			public void onStopTrackingTouch(SeekBar diceSlider)
			{
				// TODO Auto-generated method stub	
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
	
	public double[] getDiceProbabilities(int diceCount)
	{
		double[] pVals = new double[diceCount+1];
		for (int i = 0; i < diceCount+1; i++) {
            pVals[i] = DiceProbabilities.diceProb(diceCount, i);
        }
		return pVals;
	}

}
