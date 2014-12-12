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
	
	public static enum ICON_COLOR {
		GREEN,
		GREY,
		ORANGE,
		RED,
		YELLOW
	}
	
	static Map<MAP_STATE,String> iconMap = new HashMap<MAP_STATE,String>();
	static {
		iconMap.put(MAP_STATE.FOCUS,  "/images/solid/*-green-32.png");
		iconMap.put(MAP_STATE.NOFOCUS,  "/images/transparent/*-green-32.png");
		iconMap.put(MAP_STATE.HIDDEN,  "/images/transparent/*-grey-32.png");
	}

	static Map<ICON_COLOR, String> ICON_LAC = new HashMap<ICON_COLOR,String>();
	static {
		ICON_LAC.put(ICON_COLOR.GREEN, "/images/solid/lac-green-32.png");
		ICON_LAC.put(ICON_COLOR.GREY,  "/images/solid/lac-grey-32.png");
		ICON_LAC.put(ICON_COLOR.ORANGE, "/images/solid/lac-orange-32.png");
		ICON_LAC.put(ICON_COLOR.RED, "/images/solid/lac-red-32.png");
		ICON_LAC.put(ICON_COLOR.YELLOW, "/images/solid/lac-yellow-32.png");
	}

	static Map<ICON_COLOR, String> ICON_LAC_HA = new HashMap<ICON_COLOR,String>();
	static {
		ICON_LAC_HA.put(ICON_COLOR.GREEN, "/images/solid/lac-ha-green-32.png");
		ICON_LAC_HA.put(ICON_COLOR.GREY,  "/images/solid/lac-ha-grey-32.png");
		ICON_LAC_HA.put(ICON_COLOR.ORANGE, "/images/solid/lac-ha-orange-32.png");
		ICON_LAC_HA.put(ICON_COLOR.RED, "/images/solid/lac-ha-red-32.png");
		ICON_LAC_HA.put(ICON_COLOR.YELLOW, "/images/solid/lac-ha-yellow-32.png");
	}
	
	static Map<ICON_COLOR, String> ICON_CWS_100 = new HashMap<ICON_COLOR, String>();
	static {
		ICON_CWS_100.put(ICON_COLOR.GREEN, "/images/solid/cws-100-green-32.png");
		ICON_CWS_100.put(ICON_COLOR.GREY, "/images/solid/cws-100-grey-32.png");
		ICON_CWS_100.put(ICON_COLOR.ORANGE, "/images/solid/cws-100-orange-32.png");
		ICON_CWS_100.put(ICON_COLOR.RED, "/images/solid/cws-100-red-32.png");
		ICON_CWS_100.put(ICON_COLOR.YELLOW, "/images/solid/cws-100-yellow-32.png");
	}

	static Map<ICON_COLOR, String> ICON_CWS_200 = new HashMap<ICON_COLOR, String>();
	static {
		ICON_CWS_100.put(ICON_COLOR.GREEN, "/images/solid/cws-200-green-32.png");
		ICON_CWS_100.put(ICON_COLOR.GREY, "/images/solid/cws-200-grey-32.png");
		ICON_CWS_100.put(ICON_COLOR.ORANGE, "/images/solid/cws-200-orange-32.png");
		ICON_CWS_100.put(ICON_COLOR.RED, "/images/solid/cws-200-red-32.png");
		ICON_CWS_100.put(ICON_COLOR.YELLOW, "/images/solid/cws-200-yellow-32.png");
	}

	static Map<ICON_COLOR, String> ICON_CWS_300 = new HashMap<ICON_COLOR, String>();
	static {
		ICON_CWS_100.put(ICON_COLOR.GREEN, "/images/solid/cws-300-green-32.png");
		ICON_CWS_100.put(ICON_COLOR.GREY, "/images/solid/cws-300-grey-32.png");
		ICON_CWS_100.put(ICON_COLOR.ORANGE, "/images/solid/cws-300-orange-32.png");
		ICON_CWS_100.put(ICON_COLOR.RED, "/images/solid/cws-300-red-32.png");
		ICON_CWS_100.put(ICON_COLOR.YELLOW, "/images/solid/cws-300-yellow-32.png");
	}
	
	private static Map<DEV_TYPE, Map<ICON_COLOR, String>> devIconMap = new HashMap<DEV_TYPE, Map<ICON_COLOR, String>>();
	static {
		devIconMap.put(DEV_TYPE.LAC,  ICON_LAC);
		devIconMap.put(DEV_TYPE.LAC_HA, ICON_LAC_HA);
		devIconMap.put(DEV_TYPE.CWS_100, ICON_CWS_100);
		devIconMap.put(DEV_TYPE.CWS_200,  ICON_CWS_200);
		devIconMap.put(DEV_TYPE.CWS_300, ICON_CWS_300);
	}
	
	
	private String systemName   = "n/a";
	private String locationName = "n/a";
	private DEV_TYPE devType    = DEV_TYPE.LAC;
	private MAP_STATE mapState  = MAP_STATE.HIDDEN;
	
	public GeoLocation() {
		super();
	}
	
	public GeoLocation(String systemName, DEV_TYPE devType) {
		super();
		this.systemName = systemName;
		this.devType = devType;
		this.setIconImage(getIconPath());
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
		// Default is green
		return devIconMap.get(getDevType()).get(ICON_COLOR.GREEN);
	}
	
	public String getIconPath(ICON_COLOR color) {
		return devIconMap.get(getDevType()).get(color);
	}
	
	@Override
	public String toString() {
		return "GeoLocation: systemName = " + systemName + " devType=" + devType.name() + " mapState=" + mapState + " lat=" + getLat() + " long=" + getLng() + " location=" + locationName;
	}
}
