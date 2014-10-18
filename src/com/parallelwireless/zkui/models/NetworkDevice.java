package com.parallelwireless.zkui.models;


import java.util.Comparator;
import java.util.List;

import com.parallelwireless.zkui.models.resources.ResourceConfig;

public interface NetworkDevice {
	public enum TYPE {
		unicloud,
		cws_mesh,
		cws_gw
	}

	public enum STATUS {
		up,
		down
	}
	
	public boolean isUp();
	public TYPE getType();
	public List<NetworkDeviceInterface> getNetworkInterfaces();
	public SysInfo getSysInfo();
	public NetworkDeviceInfo getNetworkDeviceInfo();
}
