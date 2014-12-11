package com.parallelwireless.zkui.models.map;

import java.util.Collection;
import java.util.LinkedList;

import org.zkoss.gmaps.MapModelList;

import com.parallelwireless.zkui.models.NetworkDevice;
import com.parallelwireless.zkui.models.NetworkDevice.TYPE;
import com.parallelwireless.zkui.models.UnicloudModel;
import com.parallelwireless.zkui.models.resources.GeoLocation;

@SuppressWarnings("serial")
public class NetworkDeviceMapModel extends MapModelList {
	
	NetworkDevice d;
	Collection<GeoLocation> devices = new LinkedList<GeoLocation>();
	
	public NetworkDeviceMapModel(NetworkDevice d) {
		super();
		this.d = d;
		devices.add(d.getSysInfo().getGeo());
		if(d.getType() == TYPE.LAC) {
			UnicloudModel u = (UnicloudModel)d;
			for(NetworkDevice cws : u.getCwsList()) {
				devices.add(cws.getSysInfo().getGeo());
			}
		}
		this.addAll(devices);
	}
	
	public double getCenterLat() {
		return d.getLat();
	}
	
	public double getCenterLng() {
		return d.getLng();
	}
}
