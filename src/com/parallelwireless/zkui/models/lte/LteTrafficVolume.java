package com.parallelwireless.zkui.models.lte;

public class LteTrafficVolume {
	long[] qciTrafficDL = { 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L };
	long[] qciTrafficUL = { 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L };
	
	public LteTrafficVolume() {
		
	}

	public long[] getQciTrafficDL() {
		return qciTrafficDL;
	}

	public void setQciTrafficDL(long[] qciTrafficDL) {
		this.qciTrafficDL = qciTrafficDL;
	}

	public long[] getQciTrafficUL() {
		return qciTrafficUL;
	}

	public void setQciTrafficUL(long[] qciTrafficUL) {
		this.qciTrafficUL = qciTrafficUL;
	}

	public long getTotalTrafficVolumeUL() {
		long totalVolume = 0;
		for(int i=0; i < 9; i++) {
			totalVolume += qciTrafficUL[i];
		}
		return totalVolume;
	}
	
	public long getTotalTrafficVolumeDL() {
		long totalVolume = 0;
		for(int i=0; i < 9; i++) {
			totalVolume += qciTrafficUL[i];
		}
		return totalVolume;
	}
}
