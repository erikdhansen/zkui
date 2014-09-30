package com.parallelwireless.zkui;

import java.util.LinkedHashMap;
import java.util.Map;

import com.parallelwireless.zkui.AlarmSeverity.SEVERITY;

public class AlarmDeviceData {

	Map<String, Integer> totalByDevice;
	Map<String, Map<SEVERITY, Integer>> sevByDevice;
	
	public AlarmDeviceData() {
		createDataMaps();
	}

	private void createDataMaps() {
		totalByDevice = new LinkedHashMap<String, Integer>();
		sevByDevice  = new LinkedHashMap<String, Map<SEVERITY,Integer>>();
		totalByDevice.put("UC1", 14);
		totalByDevice.put("UC2", 26);
		
		Map<SEVERITY,Integer> uc1 = new LinkedHashMap<SEVERITY,Integer>();
		uc1.put(SEVERITY.Critical, 2);
		uc1.put(SEVERITY.Major, 4);
		uc1.put(SEVERITY.Minor, 8);
		
		Map<SEVERITY,Integer> uc2 = new LinkedHashMap<SEVERITY,Integer>();
		uc2.put(SEVERITY.Critical, 6);
		uc2.put(SEVERITY.Major, 11);
		uc2.put(SEVERITY.Minor, 9);
				
		sevByDevice.put("UC1", uc1);
		sevByDevice.put("UC2",  uc2);
	}
	
	public Map<String, Integer> getTotalByDevice() {
		return totalByDevice;
	}

	public Map<SEVERITY, Integer> getSevByDevice(String device) {
		return sevByDevice.get(device);
	}
	
	
}
