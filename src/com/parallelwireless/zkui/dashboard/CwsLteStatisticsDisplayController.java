package com.parallelwireless.zkui.dashboard;

import org.zkoss.chart.Charts;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

@SuppressWarnings("serial")
public class CwsLteStatisticsDisplayController extends SelectorComposer<Div>{

	@Wire
	Charts lteSetupChart;
	@Wire
	Charts lteReleaseChart;
	@Wire
	Charts lteHandoverInChart;
	@Wire
	Charts lteHandoverOutChart;

	public void doAfterCompose(Div d) throws Exception {
		
	}
	
	
}
