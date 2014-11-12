package com.parallelwireless.zkui.models.resources;


import java.util.logging.Logger;

import com.parallelwireless.zkui.models.UnimanageDataUtil;
import com.parallelwireless.zkui.models.resources.SystemResource.RESOURCE;

public class GeoLocation {
	final static Logger log = Logger.getLogger(GeoLocation.class.getName());
	
	private String systemName = "random";
	private float latitude = 0f;
	private float longitude = 0f;
	private String locationName = "random";
	
	public GeoLocation() {
		
	}
	
	public GeoLocation(String systemName) {
		this.systemName = systemName;
	}
	
	public void addResources(ResourceConfig cfg) throws Exception {
		if((cfg.get(RESOURCE.GEO_LATITUDE) == null) || (cfg.get(RESOURCE.GEO_LONGITUDE) == null)) {
			log.warning("No location data found!  Generating RANDOM GeoLocation!");
			GeoLocation g = UnimanageDataUtil.generateRandomLocation();
			latitude = g.getLatitude();
			longitude = g.getLongitude();
		} else {
			latitude = Float.valueOf(cfg.get(RESOURCE.GEO_LATITUDE));
			longitude = Float.valueOf(cfg.get(RESOURCE.GEO_LONGITUDE));
		}
	}
	
	public GeoLocation(String systemName, float latitude, float longitude) {
		this.systemName = systemName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	@Override
	public String toString() {
		return "GeoLocation: systemName = " + systemName + " lat=" + latitude + " long=" + longitude + " location=" + locationName;
	}
}
