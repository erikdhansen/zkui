package com.parallelwireless.zkui.models.resources;

import java.util.HashMap;

import com.parallelwireless.zkui.models.UnimanageDataUtil;
import com.parallelwireless.zkui.models.resources.SystemResource.RESOURCE;

@SuppressWarnings("serial")
public class ResourceConfig extends HashMap<SystemResource.RESOURCE, String> {
	
	public static final long KB = 1024;
	public static final long MB = KB * 1024;
	public static final long GB = MB * 1024;
	public static final long TB = GB * 1024;
	
	public static ResourceConfig generate() {
		ResourceConfig cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE,     String.valueOf(UnimanageDataUtil.getRandomLong(20)));
		cfg.put(RESOURCE.CPU_LOAD_FIVE,    String.valueOf(UnimanageDataUtil.getRandomLong(20)));
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, String.valueOf(UnimanageDataUtil.getRandomLong(20)));
		int[] cpuPercent = UnimanageDataUtil.getRandomPercent(3);
		cfg.put(RESOURCE.CPU_USER_PCT,     String.valueOf(cpuPercent[0]));
		cfg.put(RESOURCE.CPU_SYS_PCT,      String.valueOf(cpuPercent[1]));
		cfg.put(RESOURCE.CPU_IDLE_PCT,     String.valueOf(cpuPercent[2]));
		cfg.put(RESOURCE.MEM_RAM_TOTAL,    String.valueOf(16 * GB));
		cfg.put(RESOURCE.MEM_RAM_USED,     String.valueOf(UnimanageDataUtil.getRandomLong(16 * GB)));
		cfg.put(RESOURCE.MEM_RAM_FREE,     String.valueOf((16*GB) - Long.parseLong(cfg.get(RESOURCE.MEM_RAM_USED))));
		cfg.put(RESOURCE.MEM_SWAP_TOTAL,   String.valueOf(8 * GB));
		cfg.put(RESOURCE.MEM_SWAP_FREE,    String.valueOf(UnimanageDataUtil.getRandomLong(8 * GB)));
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda".concat(String.valueOf(UnimanageDataUtil.getRandomLong(5))));
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, String.valueOf(1 * TB));
		cfg.put(RESOURCE.DISK_USED_BYTES,  String.valueOf(UnimanageDataUtil.getRandomLong(1 * TB)));
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, "612345678900");
		cfg.put(RESOURCE.NET_INTF_NAME, "eth".concat(String.valueOf(UnimanageDataUtil.getRandomLong(4))));
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES,     String.valueOf(UnimanageDataUtil.getRandomLong(1*TB)));
		cfg.put(RESOURCE.NET_TX_BYTES,     String.valueOf(UnimanageDataUtil.getRandomLong(1*TB)));
		cfg.put(RESOURCE.NET_PCT_UTIL,     String.valueOf(UnimanageDataUtil.getRandomLong(100)));
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < 11; i++) {
			sb.append(String.valueOf(UnimanageDataUtil.getRandomLong(100)).concat(" "));
		}
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, sb.toString().trim());
		return cfg;
	}

}
