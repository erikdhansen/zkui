package com.parallelwireless.zkui.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Top10List {
	
	private ArrayList<NetworkDevice> items      = null;
	Comparator<NetworkDevice>        comparator = null;
	
	public Top10List(Collection<NetworkDevice> items, Comparator<NetworkDevice> comparator) {
		this.comparator = comparator;
		//this.items = Collections.sort(items, comparator);
	}
}
