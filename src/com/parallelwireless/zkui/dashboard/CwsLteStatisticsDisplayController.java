package com.parallelwireless.zkui.dashboard;

import org.zkoss.chart.Charts;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

@SuppressWarnings("serial")
public class CwsLteStatisticsDisplayController extends SelectorComposer<Div>{

	@Wire
	Charts setSuccessRate;
	@Wire
	Charts serviceDropRate;
	@Wire
	Charts avgDLThroughput;
	@Wire
	Charts avgULThroughput;
	@Wire
	Charts avgDLVolume;
	@Wire
	Charts avgULVolume;
	@Wire 
	Charts handoverSuccessRate;
	
	public void doAfterCompose(Div d) throws Exception {
		
	}
	
	
}
