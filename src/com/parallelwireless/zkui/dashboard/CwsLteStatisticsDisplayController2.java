package com.parallelwireless.zkui.dashboard;

import org.zkoss.chart.Charts;
import org.zkoss.chart.model.CategoryModel;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import com.parallelwireless.zkui.models.UnimanageDataUtil;

@SuppressWarnings("serial")
public class CwsLteStatisticsDisplayController2 extends SelectorComposer<Div>{

	@Wire
	Charts lteSetupChart;
	@Wire
	Charts lteReleaseChart;
	@Wire
	Charts lteHandoverInChart;
	@Wire
	Charts lteHandoverOutChart;
	
	public void doAfterCompose(Div d) throws Exception {
		super.doAfterCompose(d);
		doSetupChart();
		doReleaseChart();
		doHandoverInChart();
		doHandoverOutChart();
	}
		
	private void doSetupChart() {
		lteSetupChart.setModel(UnimanageDataUtil.getLteSetupModel());
		lteSetupChart.getSeries().setStack("Attempts");
		lteSetupChart.getSeries(1).setStack("Attempts");
		lteSetupChart.getYAxis().setTitle("Error Rate");
		lteSetupChart.getPlotOptions().getColumn().setStacking("percent");
		
	}
	
	private void doReleaseChart() {
		lteReleaseChart.setModel(UnimanageDataUtil.getLteReleaseModel());
		lteReleaseChart.getSeries().setStack("Releases");
		lteReleaseChart.getSeries(1).setStack("Releases");
		lteReleaseChart.getYAxis().setTitle("Error Rate");
		lteReleaseChart.getPlotOptions().getColumn().setStacking("percent");
	}
	
	private void doHandoverInChart() {
		lteHandoverInChart.setModel(UnimanageDataUtil.getLteHandoverIn());
		lteHandoverInChart.getSeries().setStack("Handovers");
		lteHandoverInChart.getSeries(1).setStack("Handovers");
		lteHandoverInChart.getYAxis().setTitle("Error Rate");
		lteHandoverInChart.getPlotOptions().getColumn().setStacking("percent");		
	}
	
	private void doHandoverOutChart() {
		lteHandoverOutChart.setModel(UnimanageDataUtil.getLteHandoverOut());
		lteHandoverOutChart.getSeries().setStack("Handovers");
		lteHandoverOutChart.getSeries(1).setStack("Handovers");
		lteHandoverOutChart.getYAxis().setTitle("Error Rate");
		lteHandoverOutChart.getPlotOptions().getColumn().setStacking("percent");		
	}
		
}
