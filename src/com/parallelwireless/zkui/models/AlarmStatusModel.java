package com.parallelwireless.zkui.models;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

public class AlarmStatusModel {

	private List<AlarmRowModel> alarmRowModels = new ArrayList<AlarmRowModel>();
	
	public AlarmStatusModel() {
	}

	public List<AlarmRowModel> getAlarmRowModels() {
		return alarmRowModels;
	}
	
	public void setAlarmRowModels(List<AlarmRowModel> alarmRowModels) {
		this.alarmRowModels = alarmRowModels;
	}
	
	public ListModel<AlarmRowModel> getAlarmRowListModel() {
		return new ListModelList<AlarmRowModel>(alarmRowModels);
	}
	
	public int getCriticalTotal() {
		int total = 0;
		for(AlarmRowModel a : alarmRowModels) {
			total += a.getCritical();
		}
		return total;
	}

	public int getMajorTotal() {
		int total = 0;
		for(AlarmRowModel a : alarmRowModels) {
			total += a.getMajor();
		}
		return total;
	}

	public int getMinorTotal() {
		int total = 0;
		for(AlarmRowModel a : alarmRowModels) {
			total += a.getMinor();
		}
		return total;
	}
	
}
