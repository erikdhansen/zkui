package com.parallelwireless.zkui.models.lte;

public class LteServiceTrafficStats {
	
	long[] serviceAvgThruUL = new long[9];
	long[] serviceAvgThruDL = new long[9];
	long[] trafficVolumeUL  = new long[9];
	long[] trafficVolumeDL  = new long[9];
	
	public LteServiceTrafficStats() {
		
	}
	
	public LteServiceTrafficStats(QCI[] qci) {
		setQCI(qci);
	}

	public void setQCI(QCI[] qci) {
		for(int i=0; i < 9; i++) {
			serviceAvgThruUL[i] = qci[i].getServiceAvgThruUL();
			serviceAvgThruDL[i] = qci[i].getServiceAvgThruDL();
			trafficVolumeUL[i]  = qci[i].getServiceTrafficVolUL();
			trafficVolumeDL[i]  = qci[i].getServiceTrafficVolDL();
		}
		
	}
	
	public long getServiceAvgThruUL(int index) {
		return serviceAvgThruUL[index];
	}
	
	public long getServiceAvgThruDL(int index) {
		return serviceAvgThruDL[index];
	}

	public long getTrafficVolumeUL(int index) {
		return trafficVolumeUL[index];
	}

	public long getTrafficVolumeDL(int index) {
		return trafficVolumeDL[index];
	}
	
	public long getTotalTrafficVolumeUL() {
		long totalVolumeUL = 0;
		for(int i=0; i < 9; i++) {
			totalVolumeUL += trafficVolumeUL[i];
		}
		return totalVolumeUL;
	}
	
	public long getTotalTrafficVolumeDL() {
		long totalVolumeDL = 0;
		for(int i=0; i < 9; i++) {
			totalVolumeDL += trafficVolumeDL[i];
		}
		return totalVolumeDL;
	}
		
	public long getTotalThroughputDL() {
		long totalThroughput = 0;
		for(int i=0; i < 9; i++) {
			totalThroughput += serviceAvgThruDL[i];
		}
		return totalThroughput;
	}

	public long getTotalThroughputUL() {
		long totalThroughput = 0;
		for(int i=0; i < 9; i++) {
			totalThroughput += serviceAvgThruUL[i];
		}
		return totalThroughput;
	}
	
}
