package com.parallelwireless.zkui;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Radiogroup;


@SuppressWarnings("serial")
public class ManageDeviceLayoutController extends SelectorComposer<Div> {

	@Wire
	Combobox 	deviceNameCombo;
	@Wire
	Radiogroup	deviceTypeRadio;
	
	@Override
	public void doAfterCompose(Div d) throws Exception {
		super.doAfterCompose(d);
	}
}
