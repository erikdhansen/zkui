package com.parallelwireless.zkui;

import java.util.LinkedHashMap;
import java.util.Map;

import com.parallelwireless.zkui.AlarmSeverity.SEVERITY;

public class AlarmSeverityData {

	Map<AlarmSeverity.SEVERITY, Integer> totalBySeverity;
	Map<AlarmSeverity.SEVERITY, Map<String, Integer>> sevByAckStatus;
	
	AlarmSeverity critical;
	AlarmSeverity major;
	AlarmSeverity minor;
	
	public AlarmSeverityData(AlarmSeverity critical, AlarmSeverity major, AlarmSeverity minor) {
		this.critical = critical;
		this.major = major;
		this.minor = minor;
		createDataMaps();
	}

	private void createDataMaps() {
		totalBySeverity = new LinkedHashMap<AlarmSeverity.SEVERITY, Integer>();
		sevByAckStatus  = new LinkedHashMap<AlarmSeverity.SEVERITY, Map<String,Integer>>();
		totalBySeverity.put(AlarmSeverity.SEVERITY.Critical, critical.acked + critical.unacked);
		totalBySeverity.put(AlarmSeverity.SEVERITY.Major,  major.unacked + major.acked);
		totalBySeverity.put(AlarmSeverity.SEVERITY.Minor, minor.acked + minor.unacked);
		
		Map<String,Integer> mCrit = new LinkedHashMap<String,Integer>();
		mCrit.put("UnAcked", critical.unacked);
		mCrit.put("Acked", critical.acked);
		Map<String,Integer> mMajor = new LinkedHashMap<String,Integer>();
		mMajor.put("UnAcked", major.unacked);
		mMajor.put("Acked", major.acked);
		Map<String,Integer> mMinor = new LinkedHashMap<String,Integer>();
		mMinor.put("UnAcked", minor.unacked);
		mMinor.put("Acked", minor.acked);
		
		sevByAckStatus.put(AlarmSeverity.SEVERITY.Critical, mCrit);
		sevByAckStatus.put(AlarmSeverity.SEVERITY.Major,  mMajor);
		sevByAckStatus.put(AlarmSeverity.SEVERITY.Minor, mMinor);
	}
	
	public Map<AlarmSeverity.SEVERITY, Integer> getTotalBySeverity() {
		return totalBySeverity;
	}

	public Map<String, Integer> getStatusBySeverity(AlarmSeverity.SEVERITY severity) {
		return sevByAckStatus.get(severity);
	}
	
	
}
