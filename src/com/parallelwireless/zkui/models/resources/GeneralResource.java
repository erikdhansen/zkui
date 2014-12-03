package com.parallelwireless.zkui.models.resources;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class GeneralResource extends AbstractSystemResource {

	Date installDate = new Date()	;
	String systemVersion = "";
	String serialNumber = "";
	
	public GeneralResource(String systemName) {
		setSystemName(systemName);
	}
	
	@Override
	public void addResources(ResourceConfig cfg) throws Exception {
		installDate    = cfg.get(RESOURCE.GEN_INSTALL_DATE) == null ? installDate : new Date(Long.parseLong(cfg.get(RESOURCE.GEN_INSTALL_DATE)));
		systemVersion  = cfg.get(RESOURCE.GEN_SYSTEM_VERSION) == null ? systemVersion : cfg.get(RESOURCE.GEN_SYSTEM_VERSION);
		serialNumber   = cfg.get(RESOURCE.GEN_SERIAL_NUMBER) == null ? serialNumber : cfg.get(RESOURCE.GEN_SERIAL_NUMBER);
	}
	
	@Override
	public int getMonitoredValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getInstallDate() {
		StringBuilder sb = new StringBuilder();
		Calendar c = Calendar.getInstance();
		c.setTime(installDate);
		sb.append(c.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US)).append(" ").append(c.get(Calendar.DAY_OF_MONTH)).append(", ").append(c.get(Calendar.YEAR));
		return sb.toString();
	}

	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}

	public String getSystemVersion() {
		return systemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	
}
