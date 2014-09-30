package com.parallelwireless.zkui;

import java.util.ArrayList;
import java.util.List;

public class CwsAlarmModel {
	
	private List<CwsAlarm> cws = new ArrayList<CwsAlarm>();
	
	public CwsAlarmModel() {
		cws.add(new CwsAlarm("cws-1a", 2, 4, 1));
		cws.add(new CwsAlarm("cws-1b", 5, 0, 8));
		cws.add(new CwsAlarm("cws-1c", 4, 2, 2));
		cws.add(new CwsAlarm("cws-1d", 2, 1, 12));		
	}
	
	public List<CwsAlarm> getCws() {
		return cws;
	}
	
}
