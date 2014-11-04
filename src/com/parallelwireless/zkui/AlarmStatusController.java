package com.parallelwireless.zkui;

import org.zkoss.chart.Charts;
import org.zkoss.chart.model.DefaultPieModel;
import org.zkoss.chart.model.PieModel;
import org.zkoss.chart.plotOptions.DataLabels;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import com.parallelwireless.zkui.models.AlarmRowModel;
import com.parallelwireless.zkui.models.AlarmStatusModel;
import com.parallelwireless.zkui.models.Unimanage;
import com.parallelwireless.zkui.models.UnimanageDataUtil;

@SuppressWarnings("serial")
public class AlarmStatusController extends SelectorComposer<Window>{

	AlarmStatusModel alarmStatusData = UnimanageDataUtil.getAlarmSummary();
	
	@Wire
	Charts alarm_counts;
	
	public ListModel<AlarmRowModel> getAlarmRows() {
		return new ListModelList<AlarmRowModel>(alarmStatusData.getAlarmRowModels());
	}
	
	public AlarmStatusModel getAlarmSummary() {
		return alarmStatusData;
	}
	
	public void doAfterCompose(Window d) throws Exception {
		super.doAfterCompose(d);
		
		DataLabels dataLabels = alarm_counts.getPlotOptions().getSeries().getDataLabels();
		dataLabels.setEnabled(true);
		dataLabels.setFormat("{point.name}: {point.y}");
		
		alarm_counts.getTooltip().setHeaderFormat("<span style=\"font-size: 11px\">{series.name}</span><br/>");
		alarm_counts.getTooltip().setPointFormat("<span style=\"color:{point.color}\">{point.name}" + "</span>: <b>{point.y}</b>");
		alarm_counts.setColors(Unimanage.ALARM_COLOR_GRADIENTS);
		alarm_counts.setModel(getAlarmSummaryModel());
		
	}
	
	public PieModel getAlarmSummaryModel() {
		int critical = alarmStatusData.getCriticalTotal();
		int major    = alarmStatusData.getMajorTotal();
		int minor    = alarmStatusData.getMinorTotal();
		
		PieModel model = new DefaultPieModel();
		model.setValue("Critical", critical);
		model.setValue("Major", major);
		model.setValue("Minor", minor);
		return model;
	}
}
