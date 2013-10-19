package com.SmallJoeMan.sindudo;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint.Align;

public class LineGraph {
	
	private Context appContext;
	private GraphicalView view;
	private TimeSeries series = new TimeSeries("probabilities");
	private XYMultipleSeriesRenderer mRenderer;
	private XYSeriesRenderer renderer;
	private XYMultipleSeriesDataset dataset;
	
	public LineGraph()
	{
		mRenderer = new XYMultipleSeriesRenderer();
		renderer = new XYSeriesRenderer();	   
	    mRenderer.addSeriesRenderer(renderer);
	    
	    dataset = new XYMultipleSeriesDataset();
		dataset.addSeries(series);
	}
	
	public LineGraph(Context context, double[] yVals)
	{
		this();
		appContext = context;
		formatRenderers();
		setDataset(yVals);
	}
	
	public void formatRenderers()
	{
		renderer.setPointStyle(PointStyle.CIRCLE);
		renderer.setFillPoints(true);
		renderer.setColor(Color.argb(255, 0, 99, 212));
		mRenderer.setApplyBackgroundColor(true);
		mRenderer.setMarginsColor(Color.argb(0x01, 0x01, 0x01, 0x01));
		mRenderer.setBackgroundColor(Color.TRANSPARENT);
		mRenderer.setAxisTitleTextSize(25); // 16
	    mRenderer.setChartTitleTextSize(25); // 20
	    mRenderer.setLabelsTextSize(25); // 15
	    mRenderer.setPointSize(5);
	    mRenderer.setMargins(new int[] { 20, 90, 20, 20 });
	    mRenderer.setYLabelsAlign(Align.RIGHT);
	    mRenderer.setYLabelsPadding(10);
	    mRenderer.setZoomButtonsVisible(false);
	    mRenderer.setShowLegend(false);
	    mRenderer.setShowGridX(true);
	    mRenderer.setShowLabels(true);
	    mRenderer.setPanEnabled(false,false);
	    mRenderer.setYAxisMin(0.0);
	    mRenderer.setYAxisMax(1.0);
	    mRenderer.setXTitle(appContext.getString(R.string.xTitle));
	    mRenderer.setYTitle(appContext.getString(R.string.yTitle));
	    mRenderer.setXLabelsColor(Color.BLACK);
	    mRenderer.setYLabelsColor(0, Color.BLACK);
	    mRenderer.setLabelsColor(Color.BLACK);
	    mRenderer.setAxesColor(Color.BLACK);
	}
	
	public void setDataset( double[] yVals )
	{
		// generate values
		series.clear();
		int range;
		if(yVals.length>16)
		{
			range = 16; 
		}
		else
		{
			range=yVals.length;
		}
		for (int i = 0; i<range; i++)
		{
			series.add(i, yVals[i]);
		}	
	}
	
	public GraphicalView getView()
	{			
		// return GraphView
		view = ChartFactory.getLineChartView(appContext, dataset, mRenderer);
		return view;
	}
}
