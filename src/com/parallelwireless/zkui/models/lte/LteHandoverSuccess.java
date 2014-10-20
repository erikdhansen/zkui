package com.parallelwireless.zkui.models.lte;

public class LteHandoverSuccess {
	long inAttempt  = 0;
	long inSuccess  = 0;
	long outAttempt = 0;
	long outSuccess = 0;
	
	public LteHandoverSuccess() {
		
	}
	
	public LteHandoverSuccess(long inAttempt, long inSuccess, long outAttempt, long outSuccess) {
		this.inAttempt = inAttempt;
		this.inSuccess = inSuccess;
		this.outAttempt = outAttempt;
		this.outSuccess = outSuccess;
	}

	public long getInAttempt() {
		return inAttempt;
	}

	public void setInAttempt(long inAttempt) {
		this.inAttempt = inAttempt;
	}

	public long getInSuccess() {
		return inSuccess;
	}

	public void setInSuccess(long inSuccess) {
		this.inSuccess = inSuccess;
	}

	public long getOutAttempt() {
		return outAttempt;
	}

	public void setOutAttempt(long outAttempt) {
		this.outAttempt = outAttempt;
	}

	public long getOutSuccess() {
		return outSuccess;
	}

	public void setOutSuccess(long outSuccess) {
		this.outSuccess = outSuccess;
	}
	
	
}