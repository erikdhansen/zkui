package com.parallelwireless.zkui.dashboard;

import java.util.LinkedList;
import java.util.List;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Legend;
import org.zkoss.chart.YAxis;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import com.parallelwireless.zkui.models.CwsModel;
import com.parallelwireless.zkui.models.Unimanage;
import com.parallelwireless.zkui.models.UnimanageDataUtil;

@SuppressWarnings("serial")
public class CwsSystemResourceUsageController extends SelectorComposer<Div>{

	@Wire
	Charts cpuChart;
	@Wire
	Charts memChart;
	@Wire
	Charts diskChart;
	@Wire
	Charts netChart;
	@Wire
	Div cpuChartDiv;


	List<CwsModel>	top10CPU  = new LinkedList<CwsModel>();
	List<CwsModel> top10Mem  = new LinkedList<CwsModel>();
	List<CwsModel> top10Disk = new LinkedList<CwsModel>();
	List<CwsModel> top10Net  = new LinkedList<CwsModel>();
	
	public void doAfterCompose(Div d) throws Exception {
		super.doAfterCompose(d);
		doCpuChart();
		doMemChart();
		doDiskChart();
		doNetChart();
	}
	
	private void doNetChart() {
		netChart.setModel(UnimanageDataUtil.getCwsNetResourceModel());
		netChart.getYAxis().setMin(0);
		netChart.getYAxis().setMax(100);
		netChart.getYAxis().setTitle("% Net");
		
	}
	private void doDiskChart() {
		diskChart.setModel(UnimanageDataUtil.getCwsDiskResourceModel());
		//diskChart.getSeries().setStack("Used");
		//diskChart.getSeries(1).setStack("Free");
		diskChart.getYAxis().setTitle("% Disk");
		diskChart.getPlotOptions().getColumn().setStacking("percent");
		
	}
	private void doMemChart() {
		memChart.setModel(UnimanageDataUtil.getCwsMemResourceModel());
		
		// Alternate RAM/SWAP as series stack since that's how the data was added
		// This allows for stack grouping across all data
		memChart.getSeries().setStack("RAM");
 		memChart.getSeries().setColor(Unimanage.RESOURCE_RAM_USED);
//		memChart.getPlotOptions().getSeries().setThreshold(75);
//		memChart.getPlotOptions().getSeries().setNegativeColor("#aaffaa");
//		memChart.getPlotOptions().getSeries().setColor("#ff3333");
		memChart.getSeries(1).setStack("RAM");
		memChart.getSeries(1).setColor(Unimanage.RESOURCE_RAM_FREE);
		memChart.getSeries(2).setStack("Swap");
		memChart.getSeries(2).setColor(Unimanage.RESOURCE_SWAP_USED);
		memChart.getSeries(3).setStack("Swap");
		memChart.getSeries(3).setColor(Unimanage.RESOURCE_SWAP_FREE);

		memChart.getXAxis().setTitle("% Memory");
		memChart.getYAxis().setMin(0);
		memChart.getTooltip().setPointFormat("<span style=\"color:{series.color}\">{series.name}</span>" + ": <b>{point.y}</b> ({point.percentage:.0f}%)</br>");
		memChart.getTooltip().setShared(true);
		memChart.getPlotOptions().getColumn().setStacking("percent");
		memChart.setInverted(true);
	}
	
	private void doCpuChart() {
		cpuChart.setModel(UnimanageDataUtil.getCwsLteSetupSuccessRate());
		cpuChart.getXAxis().setTitle("");
		YAxis y = cpuChart.getYAxis();
		y.setMin(0);
		y.setTitle("Setup Success Rate");
		y.getTitle().setAlign("high");
		y.getLabels().setOverflow("justify");
		cpuChart.getPlotOptions().getBar().getDataLabels().setEnabled(true);
		
		Legend legend = cpuChart.getLegend();
		legend.setLayout("vertical");
		legend.setAlign("right");
		legend.setVerticalAlign("top");
		legend.setX(0);
		legend.setY(60);
		legend.setFloating(true);
		legend.setBorderWidth(1);
		legend.setShadow(true);
		legend.setBackgroundColor("#ffffff");
		cpuChart.getPlotOptions().getColumn().setStacking("percent");
		cpuChart.getCredits().setEnabled(false);
		
	}
	
	public void togglecpuChart() {
		cpuChartDiv.setVisible( cpuChartDiv.isVisible() ? false : true );
	}
}
