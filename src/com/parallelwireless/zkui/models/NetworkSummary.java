package com.parallelwireless.zkui.models;

import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.zkoss.chart.model.DefaultPieModel;
import org.zkoss.chart.model.PieModel;

import com.parallelwireless.zkui.models.NetworkDevice.ROLE;
import com.parallelwireless.zkui.models.NetworkDevice.TYPE;

public class NetworkSummary {
	NetworkMap nmap;

	Map<String,Integer> all       = new TreeMap<String,Integer>();
	Map<String,Integer> uniclouds = new TreeMap<String,Integer>();
	Map<String,Integer> cwss      = new TreeMap<String,Integer>();
	Map<String,Integer> cwsGW     = new TreeMap<String, Integer>();
	Map<String,Integer> cwsMesh   = new TreeMap<String, Integer>();
		
	private PieModel ddModel;
	private Map<NetworkDevice.ROLE, Integer> allDevices;
	private List<NetworkDeviceStatusBucket> networkDevices;
	private Map<String, Integer> allDevs;
	private Map<String, TreeMap<String, Integer>> netDevMap;
	
	public NetworkSummary(NetworkMap nmap) {
		this.nmap = nmap;
		all.put("up", 0);
		all.put("down", 0);
		uniclouds.put("up",  0);
		uniclouds.put("down", 0);
		cwss.put("up",  0);
		cwss.put("down",  0);
		cwsGW.put("up", 0);
		cwsGW.put("down",  0);
		cwsMesh.put("up", 0);
		cwsMesh.put("down", 0);
		processNmap();
		createDrilldownPieChart();
		// createDonutPieChart();
	}

	private void processNmap() {
		for(Integer ucId : nmap.keySet()) {
			UnicloudModel uc = nmap.get(ucId);
			if(uc.isUp()) {
				uniclouds.put("up", uniclouds.get("up") + 1);
			} else {
				uniclouds.put("down", uniclouds.get("down") + 1);
			}
			for(CwsModel cws : uc.getCwsList()) {
				if(cws.isUp()) {
					cwss.put("up", cwss.get("up") + 1);
					if(cws.getRole() == NetworkDevice.ROLE.CWS_GW) {
						cwsGW.put("up", cwsGW.get("up") + 1);
					} else {
						cwsMesh.put("up", cwsMesh.get("up") + 1);
					}
				} else {
					cwss.put("down", cwss.get("down") +1);
					if(cws.getRole() == NetworkDevice.ROLE.CWS_GW) {
						cwsGW.put("down", cwsGW.get("down") + 1);
					} else {
						cwsMesh.put("down", cwsMesh.get("down") + 1);
					}					
				}
			}
		}
		all.put("up", uniclouds.get("up") + cwss.get("up"));
		all.put("down",  uniclouds.get("down") + cwss.get("down"));
	}
	
	public Map<String,Integer> getAll() {
		return all;
	}
	
	public Map<String,Integer> getUniclouds() {
		return uniclouds;
	}
	
	public Map<String,Integer> getCwss() {
		return cwss;
	}
	
	public int getUnicloudCount() {
		return uniclouds.get("up") + uniclouds.get("down");
	}
	
	public int getCwsTotalCount() {
		return cwss.get("up") + cwss.get("down");
	}
	
	public int getCwsMeshCount() {
		return cwsMesh.get("up") + cwsMesh.get("down");
	}
	
	public int getCwsGwCount() {
		return cwsGW.get("up") + cwsGW.get("down");
	}
	
	public List<NetworkSummaryRow> getSummaryRows() {
		List<NetworkSummaryRow> rows = new LinkedList<NetworkSummaryRow>();
		rows.add(new NetworkSummaryRow("All Devices", all.get("up"), all.get("down")));
		rows.add(new NetworkSummaryRow("Uniclouds", uniclouds.get("up"), uniclouds.get("down")));
		rows.add(new NetworkSummaryRow("CWS (GW)", cwsGW.get("up"), cwsGW.get("down")));
		rows.add(new NetworkSummaryRow("CWS (Mesh)", cwsMesh.get("up"), cwsMesh.get("down")));
		return rows;
	}

	public PieModel getAllDevicesChart() {
		PieModel model = new DefaultPieModel();
		model.setValue("Uni-Clouds", getUnicloudCount());
		model.setValue("CWSs", getCwsTotalCount());
		return model;
	}
	
	public PieModel getUnicloudStatusChart() {
		PieModel model = new DefaultPieModel();
		model.setValue("up", uniclouds.get("up"));
		model.setValue("down", uniclouds.get("down"));
		return model;
	}
	
	public PieModel getCwsStatusChart() {
		PieModel model = new DefaultPieModel();
		model.setValue("up", cwss.get("up"));
		model.setValue("down", cwss.get("down"));
		return model;
	}
	
