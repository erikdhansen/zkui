package com.parallelwireless.zkui.models.resources;

public interface SystemResource {
	public enum RESOURCE {
		CPU_LOAD_ONE("oneMinLoad"),
		CPU_LOAD_FIVE("fiveMinLoad"),
		CPU_LOAD_FIFTEEN("fifteenMinLoad"),
		CPU_USER_PCT("percentUserCPU"),
		CPU_SYS_PCT("percentSysCPU"),
		CPU_IDLE_PCT("percentIdleCPU"),
		MEM_RAM_TOTAL("totalRAMAvail"),
		MEM_RAM_USED("totalRAMUsed"),
		MEM_RAM_FREE("totalRAMFree"),
		MEM_RAM_BUFFERED("totalRAMBuffered"),
		MEM_RAM_SHARED("totalRAMShared"),
		MEM_RAM_CACHED("totalCachedMem"),
		MEM_SWAP_FREE("totalSwapAvail"),
		MEM_SWAP_TOTAL("totalSwapSize"), 
		DISK_MOUNT_PATH("diskMountPath"),
		DISK_PART_DEV_PATH("partitionDevPath"),
		DISK_AVAIL_BYTES("availableDiskInBytes"),
		DISK_INODE_USED_PCT("percentInodeUsed"),
		DISK_SPACE_USED_PCT("percentSpaceUsed"),
		DISK_TOTAL_PART_SIZE("totalPartSizeInBytes"),
		DISK_USED_BYTES("usedDiskInBytes"),
		NET_INTF_NAME("interfaceName"),
		NET_LINK_SPEED("linkSpeed"),
		NET_RX_BYTES("rxBytes"),
		NET_TX_BYTES("txBytes"),
		NET_PCT_UTIL("percentUtilization"),
		NET_LAST10_PCT_UTIL("lastTenPercentUtilization");
		

			private final String resource;
			private RESOURCE(String s) {
				resource = s;
			}
			public boolean isResource(String otherResource) {
				return (otherResource == null) ? false : resource.equals(otherResource);
			}
			
			public String toString() {
				return resource;
			}
	};

	public String getSystemName();
	public void addResources(ResourceConfig config) throws Exception;
}
