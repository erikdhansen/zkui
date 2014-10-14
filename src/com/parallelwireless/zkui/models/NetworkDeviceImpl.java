package com.parallelwireless.zkui.models;

import java.util.LinkedList;
import java.util.List;

public abstract class NetworkDeviceImpl implements NetworkDevice {

	boolean up = true;
	NetworkDevice.TYPE type;
	List<NetworkDeviceInterface> networkDeviceInterfaces = new LinkedList<NetworkDeviceInterface>();
	NetworkDeviceInfo networkDeviceInfo = new NetworkDeviceInfo();
	SysInfo sysinfo = new SysInfo();
	
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

}
