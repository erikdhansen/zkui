package com.parallelwireless.zkui.models;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.parallelwireless.zkui.models.inventory.SystemInventory;

public class UnicloudModel extends NetworkDeviceImpl {
	final static Logger log = Logger.getLogger(UnicloudModel.class.getName());
	int id;
	String name;
	int lastSeenMinutes = 0;
	boolean ha = false;
	NetworkDevice.ROLE role = NetworkDevice.ROLE.LAC;
	
	List<CwsModel> cwsList = new LinkedList<CwsModel>();
	
	public UnicloudModel(int id, String name) {
		this.id = id;
		this.name = name;
		this.sysinfo = new SysInfo(name, NetworkDevice.TYPE.LAC, NetworkDevice.ROLE.LAC);
		refreshSysInfo();
		getNetworkDeviceInfo().setInterfaceList(Unimanage.spoofNetworkInterfaces(NETIF_COUNT));
		log.log(Level.INFO, "Unicloud: " + name + " Created Network Interfaces[" + getNetworkDeviceInfo().getInterfaceList().size() + "]");
		for(int i=0; i < getNetworkDeviceInfo().getInterfaceList().size(); i++) {
			log.log(Level.INFO, "[" + name + "]" + "netIf[" + i + "] ==> " + getNetworkDeviceInfo().getInterfaceList().get(i).getIPAddress());
		}
		setSystemInventory(SystemInventory.generateSampleInventory(this));
	}
	public UnicloudModel(int id, String name, boolean ha) {
		this.id   = id;
		this.name = name;
		this.ha   = ha;
		this.sysinfo = new SysInfo(name, (ha ? NetworkDevice.TYPE.LAC_HA : NetworkDevice.TYPE.LAC), NetworkDevice.ROLE.LAC);
		refreshSysInfo();
		getNetworkDeviceInfo().setInterfaceList(Unimanage.spoofNetworkInterfaces(NETIF_COUNT));
		log.log(Level.INFO, "Unicloud: " + name + " Created Network Interfaces[" + getNetworkDeviceInfo().getInterfaceList().size() + "]");
		for(int i=0; i < getNetworkDeviceInfo().getInterfaceList().size(); i++) {
			log.log(Level.INFO, "[" + name + "] netIf[" + i + "] ==> " + getNetworkDeviceInfo().getInterfaceList().get(i).getIPAddress());
		}
		setSystemInventory(SystemInventory.generateSampleInventory(this));
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
			if(cws.getRole() == NetworkDevice.ROLE.CWS_MESH) {
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
			if(cws.getRole() == CwsModel.ROLE.CWS_GW) {
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
}
