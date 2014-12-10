package com.parallelwireless.zkui.models.inventory;

import java.util.LinkedList;
import java.util.List;

import com.parallelwireless.zkui.models.NetworkDevice;
import com.parallelwireless.zkui.models.Unimanage;
import com.parallelwireless.zkui.models.UnimanageDataUtil;

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
	int 	antennaCount;
	int 	maxPowers;
	
	List<BAND>  bandlist;
	
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

	public int getAntennaCount() {
		return antennaCount;
	}

	public void setAntennaCount(int antennaCount) {
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
	
	public static List<CwsInventoryItem> generateSampleInventoryItems(NetworkDevice d) {
		List<CwsInventoryItem> items = new LinkedList<CwsInventoryItem>();
		int rndPrefix = UnimanageDataUtil.getRandomInt(1001, 9009);
		items.add(generateSampleBoardItem(d, rndPrefix));
		return items;
	}
	
	private static CwsInventoryItem generateSamplePortItem(NetworkDevice d, int rndPrefix) {
		CwsInventoryItem p1 = new CwsInventoryItem();
		return p1;
	}
	private static CwsInventoryItem generateSampleBoardItem(NetworkDevice d, int rndPrefix) {
		String version = Unimanage.getRandomVersionString();
		CwsInventoryItem b1 = new CwsInventoryItem();
		b1.setName("B1");
		b1.setCategory(CATEGORY.BOARD);
		b1.setCwsName(d.getName());
		b1.setId(String.valueOf(rndPrefix) + "." + d.getName() + "." + b1.getName());
		b1.setVersion(version);
		b1.setType(TYPE.OTHER);
		b1.setPartNum("CI9999");
		b1.setSerialNumber(Unimanage.getRandomSerialNumber(d.getType()));
		b1.setRevision("001");
		b1.setDescription("CI0001");
		return b1;
	}
}
