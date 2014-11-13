package com.parallelwireless.zkui.models;

public class GmapPolyline {

	GmapEndpoint start;
	GmapEndpoint end;
	
	public GmapPolyline() {
		
	}
	
	public GmapPolyline(GmapEndpoint start, GmapEndpoint end) {
		this.start = start;
		this.end = end;
	}

	
	public GmapEndpoint getStart() {
		return start;
	}

	public void setStart(GmapEndpoint start) {
		this.start = start;
	}

	public GmapEndpoint getEnd() {
		return end;
	}

	public void setEnd(GmapEndpoint end) {
		this.end = end;
	}

	@Override
	public boolean equals(Object o2) {
		boolean result = false;
		if(o2 instanceof GmapPolyline) {
			GmapPolyline p2 = (GmapPolyline)o2;
			if(this.getStart().equals(p2.getStart()) && this.getEnd().equals(p2.getEnd()) || (this.getStart().equals(p2.getEnd()) && this.getEnd().equals(p2.getStart())))
				result = true;
			}
		return result;
	}
	
	@Override
	public String toString() {
		return "GmapPolyline: start=" + start + " end=" + end;
	}
}
