package com.parallelwireless.zkui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.zkoss.chart.Chart;
import org.zkoss.chart.Charts;
import org.zkoss.chart.Point;
import org.zkoss.chart.Series;
import org.zkoss.chart.plotOptions.ColumnPlotOptions;
import org.zkoss.chart.plotOptions.DataLabels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import com.parallelwireless.zkui.models.NetworkDevice;
import com.parallelwireless.zkui.models.NetworkDeviceStatusBucket;
import com.parallelwireless.zkui.models.NetworkSummary;
import com.parallelwireless.zkui.models.Unimanage;
import com.parallelwireless.zkui.models.UnimanageDataUtil;

public class NetworkStatusController extends SelectorComposer<Div>{

	@Wire
	Charts chart;
	
	NetworkSummary summary = UnimanageDataUtil.getNetworkSummary();
	
	public void doAfterCompose(Div d) throws Exception {
		super.doAfterCompose(d);
		
		DataLabels dataLabels = chart.getPlotOptions().getSeries().getDataLabels();
		dataLabels.setEnabled(true);
		dataLabels.setFormat("{point.name}: {point.y}");
		
		chart.getTooltip().setHeaderFormat("<span style=\"font-size: 11px\">{series.name}</span><br/>");
		chart.getTooltip().setPointFormat("<span style=\"color:{point.color}\">{point.name}" + "</span>: <b>{point.y}</b>");
		chart.setColors(Unimanage.DEFAULT_CHART_GRADIENTS);
		initSeriesDrilldown();
	}
	
	private void initSeriesDrilldown() {
		Series series = chart.getSeries();
		List<Series> drilldowns = new ArrayList<Series>();
		series.setName("Network Devices");
		ColumnPlotOptions plotOptions = new ColumnPlotOptions();
		plotOptions.setColorByPoint(true);
		series.setPlotOptions(plotOptions);
		Iterator<Entry<NetworkDevice.TYPE, Integer>> iterator = summary.getAllDevices().entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<NetworkDevice.TYPE, Integer> entry = iterator.next();
			String label = NetworkDeviceStatusBucket.getLabel(entry.getKey());
			Point point = new Point(label, entry.getValue());
			if(entry.getValue() > 1) {
				point.setDrilldown(label);
				List<NetworkDeviceStatusBucket> devices = summary.getNetworkDevices(entry.getKey());
				if(!devices.isEmpty()) {
					Series s = new Series();
					s.setId(label);
					for(NetworkDeviceStatusBucket n : devices) {
						Point p = new Point((n.isUp() ? "UP" : "DOWN"), n.getCount());
						s.addPoint(p);
					}
					drilldowns.add(s);
				}
			}
			series.addPoint(point);
		}
		chart.getDrilldown().setSeries(drilldowns);
	}
}
