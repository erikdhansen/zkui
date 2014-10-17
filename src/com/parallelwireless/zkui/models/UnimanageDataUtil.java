package com.parallelwireless.zkui.models;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.DefaultCategoryModel;

import com.parallelwireless.zkui.models.resources.NetworkDeviceComparators;
import com.parallelwireless.zkui.models.resources.NetworkResource;
import com.parallelwireless.zkui.models.resources.ResourceConfig;
import com.parallelwireless.zkui.models.resources.SystemResource.RESOURCE;

public class UnimanageDataUtil {

	static NetworkMap uniclouds = new NetworkMap();
	static {
		// Unicloud Data
		UnicloudModel u = new UnicloudModel(1, "Unicloud A", "10.10.10.122");
		ResourceConfig cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "4");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "3");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "1");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "123112728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "421823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "210293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		u.getSysInfo().addResources(cfg);
		uniclouds.put(1, u);
		// Unicloud Data
		u = new UnicloudModel(1, "Unicloud B", "10.10.10.122");
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "4");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "3");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "1");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_RAM_USED, "2312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "5696700");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "2837");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "421823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "210293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE,"63211775400");
		u.getSysInfo().addResources(cfg);
		uniclouds.put(2, u);
		// Unicloud Data
		u = new UnicloudModel(1, "Unicloud C", "10.10.10.122");
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "9");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "9");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "7");
		cfg.put(RESOURCE.CPU_USER_PCT, "22");
		cfg.put(RESOURCE.CPU_SYS_PCT, "77");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "1");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "8072635");
		cfg.put(RESOURCE.MEM_RAM_FREE, "8265127");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "918273");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "421823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "210293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE,"63211775400");
		u.getSysInfo().addResources(cfg);
		uniclouds.put(3, u);
		// Unicloud Data
		u = new UnicloudModel(1, "Unicloud D", "10.10.10.122");
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE,     "7");
		cfg.put(RESOURCE.CPU_LOAD_FIVE,    "11");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "15");
		cfg.put(RESOURCE.CPU_USER_PCT,    "82");
		cfg.put(RESOURCE.CPU_SYS_PCT,     "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT,    "8");
		cfg.put(RESOURCE.MEM_RAM_TOTAL,   "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED,    "15312728");
		cfg.put(RESOURCE.MEM_RAM_FREE,    "1024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL,  "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE,   "2736252");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "421823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "210293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE,"63211775400");
		u.getSysInfo().addResources(cfg);
		uniclouds.put(4, u);		
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
	
	public static CategoryModel getUnicloudDiskResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<UnicloudModel> ucs = new LinkedList<UnicloudModel>(getAllUniclouds());
		Collections.sort(ucs, Collections.reverseOrder(new NetworkResource(null)));
		for(UnicloudModel u : ucs) {
			model.setValue("Used", u.getName(), u.getSysInfo().getDisk().getUsedDiskSpaceInBytes());
			model.setValue("Free", u.getName(), u.getSysInfo().getDisk().getAvailableDiskInBytes());
		}
		return model;
	}
	public static CategoryModel getUnicloudCpuResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		for(Map.Entry<Integer,UnicloudModel> e : uniclouds.entrySet()) {
			UnicloudModel u = e.getValue();
			model.setValue("Last Minute", u.getName(), stoi(u.getSysInfo().getCpu().getOneMinLoad()));
			model.setValue("Last 5 Min", u.getName(), stoi(u.getSysInfo().getCpu().getFiveMinLoad()));
			model.setValue("Last 15 Min", u.getName(), stoi(u.getSysInfo().getCpu().getFifteenMinLoad()));
		}
		return model;
	}
	
	public static CategoryModel getUnicloudMemResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		for(Map.Entry<Integer, UnicloudModel> e : uniclouds.entrySet()) {
			UnicloudModel u = e.getValue();
			model.setValue("RAM Used", u.getName(), u.getSysInfo().getMem().getTotalRAMUsed());
			model.setValue("RAM Free", u.getName(), u.getSysInfo().getMem().getTotalRAMFree());
			model.setValue("Swap Used", u.getName(), u.getSysInfo().getMem().getUsedSwapSize());
			model.setValue("Swap Free", u.getName(), u.getSysInfo().getMem().getAvailSwapSize());
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
