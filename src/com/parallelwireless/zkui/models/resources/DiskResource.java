package com.parallelwireless.zkui.models.resources;

import java.text.DecimalFormat;
import java.util.Comparator;

public class DiskResource implements SystemResource, Comparator<DiskResource> {

	private final static long KB = 1024;
	private final static long MB = 1024*KB;
	private final static long GB = 1024*MB;
	private final static long TB = 1024*GB;
			
	String diskMountPath        = ""; // .1.3.6.1.4.1.2021.9.1.2.1
	String partitionDevPath     = ""; // .1.3.6.1.4.1.2021.9.1.3.1
	long   totalPartSizeInBytes =  0; // .1.3.6.1.4.1.2021.9.1.6.1
	long   availableDiskInBytes =  0; // .1.3.6.1.4.1.2021.9.1.7.1    e.g. #snmpget -v 1 -c "community" target_name_or_ip .1.3.6.1.4.1.2021.9.1.7.1
	long   usedDiskSpaceInBytes =  0; // .1.3.6.1.4.1.2021.9.1.8.1
	int    percentSpaceUsed     =  0; // .1.3.6.1.4.1.2021.9.1.9.1
	int    percentInodeUsed     =  0; // .1.3.6.1.4.1.2021.9.1.10.1
	String systemName;
	ResourceConfig cfg;
	
	public DiskResource(String systemName) {
		this.systemName = systemName;
	}
	
	@Override
	public void addResources(ResourceConfig config) throws Exception{
		diskMountPath = config.get(RESOURCE.DISK_MOUNT_PATH) == null ? diskMountPath : config.get(RESOURCE.DISK_MOUNT_PATH);
		partitionDevPath = config.get(RESOURCE.DISK_PART_DEV_PATH) == null ? partitionDevPath : config.get(RESOURCE.DISK_PART_DEV_PATH);
		totalPartSizeInBytes = config.get(RESOURCE.DISK_TOTAL_PART_SIZE) == null ? totalPartSizeInBytes : Long.parseLong(config.get(RESOURCE.DISK_TOTAL_PART_SIZE));
		availableDiskInBytes = config.get(RESOURCE.DISK_AVAIL_BYTES) == null ? availableDiskInBytes : Long.parseLong(config.get(RESOURCE.DISK_AVAIL_BYTES));
		usedDiskSpaceInBytes = config.get(RESOURCE.DISK_USED_BYTES) == null ? usedDiskSpaceInBytes : Long.parseLong(config.get(RESOURCE.DISK_USED_BYTES));
		percentSpaceUsed = config.get(RESOURCE.DISK_SPACE_USED_PCT) == null ? percentSpaceUsed : Integer.parseInt(config.get(RESOURCE.DISK_SPACE_USED_PCT));
		percentInodeUsed = config.get(RESOURCE.DISK_INODE_USED_PCT) == null ? percentInodeUsed : Integer.parseInt(config.get(RESOURCE.DISK_INODE_USED_PCT));
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

	public long getTotalPartSizeInBytes() {
		return totalPartSizeInBytes;
	}

	public void setTotalPartSizeInBytes(long totalPartSizeInBytes) {
		this.totalPartSizeInBytes = totalPartSizeInBytes;
	}

	public long getAvailableDiskInBytes() {
		return availableDiskInBytes;
	}

	public void setAvailableDiskInBytes(long availableDiskInBytes) {
		this.availableDiskInBytes = availableDiskInBytes;
	}

	public long getUsedDiskSpaceInBytes() {
		return usedDiskSpaceInBytes;
	}

	public void setUsedDiskSpaceInBytes(long usedDiskSpaceInBytes) {
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
	
	public String getSystemName() {
		return systemName;
	}
	
	public String getUsedDiskSpaceHR() {
		return humanize(getUsedDiskSpaceInBytes());
	}
	
	public String getFreeDiskSpaceHR() {
		return humanize(getAvailableDiskInBytes());
	}
	
	public String getTotalDiskSpaceHR() {
		return humanize(getAvailableDiskInBytes() + getUsedDiskSpaceInBytes());
	}
	

	public String humanize(long bytes) {
		String hr = null;
		if(bytes > TB) {
			hr = new DecimalFormat("##.## TB").format(bytes/TB);
		} else if(bytes > GB) {
			hr = new DecimalFormat("##.## GB").format(bytes/GB);
		} else if(bytes > MB) {
			hr = new DecimalFormat("##.## MB").format(bytes/MB);
		} else if(bytes > KB) {
			hr = new DecimalFormat("##.## KB").format(bytes/KB);
		} else {
			hr = String.valueOf(bytes).concat(" B");
		}
		return hr;
	}
	
	@Override
	public int compare(DiskResource o1, DiskResource o2) {
		Integer disk1 = getPercentSpaceUsed();
		Integer disk2 = getPercentSpaceUsed();
		return disk2.compareTo(disk1);
	}
}
