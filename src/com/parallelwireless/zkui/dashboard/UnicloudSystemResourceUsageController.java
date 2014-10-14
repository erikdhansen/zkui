package com.parallelwireless.zkui.dashboard;

import java.util.LinkedList;
import java.util.List;

import org.zkoss.chart.Charts;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import com.parallelwireless.zkui.models.UnicloudModel;

public class UnicloudSystemResourceUsageController extends SelectorComposer<Div>{

	@Wire
	Charts cpuChart;
	@Wire
	Charts memChart;
	
	List<UnicloudModel>	top10CPU  = new LinkedList<UnicloudModel>();
	List<UnicloudModel> top10Mem  = new LinkedList<UnicloudModel>();
	List<UnicloudModel> top10Disk = new LinkedList<UnicloudModel>();
	List<UnicloudModel> top10Net  = new LinkedList<UnicloudModel>();
}
