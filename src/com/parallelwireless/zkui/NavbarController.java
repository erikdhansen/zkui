package com.parallelwireless.zkui;

import jxl.common.Logger;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.zul.Navbar;
import org.zkoss.zul.Div;


@SuppressWarnings("serial")
public class NavbarController extends SelectorComposer<Div> {
	final static Logger log = Logger.getLogger(NavbarController.class);
		
	@Wire
	Navbar mainNavbar;
	
	public void doAfterCompose(Div n) throws Exception {
		super.doAfterCompose(n);
	}
	
	@Listen("onClick = navitem")
	public void onClick(Event e) {
		log.info("Navbar navitem selected id[" + e.getTarget().getId() + "]");
		
	}
	
}
