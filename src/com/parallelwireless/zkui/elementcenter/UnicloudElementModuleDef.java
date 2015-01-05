package com.parallelwireless.zkui.elementcenter;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centeredlogic.VersionedObject;
import com.centeredlogic.ecx.elements.Element;
import com.centeredlogic.ecx.moduleSupport.AbstractElementModuleDef;
import com.centeredlogic.ecx.moduleSupport.ElementControllerIf;
import com.centeredlogic.ecx.moduleSupport.gui.ElementModuleGuiDefIf;
//import com.centeredlogic.net.snmp.TrapManagerIf;
import com.parallelwireless.unimanage.mib2unicloud.config.*;

public class UnicloudElementModuleDef extends AbstractElementModuleDef {
	final static Log log = LogFactory.getLog(UnicloudElementModuleDef.class);
	
	public static ArrayList<VersionedObject> configAppRootNodes;
	
	public static String MODULENAME = "Mib2Unicloud";
	public static String DISPLAY_NAME = "LAC SNMP MIB-II Device";
	
	boolean started = false;
	
	static {
		configAppRootNodes = new ArrayList<VersionedObject>();
		configAppRootNodes.add(new Mib2());
		configAppRootNodes.add(new Host());
	}
	@Override
	public ElementModuleGuiDefIf getElementModuleGuiDef() {
		return null;
	}

	@Override
	public ElementControllerIf createElementController(Element element) {
		UnicloudElementController controller = new UnicloudElementController(element);
		controller.setRootNodes(configAppRootNodes);
		controller.setElement(element);
		return controller;
	}

	@Override
	public String getDisplayName() {
		return DISPLAY_NAME;
	}

	@Override
	public void shuttingDown() {
		log.debug("Shutting down...");
	}
	
	@Override
	public boolean startedUp() {
		log.debug("Starting up...");
		if(!started) {
			started = true;
		}
		return started;
	}
}
