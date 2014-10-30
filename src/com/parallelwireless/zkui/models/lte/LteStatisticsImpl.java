package com.parallelwireless.zkui.models.lte;

public class LteStatisticsImpl implements LteStatistics {

	LteErabSetupSuccessRateAll setupSuccessRateTotal     = new LteErabSetupSuccessRateAll();
	LteErabSetupSuccessRateQCI setupSuccessRatePerQCI    = new LteErabSetupSuccessRateQCI();
	LteServiceDropRate serviceDropRate                   = new LteServiceDropRate();
	LteHandoverSuccess serviceHandoverInbound            = new LteHandoverSuccess(true);
	LteHandoverSuccess serviceHandoverOutbound           = new LteHandoverSuccess(false);
	LteServiceTrafficStats serviceTrafficStats           = new LteServiceTrafficStats();
	LteTrafficVolume serviceTrafficVolume                = new LteTrafficVolume();

	QCI[] qcis = new QCI[9];
	
	final static String QCI_ROOT_ATTEMPT       = "LTE_ERAB_EST_ATTEMPT_QCI_";
    final static String QCI_ROOT_SUCCESS       = "LTE_ERAB_SUCCESS_ATTMEPT_QCI_";
    final static String QCI_AVG_THRU_DL_QCI    = "LTE_SERVICE_AVG_THRU_DL_QCI_";
    final static String QCI_AVG_THRU_UL_QCI    = "LTE_SERVICE_AVG_THRU_UL_QCI_";
    final static String QCI_TRAFFIC_VOL_DL_QCI = "LTE_DL_TRAFFIC_VOLUME_QCI_";
    final static String QCI_TRAFFIC_VOL_UL_QCI = "LTE_UL_TRAFFIC_VOLUME_QCI_";
    
	int CRITICAL;
	int MAJOR;
	int MINOR;

	String systemName;
	
	public LteStatisticsImpl(String systemName) {
		this.systemName = systemName;
	}

	public void addStatistics(Statistics statistics) {
		// LteServiceDropRate
		serviceDropRate.setAbnormalReleases(Long.parseLong(statistics.get(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL)));
		serviceDropRate.setTotalReleases(Long.parseLong(statistics.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)));
		serviceHandoverInbound.setAttempt(Long.parseLong(statistics.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)));
		serviceHandoverInbound.setSuccess(Long.parseLong(statistics.get(STAT.LTE_HANDOVER_SUCCESSES_IN)));
		serviceHandoverOutbound.setAttempt(Long.parseLong(statistics.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)));
		serviceHandoverOutbound.setSuccess(Long.parseLong(statistics.get(STAT.LTE_HANDOVER_SUCCESSES_OUT)));
		setupSuccessRateTotal.setSetupAttempts(Long.parseLong(statistics.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)));
		setupSuccessRateTotal.setSetupSuccesses(Long.parseLong(statistics.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)));
		for(int i=0; i < 9; i++) {
			qcis[i].setSystemName(systemName);
		}
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

	public LteHandoverSuccess getServiceHandoverInbound() {
		return serviceHandoverInbound;
	}

	public void setServiceHandoverInbound(LteHandoverSuccess serviceHandoverInbound) {
		this.serviceHandoverInbound = serviceHandoverInbound;
	}

	public LteHandoverSuccess getServiceHandoverOutbound() {
		return serviceHandoverOutbound;
	}

	public void setServiceHandoverOutbound(LteHandoverSuccess serviceHandoverOutbound) {
		this.serviceHandoverOutbound = serviceHandoverOutbound;
	}

	public LteServiceTrafficStats getServiceTrafficStats() {
		return serviceTrafficStats;
	}
	
	public void setQCI(QCI[] qcis) {
		this.qcis = qcis;
		this.serviceTrafficStats.setQCI(qcis);
	}
	
	public QCI[] getQCI() {
		return qcis;
	}
	
	@Override
	public String getSystemName() {
		return systemName;
	}
	
}
