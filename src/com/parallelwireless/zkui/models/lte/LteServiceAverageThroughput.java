package com.parallelwireless.zkui.models.lte;

public class LteServiceAverageThroughput {
	long[] qciAverageDL = { 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L };
	long[] qciAverageUL = { 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L };
	
	public LteServiceAverageThroughput() {
		
	}

	public long[] getQciAverageDL() {
		return qciAverageDL;
	}

	public void setQciAverageDL(long[] qciAverageDL) {
		this.qciAverageDL = qciAverageDL;
	}

	public long[] getQciAverageUL() {
		return qciAverageUL;
	}

	public void setQciAverageUL(long[] qciAverageUL) {
		this.qciAverageUL = qciAverageUL;
	}
	
	public long getTotalThroughputDL() {
		long totalThroughput = 0;
		for(int i=0; i < 9; i++) {
			totalThroughput += qciAverageDL[i];
		}
		return totalThroughput;
	}

	public long getTotalThroughputUL() {
		long totalThroughput = 0;
		for(int i=0; i < 9; i++) {
			totalThroughput += qciAverageUL[i];
		}
		return totalThroughput;
	}
	
}
