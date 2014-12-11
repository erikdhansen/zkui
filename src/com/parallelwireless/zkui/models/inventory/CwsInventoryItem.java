package com.parallelwireless.zkui.models.inventory;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.parallelwireless.zkui.models.NetworkDevice;
import com.parallelwireless.zkui.models.Unimanage;
import com.parallelwireless.zkui.models.UnimanageDataUtil;
import com.parallelwireless.zkui.models.inventory.CwsInventoryItemFactory.PARTS;

public class CwsInventoryItem {
	String id;
	String name;
	CATEGORY category;
	
	String  cwsName;
	String  version;
	TYPE	type;
	String  partNum;
	String  serialNumber;
	String  revision;
	String  description;
	String 	antennaCount;
	int 	maxPowers;
	
	List<BAND>  bandlist;
	
	public enum CATEGORY {
		BOARD("Board"),
		PORT("Port"),
		SYSTEM("System");
		
		private String category;
		private CATEGORY(String category) {
			this.category = category;
		}
		public String getTypeName() {
			return category;
		}
	}
	
	public enum TYPE {
		LTE("LTE"),
		WIFI("WiFi"),
		OTHER("");
		
		private String type;
		private TYPE(String type) {
			this.type = type;
		}
		public String getTypeName() {
			return type;
		}
	}
	
	public enum BAND {
		LTE_BAND_20("Band-20"),
		LTE_BAND_3("Band-3"),
		TWOFOUR_GHZ_WIFI("2.4GHz"),
		FIVE_GHZ_WIFI("5 GHz");
		
		private String bandName;
		private BAND(String bandName) {
			this.bandName = bandName;
		}
		public String getBandName() {
			return bandName;
		}
	}	
	
	public CwsInventoryItem() {
		
	}
	protected CwsInventoryItem(PARTS part) {
		this.partNum = part.getName();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CATEGORY getCategory() {
		return category;
	}

	public void setCategory(CATEGORY category) {
		this.category = category;
	}

	public String getCwsName() {
		return cwsName;
	}

	public void setCwsName(String cwsName) {
		this.cwsName = cwsName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public String getPartNum() {
		return partNum;
	}

	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAntennaCount() {
		return antennaCount;
	}

	public void setAntennaCount(String antennaCount) {
		this.antennaCount = antennaCount;
	}

	public int getMaxPowers() {
		return maxPowers;
	}

	public void setMaxPowers(int maxPowers) {
		this.maxPowers = maxPowers;
	}

	public List<BAND> getBandlist() {
		return bandlist;
	}
	
	public String getBandlistString() {
		StringBuilder sb = new StringBuilder(bandlist.get(0).name());
		if(bandlist.size() > 1) {
			for(int i=1; i < bandlist.size(); i++)
				sb.append(", ").append(bandlist.get(i).name());
		}
		return sb.toString();
	}

	public void setBandlist(List<BAND> bandlist) {
		this.bandlist = bandlist;
	}
	
	public static List<CwsInventoryItem> generateSampleInventory(NetworkDevice d, int itemCount) {
		List<CwsInventoryItem> itemList = new LinkedList<CwsInventoryItem>();
		return itemList;
	}
	
	public static List<CwsInventoryItem> generateSampleInventoryItems(NetworkDevice d) {
		List<CwsInventoryItem> items = new LinkedList<CwsInventoryItem>();
		CwsInventoryItem item = CwsInventoryItemFactory.buildPart(PARTS.P_CI9999, 1);
		item.setCwsName(d.getName());
		items.add(item);
		item = CwsInventoryItemFactory.buildPart(PARTS.P_6010012, 1);
		item.setCwsName(d.getName());
		items.add(item);
		item = CwsInventoryItemFactory.buildPart(PARTS.P_6010012, 0);
		item.setCwsName(d.getName());
		items.add(item);
		item = CwsInventoryItemFactory.buildPart(PARTS.P_2110004, 1);
		item.setCwsName(d.getName());
		items.add(item);
		item = CwsInventoryItemFactory.buildPart(PARTS.P_2110005, 2);
		item.setCwsName(d.getName());
		items.add(item);
		return items;
	}


}

