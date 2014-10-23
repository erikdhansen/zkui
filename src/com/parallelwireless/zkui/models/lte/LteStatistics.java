package com.parallelwireless.zkui.models.lte;

public interface LteStatistics {
	public enum STAT {
		LTE_ERAB_SSR_ATTEMPT_ALL("lteErabEstabAttemptAll"),
		LTE_ERAB_SSR_SUCCESS_ALL("lteErabEstabSuccessAll"),
		LTE_SERVICE_DROP_RATE_ABNORMAL("lteServiceDropRateAbnormal"),
		LTE_SERVICE_DROP_RATE_TOTAL("lteServiceDropRateTotal"),
		LTE_HANDOVER_ATTEMPTS_IN("lteHandoverAttemptsIn"),
		LTE_HANDOVER_SUCCESSES_IN("lteHandoverSuccessesIn"),
		LTE_HANDOVER_SUCCESSES_OUT("lteHandoverSuccessOut"),
		LTE_HANDOVER_ATTEMPTS_OUT("lteHandoverAttemptsOut"),
		LTE_SERVICE_AVG_THRU_DL_QCI_1("lteServiceAvgThroughputDLQCI1"),
		LTE_SERVICE_AVG_THRU_DL_QCI_2("lteServiceAvgThroughputDLQCI2"),
		LTE_SERVICE_AVG_THRU_DL_QCI_3("lteServiceAvgThroughputDLQCI3"),
		LTE_SERVICE_AVG_THRU_DL_QCI_4("lteServiceAvgThroughputDLQCI4"),
		LTE_SERVICE_AVG_THRU_DL_QCI_5("lteServiceAvgThroughputDLQCI5"),
		LTE_SERVICE_AVG_THRU_DL_QCI_6("lteServiceAvgThroughputDLQCI6"),
		LTE_SERVICE_AVG_THRU_DL_QCI_7("lteServiceAvgThroughputDLQCI7"),
		LTE_SERVICE_AVG_THRU_DL_QCI_8("lteServiceAvgThroughputDLQCI8"),
		LTE_SERVICE_AVG_THRU_DL_QCI_9("lteServiceAvgThroughputDLQCI9"),
		LTE_SERVICE_AVG_THRU_UL_QCI_1("lteServiceAvgThroughputULQCI1"),
		LTE_SERVICE_AVG_THRU_UL_QCI_2("lteServiceAvgThroughputULQCI2"),
		LTE_SERVICE_AVG_THRU_UL_QCI_3("lteServiceAvgThroughputULQCI3"),
		LTE_SERVICE_AVG_THRU_UL_QCI_4("lteServiceAvgThroughputULQCI4"),
		LTE_SERVICE_AVG_THRU_UL_QCI_5("lteServiceAvgThroughpuyULQCI5"),
		LTE_SERVICE_AVG_THRU_UL_QCI_6("lteServiceAvgThroughputULQCI6"),
		LTE_SERVICE_AVG_THRU_UL_QCI_7("lteServiceAvgThroughputDLQCI7"),
		LTE_SERVICE_AVG_THRU_UL_QCI_8("lteServiceAvgThroughputDLQCI8"),
		LTE_SERVICE_AVG_THRU_UL_QCI_9("lteServiceAvgThroughputDLQCI9"),
		LTE_SERVICE_TRAFFIC_VOL_UL_QCI_1("lteServiceTrafficVolumeULQCI1"),
		LTE_SERVICE_TRAFFIC_VOL_UL_QCI_2("lteServiceTrafficVolumeULQCI2"),
		LTE_SERVICE_TRAFFIC_VOL_UL_QCI_3("lteServiceTrafficVolumeULQCI3"),
		LTE_SERVICE_TRAFFIC_VOL_UL_QCI_4("lteServiceTrafficVolumeULQCI4"),
		LTE_SERVICE_TRAFFIC_VOL_UL_QCI_5("lteServiceTrafficVolumeULQCI5"),
		LTE_SERVICE_TRAFFIC_VOL_UL_QCI_6("lteServiceTrafficVolumeULQCI6"),
		LTE_SERVICE_TRAFFIC_VOL_UL_QCI_7("lteServiceTrafficVolumeULQCI7"),
		LTE_SERVICE_TRAFFIC_VOL_UL_QCI_8("lteServiceTrafficVolumeULQCI8"),
		LTE_SERVICE_TRAFFIC_VOL_UL_QCI_9("lteServiceTrafficVolumeULQCI9"),
		LTE_SERVICE_TRAFFIC_VOL_DL_QCI_1("lteServiceTrafficVolumeDLQCI1"),
		LTE_SERVICE_TRAFFIC_VOL_DL_QCI_2("lteServiceTrafficVolumeDLQCI2"),
		LTE_SERVICE_TRAFFIC_VOL_DL_QCI_3("lteServiceTrafficVolumeDLQCI3"),
		LTE_SERVICE_TRAFFIC_VOL_DL_QCI_4("lteServiceTrafficVolumeDLQCI4"),
		LTE_SERVICE_TRAFFIC_VOL_DL_QCI_5("lteServiceTrafficVolumeDLQCI5"),
		LTE_SERVICE_TRAFFIC_VOL_DL_QCI_6("lteServiceTrafficVolumeDLQCI6"),
		LTE_SERVICE_TRAFFIC_VOL_DL_QCI_7("lteServiceTrafficVolumeDLQCI7"),
		LTE_SERVICE_TRAFFIC_VOL_DL_QCI_8("lteServiceTrafficVolumeDLQCI8"),
		LTE_SERVICE_TRAFFIC_VOL_DL_QCI_9("lteServiceTrafficVolumeDLQCI9"),
		LTE_SERVICE_AVG_THRU_DL("lteServiceAverageThroughputDL"),
		LTE_SERVICE_AVG_THRU_UL("lteServiceAverageThroughputUL"),
		LTE_SERVICE_TRAFFIC_DL("lteServiceTrafficVolumeDownlink"),
		LTE_SERVICE_TRAFFIC_UL("lteServiceTrafficVolumeUplink");

			private final String statistic;
			private STAT(String s) {
				statistic = s;
			}
			public boolean isStatistic(String otherStatistic) {
				return (otherStatistic == null) ? false : statistic.equals(otherStatistic);
			}
			
			public String toString() {
				return statistic;
			}
	};

	public String getSystemName();
	public void addStatistics(Statistics statistics) throws Exception;
}
