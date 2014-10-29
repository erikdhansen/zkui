package com.parallelwireless.zkui.dashboard;

import org.zkoss.chart.Charts;
import org.zkoss.chart.model.CategoryModel;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import com.parallelwireless.zkui.models.UnimanageDataUtil;

@SuppressWarnings("serial")
public class CwsLteStatisticsDisplayController extends SelectorComposer<Div>{

	@Wire
	Charts downlinkThroughput;
	@Wire
	Charts uplinkThroughput;
	@Wire
	Charts downlinkVolume;
	@Wire
	Charts uplinkVolume;
	
	public void doAfterCompose(Div d) throws Exception {
		super.doAfterCompose(d);
		doAvgThruDLChart();
		doAvgThruULChart();
		doTrafficVolDLChart();
		doTrafficVolULChart();
	}
	
	private void doAvgThruDLChart() {
		CategoryModel model = UnimanageDataUtil.getCwsAvgThruDLModel();
		downlinkThroughput.setModel(model);
		downlinkThroughput.getYAxis().setTitle("Bandwidth");
	}
	
	private void doAvgThruULChart() {
		CategoryModel model = UnimanageDataUtil.getCwsAvgThruULModel();
		uplinkThroughput.setModel(model);
		uplinkThroughput.getYAxis().setTitle("Bandwidth");
	}
	
	private void doTrafficVolULChart() {
		CategoryModel model = UnimanageDataUtil.getTrafficVolULModel();
		uplinkVolume.setModel(model);
		downlinkVolume.getYAxis().setTitle("Bandwidth");
	}
	
	private void doTrafficVolDLChart() {
		CategoryModel model = UnimanageDataUtil.getTrafficVolDLModel();
		downlinkVolume.setModel(model);
		downlinkVolume.getYAxis().setTitle("Bandwidth");
	}
	
}
