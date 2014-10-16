package com.parallelwireless.zkui.models;

import java.net.NetworkInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.zkoss.chart.Series;
import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.ChartsModel;
import org.zkoss.chart.model.DefaultCategoryModel;
import org.zkoss.chart.model.DefaultPieModel;

import com.parallelwireless.zkui.models.ChartDataModelFactory.TYPE;
import com.parallelwireless.zkui.models.CwsModel.CWS_TYPE;

public class UnimanageDataUtil {

	static NetworkMap uniclouds = new NetworkMap();
	static {
		uniclouds.put(1, new UnicloudModel(1, "Unicloud EH", "10.10.10.122", new SysInfo("4","3","1").setMemoryStats(16337652, 12312728, 4024924, 8009428, 8009428)));
		uniclouds.put(2, new UnicloudModel(2, "Unicloud 2", "10.10.10.128", new SysInfo("2","2","2").setMemoryStats(8009428, 2312728, 5696700, 8009428, 2837)));
		uniclouds.put(3, new UnicloudModel(3, "Unicloud 3", "10.10.10.3", new SysInfo("0","0","0").setMemoryStats(16337652, 8072635, 8265107, 8009428, 918273)));
		uniclouds.put(4, new UnicloudModel(4, "Unicloud 4", "10.10.10.4", new SysInfo("7","11","15").setMemoryStats(16337652, 15312728, 1024924, 8009428, 2736252)));
	}
	static {
		uniclouds.get(1).getCwsList().add(new CwsModel("cws-uceh-1", 1, "10.11.1.1", NetworkDevice.TYPE.cws_mesh, 0));
		uniclouds.get(1).getCwsList().add(new CwsModel("cws-uceh-2", 1, "10.11.1.2", NetworkDevice.TYPE.cws_mesh, 0));
		uniclouds.get(1).getCwsList().add(new CwsModel("cws-uceh-3", 1, "10.11.1.3", NetworkDevice.TYPE.cws_gw, 0));
		uniclouds.get(1).getCwsList().add(new CwsModel("cws-uceh-3", 1, "10.11.1.4", NetworkDevice.TYPE.cws_gw, 60));
		uniclouds.get(2).getCwsList().add(new CwsModel("cws-uc2-1", 2, "10.11.2.4", NetworkDevice.TYPE.cws_mesh, 0));
		uniclouds.get(2).getCwsList().add(new CwsModel("cws-uc2-2", 2, "10.11.2.5", NetworkDevice.TYPE.cws_gw, 60));
		uniclouds.get(2).getCwsList().add(new CwsModel("cws-uc2-3", 2, "10.11.2.6", NetworkDevice.TYPE.cws_gw, 60));
		uniclouds.get(2).getCwsList().add(new CwsModel("cws-uc2-4", 2, "10.11.2.7", NetworkDevice.TYPE.cws_mesh, 0));
		uniclouds.get(3).getCwsList().add(new CwsModel("cws-uc3-1", 3, "10.11.3.8", NetworkDevice.TYPE.cws_gw, 0));
		uniclouds.get(3).getCwsList().add(new CwsModel("cws-uc3-2", 3, "10.11.3.9", NetworkDevice.TYPE.cws_mesh, 60));
		uniclouds.get(3).getCwsList().add(new CwsModel("cws-uc3-3", 3, "10.11.3.10", NetworkDevice.TYPE.cws_mesh, 0));
		uniclouds.get(4).getCwsList().add(new CwsModel("cws-uc4-1", 4, "10.11.4.11", NetworkDevice.TYPE.cws_gw, 0));
		uniclouds.get(4).getCwsList().add(new CwsModel("cws-uc4-2", 4, "10.11.4.12", NetworkDevice.TYPE.cws_mesh, 0));
		uniclouds.get(4).getCwsList().add(new CwsModel("cws-uc4-3", 4, "10.11.4.13", NetworkDevice.TYPE.cws_gw, 60));
	}
	
	public static UnicloudModel getUnicloud(int id) {
		return uniclouds.get(id);
	}
	
	public static Collection<UnicloudModel> getAllUniclouds() {
		return uniclouds.values();
	}
	
	public static NetworkSummary getNetworkSummary() {
		return new NetworkSummary(uniclouds);
	}
	
	public static AlarmStatusModel getAlarmSummary() {
		AlarmStatusModel model = new AlarmStatusModel();
		List<AlarmRowModel> rows = model.getAlarmRowModels();
		rows.clear();
		rows.add(new AlarmRowModel(NetworkDeviceStatusBucket.getLabel(NetworkDevice.TYPE.unicloud), 3, 4, 8));
		rows.add(new AlarmRowModel(NetworkDeviceStatusBucket.getLabel(NetworkDevice.TYPE.cws_gw), 6, 3, 9));
		rows.add(new AlarmRowModel(NetworkDeviceStatusBucket.getLabel(NetworkDevice.TYPE.cws_mesh), 4, 2, 3));
		return model;
	}
	
	public static CategoryModel getUnicloudCpuResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		for(Map.Entry<Integer,UnicloudModel> e : uniclouds.entrySet()) {
			UnicloudModel u = e.getValue();
			model.setValue("Last Minute", u.getName(), stoi(u.getSysInfo().getOneMinLoad()));
			model.setValue("Last 5 Min", u.getName(), stoi(u.getSysInfo().getFiveMinLoad()));
			model.setValue("Last 15 Min", u.getName(), stoi(u.getSysInfo().getFifteenMinLoad()));
		}
		return model;
	}
	
	public static CategoryModel getUnicloudMemResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		for(Map.Entry<Integer, UnicloudModel> e : uniclouds.entrySet()) {
			UnicloudModel u = e.getValue();
			System.out.println("Unicloud: " + u.getName() + ": sysInfo(mem) = " + u.getSysInfo().dumpMemInfo());
			model.setValue("RAM Used", u.getName(), u.getSysInfo().getTotalRAMUsed());
			model.setValue("RAM Free", u.getName(), u.getSysInfo().getTotalRAMFree());
			model.setValue("Swap Used", u.getName(), u.getSysInfo().getUsedSwapSize());
			model.setValue("Swap Free", u.getName(), u.getSysInfo().getAvailSwapSize());
		}
		return model;
	}
	
	private static int stoi(String s) {
		int i = -1;
		try {
			i = Integer.valueOf(s);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static List<NetworkDeviceInterface> fudgeNetworkDeviceInterfaces(NetworkDevice.TYPE type) {
		List<NetworkDeviceInterface> netIfs = new LinkedList<NetworkDeviceInterface>();
		NetworkDeviceInterface netIf = new NetworkDeviceInterface();
		netIfs.add(netIf);
		return netIfs;
		
	}
}
