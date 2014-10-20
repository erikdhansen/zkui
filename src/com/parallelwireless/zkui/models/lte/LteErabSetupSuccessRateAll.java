package com.parallelwireless.zkui.models.lte;

public class LteErabSetupSuccessRateAll {
	long setupAttempts  = 0;
	long setupSuccesses = 0;
	
	public LteErabSetupSuccessRateAll() {
	}

	public long getSetupAttempts() {
		return setupAttempts;
	}

	public void setSetupAttempts(long setupAttempts) {
		this.setupAttempts = setupAttempts;
	}

	public long getSetupSuccesses() {
		return setupSuccesses;
	}

	public void setSetupSuccesses(long setupSuccesses) {
		this.setupSuccesses = setupSuccesses;
	}
	
	public int getSetupSuccessRate() {
		Long pctLong = (100 * setupSuccesses) / setupAttempts;
		return pctLong.intValue();
	}
}
