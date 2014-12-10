package com.parallelwireless.zkui.models.resources;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;

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
		Date installTimestamp = UnimanageDataUtil.getRandomDateBetweenDayAge(1, 365);
		cfg.put(RESOURCE.GEN_INSTALL_DATE, String.valueOf(installTimestamp.getTime()));
		cfg.put(RESOURCE.GEN_SYSTEM_VERSION, UnimanageDataUtil.getRandomSystemVersion());
		cfg.put(RESOURCE.GEN_SERIAL_NUMBER, UnimanageDataUtil.getRandomSerialNumber()); 
		cfg.put(RESOURCE.CPU_LOAD_ONE,     String.valueOf(UnimanageDataUtil.getRandomLongWithinRange(20)));
		cfg.put(RESOURCE.CPU_LOAD_FIVE,    String.valueOf(UnimanageDataUtil.getRandomLongWithinRange(20)));
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, String.valueOf(UnimanageDataUtil.getRandomLongWithinRange(20)));
		int[] cpuPercent = UnimanageDataUtil.getRandomCPUPercent(3, 4);
		cfg.put(RESOURCE.CPU_USER_PCT,     String.valueOf(cpuPercent[0]));
		cfg.put(RESOURCE.CPU_SYS_PCT,      String.valueOf(cpuPercent[1]));
		cfg.put(RESOURCE.CPU_IDLE_PCT,     String.valueOf(cpuPercent[2]));
		cfg.put(RESOURCE.MEM_RAM_TOTAL,    String.valueOf(UnimanageDataUtil.getRandomChoice(new int[]{ 4, 8, 16, 32}) * GB));
		cfg.put(RESOURCE.MEM_RAM_USED,     String.valueOf(new Long(UnimanageDataUtil.getRandomIntFromZero(new Long(Long.parseLong(cfg.get(RESOURCE.MEM_RAM_TOTAL)) / MB).intValue())) * MB));
		cfg.put(RESOURCE.MEM_RAM_FREE,     String.valueOf(Long.parseLong(cfg.get(RESOURCE.MEM_RAM_TOTAL)) - Long.parseLong(cfg.get(RESOURCE.MEM_RAM_USED))));
		cfg.put(RESOURCE.MEM_SWAP_TOTAL,   String.valueOf(UnimanageDataUtil.getRandomChoice(new int[]{ 2, 4, 8, 12}) * GB));
		cfg.put(RESOURCE.MEM_SWAP_FREE,    String.valueOf(new Random().nextInt(new Long(new Long(cfg.get(RESOURCE.MEM_SWAP_TOTAL)) / MB).intValue()) * MB));
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda".concat(String.valueOf(UnimanageDataUtil.getRandomLongWithinRange(5))));
		cfg.put(RESOURCE.DISK_TOTAL_PART_SIZE, String.valueOf(UnimanageDataUtil.getRandomChoice(new int[]{ 1, 2, 4, 8}) * TB));
		int percentFull = new Random().nextInt(100) + 1;
		cfg.put(RESOURCE.DISK_USED_BYTES,  String.valueOf((Long.parseLong(cfg.get(RESOURCE.DISK_TOTAL_PART_SIZE)) * percentFull) / 100));
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, String.valueOf(Long.parseLong(cfg.get(RESOURCE.DISK_TOTAL_PART_SIZE)) - Long.parseLong(cfg.get(RESOURCE.DISK_USED_BYTES))));
		cfg.put(RESOURCE.NET_INTF_NAME, "eth".concat(String.valueOf(UnimanageDataUtil.getRandomIntFromZero(4))));
		cfg.put(RESOURCE.NET_LINK_SPEED, "1000");
		cfg.put(RESOURCE.NET_RX_BYTES,     String.valueOf(UnimanageDataUtil.getRandomLongWithinRange(5 * GB)));
		cfg.put(RESOURCE.NET_TX_BYTES,     String.valueOf(UnimanageDataUtil.getRandomLongWithinRange(5 * GB)));
		cfg.put(RESOURCE.NET_PCT_UTIL,     String.valueOf(new Random().nextInt(100)));
		GeoLocation randomLocation = UnimanageDataUtil.generateRandomLocation();
		cfg.put(RESOURCE.GEO_LATITUDE, String.valueOf(randomLocation.getLat()));
		cfg.put(RESOURCE.GEO_LONGITUDE, String.valueOf(randomLocation.getLng()));
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < 11; i++) {
			sb.append(String.valueOf(UnimanageDataUtil.getRandomLongWithinRange(100)).concat(" "));
		}
		cfg.put(RESOURCE.NET_LAST10_PCT_UTIL, sb.toString().trim());
		return cfg;
	}

}
