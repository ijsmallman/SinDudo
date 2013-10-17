package com.SmallJoeMan.sindudo;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint.Align;

public class LineGraph {
	
	
	private GraphicalView view;
	private TimeSeries series = new TimeSeries("probabilities");
	private XYMultipleSeriesRenderer mRenderer;
	private XYSeriesRenderer renderer;
	private XYMultipleSeriesDataset dataset;
	
	public LineGraph()
	{
		mRenderer = new XYMultipleSeriesRenderer();
		renderer = new XYSeriesRenderer();	
		
		renderer.setPointStyle(PointStyle.CIRCLE);
		mRenderer.setApplyBackgroundColor(true);
		mRenderer.setMarginsColor(Color.argb(0x00, 0x01, 0x01, 0x01));
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
	    mRenderer.setXTitle("minimum number of dice");
	    mRenderer.setYTitle("probability");
	    
	    mRenderer.addSeriesRenderer(renderer);
	    
	    dataset = new XYMultipleSeriesDataset();
		dataset.addSeries(series);
	}
	
	public LineGraph(double[] yVals)
	{
		this();
		setDataset(yVals);		
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
	
	public GraphicalView getView(Context context)
	{			
		// return GraphView
		view = ChartFactory.getLineChartView(context, dataset, mRenderer);
		return view;
	}
}
