package com.parallelwireless.zkui.models;

import java.util.LinkedList;
import java.util.List;


public class CwsModel extends NetworkDeviceImpl {

	private static int globalCwsId = 1;
	
	public enum CWS_TYPE {
		Gateway,
		Mesh
	}
	
	int id;
	String name;
	int unicloudId;
	NetworkDevice.TYPE type;
	int lastSeenMinutes;

	List<NetworkDeviceInterface> networkDeviceInterfaces = new LinkedList<NetworkDeviceInterface>();
	
	public CwsModel(String name, int unicloudId, String ip, NetworkDevice.TYPE type, int lastSeenMinutes) {
		this.id = globalCwsId++;
		this.name = name;
		this.unicloudId = unicloudId;
		this.type = type;
		this.lastSeenMinutes = lastSeenMinutes;
		refreshSysInfo();
		refreshNetworkDeviceInterfaces();
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
	
	public SysInfo refreshSysInfo() {
		return sysinfo;
	}
	
	public List<NetworkDeviceInterface> refreshNetworkDeviceInterfaces() {
		networkDeviceInterfaces = UnimanageDataUtil.fudgeNetworkDeviceInterfaces(getType());
		return networkDeviceInterfaces;
	}
	
	public List<NetworkDeviceInterface> getNetworkInterfaces() {
		return networkDeviceInterfaces;
	}
}
