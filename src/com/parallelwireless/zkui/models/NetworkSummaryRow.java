package com.parallelwireless.zkui.models;

public class NetworkSummaryRow {
	String name;
	int up;
	int down;
	
	public NetworkSummaryRow(String name, int up, int down) {
		this.name = name;
		this.up = up;
		this.down = down;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}
	
	
}
