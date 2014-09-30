package com.parallelwireless.zkui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.zul.Portallayout;
import org.zkoss.zul.Panel;

@SuppressWarnings("serial")
public class DashboardPortalLayoutController extends SelectorComposer<Component> {

	@Wire
	private Portallayout portalLayout;
	
	@Listen("onPortalMove = #portalLayout")
	public void saveStatus() {
		int i = 0;
		for(Component portalChild : portalLayout.getChildren()) {
			List<String> portletIds = new ArrayList<String>();
			for(Component portlet : portalChild.getChildren()) {
				portletIds.add(portlet.getId());
				Executions.getCurrent().getSession().setAttribute("PortalChildren" + i++, portletIds);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Listen("onCreate = #portalLayout")
	public void initStatus() {
		List<? extends Component> panelchildren = portalLayout.getChildren();
		for(int i=0; i < panelchildren.size(); i++) {
			List<String> panelIds = new LinkedList<String>();
			panelIds = (List<String>) Executions.getCurrent().getSession().getAttribute("PortalChildren" + i);
			if(panelIds != null) {
				for(String panelId : panelIds) {
					Panel newPanel = (Panel)portalLayout.getFellow(panelId);
					if(panelchildren.size() > 0)
						panelchildren.get(i).insertBefore(newPanel, panelchildren.get(0));
					else
						newPanel.setParent(panelchildren.get(i));
				}
			}
		}
	}
}
