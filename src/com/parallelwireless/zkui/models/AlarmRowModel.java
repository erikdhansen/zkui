package com.parallelwireless.zkui.models;

public class AlarmRowModel {

	String deviceType;
	int	   critical;
	int	   major;
	int    minor;
	
	public AlarmRowModel(){}
	public AlarmRowModel(String deviceType, int critical, int major, int minor) {
		this.deviceType = deviceType;
		this.critical = critical;
		this.major = major;
		this.minor = minor;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
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
	
}
