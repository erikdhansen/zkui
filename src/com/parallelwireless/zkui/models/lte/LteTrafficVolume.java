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

}
