package com.parallelwireless.zkui.models.map;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.zkoss.gmaps.AbstractMapModel;

import com.parallelwireless.zkui.models.NetworkDevice;

@SuppressWarnings("serial")
public class FullNetworkMapModel extends AbstractMapModel {

	Collection<NetworkDevice> devices = new LinkedList<NetworkDevice>();

	public FullNetworkMapModel(Collection<NetworkDevice> devices) {
		this.devices = devices;
	}
	
	@Override
	public void clear() {
		devices.clear();
	}

	@Override
	public Collection<NetworkDevice> getItemsIn(double swlat, double swlng, double nelat,
			double nelng, double cenlat, double cenlong, int zoom) {
		List<NetworkDevice> sublist = new LinkedList<NetworkDevice>();
		for(NetworkDevice d : devices) {
			long lat = new Double(d.getSysInfo().getGeo().getLat()).longValue();
			long lng = new Double(d.getSysInfo().getGeo().getLng()).longValue();
			
			if(lat >= swlat && lat <= nelat && lng<= swlng && lng >= nelng)
				sublist.add(d);
		}
		return sublist;
	}

}
