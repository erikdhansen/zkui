package com.parallelwireless.zkui.models.resources;

public class CpuResource implements SystemResource {
	String systemName;
	
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

	public CpuResource(String systemName) {
		this.systemName = systemName;
	}
	
	@Override
	public void addResources(ResourceConfig cfg) throws Exception {
		oneMinLoad     = cfg.get(RESOURCE.CPU_LOAD_ONE)     == null ? oneMinLoad : cfg.get(RESOURCE.CPU_LOAD_ONE);
		fiveMinLoad    = cfg.get(RESOURCE.CPU_LOAD_FIVE)    == null ? fiveMinLoad : cfg.get(RESOURCE.CPU_LOAD_FIVE);
		fifteenMinLoad = cfg.get(RESOURCE.CPU_LOAD_FIFTEEN) == null ? fifteenMinLoad : cfg.get(RESOURCE.CPU_LOAD_FIFTEEN);
		percentUserCPU = cfg.get(RESOURCE.CPU_USER_PCT)     == null ? percentUserCPU : Integer.parseInt(cfg.get(RESOURCE.CPU_USER_PCT));
		percentSysCPU  = cfg.get(RESOURCE.CPU_SYS_PCT)   == null ? percentSysCPU : Integer.parseInt(cfg.get(RESOURCE.CPU_SYS_PCT));
		percentIdleCPU = cfg.get(RESOURCE.CPU_IDLE_PCT)     == null ? percentIdleCPU : Integer.parseInt(cfg.get(RESOURCE.CPU_IDLE_PCT));
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

	public int getPercentCPUTotal() {
		return getPercentUserCPU() + getPercentSysCPU();
	}
	
	@Override
	public String getSystemName() {
		return systemName;
	}		
}
