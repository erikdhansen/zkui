package com.parallelwireless.zkui.models;

public class NetworkDeviceStatImpl implements NetworkDevice {
	NetworkDevice.TYPE type;
	NetworkDevice.STATUS status;
	int count = 0;
	
	public NetworkDeviceStatImpl(NetworkDevice.TYPE type, NetworkDevice.STATUS status, int count) {
		this.type = type;
		this.status = status;
		this.count = count;
	}
	
	@Override
	public boolean isUp() {
		return (status == STATUS.up) ? true : false;
	}

	@Override
	public TYPE getType() {
		return type;
	}
	
	@Override
	public int getCount() {
		return count;
	}
}
