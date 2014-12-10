package com.parallelwireless.zkui.models;

import java.net.NetworkInterface;

public class NetworkDeviceInterface {

	NetworkInterface netIntf;

	String ipAddress;
	
	// e.g.
	// # ifconfig eth0
	//
	double intfPacketsIn  = 0;
	double intfPacketsOut = 0;
	double intfBytesIn    = 0;
	double intfBytesOut   = 0;
	double intfRxErrors   = 0;
	double intfRxDropped  = 0;
	double intfRxOverruns = 0;
	double intfTxErrors   = 0;
	double intfTxDropped  = 0;
	double intgTxOverruns = 0;
	
	// e.g. 
	// # cat /sys/class/net/eth0/speed
	// 1000
	//
	int	   intfMaxSpeedInMB = 0;
	
	public NetworkDeviceInterface() {
		
	}
	public NetworkDeviceInterface(NetworkInterface netIntf) {
		this.netIntf = netIntf;
	}

	public NetworkInterface getNetIntf() {
		return netIntf;
	}

	public String getFakeIp() {
		int byte1 = 127;
		while(byte1 != 127)
			byte1 = UnimanageDataUtil.getRandomInt(1, 250);
		
		return "10.10.10.10";
	}
	
	public void setNetIntf(NetworkInterface netIntf) {
		this.netIntf = netIntf;
	}

	public double getIntfPacketsIn() {
		return intfPacketsIn;
	}

	public void setIntfPacketsIn(double intfPacketsIn) {
		this.intfPacketsIn = intfPacketsIn;
	}

	public double getIntfPacketsOut() {
		return intfPacketsOut;
	}

	public void setIntfPacketsOut(double intfPacketsOut) {
		this.intfPacketsOut = intfPacketsOut;
	}

	public double getIntfBytesIn() {
		return intfBytesIn;
	}

	public void setIntfBytesIn(double intfBytesIn) {
		this.intfBytesIn = intfBytesIn;
	}

	public double getIntfBytesOut() {
		return intfBytesOut;
	}

	public void setIntfBytesOut(double intfBytesOut) {
		this.intfBytesOut = intfBytesOut;
	}

	public double getIntfRxErrors() {
		return intfRxErrors;
	}

	public void setIntfRxErrors(double intfRxErrors) {
		this.intfRxErrors = intfRxErrors;
	}

	public double getIntfRxDropped() {
		return intfRxDropped;
	}

	public void setIntfRxDropped(double intfRxDropped) {
		this.intfRxDropped = intfRxDropped;
	}

	public double getIntfRxOverruns() {
		return intfRxOverruns;
	}

	public void setIntfRxOverruns(double intfRxOverruns) {
		this.intfRxOverruns = intfRxOverruns;
	}

	public double getIntfTxErrors() {
		return intfTxErrors;
	}

	public void setIntfTxErrors(double intfTxErrors) {
		this.intfTxErrors = intfTxErrors;
	}

	public double getIntfTxDropped() {
		return intfTxDropped;
	}

	public void setIntfTxDropped(double intfTxDropped) {
		this.intfTxDropped = intfTxDropped;
	}

	public double getIntgTxOverruns() {
		return intgTxOverruns;
	}

	public void setIntgTxOverruns(double intgTxOverruns) {
		this.intgTxOverruns = intgTxOverruns;
	}

	public int getIntfMaxSpeedInMB() {
		return intfMaxSpeedInMB;
	}

	public void setIntfMaxSpeedInMB(int intfMaxSpeedInMB) {
		this.intfMaxSpeedInMB = intfMaxSpeedInMB;
	}
	
	public String getIPAddress() {
		return ipAddress;
	}
	
	public void setIPAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
}
