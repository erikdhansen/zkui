package com.parallelwireless.zkui.models;

import com.parallelwireless.zkui.models.AlarmModel.Severity;

public class AlarmDataUtil {

	public static AlarmList getAlarms() {
		AlarmList a = new AlarmList();
		a.add(new AlarmModel(Severity.CRIT, true));
		a.add(new AlarmModel(Severity.CRIT, true));
		a.add(new AlarmModel(Severity.CRIT, true));
		a.add(new AlarmModel(Severity.CRIT, false));
		a.add(new AlarmModel(Severity.CRIT, false));
		a.add(new AlarmModel(Severity.MAJ, true));
		a.add(new AlarmModel(Severity.MAJ, true));
		a.add(new AlarmModel(Severity.MAJ, true));
		a.add(new AlarmModel(Severity.MAJ, true));
		a.add(new AlarmModel(Severity.MAJ, true));
		a.add(new AlarmModel(Severity.MAJ, true));
		a.add(new AlarmModel(Severity.MAJ, true));
		a.add(new AlarmModel(Severity.MAJ, false));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, true));
		a.add(new AlarmModel(Severity.MIN, false));
		a.add(new AlarmModel(Severity.MIN, false));
		a.add(new AlarmModel(Severity.MIN, false));		
		return a;
	}
}
