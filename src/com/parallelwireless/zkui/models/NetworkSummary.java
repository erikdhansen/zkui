package com.parallelwireless.zkui.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.zkoss.chart.model.DefaultPieModel;
import org.zkoss.chart.model.PieModel;

import com.parallelwireless.zkui.models.NetworkDevice.TYPE;

public class NetworkSummary {
	NetworkMap nmap;

	Map<String,Integer> all = new HashMap<String,Integer>();
	Map<String,Integer> uniclouds = new HashMap<String,Integer>();
	Map<String,Integer> cwss = new HashMap<String,Integer>();
	Map<String,Integer> cwsGW = new HashMap<String, Integer>();
	Map<String,Integer> cwsMesh = new HashMap<String, Integer>();
		
	private PieModel ddModel;
	private Map<NetworkDevice.TYPE, Integer> allDevices;
	private List<NetworkDevice> networkDevices;
	private Map<String, Integer> allDevs;
	private Map<String, HashMap<String, Integer>> netDevMap;
	
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
					if(cws.getType() == NetworkDevice.TYPE.cws_gw) {
						cwsGW.put("up", cwsGW.get("up") + 1);
					} else {
						cwsMesh.put("up", cwsMesh.get("up") + 1);
					}
				} else {
					cwss.put("down", cwss.get("down") +1);
					if(cws.getType() == NetworkDevice.TYPE.cws_gw) {
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
		rows.add(new NetworkSummaryRow("CWS (total)", cwss.get("up"), cwss.get("down")));
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
		allDevs    = new HashMap<String, Integer>();
		netDevMap  = new HashMap<String, HashMap<String, Integer>>();
		
		allDevs.put(NetworkDeviceStatImpl.getLabel(NetworkDevice.TYPE.unicloud), getUnicloudCount());
		allDevs.put(NetworkDeviceStatImpl.getLabel(NetworkDevice.TYPE.cws_gw), getCwsGwCount());
		allDevs.put(NetworkDeviceStatImpl.getLabel(NetworkDevice.TYPE.cws_mesh), getCwsMeshCount());
		
		HashMap<String, Integer> uniclouds = new HashMap<String, Integer>();
		uniclouds.put(NetworkDevice.STATUS.up.toString(), uniclouds.get("up"));
		uniclouds.put(NetworkDevice.STATUS.down.toString(), uniclouds.get("down"));
		netDevMap.put(NetworkDeviceStatImpl.getLabel(NetworkDevice.TYPE.unicloud), uniclouds);
		
		HashMap<String, Integer> gw = new HashMap<String, Integer>();
		gw.put(NetworkDevice.STATUS.up.toString(), cwsGW.get("up"));
		gw.put(NetworkDevice.STATUS.down.toString(), cwsGW.get("down"));
		netDevMap.put(NetworkDeviceStatImpl.getLabel(NetworkDevice.TYPE.cws_gw), gw);
		
		HashMap<String, Integer> mesh = new HashMap<String, Integer>();
		mesh.put(NetworkDevice.STATUS.up.toString(), cwsMesh.get("up"));
		mesh.put(NetworkDevice.STATUS.down.toString(), cwsMesh.get("down"));
		netDevMap.put(NetworkDeviceStatImpl.getLabel(NetworkDevice.TYPE.cws_mesh), mesh);
	}
	
	public Map<String, Integer> getAllDevs() {
		return allDevs;
	}
	
	public Map<String, Integer> getDevices(String deviceTypeLabel) {
		return netDevMap.get(deviceTypeLabel);
	}
	
	private void createDrilldownPieChart() {
		ddModel = getAllDevicesChart();
		
		allDevices = new HashMap<NetworkDevice.TYPE, Integer>();
		allDevices.put(TYPE.unicloud, getUnicloudCount());
		allDevices.put(TYPE.cws_mesh, getCwsMeshCount());
		allDevices.put(TYPE.cws_gw,  getCwsGwCount());
		
		networkDevices = new LinkedList<NetworkDevice>();
		networkDevices.add(new NetworkDeviceStatImpl(NetworkDevice.TYPE.unicloud, NetworkDevice.STATUS.up, uniclouds.get("up")));
		networkDevices.add(new NetworkDeviceStatImpl(NetworkDevice.TYPE.unicloud, NetworkDevice.STATUS.down, uniclouds.get("down")));
		networkDevices.add(new NetworkDeviceStatImpl(NetworkDevice.TYPE.cws_mesh, NetworkDevice.STATUS.up, cwsMesh.get("up")));
		networkDevices.add(new NetworkDeviceStatImpl(NetworkDevice.TYPE.cws_mesh, NetworkDevice.STATUS.down, cwsMesh.get("down")));
		networkDevices.add(new NetworkDeviceStatImpl(NetworkDevice.TYPE.cws_gw, NetworkDevice.STATUS.up, cwsGW.get("up")));
		networkDevices.add(new NetworkDeviceStatImpl(NetworkDevice.TYPE.cws_gw, NetworkDevice.STATUS.down, cwsGW.get("down")));
	}
	
	public PieModel getPieModel() {
		return ddModel;
	}
	
	public Map<NetworkDevice.TYPE, Integer> getAllDevices() {
		return allDevices;
	}
	
	public List<NetworkDevice> getNetworkDevices(NetworkDevice.TYPE type) {
		List<NetworkDevice> result = new LinkedList<NetworkDevice>();
		for(NetworkDevice nd : networkDevices) {
			if(nd.getType() == type) {
				result.add(nd);
			}
		}
		return result;
	}
}
