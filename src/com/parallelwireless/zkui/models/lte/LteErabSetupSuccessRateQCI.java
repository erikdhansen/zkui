package com.parallelwireless.zkui.models.lte;

public class LteErabSetupSuccessRateQCI {

	LteErabSetupSuccessRateAll[] qci = new LteErabSetupSuccessRateAll[9];
	
	public LteErabSetupSuccessRateQCI() {
		for(int i=0; i < 9; i++) {
			qci[0] = new LteErabSetupSuccessRateAll();
		}
	}

	public LteErabSetupSuccessRateAll[] getQci() {
		return qci;
	}

	public void setQci(LteErabSetupSuccessRateAll[] qci) {
		this.qci = qci;
	}
}
