package com.parallelwireless.zkui;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

@SuppressWarnings("serial")
public class UnicloudHeirarchyController extends SelectorComposer<Component> {
	final CwsAlarmModel cwsAlarmData = new CwsAlarmModel();
	public ListModel<CwsAlarm> getUnicloud() {
		return new ListModelList<CwsAlarm>(cwsAlarmData.getCws());
	}
}
