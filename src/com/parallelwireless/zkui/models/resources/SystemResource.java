package com.parallelwireless.zkui.models.resources;

public interface SystemResource {
	public enum RESOURCE {
		CPU_LOAD_ONE("oneMinLoad"),
		CPU_LOAD_FIVE("fiveMinLoad"),
		CPU_LOAD_FIFTEEN("fifteenMinLoad"),
		MEM_RAM_TOTAL("totalRAMAvail"),
		MEM_RAM_USED("totalRAMUsed"),
		MEM_RAM_FREE("totalRAMFree"),
		MEM_RAM_BUFFERED("totalRAMBuffered"),
		MEM_RAM_SHARED("totalRAMShared"),
		MEM_RAM_CACHED("totalCachedMem"),
		MEM_SWAP_FREE("totalSwapAvail"),
		MEM_SWAP_TOTAL("totalSwapSize"), 
		DISK_MOUNT_PATH("diskMountPath"),
		DISK_PART_DEV_PATH("partitionDevPath");

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
	
	public void addResources(ResourceConfig config) throws Exception;
}
