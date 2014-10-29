package com.parallelwireless.zkui.models.lte;

import java.util.Comparator;

import com.parallelwireless.zkui.models.CwsModel;

public class QCI {
	long serviceAvgThruUL    = 0;
	long serviceAvgThruDL    = 0;
	long serviceTrafficVolUL = 0;
	long serviceTrafficVolDL = 0;
	
	String qciName = "";
	String systemName = "";
	
	public QCI() {	
	}

	public QCI(int qciIndex, long serviceAvgThruUL, long serviceAvgThruDL, long serviceTrafficVolUL, long serviceTrafficVolDL) {
		this.qciName = "QCI_" + (qciIndex + 1);
		this.serviceAvgThruUL    = serviceAvgThruUL;
		this.serviceAvgThruDL    = serviceAvgThruDL;
		this.serviceTrafficVolUL = serviceTrafficVolUL;
		this.serviceTrafficVolDL = serviceTrafficVolDL;
	}
	
	public String getQciName() {
		return qciName;
	}
	
	public void setQciName(String qciName) {
		this.qciName = qciName;
	}
	
	public String getSystemName() {
		return systemName;
	}
	
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	public long getServiceAvgThruUL() {
		return serviceAvgThruUL;
	}

	public void setServiceAvgThruUL(long serviceAvgThruUL) {
		this.serviceAvgThruUL = serviceAvgThruUL;
	}

	public long getServiceAvgThruDL() {
		return serviceAvgThruDL;
	}

	public void setServiceAvgThruDL(long serviceAvgThruDL) {
		this.serviceAvgThruDL = serviceAvgThruDL;
	}

	public long getServiceTrafficVolUL() {
		return serviceTrafficVolUL;
	}

	public void setServiceTrafficVolUL(long serviceTrafficVolUL) {
		this.serviceTrafficVolUL = serviceTrafficVolUL;
	}

	public long getServiceTrafficVolDL() {
		return serviceTrafficVolDL;
	}

	public void setServiceTrafficVolDL(long serviceTrafficVolDL) {
		this.serviceTrafficVolDL = serviceTrafficVolDL;
	}
	
	public final static Comparator<QCI> AVG_THRU_DL = 
		new Comparator<QCI>() {
			@Override
			public int compare(QCI q1, QCI q2) {
				Long s1 = q1.getServiceAvgThruDL();
				Long s2 = q2.getServiceAvgThruDL();
				return s2.compareTo(s1);
		}
	};

	public final static Comparator<QCI> AVG_THRU_UL = 
			new Comparator<QCI>() {
				@Override
				public int compare(QCI q1, QCI q2) {
					Long s1 = q1.getServiceAvgThruUL();
					Long s2 = q2.getServiceAvgThruUL();
					return s2.compareTo(s1);
			}
		};
		
	public final static Comparator<QCI> TRAF_VOL_DL = 
		new Comparator<QCI>() {
			@Override
			public int compare(QCI q1, QCI q2) {
				Long s1 = q1.getServiceTrafficVolDL();
				Long s2 = q2.getServiceTrafficVolDL();
				return s2.compareTo(s1);
		}
	};
	
	public final static Comparator<QCI> TRAF_VOL_UL = 
			new Comparator<QCI>() {
				@Override
				public int compare(QCI q1, QCI q2) {
					Long s1 = q1.getServiceTrafficVolUL();
					Long s2 = q2.getServiceTrafficVolUL();
					return s2.compareTo(s1);
			}
		};		
}
