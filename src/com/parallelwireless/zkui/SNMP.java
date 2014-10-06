package com.parallelwireless.zkui;

public class SNMP {
	
	public static enum NET_DEVICE_OID {
		SYS_ONE_MIN_LOAD(".1.3.6.1.4.1.2021.10.1.3.1"),
		SYS_FIVE_MIN_LOAD(".1.3.6.1.4.1.2021.10.1.3.1"),
		SYS_FIFTEN_MIN_LOAD(".1.3.6.1.4.1.2021.10.1.3.1"),
		CPU_PERCENT_USER(".1.3.6.1.4.1.2021.11.9.0"),
		CPU_RAW_USER(".1.3.6.1.4.1.2021.11.50.0"),
		CPU_PERCENT_SYS(".1.3.6.1.4.1.2021.11.10.0"),
		CPU_RAW_SYS(".1.3.6.1.4.1.2021.11.52.0"),
		CPU_PERCENT_IDLE(".1.3.6.1.4.1.2021.11.11.0"),
		CPU_RAW_IDLE(".1.3.6.1.4.1.2021.11.53.0"),
		CPU_RAW_NICE(".1.3.6.1.4.1.2021.11.51.0"),
		MEM_TOTAL_SWAP(".1.3.6.1.4.1.2021.4.3.0"),
		MEM_AVAIL_SWAP(".1.3.6.1.4.1.2021.4.4.0"),
		MEM_AVAIL_RAM(".1.3.6.1.4.1.2021.4.5.0"),
		MEM_USED_RAM(".1.3.6.1.4.1.2021.4.6.0"),
		MEM_FREE_RAM(".1.3.6.1.4.1.2021.4.11.0"),
		MEM_SHARED_RAM(".1.3.6.1.4.1.2021.4.13.0"),
		MEM_BUFFERED_RAM(".1.3.6.1.4.1.2021.4.14.0"),
		MEM_CACHED_MEM(".1.3.6.1.4.1.2021.4.15.0"),
		DISK_MOUNT_PATH(".1.3.6.1.4.1.2021.9.1.2.1"),
		PART_DEV_PATH(".1.3.6.1.4.1.2021.9.1.3.1"),
		TOTAL_PART_SIZE_BYTES(".1.3.6.1.4.1.2021.9.1.6.1"),
		AVAIL_DISK_BYTES(".1.3.6.1.4.1.2021.9.1.7.1"),
		USED_DISK_BYTES(".1.3.6.1.4.1.2021.9.1.8.1"),
		PERCENT_SPACE_USED(".1.3.6.1.4.1.2021.9.1.9.1"),
		PERCENT_INODE_USED(".1.3.6.1.4.1.2021.9.1.10.1");
		
		private String oidString;
		public String getOidString() {
			return oidString;
		}
		private NET_DEVICE_OID(String oidString) {
			this.oidString = oidString;
		}
	}
}
