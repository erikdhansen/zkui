package com.parallelwireless.zkui.models;


import java.util.List;

import com.parallelwireless.zkui.models.inventory.SystemInventory;

public interface NetworkDevice {
	public static int NETIF_COUNT = 4;
	
	public enum TYPE {
		LAC("LAC"),
		CWS_MESH("CWS (mesh)"),
		CWS_GW("CWS (gw)");
		
		private String type;
		private TYPE(String type) {
			this.type = type;
		}
		public String getType() {
			return type;
		}
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
	public double getLat();
	public double getLng();
	public SystemInventory getSystemInventory();
	public void setSystemInventory(SystemInventory systemInventory);
}

