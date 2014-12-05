package com.parallelwireless.zkui;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.zkoss.chart.Charts;
import org.zkoss.chart.model.DefaultDialModel;
import org.zkoss.chart.model.DefaultPieModel;
import org.zkoss.chart.model.DialModel;
import org.zkoss.chart.model.DialModelScale;
import org.zkoss.chart.model.PieModel;
import org.zkoss.gmaps.Gmaps;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.zul.Tablechildren;
import org.zkoss.zul.Auxheader;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Popup;

import com.parallelwireless.zkui.models.AlarmDataUtil;
import com.parallelwireless.zkui.models.AlarmList;
import com.parallelwireless.zkui.models.AlarmModel;
import com.parallelwireless.zkui.models.AlarmModel.Severity;
import com.parallelwireless.zkui.models.NetworkDevice;
import com.parallelwireless.zkui.models.NetworkDevice.TYPE;
import com.parallelwireless.zkui.models.NetworkDeviceNotFoundException;
import com.parallelwireless.zkui.models.Unimanage;
import com.parallelwireless.zkui.models.UnimanageDataUtil;
import com.parallelwireless.zkui.models.map.NetworkDeviceMapModel;


@SuppressWarnings("serial")
public class ManageDeviceLayoutController extends SelectorComposer<Div> {
	final static Logger log = Logger.getLogger(ManageDeviceLayoutController.class.getName());
	
	@Wire
	Combobox 	deviceNameCombo;
	
	// Maps
	@Wire
	Gmaps gmap;
	
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
	// Grids
	@Wire
	Grid		alarm_grid;
	@Wire
	Grid		deviceInformation;
	
	@Wire
	Checkbox	lac;
	@Wire
	Checkbox	cwsGW;
	@Wire
	Checkbox	cwsMesh;
	@Wire
	Auxheader	alarmGridHeader;
	
	boolean includeLac     = true;
	boolean includeCwsGW   = true;
	boolean includeCwsMesh = true;
	
	@Override
	public void doAfterCompose(Div d) throws Exception {
		super.doAfterCompose(d);
	}

	@Listen("onSelect = #deviceNameCombo")
	public void deviceNameSelected() {
		log.log(Level.INFO, "device name selected: " + deviceNameCombo.getSelectedItem().getValue());
		updatePage((String)deviceNameCombo.getSelectedItem().getValue());
	}
	@Listen( "onCheck = Checkbox" )
	public void deviceTypeChecked(CheckEvent e) {
		includeLac     = lac.isChecked()     ? true : false;
		includeCwsGW   = cwsGW.isChecked()   ? true : false;
		includeCwsMesh = cwsMesh.isChecked() ? true : false;
		updateDeviceNameCombo();
	}

	private void updatePage(String deviceName) {
		log.log(Level.INFO, "Updating device view page for device: " + deviceName);
		try {
			NetworkDevice d = UnimanageDataUtil.getNetworkDevice(deviceName);
			updateDeviceInformation(d);
			updateSystemResources(d);
			updateMaps(d);
			doAlarms(d);
			updateInventoryInformation(d);
			updateKPIs(d);
		} catch (NetworkDeviceNotFoundException e) {
			Unimanage.getModalWindow("No such device name" + deviceName);
		}
	}
		
	private void updateMaps(NetworkDevice d) {
		NetworkDeviceMapModel mapModel = new NetworkDeviceMapModel(d);
		gmap.setModel(mapModel);
		gmap.setCenter(mapModel.getCenterLat(), mapModel.getCenterLng());
	}
	
	private void updateDeviceNameCombo() {
		List<String> netDevNames = UnimanageDataUtil.getAllNetworkDeviceNames(includeLac, includeCwsGW, includeCwsMesh);
		deviceNameCombo.setModel(new ListModelList<String>(netDevNames));
	}
	
	private void doCpuChart(NetworkDevice d) {
		if(d == null)
			return;
		log.log(Level.INFO, "doCpuChart: NetworkDevice = " + d.getName());
		DialModel model = new DefaultDialModel();
		DialModelScale scale = model.newScale(0, 100, -150, -300, 10, 4);
		cpu_chart.setSpacingTop(5);
		cpu_chart.getXAxis().getLabels().setStyle("font-size: 8px;");
		cpu_chart.getYAxis().getLabels().setStyle("font-size: 8px;");
		scale.setTickColor("#666666");
		scale.setTickLabelOffset(0.1);
		scale.setValue(d.getSysInfo().getCpu().getPercentCPUTotal());
		scale.newRange(0, 50, "#55bf3b", 0.9, 1);
		scale.newRange(50, 70, "#ffff0d", 0.9, 1);
		scale.newRange(70, 85, "#df7318", 0.9, 1);
		scale.newRange(85, 100, "#ed5353", 0.9, 1);
		cpu_chart.setModel(model);
	}
	
