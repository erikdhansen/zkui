package com.parallelwireless.zkui;

import java.util.List;
import java.util.Map;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Color;
import org.zkoss.chart.Point;
import org.zkoss.chart.RadialGradient;
import org.zkoss.chart.Series;
import org.zkoss.chart.plotOptions.DataLabels;
import org.zkoss.chart.plotOptions.PiePlotOptions;

import com.parallelwireless.zkui.AlarmSeverity.SEVERITY;
import com.parallelwireless.zkui.models.AlarmList;

public class AlarmChartSeverity {

	public static void init(Charts c, AlarmList data) {
		Series total = c.getSeries();
		total.setName("");
		Series byAck = c.getSeries(1);
		byAck.setName("");
		List<Color> colors = c.getColors();
		
		int i = 0;
		for(Map.Entry<AlarmSeverity.SEVERITY, Integer> sev : data.getTotalBySeverity().entrySet()) {
			SEVERITY s = sev.getKey();
			int sevCount = sev.getValue();
			Point sevPoint = new Point(s.toString(), sevCount);
			sevPoint.setColor(AlarmSeverity.getColorBySeverity(s));
			total.addPoint(sevPoint);
			for(Map.Entry<String, Integer> statusEntry : data.getStatusBySeverity(s).entrySet()) {
				int count = statusEntry.getValue();
				Point statPoint = new Point(statusEntry.getKey(), count);
				statPoint.setColor(AlarmSeverity.getColorBySeverity(s, statusEntry.getKey().equalsIgnoreCase("acked") ? true : false));
				if(count < 1) {
					statPoint.getDataLabels().setEnabled(false);
				}
				byAck.addPoint(statPoint);
			}
			i++;
		}
		PiePlotOptions sevPlotOptions = new PiePlotOptions();
		sevPlotOptions.setSize("60%");
		total.setPlotOptions(sevPlotOptions);
		DataLabels sevLabels = total.getDataLabels();
		sevLabels.setFormat("{point.name}");
		sevLabels.setColor("black");
		sevLabels.setDistance(-30);
		PiePlotOptions statOptions = new PiePlotOptions();
		statOptions.setSize("80%");
		statOptions.setInnerSize("60%");
		byAck.setPlotOptions(statOptions);
		byAck.getDataLabels().setFormat("<b>{point.name}:</b> {point.y}");
	}
}
