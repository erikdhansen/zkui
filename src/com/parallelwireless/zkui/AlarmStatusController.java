package com.parallelwireless.zkui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Point;
import org.zkoss.chart.Series;
import org.zkoss.chart.plotOptions.ColumnPlotOptions;
import org.zkoss.chart.plotOptions.DataLabels;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import com.parallelwireless.zkui.models.AlarmRowModel;
import com.parallelwireless.zkui.models.AlarmStatusModel;
import com.parallelwireless.zkui.models.Unimanage;
import com.parallelwireless.zkui.models.UnimanageDataUtil;

@SuppressWarnings("serial")
public class AlarmStatusController extends SelectorComposer<Div>{

	AlarmStatusModel alarmStatusData = UnimanageDataUtil.getAlarmSummary();
	
	@Wire
	Charts alarm_counts;
	
	public ListModel<AlarmRowModel> getAlarmRows() {
		return new ListModelList<AlarmRowModel>(alarmStatusData.getAlarmRowModels());
	}
	
	public AlarmStatusModel getAlarmSummary() {
		return alarmStatusData;
	}
	
	public void doAfterCompose(Div d) throws Exception {
		super.doAfterCompose(d);
		
		DataLabels dataLabels = alarm_counts.getPlotOptions().getSeries().getDataLabels();
		dataLabels.setEnabled(true);
		dataLabels.setFormat("{point.name}: {point.y}");
		
		alarm_counts.getTooltip().setHeaderFormat("<span style=\"font-size: 11px\">{series.name}</span><br/>");
		alarm_counts.getTooltip().setPointFormat("<span style=\"color:{point.color}\">{point.name}" + "</span>: <b>{point.y}</b>");
		alarm_counts.setColors(Unimanage.DEFAULT_CHART_GRADIENTS);
		
		initAlarmSeriesDrilldown();
	}
	
	public void initAlarmSeriesDrilldown() {
		Series series = alarm_counts.getSeries();
		List<Series> drilldowns = new ArrayList<Series>();
		series.setName("Active Alarms");
		ColumnPlotOptions plotOptions = new ColumnPlotOptions();
		plotOptions.setColorByPoint(true);
		series.setPlotOptions(plotOptions);
		Iterator<AlarmRowModel> iterator = alarmStatusData.getAlarmRowModels().iterator();
		while(iterator.hasNext()) {
			AlarmRowModel row = iterator.next();
			String label = row.getDeviceType();
			int alarmCount = row.getCritical() + row.getMajor() + row.getMinor();
			Point point = new Point(label, alarmCount);
			if(alarmCount > 1) {
				point.setDrilldown(label);
					Series s = new Series();
					s.setId(label);
					
					Point critical = new Point("Critical", row.getCritical());
					critical.setColor(Unimanage.ALARM_COLOR_GRADIENTS.get(0));
					s.addPoint(critical);
					
					Point major = new Point("Major", row.getMajor());
					major.setColor(Unimanage.ALARM_COLOR_GRADIENTS.get(1));
					s.addPoint(major);
					
					Point minor = new Point("Minor", row.getMinor());
					minor.setColor(Unimanage.ALARM_COLOR_GRADIENTS.get(2));
					s.addPoint(minor);
					drilldowns.add(s);
			}
			series.addPoint(point);
		}
		alarm_counts.getDrilldown().setSeries(drilldowns);		
	}
	
}
