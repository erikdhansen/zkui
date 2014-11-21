package com.parallelwireless.zkui;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Tooltip;
import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.DefaultCategoryModel;
import org.zkoss.chart.model.DefaultDialModel;
import org.zkoss.chart.model.DefaultPieModel;
import org.zkoss.chart.model.DialModel;
import org.zkoss.chart.model.DialModelScale;
import org.zkoss.chart.model.PieModel;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.zul.Tablechildren;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Row;

import com.parallelwireless.zkui.models.AlarmDataUtil;
import com.parallelwireless.zkui.models.AlarmList;
import com.parallelwireless.zkui.models.AlarmModel;
import com.parallelwireless.zkui.models.AlarmModel.Severity;
import com.parallelwireless.zkui.models.Unimanage;


@SuppressWarnings("serial")
public class ManageDeviceLayoutController extends SelectorComposer<Div> {

	@Wire
	Combobox 	deviceNameCombo;
	@Wire
	Radiogroup	deviceTypeRadio;
	@Wire
	Charts		cpu_chart;
	@Wire
	Charts		mem_chart;
	@Wire
	Charts		disk_chart;
	@Wire
	Charts		net_chart;
	@Wire
	Tablechildren mem_div;
	@Wire
	Charts		alarm_chart;
	@Wire
	Grid		alarm_grid;
	
	@Override
	public void doAfterCompose(Div d) throws Exception {
		super.doAfterCompose(d);
		doCpuChart();
		doMemChart();
		doDiskChart();
		doNetChart();
		doAlarms();
	}
	
	private void doAlarms() {
		alarm_chart.setColors(Unimanage.ALARM_COLOR_GRADIENTS);
		PieModel model = new DefaultPieModel();
		AlarmList alarms = AlarmDataUtil.getAlarmsByDevice("Unicloud A");
		model.setValue("Critical", alarms.getSeverityCount(Severity.CRIT));
		model.setValue("Major", alarms.getSeverityCount(Severity.MAJ));
		model.setValue("Minor", alarms.getSeverityCount(Severity.MIN));
		alarm_chart.setModel(model);
	}
	
	private void doCpuChart() {
		DialModel model = new DefaultDialModel();
		DialModelScale scale = model.newScale(0, 100, -150, -300, 10, 4);
		cpu_chart.setSpacingTop(5);
		cpu_chart.getXAxis().getLabels().setStyle("font-size: 8px;");
		cpu_chart.getYAxis().getLabels().setStyle("font-size: 8px;");
		scale.setTickColor("#666666");
		scale.setTickLabelOffset(0.1);
		scale.setValue(75);
		scale.newRange(0, 50, "#55bf3b", 0.9, 1);
		scale.newRange(50, 70, "#ffff0d", 0.9, 1);
		scale.newRange(70, 85, "#df7318", 0.9, 1);
		scale.newRange(85, 100, "#ed5353", 0.9, 1);
		cpu_chart.setModel(model);
	}
	private void doMemChart() {
		DialModel model = new DefaultDialModel();
		DialModelScale scale = model.newScale(0, 100, -150, -300, 10, 4);
		mem_chart.setSpacingTop(5);
		mem_chart.getXAxis().getLabels().setStyle("font-size: 8px;");
		mem_chart.getYAxis().getLabels().setStyle("font-size: 8px;");
		scale.setTickColor("#666666");
		scale.setTickLabelOffset(0.1);
		scale.setValue(88);
		scale.newRange(0, 75, "#55bf3b", 0.9, 1);
		scale.newRange(75, 85, "#ffff0d", 0.9, 1);
		scale.newRange(85, 95, "#df7318", 0.9, 1);
		scale.newRange(95, 100, "#ed5353", 0.9, 1);
		Popup p = new Popup();
		p.setId("mem_detail_popup");
		p.appendChild(getMemoryPopup());
		mem_chart.setModel(model);
		mem_chart.setShowAxes(false);
		mem_div.setTooltip("mem_detail_popup");
	}
	private void doDiskChart() {
		DialModel model = new DefaultDialModel();
		DialModelScale scale = model.newScale(0, 100, -150, -300, 10, 4);
		disk_chart.setSpacingTop(5);
		disk_chart.getXAxis().getLabels().setStyle("font-size: 8px;");
		disk_chart.getYAxis().getLabels().setStyle("font-size: 8px;");
		scale.setTickColor("#666666");
		scale.setTickLabelOffset(0.1);
		scale.setValue(73);
		scale.newRange(0, 75, "#55bf3b", 0.9, 1);
		scale.newRange(75, 85, "#ffff0d", 0.9, 1);
		scale.newRange(85, 95, "#df7318", 0.9, 1);
		scale.newRange(95, 100, "#ed5353", 0.9, 1);
		disk_chart.setModel(model);		
	}
	private void doNetChart() {
		DialModel model = new DefaultDialModel();
		DialModelScale scale = model.newScale(0, 100, -150, -300, 10, 4);
		net_chart.setSpacingTop(5);
		net_chart.getXAxis().getLabels().setStyle("font-size: 8px;");
		net_chart.getYAxis().getLabels().setStyle("font-size: 8px;");
		scale.setTickColor("#666666");
		scale.setTickLabelOffset(0.1);
		scale.setValue(25);
		scale.newRange(0, 75, "#55bf3b", 0.9, 1);
		scale.newRange(75, 85, "#ffff0d", 0.9, 1);
		scale.newRange(85, 95, "#df7318", 0.9, 1);
		scale.newRange(95, 100, "#ed5353", 0.9, 1);
		net_chart.setModel(model);		
	}
	
	private Charts getMemoryPopup() {
		Charts memDetail = new Charts();
		memDetail.setId("mem_detail");
		DialModel model = new DefaultDialModel();
		memDetail.setType(Charts.GAUGE);
		DialModelScale scale = model.newScale(0, 100, -150, -300, 10, 4);
		scale.setValue(88);
		scale.newRange(0, 75, "#55bf3b", 0.9, 1);
		scale.newRange(75, 85, "#ffff0d", 0.9, 1);
		scale.newRange(85, 95, "#df7318", 0.9, 1);
		scale.newRange(95, 100, "#ed5353", 0.9, 1);
		memDetail.setModel(model);
		return memDetail;
	}
}
