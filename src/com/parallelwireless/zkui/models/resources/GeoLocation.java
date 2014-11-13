package com.parallelwireless.zkui.models.resources;


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.zkoss.gmaps.Gmarker;

import com.parallelwireless.zkui.models.UnimanageDataUtil;
import com.parallelwireless.zkui.models.resources.SystemResource.RESOURCE;

@SuppressWarnings("serial")
public class GeoLocation extends Gmarker {
	final static Logger log = Logger.getLogger(GeoLocation.class.getName());
	
	public static enum MAP_STATE {
		FOCUS,
		NOFOCUS,
		HIDDEN
	};
	
	public static enum DEV_TYPE {
		UNICLOUD,
		CWS
	};
	
	static Map<MAP_STATE,String> iconMap = new HashMap<MAP_STATE,String>();
	static {
		iconMap.put(MAP_STATE.FOCUS,  "/images/solid/*-green-32.png");
		iconMap.put(MAP_STATE.NOFOCUS,  "/images/transparent/*-green-32.png");
		iconMap.put(MAP_STATE.HIDDEN,  "/images/transparent/*-grey-32.png");
	}

	
	
	private String systemName   = "n/a";
	private String locationName = "n/a";
	private DEV_TYPE devType    = DEV_TYPE.UNICLOUD;
	private MAP_STATE mapState  = MAP_STATE.HIDDEN;
	
	public GeoLocation() {
		super();
	}
	
	public GeoLocation(String systemName, DEV_TYPE devType) {
		super();
		this.systemName = systemName;
		this.devType = devType;
		this.setId(systemName);
	}
	
	public void addResources(ResourceConfig cfg) throws Exception {
		if((cfg.get(RESOURCE.GEO_LATITUDE) == null) || (cfg.get(RESOURCE.GEO_LONGITUDE) == null)) {
			log.warning("No location data found!  Generating RANDOM GeoLocation!");
			GeoLocation g = UnimanageDataUtil.generateRandomLocation();
			setLat(g.getLat());
			setLng(g.getLng());
		} else {
			setLat(Float.valueOf(cfg.get(RESOURCE.GEO_LATITUDE)));
			setLng(Float.valueOf(cfg.get(RESOURCE.GEO_LONGITUDE)));
		}
	}
	
	public GeoLocation(String systemName, DEV_TYPE devType, float latitude, float longitude) {
		super();
		this.systemName = systemName;
		this.devType = devType;
		this.setId(systemName);
		this.setLat(latitude);
		this.setLng(longitude);
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
		this.setId(systemName);
	}
	
	public DEV_TYPE getDevType() {
		return devType;
	}
	
	public void setDevType(DEV_TYPE devType) {
		this.devType = devType;
	}
	
	public MAP_STATE getMapState() {
		return mapState;
	}
	
	public void setMapState(MAP_STATE mapState) {
		this.mapState = mapState;
		this.setIconImage(getIconPath());
	}
	
	public String getIconPath() {
		String dev = "";
		if(devType == DEV_TYPE.UNICLOUD){
			dev = "unicloud";
		} else if(devType == DEV_TYPE.CWS){
			dev = "cws-100";
		}
		
		String basePathname = iconMap.get(mapState);
		String iconPath = basePathname.replace("*", dev);
		return iconPath;
	}
	
	@Override
	public String toString() {
		return "GeoLocation: systemName = " + systemName + " devType=" + devType.name() + " mapState=" + mapState + " lat=" + getLat() + " long=" + getLng() + " location=" + locationName;
	}
}
