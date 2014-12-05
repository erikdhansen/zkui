package com.parallelwireless.zkui.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import com.parallelwireless.zkui.AlarmSeverity;
import com.parallelwireless.zkui.AlarmSeverity.SEVERITY;

@SuppressWarnings("serial")
public class AlarmList extends LinkedList<AlarmModel> {

	public int getUnackedCount() {
		int unacked = 0;
		for(AlarmModel a : this) {
			if(!a.isAcked()) {
				unacked++;
			}
		}
		return unacked;
	}
	
	public int getSeverityCount(AlarmModel.Severity severity) {
		int count = 0;
		for(AlarmModel a : this) {
			if(a.getSeverity() == severity)
				count++;
		}
		return count;
	}
	
	public Map<AlarmSeverity.SEVERITY, Integer> getTotalBySeverity() {
		Map<AlarmSeverity.SEVERITY, Integer> totalBySeverity = new HashMap<AlarmSeverity.SEVERITY, Integer>();
		totalBySeverity.put(SEVERITY.Critical, 0);
		totalBySeverity.put(SEVERITY.Major, 0);
		totalBySeverity.put(SEVERITY.Minor, 0);
		for(AlarmModel a : this) {
			if(a.severity == AlarmModel.Severity.CRIT) {
				totalBySeverity.put(SEVERITY.Critical, totalBySeverity.get(SEVERITY.Critical) + 1);
			} else if(a.severity == AlarmModel.Severity.MAJ) {
				totalBySeverity.put(SEVERITY.Major, totalBySeverity.get(SEVERITY.Major) + 1);
			} else if(a.severity == AlarmModel.Severity.MIN) {
				totalBySeverity.put(SEVERITY.Minor, totalBySeverity.get(SEVERITY.Minor) + 1);				
			}
		}
		return totalBySeverity;
	}
	
	public Map<String, Integer> getStatusBySeverity(AlarmSeverity.SEVERITY severity) {
		Map<String, Integer> aMap = new HashMap<String, Integer>();
		aMap.put("ACKed", 0);
		aMap.put("UNACKed", 0);
		AlarmModel.Severity mappedSeverity;
		if(severity == SEVERITY.Critical){
			mappedSeverity = AlarmModel.Severity.CRIT;
		} else if(severity == SEVERITY.Major) {
			mappedSeverity = AlarmModel.Severity.MAJ;
		} else if(severity == SEVERITY.Minor) {
			mappedSeverity = AlarmModel.Severity.MIN;
		} else {
			mappedSeverity = AlarmModel.Severity.CLEAR;
		}
		for(AlarmModel a : this) {
			if(a.severity == mappedSeverity) {
				if(a.isAcked()) {
					aMap.put("ACKed", aMap.get("ACKed") + 1);
				} else {
					aMap.put("UNACKed", aMap.get("UNACKed") + 1);
				}
			}
		}
		return aMap;
	}
}
