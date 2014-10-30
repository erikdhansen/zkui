package com.parallelwireless.zkui.models.lte;

public class LteHandoverSuccess extends AbstractLteStatisticType {
	long attempt  = 0;
	long success  = 0;
	boolean inbound = false;
		
	public LteHandoverSuccess(boolean inbound) {
		CRITICAL = 50;
		MAJOR    = 30;
		MINOR    = 15;		
	}

	public long getAttempt() {
		return attempt;
	}

	public void setAttempt(long attempt) {
		this.attempt = attempt;
	}

	public long getSuccess() {
		return success;
	}

	public void setSuccess(long success) {
		this.success = success;
	}

	public long getFailures() {
		return this.attempt - this.success;
	}
		
	public int getHandoverFailureRate() {
		long dividend = (getAttempt() == 0) ? 1 : getAttempt();
		return new Long((100 * getFailures())/dividend).intValue();
	}
	
	@Override
	public int getMonitoredValue() {
		return getHandoverFailureRate();
	}
}
