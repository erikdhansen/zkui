package com.parallelwireless.zkui.models;


import com.parallelwireless.zkui.models.NetworkDevice.ROLE;
import com.parallelwireless.zkui.models.NetworkDevice.STATUS;

public class NetworkDeviceStatusBucket {
	NetworkDevice.ROLE role;
	NetworkDevice.STATUS status;
	int count = 0;
	
   public NetworkDeviceStatusBucket(NetworkDevice.ROLE role, NetworkDevice.STATUS status, int count) {
		this.role = role;
		this.status = status;
		this.count = count;
	}
	
	public boolean isUp() {
		return (status == STATUS.up) ? true : false;
	}

	public ROLE getRole() {
		return role;
	}
	
	public int getCount() {
		return count;
	}
	
	public static String getLabel(ROLE role) {
		switch(role){
		case LAC:
			return "LAC";
		case CWS_MESH:
			return "CWS (Mesh)";
		case CWS_GW:
			return "CWS (GW)";
		default:
			return "Unknown Type: " + role;
		}
	}
}
