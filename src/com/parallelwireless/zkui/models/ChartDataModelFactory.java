package com.parallelwireless.zkui.models;

import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.ChartsModel;
import org.zkoss.chart.model.DefaultCategoryModel;
import org.zkoss.chart.model.DefaultPieModel;
import org.zkoss.chart.model.DefaultXYModel;
import org.zkoss.chart.model.DefaultXYZModel;
import org.zkoss.chart.model.PieModel;
import org.zkoss.chart.model.XYModel;
import org.zkoss.chart.model.XYZModel;


public class ChartDataModelFactory {

	ChartDataModelFactory me = new ChartDataModelFactory();
	
	PieModel      pie = null;
	CategoryModel category = null;
	XYModel       xy = null;
	XYZModel      xyz = null;
	
	public enum TYPE {
		pie,
		category,
		xy,
		xyz
	};
	
	private ChartDataModelFactory() {
		me = this;
	}
	
	public static ChartsModel getNewChartDataModel(TYPE type) {
		ChartsModel dataModel = null;
		
		switch(type) {
		case pie:
			return new DefaultPieModel();
		case category:
			return new DefaultCategoryModel();
		case xy:
			return new DefaultXYModel();
		case xyz:
			return new DefaultXYZModel();
		default:
			dataModel = new DefaultXYModel();
		}
		return dataModel;
	}
}
