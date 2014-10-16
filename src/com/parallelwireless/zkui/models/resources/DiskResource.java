package com.parallelwireless.zkui.models.resources;

public class DiskResource implements SystemResource {

	String diskMountPath        = ""; // .1.3.6.1.4.1.2021.9.1.2.1
	String partitionDevPath     = ""; // .1.3.6.1.4.1.2021.9.1.3.1
	int    totalPartSizeInBytes =  0; // .1.3.6.1.4.1.2021.9.1.6.1
	int    availableDiskInBytes =  0; // .1.3.6.1.4.1.2021.9.1.7.1    e.g. #snmpget -v 1 -c "community" target_name_or_ip .1.3.6.1.4.1.2021.9.1.7.1
	int    usedDiskSpaceInBytes =  0; // .1.3.6.1.4.1.2021.9.1.8.1
	int    percentSpaceUsed     =  0; // .1.3.6.1.4.1.2021.9.1.9.1
	int    percentInodeUsed     =  0; // .1.3.6.1.4.1.2021.9.1.10.1
	
	ResourceConfig cfg;
	
	public DiskResource() {	
	}
	
	@Override
	public void addResources(ResourceConfig config) throws Exception{
		diskMountPath = config.get(RESOURCE.DISK_MOUNT_PATH) == null ? diskMountPath : config.get(RESOURCE.DISK_MOUNT_PATH);
		partitionDevPath = config.get(RESOURCE.DISK_PART_DEV_PATH) == null ? partitionDevPath : config.get(RESOURCE.DISK_PART_DEV_PATH);
		totalPartSizeInBytes = config.get(RESOURCE.DISK_PART_TOTAL_SIZE) == null ? totalPartSizeInBytes : config.get(RESOURCE.DISK_PART_TOTAL_PATH);
		availableDiskInBytes = config.get(RESOURCE.DISK_TOTAL_FREE) == null ? availableDiskInBytes : Integer.parseInt(config.get(RESOURCE.DISK_TOTAL_FREE));
		usedDiskSpaceInBytes = config.get(RESOURCE.DISK_TOTAL_USED) == null ? usedDiskSpaceInBytes : Integer.parseInt(config.get(RESOURCE.DISK_TOTAL_USED));
		percentSpaceUsed = config.get(RESOURCE.DISK_SPACE_USED_PCT) == null ? percentSpaceUsed : Integer.parseInt(config.get(RESOURCE.DISK_USED_PCT));
		percentInodeUsed = comfig.get(RESOURCE.DISK_INODE_USED_PCT) == null ? percentInodeUsed : Integer.parseInt(config.get(RESOURCE.DISK_INODE_USED_PCT));
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
