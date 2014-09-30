package com.parallelwireless.zkui.models;

public class CwsModel implements NetworkDevice {

	private static int globalCwsId = 1;
	
	public enum CWS_TYPE {
		Gateway,
		Mesh
	}
	
	int id;
	String name;
	int unicloudId;
	String ip;
	NetworkDevice.TYPE type;
	int lastSeenMinutes;
	
	public CwsModel(String name, int unicloudId, String ip, NetworkDevice.TYPE type, int lastSeenMinutes) {
		this.id = globalCwsId++;
		this.name = name;
		this.unicloudId = unicloudId;
		this.ip = ip;
		this.type = type;
		this.lastSeenMinutes = lastSeenMinutes;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnicloudId() {
		return unicloudId;
	}
	
	public void setUnicloudId(int unicloudId) {
		this.unicloudId = unicloudId;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setType(NetworkDevice.TYPE type) {
		this.type = type;
	}

	public int getLastSeenMinutes() {
		return lastSeenMinutes;
	}

	public void setLastSeenMinutes(int lastSeenMinutes) {
		this.lastSeenMinutes = lastSeenMinutes;
	}

	@Override
	public boolean isUp() {
		return lastSeenMinutes < 5 ? true : false;
	}

	@Override
	public TYPE getType() {
		return type;
	}

	@Override
	public int getCount() {
		return 1;
	}
	
	
}
