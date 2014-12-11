package com.parallelwireless.zkui.models.inventory;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.parallelwireless.zkui.models.UnimanageDataUtil;
import com.parallelwireless.zkui.models.inventory.CwsInventoryItem.BAND;
import com.parallelwireless.zkui.models.inventory.CwsInventoryItem.CATEGORY;
import com.parallelwireless.zkui.models.inventory.CwsInventoryItem.TYPE;



public final class CwsInventoryItemFactory {
	final static Logger log = Logger.getLogger(CwsInventoryItem.class.getName());
	public static enum PARTS {
		P_CI9999(0, "CI9999"),
		P_6010005(1, "601-0005"),
		P_6010006(2, "601-0006"),
		P_6010012(3, "601-0012"),
		P_6020001(4, "602-0001"),
		P_2110004(5, "211-0004"),
		P_2110005(6, "211-0005");
		
		private int index;
		private String name;
		private PARTS(int index, String name) {
			this.index = index;
			this.name = name;
		}
		public int getIndex() {
			return index;
		}
		public String getName() {
			return name;
		}
		
		public static PARTS get(String name) {
			for(PARTS p : PARTS.values()) {
				if(p.getName().equalsIgnoreCase(name))
					return p;
			}
			return null;
		}
		
		public static PARTS get(int index) {
			for(PARTS p : PARTS.values()) {
				if(p.getIndex() == index) {
					return p;
				}
			}
			return null;
		}
	}
	
	private final CwsInventoryItemFactory _factory = new CwsInventoryItemFactory();
	
	private CwsInventoryItemFactory() {	
	}
	
	public static CwsInventoryItem buildRandomPart(int index) {
		int partTypeCount = PARTS.values().length;
		PARTS part = PARTS.get(new Random().nextInt(partTypeCount));
		log.log(Level.INFO, "Generating random CWS Inventory Item: PartNum[" + part.getName() + "]");
		return buildPart(part, index);
	}
	
	public static CwsInventoryItem buildPart(PARTS part, int index) {
		CwsInventoryItem item = new CwsInventoryItem(part);
		item.setCategory(categoryFromPartNum(part));
		item.setName(item.getCategory().name().substring(0, 1).concat(String.valueOf(index)));
		item.setType(typeFromPartNum(part));
		item.setSerialNumber(String.valueOf(UnimanageDataUtil.getRandomLong(10000001, 10009999)));
		item.setRevision("???");
		item.setDescription(descriptionFromPartNum(part));
		item.setAntennaCount(antennaCountFromPartNum(part));
		item.setMaxPowers(maxPowerFromPartNum(part));
		item.setBandlist(bandListFromPartNum(part));
		return item;
	}
	
	private static String descriptionFromPartNum(PARTS part) {
		String description = "";
		switch(part) {
		case P_2110004:
			description = "WIFI_MOD_WLE250NX";
			break;
		case P_2110005:
			description = "WIFI_MOD_HP_5G_WLE";
			break;
		case P_6010012:
			description = "Parallel Wireless LTE Radio";
			break;
		case P_6010005:
			description = "Victrola BBP";
			break;
		case P_6010006:
			description = "Zenith BBP";
			break;
		case P_CI9999:
			description = "CI9999";
			break;
		default:
		}
		return description;
	}
		
	private static TYPE typeFromPartNum(PARTS part) {
		TYPE type = TYPE.OTHER;
		switch(part) {
		case P_6010012:
			type = TYPE.LTE;
			break;
		case P_2110004:
		case P_2110005:
			type = TYPE.WIFI;
			break;
		default:
		}
		return type;
	}
	private static CATEGORY categoryFromPartNum(PARTS part) {
		CATEGORY category = null;
		switch(part) {
			case P_CI9999:
			case P_6020001:
			case P_6010005:
			case P_6010006:
				category = CATEGORY.BOARD;
				break;
			case P_6010012:
			case P_2110004:
			case P_2110005:
				category = CATEGORY.PORT;
				break;
			default:
				category = CATEGORY.SYSTEM;
		}
		return category;
	}
	
	private static List<BAND> bandListFromPartNum(PARTS part) {
		List<BAND> bands = new LinkedList<BAND>();
		switch(part) {
		case P_2110005:
			bands.add(BAND.FIVE_GHZ_WIFI);
			break;
		case P_2110004:
			bands.add(BAND.TWOFOUR_GHZ_WIFI);
			bands.add(BAND.FIVE_GHZ_WIFI);
			break;
		case P_6010012:
			bands.add(BAND.LTE_BAND_20);
			bands.add(BAND.LTE_BAND_3);
		default:
		}
		return bands;
	}
	
	private static int maxPowerFromPartNum(PARTS part) {
		int maxp = 0;
		switch(part) {
		case P_2110005:
			maxp = 24;
			break;
		case P_2110004:
			maxp = 21;
			break;
		case P_6010012:
			maxp = -8;
			break;
		default:
		}
		return maxp;
	}
	
	private static String antennaCountFromPartNum(PARTS part) {
		String count;
		switch(part) {
		case P_2110005:
			count = "3";
			break;
		case P_2110004:
			count = "2";
			break;
		default:
			count = "n/a";
		}
		return count;
	}	
}
