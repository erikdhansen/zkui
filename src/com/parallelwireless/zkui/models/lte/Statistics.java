package com.parallelwireless.zkui.models.lte;

import java.util.HashMap;
import java.util.Random;

import com.parallelwireless.zkui.models.UnimanageDataUtil;
import com.parallelwireless.zkui.models.lte.LteStatistics.STAT;

@SuppressWarnings("serial")
public class Statistics extends HashMap<LteStatistics.STAT, String>{

	public Statistics() {
		this.put(STAT.LTE_ERAB_SSR_ATTEMPT_ALL, String.valueOf(UnimanageDataUtil.getRandomLongWithinRange(9999999)));
		this.put(STAT.LTE_ERAB_SSR_SUCCESS_ALL, String.valueOf(UnimanageDataUtil.getPercentOfLong(Long.parseLong(this.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)), new Random().nextInt(30) + 70)));
		this.put(STAT.LTE_HANDOVER_ATTEMPTS_IN, String.valueOf(UnimanageDataUtil.getRandomLongWithinRange(100000)));
		this.put(STAT.LTE_HANDOVER_ATTEMPTS_OUT, String.valueOf(UnimanageDataUtil.getRandomLongWithinRange(100000)));
		this.put(STAT.LTE_HANDOVER_SUCCESSES_IN, String.valueOf(UnimanageDataUtil.getPercentOfLong(Long.parseLong(this.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)), new Random().nextInt(30) + 70)));
		this.put(STAT.LTE_HANDOVER_SUCCESSES_OUT, String.valueOf(UnimanageDataUtil.getPercentOfLong(Long.parseLong(this.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)), new Random().nextInt(30) + 70)));
		this.put(STAT.LTE_SERVICE_DROP_RATE_TOTAL, String.valueOf(Long.parseLong(this.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)) * 7 / 10));
		this.put(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL, String.valueOf(UnimanageDataUtil.getPercentOfLong(Long.parseLong(this.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)), new Random().nextInt(20))));
	}
}