	private void doMemChart(NetworkDevice d) {
		if(d == null)
			return;
		log.log(Level.INFO, "doMemChart: NetworkDevice = " + d.getName());		
		DialModel model = new DefaultDialModel();
		DialModelScale scale = model.newScale(0, 100, -150, -300, 10, 4);
		mem_chart.setSpacingTop(5);
		mem_chart.getXAxis().getLabels().setStyle("font-size: 8px;");
		mem_chart.getYAxis().getLabels().setStyle("font-size: 8px;");
		scale.setTickColor("#666666");
		scale.setTickLabelOffset(0.1);
		scale.setValue(d.getSysInfo().getMem().getPercentUsed());
		scale.newRange(0, 75, "#55bf3b", 0.9, 1);
		scale.newRange(75, 85, "#ffff0d", 0.9, 1);
		scale.newRange(85, 95, "#df7318", 0.9, 1);
		scale.newRange(95, 100, "#ed5353", 0.9, 1);
		mem_chart.setModel(model);
	}
	
	private void doDiskChart(NetworkDevice d) {
		if(d == null)
			return;
		log.log(Level.INFO, "doDiskChart: NetworkDevice = " + d.getName());		
		DialModel model = new DefaultDialModel();
		DialModelScale scale = model.newScale(0, 100, -150, -300, 10, 4);
		disk_chart.setSpacingTop(5);
		disk_chart.getXAxis().getLabels().setStyle("font-size: 8px;");
		disk_chart.getYAxis().getLabels().setStyle("font-size: 8px;");
		scale.setTickColor("#666666");
		scale.setTickLabelOffset(0.1);
		scale.setValue(d == null ? 0 : d.getSysInfo().getDisk().getPercentSpaceUsed());
		scale.newRange(0, 75, "#55bf3b", 0.9, 1);
		scale.newRange(75, 85, "#ffff0d", 0.9, 1);
		scale.newRange(85, 95, "#df7318", 0.9, 1);
		scale.newRange(95, 100, "#ed5353", 0.9, 1);
		disk_chart.setModel(model);		
	}
	private void doNetChart(NetworkDevice d) {
		if(d == null)
			return;
		log.log(Level.INFO, "doNetChart: NetworkDevice = " + d.getName());		
		DialModel model = new DefaultDialModel();
		DialModelScale scale = model.newScale(0, 100, -150, -300, 10, 4);
		net_chart.setSpacingTop(5);
		net_chart.getXAxis().getLabels().setStyle("font-size: 8px;");
		net_chart.getYAxis().getLabels().setStyle("font-size: 8px;");
		scale.setTickColor("#666666");
		scale.setTickLabelOffset(0.1); 
		scale.setValue(d.getSysInfo().getNetwork().getCurrentPercentUtilization());
		scale.newRange(0, 75, "#55bf3b", 0.9, 1);
		scale.newRange(75, 85, "#ffff0d", 0.9, 1);
		scale.newRange(85, 95, "#df7318", 0.9, 1);
		scale.newRange(95, 100, "#ed5353", 0.9, 1);
		net_chart.setModel(model);		
	}
	
	private void updateDeviceInformation(NetworkDevice d) {
		log.log(Level.INFO, "updateDeviceInformation: " + d.toString());
		LinkedList<NetworkDevice> dlist = new LinkedList<>();
		dlist.add(d);
		deviceInformation.setModel(new ListModelList<NetworkDevice>(dlist));
	}
	
	private void updateSystemResources(NetworkDevice d) {
		log.log(Level.INFO, "updateSystemResources: " + d.toString());
		doCpuChart(d);
		doMemChart(d);
		doDiskChart(d);
		doNetChart(d);
	}
	
	private void doAlarms(NetworkDevice d) {
		if(d == null)
			return;
		log.log(Level.INFO, "updateAlarmInformation: " + d.toString());
		
		// Alarm Chart
		alarm_chart.setColors(Unimanage.ALARM_COLOR_GRADIENTS);
		alarm_chart.setTitle(d.getName());
		PieModel model = new DefaultPieModel();
		AlarmList alarms = AlarmDataUtil.getAlarmsByDevice(d.getName());
		model.setValue("Critical", alarms.getSeverityCount(Severity.CRIT));
		model.setValue("Major", alarms.getSeverityCount(Severity.MAJ));
		model.setValue("Minor", alarms.getSeverityCount(Severity.MIN));
		alarm_chart.setModel(model);		
		
		// Alarm Grid
		alarmGridHeader.setLabel("Device Alarms: " + d.getName());
		alarm_grid.setModel(new ListModelList<AlarmModel>(alarms));
		
	}
	
	private void updateInventoryInformation(NetworkDevice d) {
		log.log(Level.INFO, "updateInventoryInformation: " + d.toString());		
	}
	
	private void updateKPIs(NetworkDevice d) {
		log.log(Level.INFO, "updateKPIs: " + d.toString());		
	}
	
}
