package com.parallelwireless.zkui.models;

import java.util.Comparator;
import com.parallelwireless.zkui.models.inventory.SystemInventory;
import com.parallelwireless.zkui.models.lte.LteStatisticsImpl;
import com.parallelwireless.zkui.models.lte.QCI;
import com.parallelwireless.zkui.models.lte.Statistics;
import com.parallelwireless.zkui.models.resources.ResourceConfig;


public class CwsModel extends NetworkDeviceImpl {

	private static int globalCwsId = 1;
	
	public enum CWS_ROLE {
		Gateway,
		Mesh
	}
	
	int id;
	String name;
	int unicloudId;
	TYPE type;
	CWS_ROLE cwsRole;
	int lastSeenMinutes;
	String unicloudName = "";
		
	LteStatisticsImpl lteStats = null;
	
	public CwsModel(String name, int unicloudId, TYPE type, ROLE role) {
		this.id = globalCwsId++;
		this.name = name;
		this.unicloudId = unicloudId;
		this.type = type;
		this.sysinfo = new SysInfo(name, type, role);
		networkDeviceInfo.setInterfaceList(Unimanage.spoofNetworkInterfaces(NETIF_COUNT));		
		this.sysinfo.addResources(ResourceConfig.generate());
		lteStats = new LteStatisticsImpl(name);		
		lteStats.setQCI(QCI.generateRandomQCIs(UnimanageDataUtil.getUnicloud(unicloudId).getName()));
		lteStats.addStatistics(new Statistics());
		setSystemInventory(SystemInventory.generateSampleInventory(this));
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
	
	public void setCwsRole(CWS_ROLE cwsRole) {
		this.cwsRole = cwsRole;
	}
	
	public CWS_ROLE getCwsRole() {
		return cwsRole;
	}
	public void setType(TYPE type) {
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
