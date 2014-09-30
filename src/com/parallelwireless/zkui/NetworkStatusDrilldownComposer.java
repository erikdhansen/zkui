package com.parallelwireless.zkui;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.chart.Chart;
import org.zkoss.chart.Charts;
import org.zkoss.chart.Series;
import org.zkoss.chart.plotOptions.ColumnPlotOptions;
import org.zkoss.chart.plotOptions.DataLabels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;

public class NetworkStatusDrilldownComposer extends SelectorComposer<Component>{

	@Wire
	Charts status;
	
	public void doAfterCompose(Component c) throws Exception {
		super.doAfterCompose(c);
		
		DataLabels dataLabels = status.getPlotOptions().getSeries().getDataLabels();
		dataLabels.setEnabled(true);
		dataLabels.setFormat("{point.name}: {point.y}");
		
		status.getTooltip().setHeaderFormat("<span style=\"font-size: 11px\">{series.name}</span><br/>");
		status.getTooltip().setPointFormat("<span style=\"color:{point:color}\">{point.name}" + "</span>: <b>{point.y}</b> of total<br/>");
		initSeries();
	}
	
	private void initSeries() {
		Series series = status.getSeries();
		List<Series> drilldowns = new ArrayList<Series>();
		series.setName("Device Types");
		ColumnPlotOptions plotOptions = new ColumnPlotOptions();
		plotOptions.setColorByPoint(true);
		series.setPlotOptions(plotOptions);
		
	}
}
