package com.parallelwireless.zkui.network;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.zkoss.gmaps.Gmaps;
import org.zkoss.gmaps.Gmarker;
import org.zkoss.gmaps.Gpolyline;
import org.zkoss.gmaps.event.MapMouseEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import com.parallelwireless.zkui.models.CwsModel;
import com.parallelwireless.zkui.models.GmapEndpoint;
import com.parallelwireless.zkui.models.GmapPolyline;
import com.parallelwireless.zkui.models.NetworkDevice.TYPE;
import com.parallelwireless.zkui.models.UnicloudModel;
import com.parallelwireless.zkui.models.UnimanageDataUtil;
import com.parallelwireless.zkui.models.resources.GeoLocation;
import com.parallelwireless.zkui.models.resources.GeoLocation.MAP_STATE;

@SuppressWarnings("serial")
public class GoogleMapsController extends SelectorComposer<Div>{
	final static Logger log = Logger.getLogger(GoogleMapsController.class.getName());

	@Wire
	Gmaps gmap;
	@Wire
	Div infovis;
	
	List<Gmarker> cwsList = new LinkedList<Gmarker>();
	Map<String,GeoLocation>     geos   = UnimanageDataUtil.getAllGeoLocations();

	HashSet<GmapPolyline> networkMapLinks = new LinkedHashSet<GmapPolyline>();
	
	public void doAfterCompose(Div d) throws Exception {
		super.doAfterCompose(d);
//		gmap.getChildren().removeAll(gmap.getChildren());
		for(GeoLocation g : geos.values()) {
			g.setMapState(MAP_STATE.HIDDEN);
			if(gmap != null && g != null)
				gmap.appendChild(g);
		}
		buildNetworkLinks();
		for(GmapPolyline l : networkMapLinks) {
			Gpolyline newlink = new Gpolyline();
			newlink.setPoints(l.getStart().getLat() + "," + l.getStart().getLng() + "," + 
			                  l.getStart().getZoom() + "," + l.getEnd().getLat() + "," + 
					          l.getEnd().getLng() + "," + l.getEnd().getZoom());
			newlink.setColor("#555");
			newlink.setOpacity(50);
			gmap.appendChild(newlink);
		}
}


	public void buildNetworkLinks() {
		Collection<UnicloudModel> uniclouds = UnimanageDataUtil.getAllUniclouds();
		for(UnicloudModel u : uniclouds) {
			// Unicloud Endpoints
			GmapEndpoint start = new GmapEndpoint(u.getSysInfo().getGeo().getLat(), u.getSysInfo().getGeo().getLng(), 3);
			for(String neighbor : u.getNetworkLinks()) {
				GeoLocation g = geos.get(neighbor);
				GmapEndpoint end = new GmapEndpoint(g.getLat(), g.getLng(), 3);
				GmapPolyline netlink = new GmapPolyline(start, end);
				networkMapLinks.add(netlink);
				log.info("buildNetworkLinks: added network link [" + u.getName() + " => " + neighbor + "] start=" + start + " end=" + end);
			}
			// Uniclouds CWS endpoints
			for(CwsModel cws : u.getCwsList()) {
				networkMapLinks.addAll(getCwsNetworkLinks(cws));
			}
		}
	}
	
	public Collection<GmapPolyline> getCwsNetworkLinks(CwsModel cws) {
		Collection<GmapPolyline> links = new LinkedList<GmapPolyline>();
		GmapEndpoint start = new GmapEndpoint(cws.getSysInfo().getGeo().getLat(), cws.getSysInfo().getGeo().getLng(), 3);
		for(String neighbor : cws.getNetworkLinks()) {
			GmapEndpoint end = new GmapEndpoint(geos.get(neighbor).getLat(), geos.get(neighbor).getLng(), 3);
			GmapPolyline netlink = new GmapPolyline(start, end);
			links.add(netlink);
			log.info("getCwsNetworkLinks: added network link [" + cws.getName() + " => " + neighbor + "]: " + start + " => " + end);
		}
		return links;
	}
	
	@Listen("onMapClick = #gmap")
	public void onMapClick(MapMouseEvent event) {
		Gmarker gmarker = event.getGmarker();
		GeoLocation geo = geos.get(gmarker.getId());
		String geoId    = geo.getId();
		if(geo != null) {
			if(geo.getDevType() == TYPE.LAC){
				geo.setMapState(MAP_STATE.FOCUS);
				for(UnicloudModel u : UnimanageDataUtil.getAllUniclouds()) {
					if(u.getName().equalsIgnoreCase(geoId)) {
						for(CwsModel c : u.getCwsList()) {
							geos.get(c.getName()).setMapState(MAP_STATE.FOCUS);
						}
					} else {
						geos.get(u.getName()).setMapState(MAP_STATE.HIDDEN);
						log.info("UnicloudModel[" + u.getName() + "] STATE => FOCUS");
						for(CwsModel c : u.getCwsList()) {
							geos.get(c.getName()).setMapState(MAP_STATE.HIDDEN);
						}
					}
				}
			} else {
				// DO nothing for CWS
			}
		}
	}
}
