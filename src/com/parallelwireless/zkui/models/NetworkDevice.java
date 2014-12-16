package com.parallelwireless.zkui.models;


import java.util.List;

import com.parallelwireless.zkui.models.inventory.SystemInventory;

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
	
	public static enum TYPE {
		LAC,
		LAC_HA,
		CWS_100,
		CWS_200,
		CWS_300
	};
	public enum STATUS {
		up,
		down
	}
	

	
	public String getName();
	public boolean isUp();
	public TYPE getType();
	public ROLE getRole();
	public List<NetworkDeviceInterface> getNetworkInterfaces();
	public SysInfo getSysInfo();
	public NetworkDeviceInfo getNetworkDeviceInfo();
	public List<String> getNetworkLinks();
	public double getLat();
	public double getLng();
	public SystemInventory getSystemInventory();
	public void setSystemInventory(SystemInventory systemInventory);
}

