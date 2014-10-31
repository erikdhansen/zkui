package com.parallelwireless.zkui.models;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.parallelwireless.zkui.models.lte.LteErabSetupSuccessRateAll;
import com.parallelwireless.zkui.models.lte.LteStatisticsImpl;
import com.parallelwireless.zkui.models.lte.QCI;
import com.parallelwireless.zkui.models.lte.Statistics;
import com.parallelwireless.zkui.models.resources.ResourceConfig;


public class CwsModel extends NetworkDeviceImpl {

	private static int globalCwsId = 1;
	
	public enum CWS_TYPE {
		Gateway,
		Mesh
	}
	
	int id;
	String name;
	int unicloudId;
	NetworkDevice.TYPE type;
	int lastSeenMinutes;
	String unicloudName = "";
	
	List<NetworkDeviceInterface> networkDeviceInterfaces = new LinkedList<NetworkDeviceInterface>();
	LteStatisticsImpl lteStats = null;
	
	public CwsModel(String name, int unicloudId, String ip, NetworkDevice.TYPE type) {
		this.id = globalCwsId++;
		this.name = name;
		this.unicloudId = unicloudId;
		this.type = type;
		this.sysinfo = new SysInfo(name);
		this.sysinfo.addResources(ResourceConfig.generate());
		lteStats = new LteStatisticsImpl(name);		
		lteStats.setQCI(QCI.generateRandomQCIs());
		lteStats.addStatistics(new Statistics());		
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnicloudId() {
		return unicloudId;
	}
	
	public void setUnicloudId(int unicloudId) {
		this.unicloudId = unicloudId;
	}
	
	public void setType(NetworkDevice.TYPE type) {
		this.type = type;
	}

	public int getLastSeenMinutes() {
		return lastSeenMinutes;
	}
	// TODO Auto-generated method stub

	public void setLastSeenMinutes(int lastSeenMinutes) {
		this.lastSeenMinutes = lastSeenMinutes;
	}

	@Override
	public boolean isUp() {
		return lastSeenMinutes < 5 ? true : false;
	}

	public void setUnicloud(String unicloudName) {
		this.unicloudName = unicloudName;
	}
	
	public String getUnicloud() {
		return unicloudName;
	}
	
	@Override
	public TYPE getType() {
		return type;
	}
	
	public SysInfo refreshSysInfo() {
		return sysinfo;
	}
	
	public List<NetworkDeviceInterface> refreshNetworkDeviceInterfaces() {
		networkDeviceInterfaces = UnimanageDataUtil.fudgeNetworkDeviceInterfaces(getType());
		return networkDeviceInterfaces;
	}
	
	public List<NetworkDeviceInterface> getNetworkInterfaces() {
		return networkDeviceInterfaces;
	}
	
	public LteStatisticsImpl getLteStats() {
		return lteStats;
	}
	
	public void setLteStats(LteStatisticsImpl lteStats) {
		this.lteStats = lteStats;
	}
	public static final Comparator<NetworkDevice> DISK =
			new Comparator<NetworkDevice>() {
			@Override
			public int compare(NetworkDevice n1, NetworkDevice n2) {
				Integer disk1 = n1.getSysInfo().getDisk().getPercentSpaceUsed();
				Integer disk2 = n2.getSysInfo().getDisk().getPercentSpaceUsed();
				return disk2.compareTo(disk1);
		}
	};
	
	public final static Comparator<CwsModel> LTE_SETUP_SUCCESS_RATE =  
			new Comparator<CwsModel>() {
			@Override
			public int compare(CwsModel c1, CwsModel c2) {
				Integer s1 = c1.getLteStats().getSetupSuccessRateTotal().getSetupSuccessRate();
				Integer s2 = c2.getLteStats().getSetupSuccessRateTotal().getSetupSuccessRate();
				return s2.compareTo(s1);
		}
	};
	
	public final static Comparator<CwsModel> LTE_SERVICE_DROP_RATE = 
			new Comparator<CwsModel>() {

		    @Override
		    public int compare(CwsModel c1, CwsModel c2) {
		    	Integer s1 = c1.getLteStats().getServiceDropRate().getAbnormalDropRate();
		    	Integer s2 = c2.getLteStats().getServiceDropRate().getAbnormalDropRate();
		    	return s2.compareTo(s1);
		    }
	};
	
	public final static Comparator<CwsModel> LTE_HANDOVER_SUCCESS_RATE_IN = 
			new Comparator<CwsModel>() {
		    @Override
		    public int compare(CwsModel c1, CwsModel c2) {
		    	Integer s1 = new Long((100 * c1.getLteStats().getServiceHandoverInbound().getHandoverFailureRate())).intValue();
		    	Integer s2 = new Long((100 * c2.getLteStats().getServiceHandoverInbound().getHandoverFailureRate())).intValue();
		    	return s2.compareTo(s1);
		    }
	};

	public final static Comparator<CwsModel> LTE_HANDOVER_SUCCESS_RATE_OUT = 
			new Comparator<CwsModel>() {
		    @Override
		    public int compare(CwsModel c1, CwsModel c2) {
		    	Integer s1 = c1.getLteStats().getServiceHandoverOutbound().getHandoverFailureRate();
		    	Integer s2 = c2.getLteStats().getServiceHandoverOutbound().getHandoverFailureRate();
		    	return s2.compareTo(s1);
		    }
	};

	public final static Comparator<CwsModel> LTE_AVG_THROUGHPUT_UL = 
			new Comparator<CwsModel>() {
		    @Override
		    public int compare(CwsModel c1, CwsModel c2) {
		    	Long s1 = c1.getLteStats().getServiceTrafficStats().getTotalThroughputUL();
		    	Long s2 = c2.getLteStats().getServiceTrafficStats().getTotalThroughputUL();
		    	return s2.compareTo(s1);
		    }
	};

	public final static Comparator<CwsModel> LTE_AVG_THROUGHPUT_DL = 
			new Comparator<CwsModel>() {
		    @Override
		    public int compare(CwsModel c1, CwsModel c2) {
		    	Long s1 = c1.getLteStats().getServiceTrafficStats().getTotalThroughputDL();
		    	Long s2 = c2.getLteStats().getServiceTrafficStats().getTotalThroughputDL();
		    	return s2.compareTo(s1);
		    }
	};


	public final static Comparator<CwsModel> LTE_TRAFFIC_VOLUME_UL = 
			new Comparator<CwsModel>() {
		    @Override
		    public int compare(CwsModel c1, CwsModel c2) {
		    	Long s1 = c1.getLteStats().getServiceTrafficStats().getTotalTrafficVolumeUL();
		    	Long s2 = c2.getLteStats().getServiceTrafficStats().getTotalTrafficVolumeUL();
		    	return s2.compareTo(s1);
		    }
	};
	
	public final static Comparator<CwsModel> LTE_TRAFFIC_VOLUME_DL = 
			new Comparator<CwsModel>() {
		    @Override
		    public int compare(CwsModel c1, CwsModel c2) {
		    	Long s1 = c1.getLteStats().getServiceTrafficStats().getTotalTrafficVolumeDL();
		    	Long s2 = c2.getLteStats().getServiceTrafficStats().getTotalTrafficVolumeDL();
		    	return s2.compareTo(s1);
		    }
	};

}
