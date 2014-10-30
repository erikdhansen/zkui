package com.parallelwireless.zkui.models.lte;

public class LteServiceDropRate extends AbstractLteStatisticType {

	long abnormalReleases = 0;
	long totalReleases   = 0;
	
	public LteServiceDropRate() {
		CRITICAL = 50;
		MAJOR    = 30;
		MINOR    = 10;
	}

	public long getAbnormalReleases() {
		return abnormalReleases;
	}

	public void setAbnormalReleases(long abnormalReleases) {
		this.abnormalReleases = abnormalReleases;
	}

	public long getTotalReleases() {
		return totalReleases;
	}

	public void setTotalReleases(long totalReleases) {
		this.totalReleases = totalReleases;
	}
	
	public long getNormalReleases() {
		return totalReleases - abnormalReleases;
	}
	
	public int getAbnormalDropRate() {
		long dividend = (totalReleases == 0) ? 1 : totalReleases;
		Long pctLong = (100 * abnormalReleases) / dividend;
		return pctLong.intValue();
	}

	@Override
	public int getMonitoredValue() {
		return getAbnormalDropRate();
	}
}
