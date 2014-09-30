package com.parallelwireless.zkui.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.chart.Series;
import org.zkoss.chart.model.ChartsModel;
import org.zkoss.chart.model.DefaultPieModel;

import com.parallelwireless.zkui.models.ChartDataModelFactory.TYPE;
import com.parallelwireless.zkui.models.CwsModel.CWS_TYPE;

public class UnimanageDataUtil {

	static NetworkMap uniclouds = new NetworkMap();
	static {
		uniclouds.put(1, new UnicloudModel(1, "Unicloud EH", "10.10.10.122", 1));
		uniclouds.put(2, new UnicloudModel(2, "Unicloud 2", "10.10.10.128", 1));
		uniclouds.put(3, new UnicloudModel(3, "Unicloud 3", "10.10.10.3", 3));
		uniclouds.put(4, new UnicloudModel(4, "Unicloud 4", "10.10.10.4", 4));
	}
	static {
		uniclouds.get(1).getCwsList().add(new CwsModel("cws-uceh-1", 1, "10.11.1.1", NetworkDevice.TYPE.cws_mesh, 0));
		uniclouds.get(1).getCwsList().add(new CwsModel("cws-uceh-2", 1, "10.11.1.2", NetworkDevice.TYPE.cws_mesh, 0));
		uniclouds.get(1).getCwsList().add(new CwsModel("cws-uceh-3", 1, "10.11.1.3", NetworkDevice.TYPE.cws_gw, 0));
		uniclouds.get(1).getCwsList().add(new CwsModel("cws-uceh-3", 1, "10.11.1.3", NetworkDevice.TYPE.cws_gw, 60));
		uniclouds.get(2).getCwsList().add(new CwsModel("cws-uc2-1", 2, "10.11.2.4", NetworkDevice.TYPE.cws_mesh, 0));
		uniclouds.get(2).getCwsList().add(new CwsModel("cws-uc2-2", 2, "10.11.2.5", NetworkDevice.TYPE.cws_gw, 60));
		uniclouds.get(2).getCwsList().add(new CwsModel("cws-uc2-3", 2, "10.11.2.6", NetworkDevice.TYPE.cws_gw, 60));
		uniclouds.get(2).getCwsList().add(new CwsModel("cws-uc2-4", 2, "10.11.2.7", NetworkDevice.TYPE.cws_mesh, 0));
		uniclouds.get(3).getCwsList().add(new CwsModel("cws-uc3-1", 3, "10.11.3.8", NetworkDevice.TYPE.cws_gw, 0));
		uniclouds.get(3).getCwsList().add(new CwsModel("cws-uc3-2", 3, "10.11.3.9", NetworkDevice.TYPE.cws_mesh, 60));
		uniclouds.get(3).getCwsList().add(new CwsModel("cws-uc3-3", 3, "10.11.3.10", NetworkDevice.TYPE.cws_mesh, 0));
		uniclouds.get(4).getCwsList().add(new CwsModel("cws-uc4-1", 4, "10.11.4.11", NetworkDevice.TYPE.cws_gw, 0));
		uniclouds.get(4).getCwsList().add(new CwsModel("cws-uc4-2", 4, "10.11.4.12", NetworkDevice.TYPE.cws_mesh, 0));
		uniclouds.get(4).getCwsList().add(new CwsModel("cws-uc4-3", 4, "10.11.4.13", NetworkDevice.TYPE.cws_gw, 60));
	}
	static NetworkSummary networkSummary = new NetworkSummary(uniclouds);
	
	public static UnicloudModel getUnicloud(int id) {
		return uniclouds.get(id);
	}
	
	public static Collection<UnicloudModel> getAllUniclouds() {
		return uniclouds.values();
	}
	
	public static NetworkSummary getNetworkSummary() {
		return networkSummary;
	}
}