	public PieModel getCwsGwStatusChart() {
		PieModel model = new DefaultPieModel();
		model.setValue("up", cwsGW.get("up"));
		model.setValue("down", cwsGW.get("down"));
		return model;
	}
	
	public PieModel getCwsMeshStatusChart() {
		PieModel model = new DefaultPieModel();
		model.setValue("up", cwsMesh.get("up"));
		model.setValue("down", cwsMesh.get("down"));
		return model;
	}
	
	private void createDonutPieChart() {
		allDevs    = new TreeMap<String, Integer>();
		netDevMap  = new TreeMap<String, TreeMap<String, Integer>>();
		
		allDevs.put(NetworkDeviceStatusBucket.getLabel(NetworkDevice.ROLE.LAC), getUnicloudCount());
		allDevs.put(NetworkDeviceStatusBucket.getLabel(NetworkDevice.ROLE.CWS_GW), getCwsGwCount());
		allDevs.put(NetworkDeviceStatusBucket.getLabel(NetworkDevice.ROLE.CWS_MESH), getCwsMeshCount());
		
		TreeMap<String, Integer> uniclouds = new TreeMap<String, Integer>();
		uniclouds.put(NetworkDevice.STATUS.up.toString(), uniclouds.get("up"));
		uniclouds.put(NetworkDevice.STATUS.down.toString(), uniclouds.get("down"));
		netDevMap.put(NetworkDeviceStatusBucket.getLabel(NetworkDevice.ROLE.LAC), uniclouds);
		
		TreeMap<String, Integer> gw = new TreeMap<String, Integer>();
		gw.put(NetworkDevice.STATUS.up.toString(), cwsGW.get("up"));
		gw.put(NetworkDevice.STATUS.down.toString(), cwsGW.get("down"));
		netDevMap.put(NetworkDeviceStatusBucket.getLabel(NetworkDevice.ROLE.CWS_GW), gw);
		
		TreeMap<String, Integer> mesh = new TreeMap<String, Integer>();
		mesh.put(NetworkDevice.STATUS.up.toString(), cwsMesh.get("up"));
		mesh.put(NetworkDevice.STATUS.down.toString(), cwsMesh.get("down"));
		netDevMap.put(NetworkDeviceStatusBucket.getLabel(NetworkDevice.ROLE.CWS_MESH), mesh);
	}
	
	public Map<String, Integer> getAllDevs() {
		return allDevs;
	}
	
	public Map<String, Integer> getDevices(String deviceTypeLabel) {
		return netDevMap.get(deviceTypeLabel);
	}
	
	private void createDrilldownPieChart() {
		ddModel = getAllDevicesChart();
		
		allDevices = new TreeMap<NetworkDevice.ROLE, Integer>();
		allDevices.put(ROLE.LAC, getUnicloudCount());
		allDevices.put(ROLE.CWS_MESH, getCwsMeshCount());
		allDevices.put(ROLE.CWS_GW,  getCwsGwCount());
		
		networkDevices = new LinkedList<NetworkDeviceStatusBucket>();
		networkDevices.add(new NetworkDeviceStatusBucket(NetworkDevice.ROLE.LAC, NetworkDevice.STATUS.up, uniclouds.get("up")));
		networkDevices.add(new NetworkDeviceStatusBucket(NetworkDevice.ROLE.LAC, NetworkDevice.STATUS.down, uniclouds.get("down")));
		networkDevices.add(new NetworkDeviceStatusBucket(NetworkDevice.ROLE.CWS_MESH, NetworkDevice.STATUS.up, cwsMesh.get("up")));
		networkDevices.add(new NetworkDeviceStatusBucket(NetworkDevice.ROLE.CWS_MESH, NetworkDevice.STATUS.down, cwsMesh.get("down")));
		networkDevices.add(new NetworkDeviceStatusBucket(NetworkDevice.ROLE.CWS_GW, NetworkDevice.STATUS.up, cwsGW.get("up")));
		networkDevices.add(new NetworkDeviceStatusBucket(NetworkDevice.ROLE.CWS_GW, NetworkDevice.STATUS.down, cwsGW.get("down")));
	}
	
	public PieModel getPieModel() {
		return ddModel;
	}
	
	public Map<NetworkDevice.ROLE, Integer> getAllDevices() {
		return allDevices;
	}
	
	public List<NetworkDeviceStatusBucket> getNetworkDevices(NetworkDevice.ROLE role) {
		List<NetworkDeviceStatusBucket> result = new LinkedList<NetworkDeviceStatusBucket>();
		for(NetworkDeviceStatusBucket nd : networkDevices) {
			if(nd.getRole() == role) {
				result.add(nd);
			}
		}
		return result;
	}
}
