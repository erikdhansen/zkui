package com.parallelwireless.zkui.models.inventory;

import java.util.Date;

import com.parallelwireless.zkui.models.NetworkDevice;
import com.parallelwireless.zkui.models.Unimanage;
import com.parallelwireless.zkui.models.UnimanageDataUtil;

public class LacInventoryItem {
	
	String name;
	String ipAddress;
	Date   installDate;
	String version;
	String serialNumber;
	
	// CPU Information
	int cpuCount;
	String cpuSpeed;
	// Memory
	String physicalMemory;
	// Disk
	int diskCount;
	String totalSpace;
	String availableSpace;
	// Net
	int ifCount;
	
	public LacInventoryItem() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Date getInstallDate() {
		return installDate;
	}
	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public int getCpuCount() {
		return cpuCount;
	}
	public void setCpuCount(int cpuCount) {
		this.cpuCount = cpuCount;
	}
	public String getCpuSpeed() {
		return cpuSpeed;
	}
	public void setCpuSpeed(String cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}
	public String getPhysicalMemory() {
		return physicalMemory;
	}
	public void setPhysicalMemory(String physicalMemory) {
		this.physicalMemory = physicalMemory;
	}
	public int getDiskCount() {
		return diskCount;
	}
	public void setDiskCount(int diskCount) {
		this.diskCount = diskCount;
	}
	public String getTotalSpace() {
		return totalSpace;
	}
	public void setTotalSpace(String totalSpace) {
		this.totalSpace = totalSpace;
	}
	public String getAvailableSpace() {
		return availableSpace;
	}
	public void setAvailableSpace(String availableSpace) {
		this.availableSpace = availableSpace;
	}
	public int getIfCount() {
		return ifCount;
	}
	public void setIfCount(int ifCount) {
		this.ifCount = ifCount;
	}

	public static LacInventoryItem generateSampleInventoryItem(NetworkDevice d) {
		LacInventoryItem lac = new LacInventoryItem();
		lac.setName(d.getName());
		lac.setIpAddress(d.getNetworkDeviceInfo().getInterfaceList().get(0).getIPAddress());
		lac.setInstallDate(Unimanage.getRandomInstallDate(UnimanageDataUtil.getRandomIntFromZero(300)));
		lac.setSerialNumber(Unimanage.getRandomSerialNumber(d.getType()));
		lac.setVersion(Unimanage.getRandomVersionString());
		lac.setCpuCount(d.getSysInfo().getCpuCount());
		lac.setCpuSpeed(d.getSysInfo().getCpuSpeed());
		lac.setPhysicalMemory(d.getSysInfo().getMem().getTotalRAMAvailHR());
		lac.setDiskCount(4);
		lac.setTotalSpace(d.getSysInfo().getDisk().getTotalDiskSpaceHR());
		lac.setAvailableSpace(d.getSysInfo().getDisk().getFreeDiskSpaceHR());
		lac.setIfCount(d.getNetworkInterfaces().size());
		return lac;
	}
	
}
