package com.parallelwireless.zkui.models;


import com.parallelwireless.zkui.models.NetworkDevice.DEV_TYPE;
import com.parallelwireless.zkui.models.NetworkDevice.ROLE;
import com.parallelwireless.zkui.models.NetworkDevice.STATUS;

public class NetworkDeviceStatusBucket {
	NetworkDevice.DEV_TYPE type;
	NetworkDevice.STATUS status;
	int count = 0;
	
   public NetworkDeviceStatusBucket(NetworkDevice.DEV_TYPE type, NetworkDevice.STATUS status, int count) {
		this.type = type;
		this.status = status;
		this.count = count;
	}
	
	public boolean isUp() {
		return (status == STATUS.up) ? true : false;
	}

	public DEV_TYPE getType() {
		return type;
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
