package com.parallelwireless.zkui;

import java.util.LinkedList;
import java.util.List;

import org.zkoss.chart.Chart;
import org.zkoss.chart.Charts;
import org.zkoss.chart.Color;
import org.zkoss.chart.RadialGradient;
import org.zkoss.chart.Theme;
import org.zkoss.chart.plotOptions.PieDataLabels;
import org.zkoss.chart.plotOptions.PiePlotOptions;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Window;

import com.parallelwireless.zkui.AlarmSeverity.SEVERITY;
import com.parallelwireless.zkui.models.AlarmDataUtil;
import com.parallelwireless.zkui.models.AlarmList;

@SuppressWarnings("serial")
public class AlarmSummaryChartComposer extends SelectorComposer<Groupbox                   > {
   
	@Wire
	Charts summary;
	@Wire
	Charts severities;
	@Wire
	Charts device;
	
	public void doAfterCompose(Groupbox comp) throws Exception {
		super.doAfterCompose(comp);
		initChart(summary);
		AlarmList alarms = AlarmDataUtil.getAlarms();
		AlarmChartData.summary(summary.getSeries(), alarms);
		AlarmChartSeverity.init(severities, alarms);
//		AlarmChartDevice.init(device, new AlarmDeviceData());						  
	}
	
	private void initChart(Charts c) {
		Chart s = c.getChart();
		s.setPlotBorderWidth(0);
		s.setPlotShadow(true);
		c.getTooltip().setPointFormat("{series.name}: <b>{point.value}</b>");
		
		PiePlotOptions p = c.getPlotOptions().getPie();
		p.setAllowPointSelect(true);
		p.setCursor("pointer");
		PieDataLabels dl = (PieDataLabels)p.getDataLabels();
		dl.setEnabled(true);
		dl.setColor("#000000");
		dl.setConnectorColor("#000000");
		dl.setFormat("<b>{point.name}</b>: {point.y} %");
		initGradientColors(c);
	}
	
    private void initGradientColors(Charts c) {
        List<Color> gradientColors = new LinkedList<Color>();
        String[][] colors = {
                {"#f1c40f", "#f39c12"},
                {"#3498db", "#2980b9"},
                {"#e67e22", "#d35400"},
                {"#1abc9c", "#16a085"},
                {"#2ecc71", "#27ae60"},
                {"#e74c3c", "#c0392b"}
        };
        for (String[] color: colors) {
            RadialGradient radialGradient = new RadialGradient(0.5, 0.3, 0.7);
            radialGradient.setStops(color[0], color[1]);
            gradientColors.add(new Color(radialGradient));
        }
        c.setColors(gradientColors);
    }
    
}
