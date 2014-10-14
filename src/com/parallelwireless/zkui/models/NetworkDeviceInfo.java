package com.parallelwireless.zkui.models;

import java.util.LinkedList;
import java.util.List;

public class NetworkDeviceInfo {
	List<NetworkDeviceInterface> interfaceList = new LinkedList<NetworkDeviceInterface>();
	
	public StatTotals statistics = new StatTotals();
	
	public NetworkDeviceInfo() {
	}
	
	public List<NetworkDeviceInterface> getInterfaceList() {
		return interfaceList;
	}
	
	public void setInterfaceList(List<NetworkDeviceInterface> interfaceList) {
		this.interfaceList = interfaceList;
	}
	
	public void addInterface(NetworkDeviceInterface netIf) {
		interfaceList.add(netIf);
	}
	
	public StatTotals getNetworkStatistics() {
		statistics.total();
		return statistics;
	}
	
	public class StatTotals {
		
		public StatTotals() {
		}
		
		public void total() {	
		}
	}
}
