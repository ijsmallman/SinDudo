package com.SmallJoeMan.sindudo;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		WebView webview = (WebView) findViewById(R.id.webView1);
		
		String content = "<html>"
			+ "  <head>"
			+ "    <script type=\"text/javascript\" src=\"jsapi.js\"></script>"
			+ "    <script type=\"text/javascript\">"
			+ "      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});"
			+ "      google.setOnLoadCallback(drawChart);"
			+ "      function drawChart() {"
			+ "          var data = new google.visualization.DataTable();"
		    + "          data.addColumn('number', 'Dice');" // Implicit domain label col.
		    + "          data.addColumn('number', 'Probability');" // Implicit series data col.
		    + "          data.addColumn({type: 'string', role: 'tooltip'});" 
		    + "          data.addRows(["
		    + "              [0,1,'Dice: 0, Probability: 1'],"
		    + "              [1,0.985787,'Dice: 1, Probability: 0.985787'],"
		    + "              [2,0.970511,'Dice: 2, Probability: 0.970511'],"
		    + "              [3,0.89721,'Dice: 3, Probability: 0.89721'],"
		    + "              [4,0.76038,'Dice: 4, Probability: 0.76038'],"
		    + "              [5,0.575661,'Dice: 5, Probability: 0.575661'],"
		    + "              [6,0.383553,'Dice: 6, Probability: 0.383553'],"
		    + "              [7,0.223463,'Dice: 7, Probability: 0.223463'],"
		    + "              [8,0.113687,'Dice: 8, Probability: 0.113687'],"
		    + "              [9,0.0505656,'Dice: 9, Probability: 0.0505656'],"
		    + "              [10,0.0197063,'Dice: 10, Probability: 0.0197063'],"
		    + "              [11,0.00674539,'Dice: 11, Probability: 0.00674539'],"
		    + "              [12,0.00203234,'Dice: 12, Probability: 0.00203234'],"
		    + "              [13,0.000539869,'Dice: 13, Probability: 0.000539869'],"
		    + "              [14,0.000126571,'Dice: 14, Probability: 0.000126571'],"
		    + "              [15,0.000026198,'Dice: 15, Probability: 0.000026198'],"
		    + "              [16,0.000004785,'Dice: 16, Probability: 0.000004785'],"
		    + "           ]);"
			+ "        var options = {"
		    + "          title: 'N=30',"
			+ "          hAxis: {title: 'Dice', titleTextStyle: {color: 'red'}, minValue: 0, maxValue: 16},"
			+ "          vAxis: {title: 'Probability', titleTextStyle: {color: 'red'},minValue: 0, maxValue: 1},"
			+ "          legend: 'none',"
			+ "          pointSize: 3"
			+ "        };"
			+ "        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));"
			+ "        chart.draw(data, options);"
			+ "      }"
			+ "    </script>"
			+ "  </head>"
			+ "  <body>"
			+ "    <div id=\"chart_div\" style=\"width: 330px; height: 400px;\"></div>"
			+ "  </body>" + "</html>";
		
		WebSettings webSettings = webview.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webview.requestFocusFromTouch();
		webview.loadDataWithBaseURL("file:///android_asset/",content, "text/html", "utf-8", null );
		//webview.loadUrl("file:///android_asset/Code.html"); // Can be used in this way too.
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}	

}
