package com.parallelwireless.zkui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.zkoss.chart.Chart;
import org.zkoss.chart.Charts;
import org.zkoss.chart.Color;
import org.zkoss.chart.Point;
import org.zkoss.chart.Series;
import org.zkoss.chart.plotOptions.ColumnPlotOptions;
import org.zkoss.chart.plotOptions.DataLabels;
import org.zkoss.chart.plotOptions.PiePlotOptions;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import com.parallelwireless.zkui.models.NetworkSummary;
import com.parallelwireless.zkui.models.UnimanageDataUtil;

public class NetworkStatusDonutController extends SelectorComposer<Div>{

	@Wire
	Charts chart;
	
	public void doAfterCompose(Div d) throws Exception {
		super.doAfterCompose(d);

		chart.getYAxis().setTitle("Network Status By Device");
		chart.getPlotOptions().getPie().setShadow(false);
		chart.getPlotOptions().getPie().setCenter("50%", "50%");
		initSeries();
	}
	
	private void initSeries() {
		NetworkSummary summary = UnimanageDataUtil.getNetworkSummary();
		
		Series allDevices = chart.getSeries();
		Series netDevMap  = chart.getSeries(1);
		
		allDevices.setName("All Devices");
		List<Color> colors = chart.getColors();
		int i=0;
		for(Map.Entry<String, Integer> devTypeEntry : summary.getAllDevs().entrySet()) {
			String key = devTypeEntry.getKey();
			Integer value = devTypeEntry.getValue();
			Point p = new Point(key, value);
			p.setColor(colors.get(i));
			if(value < 5) {
				p.getDataLabels().setEnabled(false);
			}
			allDevices.addPoint(p);
			for(Map.Entry<String, Integer> netDev : summary.getDevices(key).entrySet()) {
				if(netDev.getValue() == null)
					continue;
				Integer devVal = netDev.getValue();
				Point devPoint = new Point(netDev.getKey(), devVal);
				devPoint.setColor(colors.get(i));
				if(devVal < 1) {
					devPoint.getDataLabels().setEnabled(false);
				}
				netDevMap.addPoint(devPoint);
			}
			i += 1;
		}
		PiePlotOptions devPlotOptions = new PiePlotOptions();
		devPlotOptions.setSize("60%");
		allDevices.setPlotOptions(devPlotOptions);
		DataLabels devLabels = allDevices.getDataLabels();
		devLabels.setFormat("{point.name}");
		devLabels.setColor("white");
		devLabels.setDistance(-30);
		PiePlotOptions netPlotOptions = new PiePlotOptions();
		netPlotOptions.setSize("80%");
		netPlotOptions.setInnerSize("60%");
		netDevMap.setPlotOptions(netPlotOptions);
		netDevMap.getDataLabels().setFormat("<b>{point.name}:</b> {point.y}");
	}
}
