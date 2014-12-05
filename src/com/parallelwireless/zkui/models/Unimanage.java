package com.parallelwireless.zkui.models;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.chart.Color;
import org.zkoss.chart.RadialGradient;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Window;

public class Unimanage {

	public final static String COLOR_CRITICAL = "#cc0000";
	public final static String COLOR_MAJOR    = "#f39317";
	public final static String COLOR_MINOR    = "#ebf317";
	
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
}
