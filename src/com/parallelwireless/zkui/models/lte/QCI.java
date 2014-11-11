package com.parallelwireless.zkui.models.lte;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.parallelwireless.zkui.models.CwsModel;
import com.parallelwireless.zkui.models.UnimanageDataUtil;

public class QCI {
	final static Logger log = Logger.getLogger(QCI.class.getName());
	
	public static enum CSS_CLASS {
		CRITICAL("critical"),
		MAJOR("major"),
		MINOR("minor"),
		NONE("none");
		
		String severity;
		CSS_CLASS(String severity) {
			this.severity = severity;
		}
		
		public String getCssClassName() {
			return severity;
		}
	}

	long serviceAvgThruUL    = 0;
	long serviceAvgThruDL    = 0;
	long serviceTrafficVolUL = 0;
	long serviceTrafficVolDL = 0;
	
	String qciName = "";
	String systemName = "";
	
	CSS_CLASS[] cssClasses = { CSS_CLASS.NONE, CSS_CLASS.NONE, CSS_CLASS.NONE, CSS_CLASS.NONE };
	CSS_CLASS cssClass = CSS_CLASS.NONE;
	
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

	public String getCssClassName() {
		return cssClass.getCssClassName();
	}
	
	// This is to be set by the UnimanageDataUtil class when it sorts the QCIs by a 
	// particular parameter.  Normally this logic is encapsulated by the class itself
	// but rather than create separate QCI collections for each statistic, let the smarts
	// live outside the QCI class since whoever is sorting this list will know which parameter
	// is being monitored and also will have to maintain the severity threshold values...when the QCIs
	// are sorted by a particular value, that collection can then be iterated over and each QCIs CSS
	// class can be set
	
	public void setCssClass(CSS_CLASS cssClass) {
		this.cssClass = cssClass;
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
		
	public static QCI[] generateRandomQCIs() {
		QCI[] q = new QCI[9];
		for (int i = 0; i < 9; i++) {
			q[i] = new QCI(i, UnimanageDataUtil.getRandomLong(6000, 10000), UnimanageDataUtil.getRandomLong(6000, 10000),
					UnimanageDataUtil.getRandomLong(6000, 10000), UnimanageDataUtil.getRandomLong(6000, 10000));
		}
		return q;
	}
	
	@Override
	public String toString() {
		return "QCI[" + systemName + ":" + qciName + "] thruDL=" + serviceAvgThruDL + " thruUL=" + serviceAvgThruUL + " volDL=" + serviceTrafficVolDL + " volUL=" + serviceTrafficVolUL;
	}
}
