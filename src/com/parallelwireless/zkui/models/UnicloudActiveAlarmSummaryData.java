package com.parallelwireless.zkui.models;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.chart.model.CategoryModel;
import com.parallelwireless.zkui.models.AlarmModel.Severity;
import com.parallelwireless.zkui.models.ChartDataModelFactory.TYPE;

public class UnicloudActiveAlarmSummaryData {
	CategoryModel data;
	LinkedHashMap<AlarmModel.Severity, HashMap<Boolean, Integer>> aMap = new LinkedHashMap<AlarmModel.Severity, HashMap<Boolean, Integer>>();
	private CategoryModel model;
	
	public UnicloudActiveAlarmSummaryData(List<AlarmModel> alarms) {
		data = (CategoryModel) ChartDataModelFactory.getNewChartDataModel(TYPE.category);
		initializeAlarmMap(alarms);
		createDataModel();
	}
			
	private void createDataModel() {
		Map<Boolean,Integer> critical = aMap.get(Severity.CRIT);
		Map<Boolean, Integer> major = aMap.get(Severity.MAJ);
		Map<Boolean, Integer> minor = aMap.get(Severity.MIN);
		
		model = (CategoryModel) ChartDataModelFactory.getNewChartDataModel(TYPE.category);
		model.setValue("ACKed", "Critical", critical.get(true));
		model.setValue("UnACKed", "Critical", critical.get(false));
		model.setValue("ACKed", "Major", major.get(true));
		model.setValue("UnACKed", "Major", major.get(false));
		model.setValue("ACKed", "Minor", minor.get(true));
		model.setValue("UnACKed", "Minor", minor.get(false));
	}

	public CategoryModel getCategoryModel() {
		return model;
	}
	
	private void initializeAlarmMap(List<AlarmModel> alarms) {
		HashMap<Boolean, Integer> critical = new HashMap<Boolean, Integer>();
		critical.put(true, 0);
		critical.put(false, 0);
		HashMap<Boolean, Integer> major = new HashMap<Boolean, Integer>();
		major.put(true, 0);
		major.put(false, 0);
		HashMap<Boolean, Integer> minor = new HashMap<Boolean, Integer>();
		minor.put(true, 0);
		minor.put(false, 0);
		
		aMap.put(Severity.CRIT, critical);
		aMap.put(Severity.MAJ, major);
		aMap.put(Severity.MIN, minor);
		
		for(AlarmModel a : alarms) {
			System.out.println("Processing alarm: " + a.toString());
			Map<Boolean, Integer> sevMap = aMap.get(a.getSeverity());
			if(a.isAcked())
				sevMap.put(true, sevMap.get(true) + 1);
			else
				sevMap.put(false,  sevMap.get(false) + 1);
		}
	}
}
