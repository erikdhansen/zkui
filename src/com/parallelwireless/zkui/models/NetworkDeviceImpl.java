package com.parallelwireless.zkui.models;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.parallelwireless.zkui.models.resources.CpuResource;
import com.parallelwireless.zkui.models.resources.DiskResource;

public abstract class NetworkDeviceImpl implements NetworkDevice {

	boolean up = true;
	NetworkDevice.TYPE type;
	List<NetworkDeviceInterface> networkDeviceInterfaces = new LinkedList<NetworkDeviceInterface>();
	NetworkDeviceInfo networkDeviceInfo = new NetworkDeviceInfo();
	SysInfo sysinfo = null;
	List<String> networkLinks = new LinkedList<String>();
	
	int bytes = 0;
	
	@Override
	public boolean isUp() {
		return up;
	}

	@Override
	public TYPE getType() {
		return type;
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
		return networkDeviceInterfaces;
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
}
