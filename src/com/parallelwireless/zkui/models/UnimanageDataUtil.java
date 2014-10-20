package com.parallelwireless.zkui.models;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.DefaultCategoryModel;

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
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");
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
		cfg.put(RESOURCE.DISK_USED_BYTES, "49923827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "21029392840");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE,"63211775400");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "62");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "97 99 99 89 77 74 69 68 68 65");
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
		cfg.put(RESOURCE.DISK_USED_BYTES, "411823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "329293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE,"63211775400");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "10");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "63 68 66 66 66 4 4 8 9 10");
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
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "52");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "71 52 59 57 52 54 53 52 51 51");
		u.getSysInfo().addResources(cfg);
		uniclouds.put(4, u);		
	}
	static {
		CwsModel cws = new CwsModel("cws-uca-1", 1, "10.11.1.1", NetworkDevice.TYPE.cws_mesh, 0);
		ResourceConfig cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "4");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "3");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "1");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(1).getCwsList().add(cws);
		cws = new CwsModel("cws-uceh-1", 1, "10.11.1.1", NetworkDevice.TYPE.cws_mesh, 0);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "2");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "2");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "2");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(1).getCwsList().add(cws);
		cws = new CwsModel("cws-uceh-2", 1, "10.11.1.2", NetworkDevice.TYPE.cws_mesh, 0);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "14");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "13");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "11");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(1).getCwsList().add(cws);
		cws = new CwsModel("cws-uceh-3", 1, "10.11.1.3", NetworkDevice.TYPE.cws_gw, 0);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "0");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "1");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "1");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(1).getCwsList().add(cws);
		cws = new CwsModel("cws-uceh-3", 1, "10.11.1.4", NetworkDevice.TYPE.cws_gw, 60);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "4");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "1");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "1");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(2).getCwsList().add(cws);
		cws = new CwsModel("cws-uc2-1", 2, "10.11.2.4", NetworkDevice.TYPE.cws_mesh, 0);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "1");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "2");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "3");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(2).getCwsList().add(cws);
		cws = new CwsModel("cws-uc2-2", 2, "10.11.2.5", NetworkDevice.TYPE.cws_gw, 60);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "4");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "3");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "3");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(2).getCwsList().add(cws);
		cws = new CwsModel("cws-uc2-3", 2, "10.11.2.6", NetworkDevice.TYPE.cws_gw, 60);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "2");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "7");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "2");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(2).getCwsList().add(cws);
		cws = new CwsModel("cws-uc2-4", 2, "10.11.2.7", NetworkDevice.TYPE.cws_mesh, 0);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "2");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "2");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "3");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(3).getCwsList().add(cws);
		cws = new CwsModel("cws-uc3-1", 3, "10.11.3.8", NetworkDevice.TYPE.cws_gw, 0);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "3");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "3");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "4");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(3).getCwsList().add(cws);
		cws = new CwsModel("cws-uc3-2", 3, "10.11.3.9", NetworkDevice.TYPE.cws_mesh, 60);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "4");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "4");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "5");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(3).getCwsList().add(cws);
		cws = new CwsModel("cws-uc3-3", 3, "10.11.3.10", NetworkDevice.TYPE.cws_mesh, 0);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "4");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "5");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "1");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(4).getCwsList().add(cws);
		cws = new CwsModel("cws-uc4-1", 4, "10.11.4.11", NetworkDevice.TYPE.cws_gw, 0);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "2");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "2");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "1");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(4).getCwsList().add(cws);
		cws = new CwsModel("cws-uc4-2", 4, "10.11.4.12", NetworkDevice.TYPE.cws_mesh, 0);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "2");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "3");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "2");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(4).getCwsList().add(cws);
		cws = new CwsModel("cws-uc4-3", 4, "10.11.4.13", NetworkDevice.TYPE.cws_gw, 60);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "4");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "0");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "1");
		cfg.put(RESOURCE.CPU_USER_PCT, "42");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "48");
		cfg.put(RESOURCE.MEM_RAM_TOTAL, "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED, "12312728");
		cfg.put(RESOURCE.MEM_RAM_FREE, "4024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL, "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE, "8009428");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "521823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth0");
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES, "8374637");
		cfg.put(RESOURCE.NET_TX_BYTES, "8374625");
		cfg.put(RESOURCE.NET_PCT_UTIL, "22");
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, "83 64 89 57 46 38 20 29 26 22");		
		cws.getSysInfo().addResources(cfg);
		uniclouds.get(4).getCwsList().add(cws);
	}
	
	public static UnicloudModel getUnicloud(int id) {
		return uniclouds.get(id);
	}
	
	public static Collection<UnicloudModel> getAllUniclouds() {
		return uniclouds.values();
	}
	
	public static Collection<CwsModel> getAllCwsModels() {
		List<CwsModel> cwsList = new LinkedList<CwsModel>();
		for(UnicloudModel u : getAllUniclouds()) {
			cwsList.addAll(u.getCwsList());
		}
		return cwsList;
	}
	
	public static Collection<CwsModel> getAllCwsModels(Comparator<NetworkDevice> comparator) {
		List<CwsModel> cwsList = new LinkedList<CwsModel>(getAllCwsModels());
		Collections.sort(cwsList, comparator);
		return cwsList;
	}
	
	public static List<CwsModel> getTop10CwsModels(Comparator<NetworkDevice> comparator) {
		List<CwsModel> cwsList = new LinkedList<CwsModel>(getAllCwsModels());
		List<CwsModel> top10 = new LinkedList<CwsModel>();
		Collections.sort(cwsList, comparator);
		for(int i = 0; i < 10; i++) {
			top10.add(cwsList.get(i));
		}
		return top10;
	}
	
	public static Collection<UnicloudModel> getAllUniclouds(Comparator<NetworkDevice> comparator) {
		List<UnicloudModel> unicloudList = new LinkedList<UnicloudModel>(uniclouds.values());
		Collections.sort(unicloudList, comparator);
		return unicloudList;
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
		for(UnicloudModel u : ucs) {
			model.setValue("Free", u.getName(), u.getSysInfo().getDisk().getAvailableDiskInBytes());
			model.setValue("Used", u.getName(), u.getSysInfo().getDisk().getUsedDiskSpaceInBytes());
		}
		return model;
	}
	
	public static CategoryModel getCwsDiskResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		for(CwsModel c : getTop10CwsModels(NetworkDeviceImpl.DISK)) {
			model.setValue("Free", c.getName(), c.getSysInfo().getDisk().getAvailableDiskInBytes());
			model.setValue("Used", c.getName(), c.getSysInfo().getDisk().getUsedDiskSpaceInBytes());
		}
		return model;
	}
	
	public static CategoryModel getUnicloudCpuResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<UnicloudModel> ucs = new LinkedList<UnicloudModel>(getAllUniclouds());
		for(UnicloudModel u : ucs) {			
			model.setValue(u.getName(), "-15 min", stoi(u.getSysInfo().getCpu().getFifteenMinLoad()));
			model.setValue(u.getName(), "-5 min", stoi(u.getSysInfo().getCpu().getFiveMinLoad()));
			model.setValue(u.getName(), "-1 min", stoi(u.getSysInfo().getCpu().getOneMinLoad()));
		}
		return model;
	}
	
	public static CategoryModel getCwsCpuResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwss = new LinkedList<CwsModel>(getTop10CwsModels(NetworkDeviceImpl.CPU));
		for(CwsModel c : cwss) {
			model.setValue(c.getName(), "-15 min", stoi(c.getSysInfo().getCpu().getFifteenMinLoad()));
			model.setValue(c.getName(), "-10 min", stoi(c.getSysInfo().getCpu().getFiveMinLoad()));
			model.setValue(c.getName(), "-5 min", stoi(c.getSysInfo().getCpu().getOneMinLoad()));
		}
		return model;
	}
	
	public static CategoryModel getUnicloudMemResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<UnicloudModel> ucs = new LinkedList<UnicloudModel>(getAllUniclouds());
		for(UnicloudModel u : ucs) {
			model.setValue("RAM Used", u.getName(), u.getSysInfo().getMem().getTotalRAMUsed());
			model.setValue("RAM Free", u.getName(), u.getSysInfo().getMem().getTotalRAMFree());
			model.setValue("Swap Used", u.getName(), u.getSysInfo().getMem().getUsedSwapSize());
			model.setValue("Swap Free", u.getName(), u.getSysInfo().getMem().getAvailSwapSize());
		}
		return model;
	}

	public static CategoryModel getCwsMemResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwss = new LinkedList<CwsModel>(getTop10CwsModels(NetworkDeviceImpl.MEM));
		for(CwsModel c : cwss) {
			model.setValue("RAM Used", c.getName(), c.getSysInfo().getMem().getTotalRAMUsed());
			model.setValue("RAM Free", c.getName(), c.getSysInfo().getMem().getTotalRAMFree());
			model.setValue("Swap Used", c.getName(), c.getSysInfo().getMem().getUsedSwapSize());
			model.setValue("Swap Free", c.getName(), c.getSysInfo().getMem().getAvailSwapSize());
		}
		return model;
	}
	
	public static CategoryModel getUnicloudNetResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<UnicloudModel> ucs = new LinkedList<UnicloudModel>(getAllUniclouds());
		for(UnicloudModel u : ucs) {
			for(int i=0; i < u.getSysInfo().getNetwork().getLastTenPercentUtilization().size(); i++) {
				model.setValue(u.getName(), "-" + (u.getSysInfo().getNetwork().getLastTenPercentUtilization().size() - i) + " min", u.getSysInfo().getNetwork().getLastTenPercentUtilization().get(i));
			}
		}
		return model;
	}

	public static CategoryModel getCwsNetResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwss = new LinkedList<CwsModel>(getTop10CwsModels(NetworkDeviceImpl.NET));
		for(CwsModel c : cwss) {
			for(int i=0; i < c.getSysInfo().getNetwork().getLastTenPercentUtilization().size(); i++) {
				model.setValue(c.getName(), "-" + (c.getSysInfo().getNetwork().getLastTenPercentUtilization().size() - i) + " min", c.getSysInfo().getNetwork().getLastTenPercentUtilization().get(i));
			}
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
