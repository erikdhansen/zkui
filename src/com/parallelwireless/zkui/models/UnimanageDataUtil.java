package com.parallelwireless.zkui.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.DefaultCategoryModel;

import com.parallelwireless.zkui.models.lte.LteStatistics;
import com.parallelwireless.zkui.models.lte.LteStatisticsImpl;
import com.parallelwireless.zkui.models.lte.QCI;
import com.parallelwireless.zkui.models.lte.Statistics;
import com.parallelwireless.zkui.models.lte.LteStatistics.STAT;
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
		cfg.put(RESOURCE.CPU_SYS_PCT, "43");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "15");
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
		cfg.put(RESOURCE.DISK_USED_BYTES, "499238276000");
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
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "29293928400");
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
		cfg.put(RESOURCE.CPU_USER_PCT,    "10");
		cfg.put(RESOURCE.CPU_SYS_PCT,     "8");
		cfg.put(RESOURCE.CPU_IDLE_PCT,    "82");
		cfg.put(RESOURCE.MEM_RAM_TOTAL,   "16337652");
		cfg.put(RESOURCE.MEM_RAM_USED,    "15312728");
		cfg.put(RESOURCE.MEM_RAM_FREE,    "1024924");
		cfg.put(RESOURCE.MEM_SWAP_TOTAL,  "8009428");
		cfg.put(RESOURCE.MEM_SWAP_FREE,   "2736252");
		cfg.put(RESOURCE.DISK_PART_DEV_PATH, "/dev/sda1");
		cfg.put(RESOURCE.DISK_USED_BYTES, "421823827600");
		cfg.put(RESOURCE.DISK_AVAIL_BYTES, "110293928400");
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
		cfg.put(RESOURCE.CPU_USER_PCT, "82");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "8");
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
		LteStatisticsImpl lte = new LteStatisticsImpl(cws.getName());
		Statistics stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(1).addCws(cws);
		cws = new CwsModel("cws-uceh-1", 1, "10.11.1.1", NetworkDevice.TYPE.cws_mesh, 0);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "2");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "2");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "2");
		cfg.put(RESOURCE.CPU_USER_PCT, "62");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "28");
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(1).addCws(cws);
		cws = new CwsModel("cws-uceh-2", 1, "10.11.1.2", NetworkDevice.TYPE.cws_mesh, 0);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "14");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "13");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "11");
		cfg.put(RESOURCE.CPU_USER_PCT, "22");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "68");
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(1).addCws(cws);
		cws = new CwsModel("cws-uceh-3", 1, "10.11.1.3", NetworkDevice.TYPE.cws_gw, 0);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "0");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "1");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "1");
		cfg.put(RESOURCE.CPU_USER_PCT, "52");
		cfg.put(RESOURCE.CPU_SYS_PCT, "10");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "38");
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(1).addCws(cws);
		cws = new CwsModel("cws-uceh-3", 1, "10.11.1.4", NetworkDevice.TYPE.cws_gw, 60);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "4");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "1");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "1");
		cfg.put(RESOURCE.CPU_USER_PCT, "12");
		cfg.put(RESOURCE.CPU_SYS_PCT, "30");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "58");
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(2).addCws(cws);
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(2).addCws(cws);
		cws = new CwsModel("cws-uc2-2", 2, "10.11.2.5", NetworkDevice.TYPE.cws_gw, 60);
		cfg = new ResourceConfig();
		cfg.put(RESOURCE.CPU_LOAD_ONE, "4");
		cfg.put(RESOURCE.CPU_LOAD_FIVE, "3");
		cfg.put(RESOURCE.CPU_LOAD_FIFTEEN, "3");
		cfg.put(RESOURCE.CPU_USER_PCT, "52");
		cfg.put(RESOURCE.CPU_SYS_PCT, "28");
		cfg.put(RESOURCE.CPU_IDLE_PCT, "20");
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(2).addCws(cws);
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(2).addCws(cws);
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(3).addCws(cws);
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(3).addCws(cws);
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(3).addCws(cws);
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);		
		uniclouds.get(4).addCws(cws);
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(4).addCws(cws);
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(4).addCws(cws);
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
		lte = new LteStatisticsImpl(cws.getName());
		stats = new Statistics();
		stats.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(getRandomLong(9999999)));
		stats.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), (new Random().nextInt(30) + 1) + 70)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(getRandomLong(100000)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), (new Random().nextInt(30) + 1) + 70)));
		stats.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), (new Random().nextInt(30) + 1) + 70)));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf((Long.parseLong(stats.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 100)/(new Random().nextInt(40) + 1) + 60));
		stats.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(getPercentOfLong(Long.parseLong(stats.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), (new Random().nextInt(20) + 1) + 80)));
		lte.setQCI(getRandomQCI());
		lte.addStatistics(stats);
		cws.setLteStats(lte);
		uniclouds.get(4).addCws(cws);
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
	
	public static List<CwsModel> getTop10CwsModelsLTE(Comparator<CwsModel> comparator) {
		System.out.println("getTop10CwsModelsLTE: called with sort by: " + comparator);
		List<CwsModel> cwsList = new LinkedList<CwsModel>(getAllCwsModels());
		List<CwsModel> top10   = new LinkedList<CwsModel>();
		Collections.sort(cwsList, comparator);
		for(int i=0; i < 10; i++) {
			top10.add(cwsList.get(i));
		}
		return top10;
	}
	
	public static List<CwsModel> getTop10CwsModelsLTEReverse(Comparator<CwsModel> comparator) {
		List<CwsModel> cwsList = new LinkedList<CwsModel>(getAllCwsModels());
		List<CwsModel> top10   = new LinkedList<CwsModel>();
		Collections.sort(cwsList, Collections.reverseOrder(comparator));
		for(int i=0; i < 10; i++) {
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
	
	public static CategoryModel getCwsLteHandoverSuccessRate() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwss = new LinkedList<CwsModel>(getTop10CwsModelsLTE(CwsModel.LTE_HANDOVER_SUCCESS_RATE_IN));
		for(CwsModel cws : cwss) {
			model.setValue("Successful", cws.getName(), cws.getLteStats().getServiceHandoverInbound().getSuccess());
			model.setValue("Unsuccessful", cws.getName(), cws.getLteStats().getServiceHandoverInbound().getFailures());
		}
		return model;
	}
	public static CategoryModel getCwsLteSetupSuccessRate() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwss = new LinkedList<CwsModel>(getTop10CwsModelsLTE(CwsModel.LTE_SETUP_SUCCESS_RATE));
		for(CwsModel cws : cwss) {
			model.setValue("Successful", cws.getName(), cws.getLteStats().getSetupSuccessRateTotal().getSetupSuccesses());
			model.setValue("Failed",  cws.getName(),  cws.getLteStats().getSetupSuccessRateTotal().getSetupAttempts() - cws.getLteStats().getSetupSuccessRateTotal().getSetupSuccesses());
		}
		return model;
	}
	
	public static CategoryModel getCwsLteServiceDropRate() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwss = new LinkedList<CwsModel>(getTop10CwsModelsLTE(CwsModel.LTE_SERVICE_DROP_RATE));
		for(CwsModel cws : cwss) {
			model.setValue("Normal Release", cws.getName(), cws.getLteStats().getServiceDropRate().getTotalReleases() - cws.getLteStats().getServiceDropRate().getAbnormalReleases());
			model.setValue("Abnormal Release", cws.getName(), cws.getLteStats().getServiceDropRate().getAbnormalReleases());
		}
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
	
	public static CategoryModel getCwsAvgThruDLModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<QCI> qcis = getTop10QCI(QCI.AVG_THRU_DL);
		for(QCI q : qcis) {
			model.setValue(q.getQciName(), q.getSystemName(), q.getServiceAvgThruDL());
		}
		return model;
	}

	public static CategoryModel getCwsAvgThruULModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<QCI> qcis = getTop10QCI(QCI.AVG_THRU_UL);
		for(QCI q : qcis) {
			model.setValue(q.getQciName(), q.getSystemName(), q.getServiceAvgThruUL());
		}
		return model;
	}

	public static CategoryModel getTrafficVolULModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<QCI> qcis = getTop10QCI(QCI.TRAF_VOL_UL);
		for(QCI q : qcis) {
			model.setValue(q.getQciName(), q.getSystemName(), q.getServiceTrafficVolUL());
		}
		return model;
	}

	public static CategoryModel getTrafficVolDLModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<QCI> qcis = getTop10QCI(QCI.TRAF_VOL_DL);
		for(QCI q : qcis) {
			model.setValue(q.getQciName(), q.getSystemName(), q.getServiceTrafficVolDL());
		}
		return model;
	}
	
	public static CategoryModel getLteSetupModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwsList = getTop10CwsModelsLTEReverse(CwsModel.LTE_SETUP_SUCCESS_RATE);
		for(CwsModel cws : cwsList) {
			model.setValue("Success", cws.getName(), cws.getLteStats().getSetupSuccessRateTotal().getSetupSuccesses());
			model.setValue("Failure", cws.getName(), cws.getLteStats().getSetupSuccessRateTotal().getSetupFailures());
		}
		return model;
	}
	
	public static CategoryModel getLteReleaseModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwsList = getTop10CwsModelsLTE(CwsModel.LTE_SERVICE_DROP_RATE);
		for(CwsModel cws : cwsList) {
			model.setValue("Normal", cws.getName(), cws.getLteStats().getServiceDropRate().getNormalReleases());
			model.setValue("Abormal", cws.getName(), cws.getLteStats().getServiceDropRate().getAbnormalReleases());
		}
		return model;
	}

	public static CategoryModel getLteHandoverIn() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwsList = getTop10CwsModelsLTE(CwsModel.LTE_HANDOVER_SUCCESS_RATE_IN);
		for(CwsModel cws : cwsList) {
			model.setValue("Normal", cws.getName(), cws.getLteStats().getServiceHandoverInbound().getSuccess());
			model.setValue("Abormal", cws.getName(), cws.getLteStats().getServiceHandoverInbound().getFailures());
		}
		return model;
	}

	public static CategoryModel getLteHandoverOut() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwsList = getTop10CwsModelsLTE(CwsModel.LTE_HANDOVER_SUCCESS_RATE_OUT);
		for(CwsModel cws : cwsList) {
			model.setValue("Normal", cws.getName(), cws.getLteStats().getServiceHandoverOutbound().getSuccess());
			model.setValue("Abormal", cws.getName(), cws.getLteStats().getServiceHandoverOutbound().getFailures());
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
	
	public static long getRandomLong() {
		return getRandomLong(9999999);
	}
	
	public static long getRandomLong(int max) {
		Random rand = new Random();
		long randomNum = rand.nextInt((max - (max * 7 / 10) + 1) + (max * 7 / 10));
		System.out.println("Generated new TOTAL: " + randomNum);
		return randomNum;
	}
	
	public static long getPercentOfLong(long total, int percent) {
		long fraction = (total * percent)/100;
		System.out.println("Attempts: " + total + " percent: " + percent + " success/failure: " + fraction);
		return fraction;
	}
	
	public static QCI[] getRandomQCI() {
		QCI[] q = new QCI[9];
		for(int i=0; i < 9; i++) {
			q[i] = new QCI(i, getRandomLong(10000), getRandomLong(10000), getRandomLong(1000), getRandomLong(10000));
		}
		return q;
	}
	
	public static List<QCI> getNQCI(int n, Comparator<QCI> comparator) {
		List<QCI> qcis = new LinkedList<QCI>();
		Collection<CwsModel> cwsList = getAllCwsModels();
		for(CwsModel cws : cwsList) {
			qcis.addAll(Arrays.asList(cws.getLteStats().getQCI()));
		}
		Collections.sort(qcis, comparator);
		return qcis.subList(0,  n-1);
	}
	
	public static List<QCI> getTop10QCI(Comparator<QCI> comparator) {
		List<QCI> qcis = new LinkedList<QCI>();
		Collection<CwsModel> cwsList = getAllCwsModels();
		for(CwsModel cws : cwsList) {
			qcis.addAll(Arrays.asList(cws.getLteStats().getQCI()));
		}
		Collections.sort(qcis, comparator);
		return qcis.subList(0, 9);
	}
	
}
