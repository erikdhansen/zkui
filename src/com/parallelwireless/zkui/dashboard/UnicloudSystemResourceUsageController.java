package com.parallelwireless.zkui.dashboard;

import java.util.LinkedList;
import java.util.List;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Legend;
import org.zkoss.chart.YAxis;
import org.zkoss.chart.model.DefaultCategoryModel;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import com.parallelwireless.zkui.models.UnicloudModel;
import com.parallelwireless.zkui.models.UnimanageDataUtil;

@SuppressWarnings("serial")
public class UnicloudSystemResourceUsageController extends SelectorComposer<Div>{

	@Wire
	Charts cpuChart;
	@Wire
	Charts memChart;
	@Wire
	Div cpuChartDiv;


	List<UnicloudModel>	top10CPU  = new LinkedList<UnicloudModel>();
	List<UnicloudModel> top10Mem  = new LinkedList<UnicloudModel>();
	List<UnicloudModel> top10Disk = new LinkedList<UnicloudModel>();
	List<UnicloudModel> top10Net  = new LinkedList<UnicloudModel>();
	
	public void doAfterCompose(Div d) throws Exception {
		super.doAfterCompose(d);
		cpuChart.setModel(UnimanageDataUtil.getUnicloudCpuResourceModel());
		cpuChart.getXAxis().setTitle("");
		memChart.setModel(new DefaultCategoryModel());
		memChart.getXAxis().setTitle("");
		
		YAxis y = cpuChart.getYAxis();
		y.setMin(0);
		y.setTitle("Load Avg");
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
		
		cpuChart.getCredits().setEnabled(false);
	}
	
	public void toggleCpuChart() {
		cpuChartDiv.setVisible( cpuChartDiv.isVisible() ? false : true );
	}
}
