package com.parallelwireless.zkui.models;


import com.parallelwireless.zkui.models.NetworkDevice.STATUS;
import com.parallelwireless.zkui.models.NetworkDevice.TYPE;

public class NetworkDeviceStatusBucket {
	NetworkDevice.TYPE type;
	NetworkDevice.STATUS status;
	int count = 0;
	
   public NetworkDeviceStatusBucket(NetworkDevice.TYPE type, NetworkDevice.STATUS status, int count) {
		this.type = type;
		this.status = status;
		this.count = count;
	}
	
	public boolean isUp() {
		return (status == STATUS.up) ? true : false;
	}

	public TYPE getType() {
		return type;
	}
	
	public int getCount() {
		return count;
	}
	
	public static String getLabel(TYPE type) {
		switch(type){
		case unicloud:
			return "Uni-Cloud";
		case cws_mesh:
			return "CWS (Mesh)";
		case cws_gw:
			return "CWS (GW)";
		default:
			return "Unknown Type: " + type;
		}
	}
}
