package com.parallelwireless.zkui.models;

import java.util.Comparator;

import com.parallelwireless.zkui.models.NetworkDevice.ROLE;
import com.parallelwireless.zkui.models.NetworkDevice.TYPE;
import com.parallelwireless.zkui.models.resources.CpuResource;
import com.parallelwireless.zkui.models.resources.DiskResource;
import com.parallelwireless.zkui.models.resources.GeneralResource;
import com.parallelwireless.zkui.models.resources.GeoLocation;
import com.parallelwireless.zkui.models.resources.MemoryResource;
import com.parallelwireless.zkui.models.resources.NetworkResource;
import com.parallelwireless.zkui.models.resources.ResourceConfig;

public class SysInfo {
	

	String  systemName = "";
	private GeneralResource gen  = null;
	private CpuResource     cpu  = null;
	private MemoryResource  mem  = null; 
	private DiskResource    disk = null; 
	private NetworkResource net  = null;
	private GeoLocation     geo  = null;
	private TYPE			type;
	private ROLE    		role;
	
	// CPU count and speed -- added here for demo purposes...should be in CPU info
	int cpuCount = 4;
	String cpuSpeed = "3.2GHz";
	
	public SysInfo(String systemName, TYPE type, ROLE role) {
		this.systemName = systemName;
		this.role = role;
		this.type = type;
		gen = new GeneralResource(systemName);
		cpu  = new CpuResource(systemName);
		mem  = new MemoryResource(systemName);
		disk = new DiskResource(systemName);
		net  = new NetworkResource(systemName);
		geo  = new GeoLocation(systemName, type);
	}
	
	public void addResources(ResourceConfig config) {
		try {
			gen.addResources(config);
			cpu.addResources(config);
			mem.addResources(config);
			disk.addResources(config);
			net.addResources(config);
			geo.addResources(config);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public GeneralResource getGeneral() {
		return gen;
	}
	
	public CpuResource getCpu() {
		return cpu;
	}
	
	public MemoryResource getMem() {
		return mem;
	}
	
	public DiskResource getDisk() {
		return disk;
	}
	
	public NetworkResource getNetwork() {
		return net;
	}
	
	public GeoLocation getGeo() {
		return geo;
	}
	
	public int getCpuCount() {
		return cpuCount;
	}
	
	public void setCpuCount(int cpuCount) {
		this.cpuCount = cpuCount;
	}
	
	public String getCpuSpeed() {
		return cpuSpeed;
	}
	
	public void setCpuSpeed(String cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}
	
	public void setRole(ROLE role) {
		this.role = role;
	}
	
	public ROLE getRole() {
		return role;
	}
	
	public TYPE getType() {
		return type;
	}
	
	public void setType(TYPE type) {
		this.type = type;
	}
	
	public static class Comparators {
		
		public static Comparator<SysInfo> CPU = new Comparator<SysInfo>() {
			@Override
			public int compare(SysInfo s1, SysInfo s2) {
				Integer cpu1 = 100 - s1.cpu.getPercentIdleCPU();
				Integer cpu2 = 100 - s2.cpu.getPercentIdleCPU();
				return cpu1.compareTo(cpu2);
			}
		};
		
		public static Comparator<SysInfo> MEMORY = new Comparator<SysInfo>() {
			@Override
			public int compare(SysInfo s1, SysInfo s2) {
				Long ram1 = s1.mem.getTotalRAMAvail() - s1.mem.getTotalRAMAvail();
				Long ram2 = s1.mem.getTotalRAMFree() - s1.mem.getTotalRAMFree();
				return ram2.compareTo(ram1);
			}
		};
		
		public static Comparator<SysInfo> DISK = new Comparator<SysInfo>() {
			@Override
			public int compare(SysInfo s1, SysInfo s2) {
				Integer disk1 = s1.disk.getPercentSpaceUsed();
				Integer disk2 = s2.disk.getPercentSpaceUsed();
				return disk2.compareTo(disk1);
			}
		};
	}


}