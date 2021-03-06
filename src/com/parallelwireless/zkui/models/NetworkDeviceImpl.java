package com.parallelwireless.zkui.models;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import com.parallelwireless.zkui.models.inventory.SystemInventory;

public abstract class NetworkDeviceImpl implements NetworkDevice {
	final static Logger log = Logger.getLogger(NetworkDeviceImpl.class.getName());
	boolean up = true;
	TYPE type;
	ROLE role;
	NetworkDeviceInfo networkDeviceInfo = new NetworkDeviceInfo();
	SysInfo sysinfo = null;
	
	List<String> networkLinks = new LinkedList<String>();
	SystemInventory inventory;
	
	int bytes = 0;
	
	public abstract String getName();
	
	@Override
	public boolean isUp() {
		return up;
	}

	@Override
	public TYPE getType() {
		return type;
	}

	@Override 
	public ROLE getRole() {
		return role;
	}
	
	public void setRole(ROLE role) {
		this.role = role;
	}
	
	@Override
	public NetworkDeviceInfo getNetworkDeviceInfo() {
		return networkDeviceInfo;
	}

	@Override
	public SysInfo getSysInfo() {
		return sysinfo;
	}

	@Override
	public List<NetworkDeviceInterface> getNetworkInterfaces() {
		return networkDeviceInfo.getInterfaceList();
	}
	
	@Override
	public List<String> getNetworkLinks() {
		return networkLinks;
	}
	
	public void setNetworkLinks(List<String> networkLinks) {
		this.networkLinks = networkLinks;
	}
	
	public NetworkDeviceImpl addNetworkLinks(String... links) {
		for(String link : links) {
			networkLinks.add(link);
		}
		return this;
	}
	
	public static final Comparator<NetworkDevice> CPU =
			new Comparator<NetworkDevice>() {
			@Override
			public int compare(NetworkDevice n1, NetworkDevice n2) {
				Integer cpu1 = n1.getSysInfo().getCpu().getPercentCPUTotal();
				Integer cpu2 = n2.getSysInfo().getCpu().getPercentCPUTotal();
				return cpu2.compareTo(cpu1);
		}
	};
	
	public static final Comparator<NetworkDevice> MEM =
			new Comparator<NetworkDevice>() {
			@Override
			public int compare(NetworkDevice n1, NetworkDevice n2) {
				Integer m1 = n1.getSysInfo().getMem().getPercentUsed();
				Integer m2 = n2.getSysInfo().getMem().getPercentUsed();
				return m2.compareTo(m1);
			}
	};
	
	public static final Comparator<NetworkDevice> DISK =
			new Comparator<NetworkDevice>() {
			@Override
			public int compare(NetworkDevice n1, NetworkDevice n2) {
				Integer disk1 = n1.getSysInfo().getDisk().getPercentSpaceUsed();
				Integer disk2 = n2.getSysInfo().getDisk().getPercentSpaceUsed();
				return disk2.compareTo(disk1);
		}
	};
	
	public static final Comparator<NetworkDevice> NET =
			new Comparator<NetworkDevice>() {
		    @Override
		    public int compare(NetworkDevice n1, NetworkDevice n2) {
		    	Integer net1 = n1.getSysInfo().getNetwork().getAverageUtilization();
		    	Integer net2 = n2.getSysInfo().getNetwork().getAverageUtilization();
		    	return net2.compareTo(net1);
		    }
	};
	

	public SystemInventory getSystemInventory() {
		return inventory;
	}
	
	public void setSystemInventory(SystemInventory inventory) {
		this.inventory = inventory;
	}
	
	@Override
	public double getLat() {
		return getSysInfo().getGeo().getLat();
	}
	
	@Override
	public double getLng() {
		return getSysInfo().getGeo().getLng();
	}

}
