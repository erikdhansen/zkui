package com.parallelwireless.zkui.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.zkoss.chart.Color;
import org.zkoss.chart.RadialGradient;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Window;

import com.parallelwireless.zkui.models.NetworkDevice.TYPE;
import com.parallelwireless.zkui.models.inventory.CwsInventoryItem;

public class Unimanage {
	final static Logger log = Logger.getLogger(Unimanage.class.getName());
	
	public final static String COLOR_CRITICAL = "#cc0000";
	public final static String COLOR_MAJOR    = "#f39317";
	public final static String COLOR_MINOR    = "#ebf317";
	
	public static enum IP4_ADDR_CLASS {
		CLASS_A,
		CLASS_B,
		CLASS_C,
		CLASS_D,
		CIDR
	}
	
	public static enum RESOURCE_COLOR {
		RESOURCE_RAM_FREE,
		RESOURCE_RAM_USED,
		RESOURCE_SWAP_USED,
		RESOURCE_SWAP_FREE
	}
	
	public static Color RESOURCE_RAM_FREE = new Color("#83ed48");
	public static Color RESOURCE_RAM_USED = new Color("#309803");
	public static Color RESOURCE_SWAP_FREE = new Color("#24cef8");
	public static Color RESOURCE_SWAP_USED = new Color("#0079a3");

	public final static List<Color> ALARM_COLOR_LIST = new ArrayList<Color>();
	static {
		ALARM_COLOR_LIST.add(new Color(COLOR_CRITICAL));
		ALARM_COLOR_LIST.add(new Color(COLOR_MAJOR));
		ALARM_COLOR_LIST.add(new Color(COLOR_MINOR));
	}
	
	public final static String COLOR_LT_BLUE   = "#175af3";
	public final static String COLOR_LT_GREEN  = "#83ed48";
	public final static String COLOR_TURQUOISE = "#24cef8";
	public final static List<Color> DEFAULT_CHART_COLORS = new ArrayList<Color>();
	static {
		DEFAULT_CHART_COLORS.add(new Color(COLOR_LT_BLUE));
		DEFAULT_CHART_COLORS.add(new Color(COLOR_LT_GREEN));
		DEFAULT_CHART_COLORS.add(new Color(COLOR_TURQUOISE));
	}
	
	public final static List<Color> DEFAULT_CHART_GRADIENTS = new ArrayList<Color>();
	static {
		RadialGradient rg = new RadialGradient(0.5, 0.3, 0.7);
		rg.setStops(COLOR_LT_BLUE, "#0205a0");
		DEFAULT_CHART_GRADIENTS.add(new Color(rg));
		rg = new RadialGradient(0.5, 0.3, 0.7);
		rg.setStops(COLOR_LT_GREEN, "#309803");
		DEFAULT_CHART_GRADIENTS.add(new Color(rg));
		rg = new RadialGradient(0.5, 0.3, 0.7);
		rg.setStops(COLOR_TURQUOISE, "#0079a3");
		DEFAULT_CHART_GRADIENTS.add(new Color(rg));
	}
	
	public final static List<Color> ALARM_COLOR_GRADIENTS = new ArrayList<Color>();
	static {
		RadialGradient rg = new RadialGradient(0.5, 0.3, 0.7);
		rg.setStops(COLOR_CRITICAL, "#770000");
		ALARM_COLOR_GRADIENTS.add(new Color(rg));
		rg = new RadialGradient(0.5, 0.3, 0.7);
		rg.setStops(COLOR_MAJOR, "#983e00");
		ALARM_COLOR_GRADIENTS.add(new Color(rg));
		rg = new RadialGradient(0.5, 0.3, 0.7);
		rg.setStops(COLOR_MINOR, "#96a000");
		ALARM_COLOR_GRADIENTS.add(new Color(rg));
	}
	
	public static void getModalWindow(String message) {
		Window w = new Window("Error", "normal", true);
		Caption c = new Caption(message, "/images/device_icon_medium.png");
		w.appendChild(c);
		w.doModal();
		return;
	}
	
	public static List<CwsInventoryItem> generateFakeCWSInventory(NetworkDevice d) {
		return CwsInventoryItem.generateSampleInventoryItems(d);
	}
	
	public static String getRandomIP() {
		return getRandomIP(IP4_ADDR_CLASS.CIDR);
	}
	
	public static Date getRandomInstallDate(int daysBack) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_YEAR, (0 - new Random().nextInt(daysBack)));
		return cal.getTime();
	}
	
	public static String getRandomVersionString() {
		return "4.0.1029";
	}
	
	public static String getRandomSerialNumber(TYPE type) {
		String prefix = type.name().replace("_", "").concat("-");
		return prefix.concat(String.format("%08d",  UnimanageDataUtil.getRandomInt(0, 9999)));
	}
	
	public static String getRandomIP(IP4_ADDR_CLASS addrClass) {
		Random r = new Random();
		int b1 = 0;
		switch(addrClass) {
			case CLASS_A:
				b1 = r.nextInt(125) + 1;
				break;
			case CLASS_B:
				b1 = UnimanageDataUtil.getRandomInt(128, 191);
				break;
			case CLASS_C:
				b1 = UnimanageDataUtil.getRandomInt(192,222);
				break;
			default:
				while(b1 == 255 || b1 == 127 ||  b1 == 223 || b1 == 0)
					b1 = r.nextInt(256);
				}
		int b2 = r.nextInt(256);
		int b3 = r.nextInt(256);
		int b4 = r.nextInt(256);
		
		String ipAddr = String.valueOf(b1).concat(".").concat(String.valueOf(b2)).concat(".").concat(String.valueOf(b3)).concat(".").concat(String.valueOf(b4));
		log.log(Level.INFO, "Generated Random IP Address: " + ipAddr);
		return ipAddr;
	}
	
	public static List<NetworkDeviceInterface> spoofNetworkInterfaces(int count) {
		List<NetworkDeviceInterface> ifs = new LinkedList<NetworkDeviceInterface>();
		for(int i=0; i < count; i++) {
			NetworkDeviceInterface di = new NetworkDeviceInterface();
			di.setIPAddress(Unimanage.getRandomIP(IP4_ADDR_CLASS.CIDR));
			ifs.add(di);
		}
		return ifs;
	}
}
