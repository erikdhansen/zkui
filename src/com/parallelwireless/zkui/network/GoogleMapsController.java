package com.parallelwireless.zkui.network;

import java.util.LinkedList;
import java.util.List;

import org.zkoss.gmaps.Gmaps;
import org.zkoss.gmaps.Gmarker;
import org.zkoss.gmaps.event.MapMouseEvent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import com.parallelwireless.zkui.models.CwsModel;
import com.parallelwireless.zkui.models.UnicloudModel;
import com.parallelwireless.zkui.models.UnimanageDataUtil;

@SuppressWarnings("serial")
public class GoogleMapsController extends SelectorComposer<Div>{
	
		@Wire
		Gmaps gmap;
	
		List<Gmarker> cwsList = new LinkedList<Gmarker>();
		
	   @Listen("onMapClick = #gmap")
	    public void onMapClick(MapMouseEvent event) {
	        Gmarker gmarker = event.getGmarker();
	        if(gmarker != null) {
	        	gmarker.setOpen(!gmarker.isOpen());
	        	
	        	if(gmarker.isOpen()) {
	        		gmarker.setIconImage("/images/solid/unicloud-green-32.png");
	        		getCWSMarkers(gmarker);
	        		if(!cwsList.isEmpty()) {
	        			for(Gmarker g : cwsList) {
	        				gmap.appendChild(g);
	        			}
	        		}
	        	} else {
	        		gmarker.setIconImage("/images/solid/unicloud-grey-32.png");
	        		for(Component c : gmap.getChildren()) {
	        			if(c.getId().startsWith("cws_")) {
	        				gmap.removeChild(c);
	        			}
	        		}
	        	}
	        }
	    }
	   
	   private void getCWSMarkers(Gmarker gmarker) {
		   cwsList.clear();
		   int ucId = Integer.parseInt(gmarker.getId());
		   UnicloudModel u = UnimanageDataUtil.getUnicloud(ucId);
		   for(CwsModel c : u.getCwsList()) {
			   Gmarker cws = new Gmarker(c.getName(), c.getSysInfo().getGeo().getLatitude(), c.getSysInfo().getGeo().getLongitude());
			   cws.setId("cws_" + c.getId());
			   cws.setIconImage("images/solid/cws-100-green-32.png");
			   cwsList.add(cws);
		   }
	   }
}
