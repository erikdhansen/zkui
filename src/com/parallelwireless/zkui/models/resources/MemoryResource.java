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
	
	static final long KB = 1024;
	static final long MB = KB * 1024;
	static final long GB = MB * 1024;
	static final long TB = GB * 1024;
	
	public MemoryResource(String systemName) {
		this.systemName = systemName;
		CRITICAL = 87;
		MAJOR    = 75;
		MINOR    = 70;		
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

	public String getTotalRAMAvailHR() {
		return humanize(totalRAMAvail);
	}
	
	public String getTotalRAMUsedHR() {
		return humanize(totalRAMUsed);
	}
	
	public String getTotalRAMFreeHR() {
		return humanize(totalRAMFree);
	}
	
	public String getTotalSwapSizeHR() {
		return humanize(totalSwapSize);
	}
	
	public String getUsedSwapSizeHR() {
		return humanize(getUsedSwapSize());
	}
	
	public String getAvailSwapSizeHR() {
		return humanize(availSwapSize);
	}
	
	public String humanize(long bytes) {
		String hr = null;
		// Display everything in MB -- regardless of value -- to three decimal places if necessary
		Double dubs = new Double(bytes);
		Double inMB = dubs / new Double(MB);
		hr = new DecimalFormat("#,###.##").format(inMB);
		return hr;
	}	
	
	public int getPercentUsed () {
		return new Long((100 * getTotalRAMUsed()) / getTotalRAMAvail()).intValue();
	}
	
	public int getMonitoredValue() {
		return getPercentUsed();
	}
	
	public String dumpMemInfo() {
		return "RAM: used=" + getTotalRAMUsedHR() + " free=" + getTotalRAMFreeHR() + " :: SWAP: used=" + getUsedSwapSizeHR() + " free=" + getAvailSwapSizeHR();
	}
	
	public String getSystemName() {
		return systemName;
	}
	
}
