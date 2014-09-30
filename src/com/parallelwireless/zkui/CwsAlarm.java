package com.parallelwireless.zkui;

public class CwsAlarm {
	private String name;
	private int critical;
	private int major;
	private int minor;
	
	public CwsAlarm(String name, int critical, int major, int minor) {
		this.name = name;
		this.major = major;
		this.minor = minor;
	}
	
	public String getName() {
		return name;
	}

	public int getCritical() {
		return critical;
	}

	public void setCritical(int critical) {
		this.critical = critical;
	}

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public int getMinor() {
		return minor;
	}

	public void setMinor(int minor) {
		this.minor = minor;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
