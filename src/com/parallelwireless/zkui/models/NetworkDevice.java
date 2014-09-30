package com.parallelwireless.zkui.models;

public interface NetworkDevice {
	public enum TYPE {
		unicloud,
		cws_mesh,
		cws_gw
	}

	public enum STATUS {
		up,
		down
	}
	
	public boolean isUp();
	public TYPE getType();
	public int getCount();
}
