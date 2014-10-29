package com.parallelwireless.zkui.models.lte;

public class QCI {
	long serviceAvgThruUL    = 0;
	long serviceAvgThruDL    = 0;
	long serviceTrafficVolUL = 0;
	long serviceTrafficVolDL = 0;
	
	public QCI() {	
	}

	public QCI(long serviceAvgThruUL, long serviceAvgThruDL, long serviceTrafficVolUL, long serviceTrafficVolDL) {
		this.serviceAvgThruUL    = serviceAvgThruUL;
		this.serviceAvgThruDL    = serviceAvgThruDL;
		this.serviceTrafficVolUL = serviceTrafficVolUL;
		this.serviceTrafficVolDL = serviceTrafficVolDL;
	}
	
	public long getServiceAvgThruUL() {
		return serviceAvgThruUL;
	}

	public void setServiceAvgThruUL(long serviceAvgThruUL) {
		this.serviceAvgThruUL = serviceAvgThruUL;
	}

	public long getServiceAvgThruDL() {
		return serviceAvgThruDL;
	}

	public void setServiceAvgThruDL(long serviceAvgThruDL) {
		this.serviceAvgThruDL = serviceAvgThruDL;
	}

	public long getServiceTrafficVolUL() {
		return serviceTrafficVolUL;
	}

	public void setServiceTrafficVolUL(long serviceTrafficVolUL) {
		this.serviceTrafficVolUL = serviceTrafficVolUL;
	}

	public long getServiceTrafficVolDL() {
		return serviceTrafficVolDL;
	}

	public void setServiceTrafficVolDL(long serviceTrafficVolDL) {
		this.serviceTrafficVolDL = serviceTrafficVolDL;
	}
}
