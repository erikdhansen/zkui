package com.parallelwireless.zkui;

import org.zkoss.gmaps.Gmarker;
import org.zkoss.gmaps.event.MapMouseEvent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

@SuppressWarnings("serial")
public class GoogleMapsController extends SelectorComposer<Component>{

	@Listen("onClick = #gmaps")
	public void onMapClick(MapMouseEvent event) {
		Gmarker marker = event.getGmarker();
		if(marker != null) {
			marker.setOpen(true);
		}
	}
}
