package com.parallelwireless.zkui;

import java.util.LinkedList;
import java.util.List;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Color;
import org.zkoss.chart.Title;
import org.zkoss.chart.YAxis;
import org.zkoss.chart.model.DefaultDialModel;
import org.zkoss.chart.model.DialModel;
import org.zkoss.chart.model.DialModelScale;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;

import com.parallelwireless.zkui.models.AlarmDataUtil;
import com.parallelwireless.zkui.models.AlarmModel;
import com.parallelwireless.zkui.models.ChartDataModelFactory;
import com.parallelwireless.zkui.models.UnicloudActiveAlarmSummaryData;


@SuppressWarnings("serial")
public class UnicloudDashboardUIController extends SelectorComposer<Component> {

	List<AlarmModel> alarmList;
	
 	@Wire
	Charts alarms;
 	@Wire
 	Charts capacity;
 	
	static List<Color> chartColors = new LinkedList<Color>();	
	static {
		chartColors.add(new Color("#ff6666"));		
		chartColors.add(new Color("#ff0000"));
		chartColors.add(new Color("#ffa500"));
		chartColors.add(new Color("#ffce6f"));
		chartColors.add(new Color("#fcff00"));
		chartColors.add(new Color("#fdff78"));
	}
	
	public void doAfterCompose(Component c) throws Exception {
		super.doAfterCompose(c);
		
		alarmList = getAlarms();
		alarms.setModel(new UnicloudActiveAlarmSummaryData(alarmList).getCategoryModel());
	
		alarms.getLegend().setBackgroundColor("#FFFFFF");
		alarms.getLegend().setReversed(true);;
		alarms.getPlotOptions().getSeries().setStacking("normal");
		alarms.getSeries().setColor(AlarmSeverity.getColorBySeverity(alarms.getSeries().getName()));
		alarms.getCredits().setEnabled(false);
		alarms.setColors(chartColors);
		
		DialModel model = new DefaultDialModel();
		capacity.setTitle("Capacity");
		DialModelScale scale = model.newScale(0, 100, 220, -280, 10, 1);
		scale.setValue(72);
		scale.setText("Capacity");
		scale.newRange(50, 70, "#fdff78", 0.9, 1);
		scale.newRange(70, 85, "#ffce6f", 0.9, 1);
		scale.newRange(85, 100, "#ff6666", 0.9, 1);
		scale.setTickColor("#6d635d");
		model.setFrameFgColor("#624712");
		model.setFrameBgColor("#ffffcc");
		model.setFrameBgColor1("#eeeeee");
		model.setFrameBgColor2("#eeeeee");
		capacity.setModel(model);
	}
	
	private List<AlarmModel> getAlarms() {
		List<AlarmModel> alarms = AlarmDataUtil.getAlarms();
		return alarms;
	}
}
