package com.parallelwireless.zkui.models;


import java.util.List;

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
	
	public String getName();
	public boolean isUp();
	public TYPE getType();
	public List<NetworkDeviceInterface> getNetworkInterfaces();
	public SysInfo getSysInfo();
	public NetworkDeviceInfo getNetworkDeviceInfo();
	public List<String> getNetworkLinks();
}
