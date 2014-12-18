package com.parallelwireless.zkui.elementcenter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.snmp4j.PDU;

import com.centeredlogic.customTypes.Timestamp;
import com.centeredlogic.ecx.LookUp;
import com.centeredlogic.ecx.deviceController.ControllerConfig;
import com.centeredlogic.ecx.deviceController.snmp.SnmpDeviceController;
import com.centeredlogic.ecx.elements.Element;
import com.centeredlogic.ecx.events.EcxEvent;
import com.centeredlogic.ecx.events.EventHelper;
import com.centeredlogic.ecx.events.EventType;
import com.centeredlogic.ecx.notifications.AbstractNotifObject;
import com.centeredlogic.ecx.snmp.EcTrapInfo;
import com.centeredlogic.ecx.snmp.EcTrapListenerIf;
import com.centeredlogic.ecx.stat.GenericStatisticsHandler;
import com.centeredlogic.ecx.stat.binning.KeyedStatValueHelper;
import com.centeredlogic.net.snmp.marshalling.TrapUtil;


public class UnicloudElementController extends SnmpDeviceController implements EcTrapListenerIf {
	final static Log log = LogFactory.getLog(UnicloudElementController.class);
	private final static String moduleName = UnicloudElementModuleDef.MODULENAME;
	
	static final String NAMESPACE = "http://parallelwireless.com/unicloud/config";
	
	private static ControllerConfig    ecControllerConfig;
	private GenericStatisticsHandler  statsHandler = null;
	KeyedStatValueHelper ecStatValueHelper;
	
	public UnicloudElementController(Element element) {
		super(ecControllerConfig, element);
	}

	@Override
	public void trapReceived(EcTrapInfo trapInfo) {
		StringBuilder oid = new StringBuilder();
		PDU pdu = trapInfo.getTrapPdu();
		AbstractNotifObject notif = null;
		
		try {
			notif = (AbstractNotifObject) TrapUtil.getNotif(super.getDataModel(), pdu, oid, null);
		} catch (Exception e) {
			log.warn("Error creating notification from trap PDU: " + e.getMessage());
			log.warn(pdu.toString());
		}
		
		if(notif != null) {
			notif.set_name(notif.getClass().getSimpleName());
			notif.set_elementId(getElement().getId());
			notif.set_oid(oid.toString());
			generateEvent(notif);
		}
	}
	
	private void generateEvent(AbstractNotifObject notif) {
		Element element = super.getElement();
		EcxEvent event = EventHelper.makeEvent(EventType.STATE, element.getId(), notif.get_name());
		event.setTimestamp(new Timestamp(System.currentTimeMillis()));
		event.setMoType("Device");
		event.setElementName(element.getName());
		event.setElementId(element.getId());
		log.debug(event);
		LookUp.getEventEngine().process(event);		
	}
}
