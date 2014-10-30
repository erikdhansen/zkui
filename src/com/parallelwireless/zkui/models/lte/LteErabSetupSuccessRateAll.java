package com.parallelwireless.zkui.models.lte;

public class LteErabSetupSuccessRateAll extends AbstractLteStatisticType {
	long setupAttempts  = 0;
	long setupSuccesses = 0;
	
	public LteErabSetupSuccessRateAll() {
		CRITICAL = 50;
		MAJOR    = 30;
		MINOR    = 15;
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
	
	public long getSetupFailures() {
		return setupAttempts - setupSuccesses;
	}
	
	public int getSetupSuccessRate() {
		long dividend = (setupAttempts == 0) ? 1 : setupAttempts;
		return new Long((100 * setupSuccesses) / dividend).intValue();
	}
	
	public int getSetupFailureRate() {
		long dividend = (setupAttempts == 0) ? 1 : setupAttempts;
		return new Long(100 * getSetupFailures()/dividend).intValue();
	}

	@Override
	public int getMonitoredValue() {
		return getSetupFailureRate();
	}
}
