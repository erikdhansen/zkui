package com.parallelwireless.zkui;

import java.util.LinkedList;
import java.util.List;

import org.zkoss.chart.Chart;
import org.zkoss.chart.Charts;
import org.zkoss.chart.Color;
import org.zkoss.chart.Point;
import org.zkoss.chart.RadialGradient;
import org.zkoss.chart.Series;
import org.zkoss.chart.plotOptions.PieDataLabels;
import org.zkoss.chart.plotOptions.PiePlotOptions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

@SuppressWarnings("serial")
public class ChartTestComposer extends SelectorComposer<Window>{
    @Wire
    Charts chart;
    
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);
        
        Chart chartOptional = chart.getChart();
        chartOptional.setBackgroundColor("");
        chartOptional.setPlotBorderWidth(0);
        chartOptional.setPlotShadow(false);
        
        chart.getTooltip().setPointFormat(
            "{series.name}: <b>{point.percentage:.1f}%</b>");
        
        PiePlotOptions pie = chart.getPlotOptions().getPie();
        
        pie.setAllowPointSelect(true);
        pie.setCursor("pointer");
        PieDataLabels dataLabels = (PieDataLabels) pie.getDataLabels();
        dataLabels.setEnabled(true);
        dataLabels.setColor("#000000");
        dataLabels.setConnectorColor("#000000");
        dataLabels.setFormat("<b>{point.name}</b>: {point.percentage} %");
        
        initGradientColors();
        initSeries();
    }
    
    private void initGradientColors() {
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
        chart.setColors(gradientColors);
    }
    
    private void initSeries() {
        Series series = chart.getSeries();
        series.setType("pie");
        series.setName("Browser share");
        series.addPoint(new Point("Firefox", 45.0));
        series.addPoint(new Point("IE", 26.8));
        Point chrome = new Point("Chrome", 12.8);
        chrome.setSelected(true);
        chrome.setSliced(true);
        series.addPoint(chrome);
        series.addPoint(new Point("Safari", 8.5));
        series.addPoint(new Point("Opera", 6.2));
        series.addPoint(new Point("Others", 0.7));
    }
}
