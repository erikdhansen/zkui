package com.parallelwireless.zkui.models;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Comparator;

import com.parallelwireless.zkui.models.resources.CpuResource;
import com.parallelwireless.zkui.models.resources.DiskResource;
import com.parallelwireless.zkui.models.resources.MemoryResource;

public class SysInfo {
	


	CpuResource    cpu = new CpuResource();
	MemoryResource mem = new MemoryResource();
	DiskResource   disk = new DiskResource();
	
	public SysInfo() {	
	}

	public SysInfo(ResourceConfig config) {
		addResource(config);
	}
	
	public SysInfo addResource(ResourceConfig config) {
		
	}

	
	
	public SysInfo setMemoryStats(int ramTotal, int ramUsed, int ramFree, int swapTotal, int swapFree) {
		this.totalRAMAvail = ramTotal;
		this.totalRAMUsed = ramUsed;
		this.totalRAMFree = ramFree;
		this.totalSwapSize = swapTotal;
		this.availSwapSize = this.totalSwapSize - swapFree;
		System.out.println("SysInfo MemStats CREATED: " + dumpMemInfo());
		return this;
	}
	
	public CpuResource getCpu() {
		return cpu;
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
	


	public static class Comparators {
		
		public static Comparator<SysInfo> CPU = new Comparator<SysInfo>() {
			@Override
			public int compare(SysInfo s1, SysInfo s2) {
				Integer cpu1 = 100 - s1.getPercentIdleCPU();
				Integer cpu2 = 100 - s2.getPercentIdleCPU();
				return cpu1.compareTo(cpu2);
			}
		};
		
		public static Comparator<SysInfo> MEMORY = new Comparator<SysInfo>() {
			@Override
			public int compare(SysInfo s1, SysInfo s2) {
				Integer ram1 = s1.totalRAMAvail - s1.totalRAMFree;
				Integer ram2 = s1.totalRAMAvail - s1.totalRAMFree;
				return ram2.compareTo(ram1);
			}
		};
		
		public static Comparator<SysInfo> DISK = new Comparator<SysInfo>() {
			@Override
			public int compare(SysInfo s1, SysInfo s2) {
				Integer disk1 = s1.getPercentSpaceUsed();
				Integer disk2 = s2.getPercentSpaceUsed();
				return disk2.compareTo(disk1);
			}
		};
	}
}