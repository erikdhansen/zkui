package com.parallelwireless.zkui.models;

public interface NetworkDevice {
	public static enum TYPE {
		unicloud,
		cws_mesh,
		cws_gw
	}

	public static enum STATUS {
		up,
		down
	}
	
	public boolean isUp();
	public TYPE getType();
	public int getCount();
}
