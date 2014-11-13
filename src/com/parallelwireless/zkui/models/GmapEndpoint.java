package com.parallelwireless.zkui.models;

public class GmapEndpoint {
	double lat;
	double lng;
	int    zoom;
	
	public GmapEndpoint() {
	}
	
	public GmapEndpoint(double lat, double lng, int zoom) {
		this.lat = lat;
		this.lng = lng;
		this.zoom = zoom;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}
	
	@Override
	public boolean equals(Object o2) {
		boolean result = false;
		if(o2 instanceof GmapEndpoint) {
			GmapEndpoint e2 = (GmapEndpoint)o2;
			if((this.getLat() == e2.getLat()) && (this.getLng() == e2.getLng())) {
				result = true;
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "GmapPolyline: lat=" + getLat() + " lng=" + getLng() + " zoom=" + getZoom();
	}	
}
