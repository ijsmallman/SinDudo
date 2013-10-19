package com.SmallJoeMan.sindudo;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class InfoActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		TextView t = (TextView) findViewById(R.id.gameInfo);
	    t.setMovementMethod(LinkMovementMethod.getInstance());
	}

}
