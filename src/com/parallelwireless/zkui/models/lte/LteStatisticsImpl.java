package com.parallelwireless.zkui.models.lte;

public class LteStatisticsImpl implements LteStatistics {

	LteErabSetupSuccessRateAll setupSuccessRateTotal     = new LteErabSetupSuccessRateAll();
	LteErabSetupSuccessRateQCI setupSuccessRatePerQCI    = new LteErabSetupSuccessRateQCI();
	LteServiceDropRate serviceDropRate                   = new LteServiceDropRate();
	LteHandoverSuccess serviceHandoverSuccess            = new LteHandoverSuccess();
	LteServiceAverageThroughput serviceAverageThroughput = new LteServiceAverageThroughput();
	LteTrafficVolume serviceTrafficVolume                = new LteTrafficVolume();

	final static String QCI_ROOT_ATTEMPT       = "LTE_ERAB_EST_ATTEMPT_QCI_";
    final static String QCI_ROOT_SUCCESS       = "LTE_ERAB_SUCCESS_ATTMEPT_QCI_";
    final static String QCI_AVG_THRU_DL_QCI    = "LTE_SERVICE_AVG_THRU_DL_QCI_";
    final static String QCI_AVG_THRU_UL_QCI    = "LTE_SERVICE_AVG_THRU_UL_QCI_";
    final static String QCI_TRAFFIC_VOL_DL_QCI = "LTE_DL_TRAFFIC_VOLUME_QCI_";
    final static String QCI_TRAFFIC_VOL_UL_QCI = "LTE_UL_TRAFFIC_VOLUME_QCI_";
    
	String systemName;
	
	public LteStatisticsImpl(String systemName) {
		this.systemName = systemName;
	}

	public void addStatistics(Statistics statistics) {
		// LteServiceDropRate
		serviceDropRate.setAbnormalReleases(Long.parseLong(statistics.get(STAT.LTE_SERVICE_DROP_RATE_ABNORMAL)));
		serviceDropRate.setTotalReleases(Long.parseLong(statistics.get(STAT.LTE_SERVICE_DROP_RATE_TOTAL)));
		serviceHandoverSuccess.setInAttempt(Long.parseLong(statistics.get(STAT.LTE_HANDOVER_ATTEMPTS_IN)));
		serviceHandoverSuccess.setInSuccess(Long.parseLong(statistics.get(STAT.LTE_HANDOVER_SUCCESSES_IN)));
		serviceHandoverSuccess.setOutAttempt(Long.parseLong(statistics.get(STAT.LTE_HANDOVER_ATTEMPTS_OUT)));
		serviceHandoverSuccess.setOutSuccess(Long.parseLong(statistics.get(STAT.LTE_HANDOVER_SUCCESSES_OUT)));
		setupSuccessRateTotal.setSetupAttempts(Long.parseLong(statistics.get(STAT.LTE_ERAB_SSR_ATTEMPT_ALL)));
		setupSuccessRateTotal.setSetupSuccesses(Long.parseLong(statistics.get(STAT.LTE_ERAB_SSR_SUCCESS_ALL)));
		//parseAllTrafficVolumeQCI(statistics);
		//parseAllAverageThroughputQCI(statistics);
	}

	public void parseAllAverageThroughputQCI(Statistics statistics) {
		long[] qciDL = serviceAverageThroughput.getQciAverageDL();
		long[] qciUL = serviceAverageThroughput.getQciAverageUL();
		for(int i=0; i < 9; i++) {
			String key  = QCI_AVG_THRU_DL_QCI + (i+1);
			String key2 = QCI_AVG_THRU_UL_QCI + (i+1);
			qciDL[i] = Long.parseLong(statistics.get(key));
			qciUL[i] = Long.parseLong(statistics.get(key2));
		}
	}
	
	public void parseAllTrafficVolumeQCI(Statistics statistics) {
		long[] qciDL = serviceTrafficVolume.getQciTrafficDL();
		long[] qciUL = serviceTrafficVolume.getQciTrafficUL();
		for(int i=0; i < 9; i++) {
			String key  = QCI_TRAFFIC_VOL_DL_QCI + (i+1);
			String key2 = QCI_TRAFFIC_VOL_UL_QCI + (i+1);
			qciDL[i] = Long.parseLong(statistics.get(key));
			qciUL[i] = Long.parseLong(statistics.get(key2));
		}
	}
	
	public void parseAllSetupStatsQCIs(Statistics statistics) {
		LteErabSetupSuccessRateAll[] qci = setupSuccessRatePerQCI.qci;
		long totalAttempts  = 0;
		long totalSuccesses = 0;
		for(int i=0; i < 9; i++) {
			STAT stat = STAT.valueOf(QCI_ROOT_ATTEMPT + String.valueOf(i+1));
			LteErabSetupSuccessRateAll ssra = qci[i];
			System.out.println("statistics.get(stat) == " + statistics + " stat: " + stat.name());
			ssra.setSetupAttempts(Long.parseLong(statistics.get(stat)));
			totalAttempts += ssra.getSetupAttempts();
			stat = STAT.valueOf(QCI_ROOT_SUCCESS + String.valueOf(i));
			ssra.setSetupSuccesses(Long.parseLong(statistics.get(stat)));
			totalSuccesses += ssra.getSetupSuccesses();
			System.out.println("qci[" + i + "] = attempts=" + ssra.getSetupAttempts() + " success=" + ssra.getSetupSuccesses());
		}
		setupSuccessRateTotal.setSetupAttempts(totalAttempts);
		setupSuccessRateTotal.setSetupSuccesses(totalSuccesses);
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

	@Override
	public String getSystemName() {
		return systemName;
	}
	
}
