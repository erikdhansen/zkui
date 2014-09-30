package com.parallelwireless.zkui;

public class Util {

	public static String colorHexToRGBA(String hexColor, int alphaPercentage) {
		if(hexColor.startsWith("#") && hexColor.length() == 7 && (alphaPercentage >= 0 && alphaPercentage < 100)) {
			Long.parseLong(hexColor.substring(1), 16);
			int red = Integer.valueOf(hexColor.substring(1, 3), 16);
			int green = Integer.valueOf(hexColor.substring(3, 5), 16);
			int blue = Integer.valueOf(hexColor.substring(5, 7), 16);
			return "rgb(" + red + ", " + green + ", " + blue + ", " + "0." + alphaPercentage + ")";
		}
		// Otherwise, just return what they gave us and they can wonder wny nothing changed...log error here maybe later
		return hexColor;
	}
}
