package com.parallelwireless.zkui.models.resources;

import java.text.DecimalFormat;

import com.parallelwireless.zkui.models.resources.SystemResource.RESOURCE;

public class MemoryResource extends AbstractSystemResource {
	// Memory
	int    totalSwapSize    = 0;  // .1.3.6.1.4.1.2021.4.3.0
	int    availSwapSize    = 0;  // .1.3.6.1.4.1.2021.4.4.0
	int    totalRAMAvail    = 0;  // .1.3.6.1.4.1.2021.4.5.0
	int    totalRAMUsed     = 0;  // .1.3.6.1.4.1.2021.4.6.0
	int    totalRAMFree     = 0;  // .1.3.6.1.4.1.2021.4.11.0
	int    totalRAMShared   = 0;  // .1.3.6.1.4.1.2021.4.13.0
	int    totalRAMBuffered = 0;  // .1.3.6.1.4.1.2021.4.14.0
	int    totalCachedMem   = 0;  // .1.3.6.1.4.1.2021.4.15.0
	String systemName;
	
	public MemoryResource(String systemName) {
		this.systemName = systemName;
		CRITICAL = 95;
		MAJOR    = 80;
		MINOR    = 75;		
	}

	@Override
	public void addResources(ResourceConfig config) throws Exception {
		setTotalSwapSize(config.get(RESOURCE.MEM_SWAP_TOTAL) == null ? getTotalSwapSize() : Integer.parseInt(config.get(RESOURCE.MEM_SWAP_TOTAL)));
		setAvailSwapSize(config.get(RESOURCE.MEM_SWAP_FREE) == null ? getAvailSwapSize() : Integer.parseInt(config.get(RESOURCE.MEM_SWAP_FREE)));
		setTotalRAMAvail(config.get(RESOURCE.MEM_RAM_TOTAL) == null ? getTotalRAMAvail() : Integer.parseInt(config.get(RESOURCE.MEM_RAM_TOTAL)));
		setTotalRAMUsed(config.get(RESOURCE.MEM_RAM_USED) == null ? getTotalRAMUsed() : Integer.parseInt(config.get(RESOURCE.MEM_RAM_USED)));
		setTotalRAMFree(config.get(RESOURCE.MEM_RAM_FREE) == null ? getTotalRAMFree() : Integer.parseInt(config.get(RESOURCE.MEM_RAM_FREE)));
		setTotalRAMShared(config.get(RESOURCE.MEM_RAM_SHARED) == null ? getTotalRAMShared() : Integer.parseInt(config.get(RESOURCE.MEM_RAM_SHARED)));
		setTotalRAMBuffered(config.get(RESOURCE.MEM_RAM_BUFFERED) == null ? getTotalRAMBuffered() : Integer.parseInt(config.get(RESOURCE.MEM_RAM_BUFFERED)));
		setTotalCachedMem(config.get(RESOURCE.MEM_RAM_CACHED) == null ? getTotalCachedMem() : Integer.parseInt(config.get(RESOURCE.MEM_RAM_CACHED)));
	}
	
	public int getTotalSwapSize() {
		return totalSwapSize;
	}
	public void setTotalSwapSize(int totalSwapSize) {
		this.totalSwapSize = totalSwapSize;
	}
	public int getAvailSwapSize() {
		return availSwapSize;
	}
	public void setAvailSwapSize(int availSwapSize) {
		this.availSwapSize = availSwapSize;
	}
	
	public int getUsedSwapSize() {
		return totalSwapSize - availSwapSize;
	}
	
	public int getTotalRAMAvail() {
		return totalRAMAvail;
	}
	public void setTotalRAMAvail(int totalRAMAvail) {
		this.totalRAMAvail = totalRAMAvail;
	}
	public int getTotalRAMUsed() {
		return totalRAMUsed;
	}
	public void setTotalRAMUsed(int totalRAMUsed) {
		this.totalRAMUsed = totalRAMUsed;
	}
	public int getTotalRAMFree() {
		return totalRAMFree;
	}
	public void setTotalRAMFree(int totalRAMFree) {
		this.totalRAMFree = totalRAMFree;
	}
	public int getTotalRAMShared() {
		return totalRAMShared;
	}
	public void setTotalRAMShared(int totalRAMShared) {
		this.totalRAMShared = totalRAMShared;
	}
	public int getTotalRAMBuffered() {
		return totalRAMBuffered;
	}
	public void setTotalRAMBuffered(int totalRAMBuffered) {
		this.totalRAMBuffered = totalRAMBuffered;
	}
	public int getTotalCachedMem() {
		return totalCachedMem;
	}
	public void setTotalCachedMem(int totalCachedMem) {
		this.totalCachedMem = totalCachedMem;
	}

	public String getTotalRAMAvailMB() {
		return mbFormat(totalRAMAvail);
	}
	
	public String getTotalRAMUsedMB() {
		return mbFormat(totalRAMUsed);
	}
	
	public String getTotalRAMFreeMB() {
		return mbFormat(totalRAMFree);
	}
	
	public String getTotalSwapSizeMB() {
		return mbFormat(totalSwapSize);
	}
	
	public String getUsedSwapSizeMB() {
		return mbFormat(getUsedSwapSize());
	}
	
	public String getAvailSwapSizeMB() {
		return mbFormat(availSwapSize);
	}
	
	public int getPercentUsed () {
		return (100 * getTotalRAMUsed()) / (getTotalRAMUsed() + getTotalRAMFree());
	}
	
	public int getMonitoredValue() {
		return getPercentUsed();
	}
	
	private String mbFormat(Number n) {
		return String.valueOf(new DecimalFormat("#,###.#").format(n.intValue() / 1024));
	}
	
	public String dumpMemInfo() {
		return "RAM: used=" + getTotalRAMUsedMB() + " free=" + getTotalRAMFreeMB() + " :: SWAP: used=" + getUsedSwapSizeMB() + " free=" + getAvailSwapSizeMB();
	}
	
	public String getSystemName() {
		return systemName;
	}
	
}
