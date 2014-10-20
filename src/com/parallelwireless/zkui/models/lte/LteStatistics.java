package com.parallelwireless.zkui.models.lte;

public class LteStatistics {

	LteErabSetupSuccessRateAll setupSuccessRateTotal     = new LteErabSetupSuccessRateAll();
	LteErabSetupSuccessRateQCI setupSuccessRatePerQCI    = new LteErabSetupSuccessRateQCI();
	LteServiceDropRate serviceDropRate                   = new LteServiceDropRate();
	LteHandoverSuccess serviceHandoverSuccess            = new LteHandoverSuccess();
	LteServiceAverageThroughput serviceAverageThroughput = new LteServiceAverageThroughput();
	LteTrafficVolume serviceTrafficVolume                = new LteTrafficVolume();
	
	public LteStatistics() {
		
	}

	public LteErabSetupSuccessRateAll getSetupSuccessRateTotal() {
		return setupSuccessRateTotal;
	}

	public void setSetupSuccessRateTotal(
			LteErabSetupSuccessRateAll setupSuccessRateTotal) {
		this.setupSuccessRateTotal = setupSuccessRateTotal;
	}

	public LteErabSetupSuccessRateQCI getSetupSuccessRatePerQCI() {
		return setupSuccessRatePerQCI;
	}

	public void setSetupSuccessRatePerQCI(
			LteErabSetupSuccessRateQCI setupSuccessRatePerQCI) {
		this.setupSuccessRatePerQCI = setupSuccessRatePerQCI;
	}

	public LteServiceDropRate getServiceDropRate() {
		return serviceDropRate;
	}

	public void setServiceDropRate(LteServiceDropRate serviceDropRate) {
		this.serviceDropRate = serviceDropRate;
	}

	public LteHandoverSuccess getServiceHandoverSuccess() {
		return serviceHandoverSuccess;
	}

	public void setServiceHandoverSuccess(LteHandoverSuccess serviceHandoverSuccess) {
		this.serviceHandoverSuccess = serviceHandoverSuccess;
	}

	public LteServiceAverageThroughput getServiceAverageThroughput() {
		return serviceAverageThroughput;
	}

	public void setServiceAverageThroughput(
			LteServiceAverageThroughput serviceAverageThroughput) {
		this.serviceAverageThroughput = serviceAverageThroughput;
	}

	public LteTrafficVolume getServiceTrafficVolume() {
		return serviceTrafficVolume;
	}

	public void setServiceTrafficVolume(LteTrafficVolume serviceTrafficVolume) {
		this.serviceTrafficVolume = serviceTrafficVolume;
	}
	
	
}
