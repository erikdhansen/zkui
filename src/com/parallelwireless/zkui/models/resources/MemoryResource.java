package com.parallelwireless.zkui.models.resources;

import java.text.DecimalFormat;

import com.parallelwireless.zkui.models.resources.SystemResource.RESOURCE;

public class MemoryResource {
	// Memory
	int    totalSwapSize    = 0;  // .1.3.6.1.4.1.2021.4.3.0
	int    availSwapSize    = 0;  // .1.3.6.1.4.1.2021.4.4.0
	int    totalRAMAvail    = 0;  // .1.3.6.1.4.1.2021.4.5.0
	int    totalRAMUsed     = 0;  // .1.3.6.1.4.1.2021.4.6.0
	int    totalRAMFree     = 0;  // .1.3.6.1.4.1.2021.4.11.0
	int    totalRAMShared   = 0;  // .1.3.6.1.4.1.2021.4.13.0
	int    totalRAMBuffered = 0;  // .1.3.6.1.4.1.2021.4.14.0
	int    totalCachedMem   = 0;  // .1.3.6.1.4.1.2021.4.15.0
		
	public MemoryResource() {
	}

	@Override
	public void addResources(ResourceConfig config) throws Exception {
		setTotalSwapSize(String.valueOf(config.get(RESOURCE.MEM_SWAP_TOTAL) == null ? getTotalSwapSize() : config.get(RESOURCE.MEM_SWAP_TOTAL)));
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
	
	private String mbFormat(Number n) {
		return String.valueOf(new DecimalFormat("#,###.#").format(n.intValue() / 1024));
	}
	
	public String dumpMemInfo() {
		return "RAM: used=" + getTotalRAMUsedMB() + " free=" + getTotalRAMFreeMB() + " :: SWAP: used=" + getUsedSwapSizeMB() + " free=" + getAvailSwapSizeMB();
	}
	
}
