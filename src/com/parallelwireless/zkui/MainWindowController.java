package com.parallelwireless.zkui;

import java.util.logging.Logger;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.zul.Navbar;
import org.zkoss.zul.Include;
import org.zkoss.zul.Window;


@SuppressWarnings("serial")
public class MainWindowController extends SelectorComposer<Window> {
	final static Logger log = Logger.getLogger(MainWindowController.class.getName());
	String currentZUL = "dashboard/dashboard.zul";
			
	@Wire
	Include mainContentInclude;
	
	@Wire
	Navbar mainNavbar;
	
	public void doAfterCompose(Window w) throws Exception {
		super.doAfterCompose(w);
		log.info("MainWindowController: doAfterCompose()");
		log.info("MainNavbar: " + mainNavbar);
	}
	
	@Listen("onClick = navitem")
	public void onNavitemClick(Event e) {
		log.info("Navitem[" + e.getTarget().getId() + "]");
		String newZul = ZulMapper.getZul(e.getTarget().getId());
		log.info("ZUL Lookup: ZulMapper -- " + e.getTarget().getId() + " => " + newZul);
		loadMainContent(newZul);
	}

	private void loadMainContent(String zul) {
		log.info("Grabbed component[" + mainContentInclude.getId() + "]");
		log.info("CurrentZUL=" + currentZUL + " requestedZUL=" + zul);
		if(zul.equalsIgnoreCase(currentZUL)) {
			// User clicked the current page's navitem...don't reload the page...or should we?
			log.info("Ignoring navitem request for " + zul + " sinze we're already on that page");
			return;
		}
		log.info("NEW ZUL [" + zul + "] requested -- load new page");
		mainContentInclude.setSrc(zul);
		mainContentInclude.afterCompose();
		currentZUL = zul;
		log.info("mainContentInclude => " + zul + " loaded");
	}
}
