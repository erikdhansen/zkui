package com.parallelwireless.zkui.models.inventory;

import java.util.LinkedList;
import java.util.List;

import com.parallelwireless.zkui.models.NetworkDevice;

public class SystemInventory {

	public static enum TYPE {
		LAC,
		CWS
	}
	
	TYPE type;
	LacInventoryItem lac;
	NetworkDevice d;
	List<CwsInventoryItem> cwsItems = new LinkedList<CwsInventoryItem>();
	
	public SystemInventory(NetworkDevice d) {
		type = (d.getType() == NetworkDevice.TYPE.LAC ? TYPE.LAC : TYPE.CWS);
		this.d = d;
	}
	
	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public LacInventoryItem getLac() {
		return lac;
	}

	public void setLac(LacInventoryItem lac) {
		this.lac = lac;
	}

	public List<CwsInventoryItem> getCwsItems() {
		return cwsItems;
	}

	public void setCwsItems(List<CwsInventoryItem> cwsItems) {
		this.cwsItems = cwsItems;
	}

	public static SystemInventory generateSampleInventory(NetworkDevice d) {
		return generateSampleInventory(d, 1);
	}
	
	public static SystemInventory generateSampleInventory(NetworkDevice d, int itemCount) {
		NetworkDevice.TYPE devType = d.getType();
		SystemInventory i = null;
		switch(devType) {
		case LAC: 
			i = generateSampleLACInventory(d);
			break;
		case CWS_MESH:
		case CWS_GW:
			i = generateSampleCWSInventory(d);
			break;
		}
		return i;
	}
	
	private static SystemInventory generateSampleLACInventory(NetworkDevice d) {
		SystemInventory i = new SystemInventory(d);
		i.setType(TYPE.LAC);
		i.setLac(LacInventoryItem.generateSampleInventoryItem(d));
		return i;
	}
	
	private static SystemInventory generateSampleCWSInventory(NetworkDevice d) {
		SystemInventory i = new SystemInventory(d);
		i.setType(TYPE.CWS);
		i.setCwsItems(CwsInventoryItem.generateSampleInventoryItems(d));
		return i;
	}
	
}
