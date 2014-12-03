package com.parallelwireless.zkui.models;

import java.util.Comparator;

import com.parallelwireless.zkui.models.resources.CpuResource;
import com.parallelwireless.zkui.models.resources.DiskResource;
import com.parallelwireless.zkui.models.resources.GeneralResource;
import com.parallelwireless.zkui.models.resources.GeoLocation;
import com.parallelwireless.zkui.models.resources.GeoLocation.DEV_TYPE;
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
	private boolean    		uni  = true;
	
	public SysInfo(String systemName, boolean uni) {
		this.systemName = systemName;
		gen = new GeneralResource(systemName);
		cpu  = new CpuResource(systemName);
		mem  = new MemoryResource(systemName);
		disk = new DiskResource(systemName);
		net  = new NetworkResource(systemName);
		geo  = new GeoLocation(systemName, uni ? DEV_TYPE.UNICLOUD : DEV_TYPE.CWS);
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