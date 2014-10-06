package com.parallelwireless.zkui.models;

public class SysInfo {
	// System Resources			// Linux SNMP OIDs
	// Load						//
	String oneMinLoad      = "";  // .1.3.6.1.4.1.2021.10.1.3.1
	String fiveMinLoad     = "";  // .1.3.6.1.4.1.2021.10.1.3.2
	String fifteenMinLoad  = "";  // .1.3.6.1.4.1.2021.10.1.3.3
	
	// CPU
	int    percentUserCPU = 0;  // .1.3.6.1.4.1.2021.11.9.0
	long   rawUserCPU     = 0;  // .1.3.6.1.4.1.2021.11.50.0
	int    percentSysCPU  = 0;  // .1.3.6.1.4.1.2021.11.10.0
	long   rawSysCPU      = 0;  // .1.3.6.1.4.1.2021.11.52.0
	int    percentIdleCPU = 0;  // .1.3.6.1.4.1.2021.11.11.0
	long   rawIdleCPU     = 0;  // .1.3.6.1.4.1.2021.11.53.0
	long   rawNiceCPU     = 0;  // .1.3.6.1.4.1.2021.11.51.0
	
	// Memory
	int    totalSwapSize    = 0;  // .1.3.6.1.4.1.2021.4.3.0
	int    availSwapSize    = 0;  // .1.3.6.1.4.1.2021.4.4.0
	int    totalRAMAvail    = 0;  // .1.3.6.1.4.1.2021.4.5.0
	int    totalRAMUsed     = 0;  // .1.3.6.1.4.1.2021.4.6.0
	int    totalRAMFree     = 0;  // .1.3.6.1.4.1.2021.4.11.0
	int    totalRAMShared   = 0;  // .1.3.6.1.4.1.2021.4.13.0
	int    totalRAMBuffered = 0;  // .1.3.6.1.4.1.2021.4.14.0
	int    totalCachedMem   = 0;  // .1.3.6.1.4.1.2021.4.15.0
	
	String diskMountPath        = ""; // .1.3.6.1.4.1.2021.9.1.2.1
	String partitionDevPath     = ""; // .1.3.6.1.4.1.2021.9.1.3.1
	int    totalPartSizeInBytes =  0; // .1.3.6.1.4.1.2021.9.1.6.1
	int    availableDiskInBytes =  0; // .1.3.6.1.4.1.2021.9.1.7.1    e.g. #snmpget -v 1 -c "community" target_name_or_ip .1.3.6.1.4.1.2021.9.1.7.1
	int    usedDiskSpaceInBytes =  0; // .1.3.6.1.4.1.2021.9.1.8.1
	int    percentSpaceUsed     =  0; // .1.3.6.1.4.1.2021.9.1.9.1
	int    percentInodeUsed     =  0; // .1.3.6.1.4.1.2021.9.1.10.1
	

	public SysInfo() {	
	}


	public String getOneMinLoad() {
		return oneMinLoad;
	}


	public void setOneMinLoad(String oneMinLoad) {
		this.oneMinLoad = oneMinLoad;
	}


	public String getFiveMinLoad() {
		return fiveMinLoad;
	}


	public void setFiveMinLoad(String fiveMinLoad) {
		this.fiveMinLoad = fiveMinLoad;
	}


	public String getFifteenMinLoad() {
		return fifteenMinLoad;
	}


	public void setFifteenMinLoad(String fifteenMinLoad) {
		this.fifteenMinLoad = fifteenMinLoad;
	}


	public int getPercentUserCPU() {
		return percentUserCPU;
	}


	public void setPercentUserCPU(int percentUserCPU) {
		this.percentUserCPU = percentUserCPU;
	}


	public long getRawUserCPU() {
		return rawUserCPU;
	}


	public void setRawUserCPU(long rawUserCPU) {
		this.rawUserCPU = rawUserCPU;
	}


	public int getPercentSysCPU() {
		return percentSysCPU;
	}


	public void setPercentSysCPU(int percentSysCPU) {
		this.percentSysCPU = percentSysCPU;
	}


	public long getRawSysCPU() {
		return rawSysCPU;
	}


	public void setRawSysCPU(long rawSysCPU) {
		this.rawSysCPU = rawSysCPU;
	}


	public int getPercentIdleCPU() {
		return percentIdleCPU;
	}


	public void setPercentIdleCPU(int percentIdleCPU) {
		this.percentIdleCPU = percentIdleCPU;
	}


	public long getRawIdleCPU() {
		return rawIdleCPU;
	}


	public void setRawIdleCPU(long rawIdleCPU) {
		this.rawIdleCPU = rawIdleCPU;
	}


	public long getRawNiceCPU() {
		return rawNiceCPU;
	}


	public void setRawNiceCPU(long rawNiceCPU) {
		this.rawNiceCPU = rawNiceCPU;
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


	public String getDiskMountPath() {
		return diskMountPath;
	}


	public void setDiskMountPath(String diskMountPath) {
		this.diskMountPath = diskMountPath;
	}


	public String getPartitionDevPath() {
		return partitionDevPath;
	}


	public void setPartitionDevPath(String partitionDevPath) {
		this.partitionDevPath = partitionDevPath;
	}


	public int getTotalPartSizeInBytes() {
		return totalPartSizeInBytes;
	}


	public void setTotalPartSizeInBytes(int totalPartSizeInBytes) {
		this.totalPartSizeInBytes = totalPartSizeInBytes;
	}


	public int getAvailableDiskInBytes() {
		return availableDiskInBytes;
	}


	public void setAvailableDiskInBytes(int availableDiskInBytes) {
		this.availableDiskInBytes = availableDiskInBytes;
	}


	public int getUsedDiskSpaceInBytes() {
		return usedDiskSpaceInBytes;
	}


	public void setUsedDiskSpaceInBytes(int usedDiskSpaceInBytes) {
		this.usedDiskSpaceInBytes = usedDiskSpaceInBytes;
	}


	public int getPercentSpaceUsed() {
		return percentSpaceUsed;
	}


	public void setPercentSpaceUsed(int percentSpaceUsed) {
		this.percentSpaceUsed = percentSpaceUsed;
	}


	public int getPercentInodeUsed() {
		return percentInodeUsed;
	}


	public void setPercentInodeUsed(int percentInodeUsed) {
		this.percentInodeUsed = percentInodeUsed;
	}
	
	
}