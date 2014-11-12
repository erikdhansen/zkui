package com.parallelwireless.zkui.models;

import java.util.LinkedList;
import java.util.List;

public class UnicloudModel extends NetworkDeviceImpl {
	int id;
	String name;
	int lastSeenMinutes = 0;
	
	NetworkDevice.TYPE type = NetworkDevice.TYPE.unicloud;
	
	List<CwsModel> cwsList = new LinkedList<CwsModel>();
	
	public UnicloudModel(int id, String name, String ip) {
		this.id = id;
		this.name = name;
		this.sysinfo = new SysInfo(name);
		refreshSysInfo();
		refreshNetworkInterfaces(); 
	}
		
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLastSeenMinutes() {
		return lastSeenMinutes;
	}
	
	public List<CwsModel> getCwsList() {
		return cwsList;
	}

	public void addCws(CwsModel cws) {
		cws.setUnicloud(this.name);
		this.cwsList.add(cws);
	}
	
	public String getStatusColor() {
		String c = "#ccffcc";
		if(lastSeenMinutes > 5) {
			c = "#fdffca";
		}
		if(lastSeenMinutes > 30) {
			c = "#ffa5866";
		}
		if(lastSeenMinutes > 60) {
			c = "#ff8888";
		}
		return c;
	}

	@Override
	public boolean isUp() {
		return (lastSeenMinutes < 5) ? true : false;
	}

	@Override
	public TYPE getType() {
		return type;
	}
	
	public List<CwsModel> getMeshCws() {
		List<CwsModel> mesh = new LinkedList<CwsModel>();
		for(CwsModel cws : cwsList) {
			if(cws.getType() == NetworkDevice.TYPE.cws_mesh) {
				mesh.add(cws);
			}
		}
		return mesh;
	}
	
	public int getMeshCount() {
		return getMeshCws().size();
	}
	
	public List<CwsModel> getGwCws() {
		List<CwsModel> gws = new LinkedList<CwsModel>();
		for(CwsModel cws : cwsList) {
			if(cws.getType() == NetworkDevice.TYPE.cws_gw) {
				gws.add(cws);
			}
		}
		return gws;
	}
	
	public int getGwCount() {
		return getGwCws().size();
	}
	
	public SysInfo refreshSysInfo() {
		return sysinfo;
	}
	
	public List<NetworkDeviceInterface> refreshNetworkInterfaces() {
		networkDeviceInterfaces = UnimanageDataUtil.fudgeNetworkDeviceInterfaces(NetworkDevice.TYPE.unicloud);
		return networkDeviceInterfaces;
	}
	
}
