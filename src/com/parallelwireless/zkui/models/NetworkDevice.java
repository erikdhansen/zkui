package com.parallelwireless.zkui.models;


import java.util.List;

import com.parallelwireless.zkui.models.inventory.SystemInventory;
import com.parallelwireless.zkui.models.resources.GeoLocation.DEV_TYPE;

public interface NetworkDevice {
	public static int NETIF_COUNT = 4;
	
	public enum ROLE {
		LAC("LAC"),
		CWS_MESH("CWS (mesh)"),
		CWS_GW("CWS (gw)");
		
		private String role;
		private ROLE(String role) {
			this.role = role;
		}
		public String getRole() {
			return role;
		}
	}

	public enum STATUS {
		up,
		down
	}
	
	public static enum DEV_TYPE {
		LAC,
		LAC_HA,
		CWS_100,
		CWS_200,
		CWS_300
	};
	
	public String getName();
	public boolean isUp();
	public DEV_TYPE getType();
	public List<NetworkDeviceInterface> getNetworkInterfaces();
	public SysInfo getSysInfo();
	public NetworkDeviceInfo getNetworkDeviceInfo();
	public List<String> getNetworkLinks();
	public double getLat();
	public double getLng();
	public SystemInventory getSystemInventory();
	public void setSystemInventory(SystemInventory systemInventory);
}

