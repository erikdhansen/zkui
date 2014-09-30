package com.parallelwireless.zkui.models;

import java.util.LinkedList;
import java.util.List;

import org.zkoss.chart.Color;

import com.parallelwireless.zkui.models.CwsModel.CWS_TYPE;

public class UnicloudModel implements NetworkDevice {
	int id;
	String name;
	String ip;
	int lastSeenMinutes = 0;
	
	List<CwsModel> cwsList = new LinkedList<CwsModel>();
	
	public UnicloudModel(int id, String name, String ip, int lastSeenMinutes) {
		this.id = id;
		this.name = name;
		this.ip = ip;
		this.lastSeenMinutes = lastSeenMinutes;
	}
	
	public String getName() {
		return name;
	}
	
	public String getIp() {
		return ip;
	}
	
	public int getLastSeenMinutes() {
		return lastSeenMinutes;
	}
	
	public List<CwsModel> getCwsList() {
		return cwsList;
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
		return NetworkDevice.TYPE.unicloud;
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

	@Override
	public int getCount() {
		return 1;
	}
	
}
