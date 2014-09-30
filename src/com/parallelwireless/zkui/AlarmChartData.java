package com.parallelwireless.zkui;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Point;
import org.zkoss.chart.Series;

import com.parallelwireless.zkui.models.AlarmList;
import com.parallelwireless.zkui.models.AlarmModel;

public class AlarmChartData {

	public static void summary(Series s, AlarmList alarms) {
		s.setType("pie");
		s.setName("Alarm Summary");
		Point p = new Point("Critical", alarms.getSeverityCount(AlarmModel.Severity.CRIT));
		p.setSelected(true);
		p.setSliced(true);
		s.addPoint(p);
		s.addPoint(new Point("Major", alarms.getSeverityCount(AlarmModel.Severity.MAJ)));
		s.addPoint(new Point("Minor", alarms.getSeverityCount(AlarmModel.Severity.MIN)));
	}
	
	public static void device(Charts c) {
		Series s = c.getSeries();
		s.setType("pie");
		s.setName("Device Summary");
		
		
	}
}
