package com.parallelwireless.zkui.models.lte;

public class LteServiceDropRate {

	long abnormalReleases = 0;
	long totalReleases   = 0;
	
	public LteServiceDropRate() {
		
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
	
	public int getPercentAbnormalDrops() {
		Long pctLong = (100 * abnormalReleases) / totalReleases;
		return pctLong.intValue();
	}
}
