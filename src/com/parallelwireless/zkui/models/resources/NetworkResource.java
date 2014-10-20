package com.parallelwireless.zkui.models.resources;

import java.util.ArrayList;
import java.util.List;

public class NetworkResource implements SystemResource {
	String systemName;
	String interfaceName;
	long   rxBytes;
	long   txBytes;
	int    linkSpeed;
	int    currentPercentUtilization;
	ArrayList<Integer>  lastTenPercentUtilization = new ArrayList<Integer>();
	
	public NetworkResource(String systemName) {
		this.systemName = systemName;
	}
	
	@Override
	public String getSystemName() {
		return systemName;
	}

	@Override
	public void addResources(ResourceConfig config) throws Exception {
		this.interfaceName = config.get(RESOURCE.NET_INTF_NAME);
		this.rxBytes = Long.parseLong(config.get(RESOURCE.NET_RX_BYTES));
		this.txBytes = Long.parseLong(config.get(RESOURCE.NET_TX_BYTES));
		this.linkSpeed = Integer.parseInt(config.get(RESOURCE.NET_LINK_SPEED));
		this.currentPercentUtilization = Integer.parseInt(config.get(RESOURCE.NET_PCT_UTIL));
		parseHistoricalUtilization(config.get(RESOURCE.NET_LAST10_PCT_UTIL));
	}

	public void parseHistoricalUtilization(String value) {
		lastTenPercentUtilization.clear();
		String[] values = value.split(" ");
		for(String p : values) {
			if(p != null && p.length() > 0) {
				lastTenPercentUtilization.add(Integer.parseInt(p));
			} else {
				lastTenPercentUtilization.add(null);
			}
		}
		lastTenPercentUtilization.add(currentPercentUtilization);
	}
	
	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public long getRxBytes() {
		return rxBytes;
	}

	public void setRxBytes(long rxBytes) {
		this.rxBytes = rxBytes;
	}

	public long getTxBytes() {
		return txBytes;
	}

	public void setTxBytes(long txBytes) {
		this.txBytes = txBytes;
	}

	public int getLinkSpeed() {
		return linkSpeed;
	}

	public void setLinkSpeed(int linkSpeed) {
		this.linkSpeed = linkSpeed;
	}

	public int getCurrentPercentUtilization() {
		return currentPercentUtilization;
	}

	public void setPercentUtilization(int currentPercentUtilization) {
		this.currentPercentUtilization = currentPercentUtilization;
	}

	public void setLastTenPercentUtilization(List<Integer> historicalUtilization) {
		this.lastTenPercentUtilization = new ArrayList<Integer>(historicalUtilization);
	}
	
	public ArrayList<Integer> getLastTenPercentUtilization() {
		return lastTenPercentUtilization;
	}
	
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	
}
