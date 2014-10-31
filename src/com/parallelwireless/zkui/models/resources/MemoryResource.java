package com.parallelwireless.zkui.models.resources;

import java.text.DecimalFormat;

import com.parallelwireless.zkui.models.resources.SystemResource.RESOURCE;

public class MemoryResource extends AbstractSystemResource {
	// Memory
	long   totalSwapSize    = 0;  // .1.3.6.1.4.1.2021.4.3.0
	long   availSwapSize    = 0;  // .1.3.6.1.4.1.2021.4.4.0
	long   totalRAMAvail    = 0;  // .1.3.6.1.4.1.2021.4.5.0
	long   totalRAMUsed     = 0;  // .1.3.6.1.4.1.2021.4.6.0
	long   totalRAMFree     = 0;  // .1.3.6.1.4.1.2021.4.11.0
	long   totalRAMShared   = 0;  // .1.3.6.1.4.1.2021.4.13.0
	long   totalRAMBuffered = 0;  // .1.3.6.1.4.1.2021.4.14.0
	long   totalCachedMem   = 0;  // .1.3.6.1.4.1.2021.4.15.0
	String systemName;
	
	public MemoryResource(String systemName) {
		this.systemName = systemName;
		CRITICAL = 95;
		MAJOR    = 80;
		MINOR    = 75;		
	}

	@Override
	public void addResources(ResourceConfig config) throws Exception {
		setTotalSwapSize(config.get(RESOURCE.MEM_SWAP_TOTAL) == null ? getTotalSwapSize() : Long.parseLong(config.get(RESOURCE.MEM_SWAP_TOTAL)));
		setAvailSwapSize(config.get(RESOURCE.MEM_SWAP_FREE) == null ? getAvailSwapSize() : Long.parseLong(config.get(RESOURCE.MEM_SWAP_FREE)));
		setTotalRAMAvail(config.get(RESOURCE.MEM_RAM_TOTAL) == null ? getTotalRAMAvail() : Long.parseLong(config.get(RESOURCE.MEM_RAM_TOTAL)));
		setTotalRAMUsed(config.get(RESOURCE.MEM_RAM_USED) == null ? getTotalRAMUsed() : Long.parseLong(config.get(RESOURCE.MEM_RAM_USED)));
		setTotalRAMFree(config.get(RESOURCE.MEM_RAM_FREE) == null ? getTotalRAMFree() : Long.parseLong(config.get(RESOURCE.MEM_RAM_FREE)));
		setTotalRAMShared(config.get(RESOURCE.MEM_RAM_SHARED) == null ? getTotalRAMShared() : Long.parseLong(config.get(RESOURCE.MEM_RAM_SHARED)));
		setTotalRAMBuffered(config.get(RESOURCE.MEM_RAM_BUFFERED) == null ? getTotalRAMBuffered() : Long.parseLong(config.get(RESOURCE.MEM_RAM_BUFFERED)));
		setTotalCachedMem(config.get(RESOURCE.MEM_RAM_CACHED) == null ? getTotalCachedMem() : Long.parseLong(config.get(RESOURCE.MEM_RAM_CACHED)));
	}
	
	public long getTotalSwapSize() {
		return totalSwapSize;
	}
	public void setTotalSwapSize(long totalSwapSize) {
		this.totalSwapSize = totalSwapSize;
	}
	public long getAvailSwapSize() {
		return availSwapSize;
	}
	public void setAvailSwapSize(long availSwapSize) {
		this.availSwapSize = availSwapSize;
	}
	
	public long getUsedSwapSize() {
		return totalSwapSize - availSwapSize;
	}
	
	public long getTotalRAMAvail() {
		return totalRAMAvail;
	}
	public void setTotalRAMAvail(long totalRAMAvail) {
		this.totalRAMAvail = totalRAMAvail;
	}
	public long getTotalRAMUsed() {
		return totalRAMUsed;
	}
	public void setTotalRAMUsed(long totalRAMUsed) {
		this.totalRAMUsed = totalRAMUsed;
	}
	public long getTotalRAMFree() {
		return totalRAMFree;
	}
	public void setTotalRAMFree(long totalRAMFree) {
		this.totalRAMFree = totalRAMFree;
	}
	public long getTotalRAMShared() {
		return totalRAMShared;
	}
	public void setTotalRAMShared(long totalRAMShared) {
		this.totalRAMShared = totalRAMShared;
	}
	public long getTotalRAMBuffered() {
		return totalRAMBuffered;
	}
	public void setTotalRAMBuffered(long totalRAMBuffered) {
		this.totalRAMBuffered = totalRAMBuffered;
	}
	public long getTotalCachedMem() {
		return totalCachedMem;
	}
	public void setTotalCachedMem(long totalCachedMem) {
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
		return new Long((100 * getTotalRAMUsed()) / (getTotalRAMUsed() + getTotalRAMFree())).intValue();
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
