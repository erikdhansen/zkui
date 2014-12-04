package com.parallelwireless.zkui.models;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.DefaultCategoryModel;
import org.zkoss.chart.model.DefaultPieModel;
import org.zkoss.chart.model.PieModel;

import com.parallelwireless.zkui.models.NetworkDevice.TYPE;
import com.parallelwireless.zkui.models.lte.LteStatistics;
import com.parallelwireless.zkui.models.lte.LteStatisticsImpl;
import com.parallelwireless.zkui.models.lte.QCI;
import com.parallelwireless.zkui.models.lte.Statistics;
import com.parallelwireless.zkui.models.lte.LteStatistics.STAT;
import com.parallelwireless.zkui.models.lte.QCI.CSS_CLASS;
import com.parallelwireless.zkui.models.resources.GeoLocation;
import com.parallelwireless.zkui.models.resources.GeoLocation.DEV_TYPE;
import com.parallelwireless.zkui.models.resources.ResourceConfig;
import com.parallelwireless.zkui.models.resources.SystemResource.RESOURCE;

public class UnimanageDataUtil {
	final static Logger log = Logger.getLogger(UnimanageDataUtil.class.getName());
	
	static NetworkMap uniclouds = new NetworkMap();
	static {
		// Unicloud Data
		UnicloudModel u = new UnicloudModel(1, "Unicloud A", "10.10.10.122");
		ResourceConfig cfg = ResourceConfig.generate();
		u.getSysInfo().addResources(cfg);
		u.getNetworkLinks().add("cws-a4");
		uniclouds.put(1, u);
		// Unicloud Data
		u = new UnicloudModel(2, "Unicloud B", "10.10.10.122");
		cfg =  ResourceConfig.generate();
		u.getSysInfo().addResources(cfg);
		u.getNetworkLinks().add("cws-b1");
		uniclouds.put(2, u);
		// Unicloud Data
		u = new UnicloudModel(3, "Unicloud C", "10.10.10.122");
		cfg = ResourceConfig.generate();
		u.getSysInfo().addResources(cfg);
		u.getNetworkLinks().add("cws-c1");
		uniclouds.put(3, u);
		// Unicloud Data
		u = new UnicloudModel(4, "Unicloud D", "10.10.10.122");
		cfg = ResourceConfig.generate();
		u.getSysInfo().addResources(cfg);
		u.getNetworkLinks().add("cws-d1");
		u.getNetworkLinks().add("cws-d3");
		uniclouds.put(4, u);		
	}
	
	static {
		CwsModel cws = new CwsModel("cws-a1", 1, "10.11.1.1", NetworkDevice.TYPE.cws_mesh);
		cws.addNetworkLinks("cws-a4", "cws-a2");
		uniclouds.get(1).addCws(cws);
		cws = new CwsModel("cws-a2", 1, "10.11.1.1", NetworkDevice.TYPE.cws_mesh);
		cws.addNetworkLinks("cws-a1", "cws-a3");
		uniclouds.get(1).addCws(cws);
		cws = new CwsModel("cws-a3", 1, "10.11.1.2", NetworkDevice.TYPE.cws_mesh);
		cws.addNetworkLinks("cws-a2", "cws-a4");
		uniclouds.get(1).addCws(cws);
		cws = new CwsModel("cws-a4", 1, "10.11.1.3", NetworkDevice.TYPE.cws_gw);
		cws.addNetworkLinks("cws-a1", "cws-a3", "Unicloud A");
		uniclouds.get(1).addCws(cws);
		cws = new CwsModel("cws-b1", 1, "10.11.1.4", NetworkDevice.TYPE.cws_gw);
		cws.addNetworkLinks("Unicloud B", "cws-b2");
		uniclouds.get(2).addCws(cws);
		cws = new CwsModel("cws-b2", 2, "10.11.2.4", NetworkDevice.TYPE.cws_mesh);
		cws.addNetworkLinks("cws-b1", "cws-c3");
		uniclouds.get(2).addCws(cws);
		cws = new CwsModel("cws-b3", 2, "10.11.2.5", NetworkDevice.TYPE.cws_gw);
		cws.addNetworkLinks("cws-b2", "cws-b5");
		uniclouds.get(2).addCws(cws);
		cws = new CwsModel("cws-b4", 2, "10.11.2.6", NetworkDevice.TYPE.cws_gw);
		cws.addNetworkLinks("cws-b5", "Unicloud B");
		uniclouds.get(2).addCws(cws);		
		cws = new CwsModel("cws-b5", 2, "10.11.2.7", NetworkDevice.TYPE.cws_mesh);
		cws.addNetworkLinks("cws-b3", "cws-b4");
		uniclouds.get(2).addCws(cws);
		cws = new CwsModel("cws-c1", 3, "10.11.3.8", NetworkDevice.TYPE.cws_gw);
		cws.addNetworkLinks("Unicloud C", "cws-c2");
		uniclouds.get(3).addCws(cws);
		cws = new CwsModel("cws-c2", 3, "10.11.3.9", NetworkDevice.TYPE.cws_mesh);
		cws.addNetworkLinks("cws-c1");
		uniclouds.get(3).addCws(cws);
		cws = new CwsModel("cws-c3", 3, "10.11.3.10", NetworkDevice.TYPE.cws_mesh);
		cws.addNetworkLinks("cws-c1");
		uniclouds.get(3).addCws(cws);
		cws = new CwsModel("cws-d1", 4, "10.11.4.11", NetworkDevice.TYPE.cws_gw);
		cws.addNetworkLinks("Unicloud D", "cws-d2");
		uniclouds.get(4).addCws(cws);
		cws = new CwsModel("cws-d2", 4, "10.11.4.12", NetworkDevice.TYPE.cws_mesh);
		cws.addNetworkLinks("cws-d1", "cws-d3");
		uniclouds.get(4).addCws(cws);
		cws = new CwsModel("cws-d3", 4, "10.11.4.13", NetworkDevice.TYPE.cws_gw);
		cws.addNetworkLinks("Unicloud D", "cws-d2");
		uniclouds.get(4).addCws(cws);
	}
	
	public static UnicloudModel getUnicloud(int id) {
		return uniclouds.get(id);
	}
	
	public static UnicloudModel getUnicloud(String systemName) throws NetworkDeviceNotFoundException {
		for(UnicloudModel u : getAllUniclouds()) {
			if(u.getName().equalsIgnoreCase(systemName)) {
				return u;
			}
		}
		throw new NetworkDeviceNotFoundException("No such system: " + systemName);
	}
	
	public static Map<String,GeoLocation> getAllGeoLocations() {
		Map<String,GeoLocation> gmap = new HashMap<String,GeoLocation>();
		for(UnicloudModel u : getAllUniclouds()) {
			gmap.put(u.getSysInfo().getGeo().getId(), u.getSysInfo().getGeo());
			for(CwsModel c : u.getCwsList()) {
				gmap.put(c.getSysInfo().getGeo().getId(), c.getSysInfo().getGeo());
			}
		}
		return gmap;
	}
	
	public static List<String> getAllNetworkDeviceNames() {
		return getAllNetworkDeviceNames(true, true, true);
	}
	
	public static List<String> getAllNetworkDeviceNames(boolean lac, boolean cwsGW, boolean cwsMesh) {
		List<String> deviceNames = new LinkedList<String>();
		for(NetworkDevice d : getAllNetworkDevices()) {
			if(d.getType() == TYPE.unicloud && lac == true) {
				deviceNames.add(d.getName());
			} else if(d.getType() == TYPE.cws_gw && cwsGW == true) {
				deviceNames.add(d.getName());
			} else if(d.getType() == TYPE.cws_mesh && cwsMesh == true) {
				deviceNames.add(d.getName());
			}
		}
		return deviceNames;
	}
	
	public static List<NetworkDevice> getAllNetworkDevices() {
		List<NetworkDevice> devices = new LinkedList<NetworkDevice>();
		for(NetworkDevice dev : getAllUniclouds()) {
			devices.add(dev);
		}
		for(NetworkDevice dev : getAllCwsModels()) {
			devices.add(dev);
		}
		return devices;
	}
	public static Collection<UnicloudModel> getAllUniclouds() {
		return uniclouds.values();
	}
	
	public static Collection<CwsModel> getAllCwsModels() {
		List<CwsModel> cwsList = new LinkedList<CwsModel>();
		for(UnicloudModel u : getAllUniclouds()) {
			cwsList.addAll(u.getCwsList());
		}
		return cwsList;
	}
	
	public static Collection<CwsModel> getAllCwsModels(Comparator<NetworkDevice> comparator) {
		List<CwsModel> cwsList = new LinkedList<CwsModel>(getAllCwsModels());
		Collections.sort(cwsList, comparator);
		return cwsList;
	}
	
	public static List<CwsModel> getTop10CwsModels(Comparator<NetworkDevice> comparator) {
		List<CwsModel> cwsList = new LinkedList<CwsModel>(getAllCwsModels());
		List<CwsModel> top10 = new LinkedList<CwsModel>();
		Collections.sort(cwsList, comparator);
		for(int i = 0; i < 10; i++) {
			top10.add(cwsList.get(i));
		}
		return top10;
	}
	
	public static List<CwsModel> getTop10CwsModelsLTE(Comparator<CwsModel> comparator) {
		List<CwsModel> cwsList = new LinkedList<CwsModel>(getAllCwsModels());
		List<CwsModel> top10   = new LinkedList<CwsModel>();
		Collections.sort(cwsList, comparator);
		for(int i=0; i < 10; i++) {
			top10.add(cwsList.get(i));
		}
		return top10;
	}
	
	public static List<CwsModel> getTop10CwsModelsLTEReverse(Comparator<CwsModel> comparator) {
		List<CwsModel> cwsList = new LinkedList<CwsModel>(getAllCwsModels());
		List<CwsModel> top10   = new LinkedList<CwsModel>();
		Collections.sort(cwsList, Collections.reverseOrder(comparator));
		for(int i=0; i < 10; i++) {
			top10.add(cwsList.get(i));
		}
		return top10;
	}
	
	public static Collection<UnicloudModel> getAllUniclouds(Comparator<NetworkDevice> comparator) {
		List<UnicloudModel> unicloudList = new LinkedList<UnicloudModel>(uniclouds.values());
		Collections.sort(unicloudList, comparator);
		return unicloudList;
	}
	
	public static NetworkSummary getNetworkSummary() {
		return new NetworkSummary(uniclouds);
	}

	public static AlarmStatusModel getAlarmSummary() {
		AlarmStatusModel model = new AlarmStatusModel();
		List<AlarmRowModel> rows = model.getAlarmRowModels();
		rows.clear();
		rows.add(new AlarmRowModel(NetworkDeviceStatusBucket.getLabel(NetworkDevice.TYPE.unicloud), 3, 4, 8));
		rows.add(new AlarmRowModel(NetworkDeviceStatusBucket.getLabel(NetworkDevice.TYPE.cws_gw), 6, 3, 9));
		rows.add(new AlarmRowModel(NetworkDeviceStatusBucket.getLabel(NetworkDevice.TYPE.cws_mesh), 4, 2, 3));
		return model;
	}
	
	
	/**
	 * 
	 * Routines to build and return CategoryModels used to crate ZK charts
	 * 
	 * \
	 */
	public static CategoryModel getCwsLteHandoverSuccessRate() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwss = new LinkedList<CwsModel>(getTop10CwsModelsLTE(CwsModel.LTE_HANDOVER_SUCCESS_RATE_IN));
		for(CwsModel cws : cwss) {
			model.setValue("Successful", cws.getName(), cws.getLteStats().getServiceHandoverInbound().getSuccess());
			model.setValue("Unsuccessful", cws.getName(), cws.getLteStats().getServiceHandoverInbound().getFailures());
		}
		return model;
	}
	public static CategoryModel getCwsLteSetupSuccessRate() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwss = new LinkedList<CwsModel>(getTop10CwsModelsLTE(CwsModel.LTE_SETUP_SUCCESS_RATE));
		for(CwsModel cws : cwss) {
			model.setValue("Successful", cws.getName(), cws.getLteStats().getSetupSuccessRateTotal().getSetupSuccesses());
			model.setValue("Failed",  cws.getName(),  cws.getLteStats().getSetupSuccessRateTotal().getSetupAttempts() - cws.getLteStats().getSetupSuccessRateTotal().getSetupSuccesses());
		}
		return model;
	}
	
	public static CategoryModel getCwsLteServiceDropRate() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwss = new LinkedList<CwsModel>(getTop10CwsModelsLTE(CwsModel.LTE_SERVICE_DROP_RATE));
		for(CwsModel cws : cwss) {
			model.setValue("Normal Release", cws.getName(), cws.getLteStats().getServiceDropRate().getTotalReleases() - cws.getLteStats().getServiceDropRate().getAbnormalReleases());
			model.setValue("Abnormal Release", cws.getName(), cws.getLteStats().getServiceDropRate().getAbnormalReleases());
		}
		return model;
	}
	
	public static CategoryModel getUnicloudDiskResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<UnicloudModel> ucs = new LinkedList<UnicloudModel>(getAllUniclouds());
		for(UnicloudModel u : ucs) {
			model.setValue("Free", u.getName(), u.getSysInfo().getDisk().getAvailableDiskInBytes());
			model.setValue("Used", u.getName(), u.getSysInfo().getDisk().getUsedDiskSpaceInBytes());
		}
		return model;
	}
	
	public static CategoryModel getCwsDiskResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		for(CwsModel c : getTop10CwsModels(NetworkDeviceImpl.DISK)) {
			model.setValue("Free", c.getName(), c.getSysInfo().getDisk().getAvailableDiskInBytes());
			model.setValue("Used", c.getName(), c.getSysInfo().getDisk().getUsedDiskSpaceInBytes());
		}
		return model;
	}
	
	public static CategoryModel getUnicloudCpuResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<UnicloudModel> ucs = new LinkedList<UnicloudModel>(getAllUniclouds());
		for(UnicloudModel u : ucs) {			
			model.setValue(u.getName(), "-15 min", stoi(u.getSysInfo().getCpu().getFifteenMinLoad()));
			model.setValue(u.getName(), "-5 min", stoi(u.getSysInfo().getCpu().getFiveMinLoad()));
			model.setValue(u.getName(), "-1 min", stoi(u.getSysInfo().getCpu().getOneMinLoad()));
		}
		return model;
	}
	
	public static CategoryModel getCwsCpuResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwss = new LinkedList<CwsModel>(getTop10CwsModels(NetworkDeviceImpl.CPU));
		for(CwsModel c : cwss) {
			model.setValue(c.getName(), "-15 min", stoi(c.getSysInfo().getCpu().getFifteenMinLoad()));
			model.setValue(c.getName(), "-10 min", stoi(c.getSysInfo().getCpu().getFiveMinLoad()));
			model.setValue(c.getName(), "-5 min", stoi(c.getSysInfo().getCpu().getOneMinLoad()));
		}
		return model;
	}
	
	public static CategoryModel getUnicloudMemResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<UnicloudModel> ucs = new LinkedList<UnicloudModel>(getAllUniclouds());
		for(UnicloudModel u : ucs) {
			model.setValue("RAM Used", u.getName(), u.getSysInfo().getMem().getTotalRAMUsed());
			model.setValue("RAM Free", u.getName(), u.getSysInfo().getMem().getTotalRAMFree());
			model.setValue("Swap Used", u.getName(), u.getSysInfo().getMem().getUsedSwapSize());
			model.setValue("Swap Free", u.getName(), u.getSysInfo().getMem().getAvailSwapSize());
		}
		return model;
	}

	public static CategoryModel getCwsMemResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwss = new LinkedList<CwsModel>(getTop10CwsModels(NetworkDeviceImpl.MEM));
		for(CwsModel c : cwss) {
			model.setValue("RAM Used", c.getName(), c.getSysInfo().getMem().getTotalRAMUsed());
			model.setValue("RAM Free", c.getName(), c.getSysInfo().getMem().getTotalRAMFree());
			model.setValue("Swap Used", c.getName(), c.getSysInfo().getMem().getUsedSwapSize());
			model.setValue("Swap Free", c.getName(), c.getSysInfo().getMem().getAvailSwapSize());
		}
		return model;
	}
	
	public static CategoryModel getUnicloudNetResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<UnicloudModel> ucs = new LinkedList<UnicloudModel>(getAllUniclouds());
		for(UnicloudModel u : ucs) {
			for(int i=0; i < u.getSysInfo().getNetwork().getLastTenPercentUtilization().size(); i++) {
				model.setValue(u.getName(), "-" + (u.getSysInfo().getNetwork().getLastTenPercentUtilization().size() - i) + " min", u.getSysInfo().getNetwork().getLastTenPercentUtilization().get(i));
			}
		}
		return model;
	}

	public static CategoryModel getCwsNetResourceModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwss = new LinkedList<CwsModel>(getTop10CwsModels(NetworkDeviceImpl.NET));
		for(CwsModel c : cwss) {
			for(int i=0; i < c.getSysInfo().getNetwork().getLastTenPercentUtilization().size(); i++) {
				model.setValue(c.getName(), "-" + (c.getSysInfo().getNetwork().getLastTenPercentUtilization().size() - i) + " min", c.getSysInfo().getNetwork().getLastTenPercentUtilization().get(i));
			}
		}
		return model;
	}	
	
	public static CategoryModel getCwsAvgThruDLModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<QCI> qcis = getTop10QCI(QCI.AVG_THRU_DL);
		for(QCI q : qcis) {
			model.setValue(q.getQciName(), q.getSystemName(), q.getServiceAvgThruDL());
		}
		return model;
	}

	public static CategoryModel getCwsAvgThruULModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<QCI> qcis = getTop10QCI(QCI.AVG_THRU_UL);
		for(QCI q : qcis) {
			model.setValue(q.getQciName(), q.getSystemName(), q.getServiceAvgThruUL());
		}
		return model;
	}

	public static CategoryModel getTrafficVolULModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<QCI> qcis = getTop10QCI(QCI.TRAF_VOL_UL);
		for(QCI q : qcis) {
			model.setValue(q.getQciName(), q.getSystemName(), q.getServiceTrafficVolUL());
		}
		return model;
	}

	public static CategoryModel getTrafficVolDLModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<QCI> qcis = getTop10QCI(QCI.TRAF_VOL_DL);
		for(QCI q : qcis) {
			model.setValue(q.getQciName(), q.getSystemName(), q.getServiceTrafficVolDL());
		}
		return model;
	}
	
	public static CategoryModel getLteSetupModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwsList = getTop10CwsModelsLTEReverse(CwsModel.LTE_SETUP_SUCCESS_RATE);
		for(CwsModel cws : cwsList) {
			model.setValue("Success", cws.getName(), cws.getLteStats().getSetupSuccessRateTotal().getSetupSuccesses());
			model.setValue("Failure", cws.getName(), cws.getLteStats().getSetupSuccessRateTotal().getSetupFailures());
		}
		return model;
	}
	
	public static CategoryModel getLteReleaseModel() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwsList = getTop10CwsModelsLTE(CwsModel.LTE_SERVICE_DROP_RATE);
		for(CwsModel cws : cwsList) {
			model.setValue("Normal", cws.getName(), cws.getLteStats().getServiceDropRate().getNormalReleases());
			model.setValue("Abormal", cws.getName(), cws.getLteStats().getServiceDropRate().getAbnormalReleases());
		}
		return model;
	}

	public static CategoryModel getLteHandoverIn() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwsList = getTop10CwsModelsLTE(CwsModel.LTE_HANDOVER_SUCCESS_RATE_IN);
		for(CwsModel cws : cwsList) {
			model.setValue("Normal", cws.getName(), cws.getLteStats().getServiceHandoverInbound().getSuccess());
			model.setValue("Abormal", cws.getName(), cws.getLteStats().getServiceHandoverInbound().getFailures());
		}
		return model;
	}

	public static CategoryModel getLteHandoverOut() {
		CategoryModel model = new DefaultCategoryModel();
		List<CwsModel> cwsList = getTop10CwsModelsLTE(CwsModel.LTE_HANDOVER_SUCCESS_RATE_OUT);
		for(CwsModel cws : cwsList) {
			model.setValue("Normal", cws.getName(), cws.getLteStats().getServiceHandoverOutbound().getSuccess());
			model.setValue("Abormal", cws.getName(), cws.getLteStats().getServiceHandoverOutbound().getFailures());
		}
		return model;
	}
	
	
	/**
	 * Utility Functions
	 *
	 */
	
	
	private static int stoi(String s) {
		int i = -1;
		try {
			i = Integer.valueOf(s);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static GeoLocation getMapCenter() {
		int i = 0;
		float lat = 0;
		float lng = 0;
		
		for(UnicloudModel u : getAllUniclouds()) {
			i++;
			lat += u.getSysInfo().getGeo().getLat();
			lng += u.getSysInfo().getGeo().getLng();
		}
		lat = (lat / i);
		lng = (lng / i);
		return new GeoLocation("MapCenter", DEV_TYPE.UNICLOUD, lat, lng);
	}
	
	
	/**
	 * Routines to generate random data
	 * 
	 * 
	 */
	public static GeoLocation generateRandomLocation() {
		// Generate a random latitude/mongitude between 42,-71 to 44,-73
		int latInt = getRandomInt(42, 44);
		int longInt = getRandomInt(-73, -71);
		long latDec = getRandomLong(999999);
		long longDec = getRandomLong(999999);
		
		
		float latitude = Float.parseFloat(latInt + "." + latDec);
		float longitude = Float.parseFloat(longInt + "." + longDec);
		
		GeoLocation g = new GeoLocation("RandomlyGenerated", DEV_TYPE.UNICLOUD, latitude, longitude);
		log.info("Generated random location: " + g);
		return g;
	}
	public static List<NetworkDeviceInterface> fudgeNetworkDeviceInterfaces(NetworkDevice.TYPE type) {
		List<NetworkDeviceInterface> netIfs = new LinkedList<NetworkDeviceInterface>();
		NetworkDeviceInterface netIf = new NetworkDeviceInterface();
		netIfs.add(netIf);
		return netIfs;
	}
	
	public static long getRandomLong() {
		return getRandomLongWithinRange(9999999);
	}
	
	public static long getRandomLong(long l) {
		return new Long(new Random().nextInt(Long.valueOf(l).intValue()));
	}
	
	public static long getRandomLong(int min, int max) {
		Random r = new Random();
		int value = r.nextInt((max - min) + 1) + min;
		return new Long(value);
	}
	
	public static int getRandomInt(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	public static long getRandomLongWithinRange(long max) {
		Random rand = new Random();
		long randomNum = rand.nextInt(new Long((max - (max * 7 / 10) + 1) + (max * 7 / 10)).intValue());
		return randomNum;
	}
	
	public static int getRandomIntFromZero(int max) throws IllegalArgumentException {
		Random rand = new Random();
		int randomNum = rand.nextInt(new Long(max).intValue());
		return randomNum;
	}
	public static long getPercentOfLong(long total, int percent) {
		long fraction = (total * percent)/100;
		return fraction;
	}
	
	public static Date getRandomDateBetweenDayAge(int min, int max) {
		long now = Calendar.getInstance().getTimeInMillis();
		Long minStamp = now - (min * 86400) * 1000;  // min date in range is current timestamp - number of milliseconds * number of days
		Long maxStamp = now - (max * 86400) * 1000; // max date in range is current timestamp - number of milliseconds * number of dayss
		long dateStamp = getRandomLong(maxStamp.intValue(), minStamp.intValue()); // min is greater than max as more recent timestamp is higher than older timestamp
		Calendar randomCal = Calendar.getInstance();
		randomCal.setTimeInMillis(dateStamp);
		log.info("Asked for a random date between T-" + min + " days and T-" + max + " days -- result: " + randomCal.getTime().toString());
		return randomCal.getTime();
	}
	
	public static String getRandomSystemVersion() {
		int major = getRandomInt(1,  4);
		int minor = getRandomInt(100, 999);
		int build = getRandomInt(1000, 9999);
		return String.valueOf(major).concat(".").concat(String.valueOf(minor)).concat(".").concat(String.valueOf(build));
	}
	
	public static String getRandomSerialNumber() {
		long serial = getRandomLong(10000, 99999);
		return "PWX".concat(String.valueOf(serial));
	}
	
	public static List<QCI> getNQCI(int n, Comparator<QCI> comparator) {
		List<QCI> qcis = new LinkedList<QCI>();
		Collection<CwsModel> cwsList = getAllCwsModels();
		for(CwsModel cws : cwsList) {
			qcis.addAll(Arrays.asList(cws.getLteStats().getQCI()));
		}
		Collections.sort(qcis, comparator);
		return qcis.subList(0,  n-1);
	}
	
	public static List<QCI> getTop10QCI(Comparator<QCI> comparator) {
		List<QCI> qcis = new LinkedList<QCI>();
		Collection<CwsModel> cwsList = getAllCwsModels();
		for(CwsModel cws : cwsList) {
			qcis.addAll(Arrays.asList(cws.getLteStats().getQCI()));
		}
		Collections.sort(qcis, comparator);
		// Copy the list before changing class - otherwise we may end up flipping the
		// class for the QCI during rendering...not sure whether things get rendered
		// serially or in parallel or in some other magical way
		List<QCI> top10 = new LinkedList<QCI>(qcis.subList(0, 9));
		for(QCI qci : top10) {
			// Look at comparator class to determine which statistic we're sorted by,
			// Then iterate over the QCIs to be displayed and set the CSS class according
			// to each QCI's value for that monitored statistic...this is ugly...in final
			// form, ANYTHING which will be rendered in the UI will subclass some generic
			// UI element which stores any CSS class info within it so it can be easily
			// changed as needed
			if(comparator.hashCode() == QCI.AVG_THRU_DL.hashCode()) {
				if(qci.getServiceAvgThruDL() > 9900) {
					qci.setCssClass(CSS_CLASS.CRITICAL);
				} else if(qci.getServiceAvgThruDL() > 9850) {
					qci.setCssClass(CSS_CLASS.MAJOR);
				} else if(qci.getServiceAvgThruDL() > 9700) {
					qci.setCssClass(CSS_CLASS.MINOR);
				}
				log.warning("QCI: " + qci.toString() + " VALUE=" + qci.getServiceAvgThruDL() + " CLASS=" + qci.getCssClassName());
			} else if(comparator.hashCode() == QCI.AVG_THRU_UL.hashCode()) {
				if(qci.getServiceAvgThruUL() > 9900) {
					qci.setCssClass(CSS_CLASS.CRITICAL);
				} else if(qci.getServiceAvgThruUL() > 9850) {
					qci.setCssClass(CSS_CLASS.MAJOR);
				} else if(qci.getServiceAvgThruUL() > 9700) {
					qci.setCssClass(CSS_CLASS.MINOR);
				}				
				log.warning("QCI: " + qci.toString() + " VALUE=" + qci.getServiceAvgThruDL() + " CLASS=" + qci.getCssClassName());				
			} else if(comparator.hashCode() == QCI.TRAF_VOL_DL.hashCode()){
				if(qci.getServiceTrafficVolDL() > 9900) {
					qci.setCssClass(CSS_CLASS.CRITICAL);
				} else if(qci.getServiceTrafficVolDL() > 9850) {
					qci.setCssClass(CSS_CLASS.MAJOR);
				} else if(qci.getServiceTrafficVolDL() > 9700) {
					qci.setCssClass(CSS_CLASS.MINOR);
				}				
				log.warning("QCI: " + qci.toString() + " VALUE=" + qci.getServiceAvgThruDL() + " CLASS=" + qci.getCssClassName());				
			} else if(comparator.hashCode() == QCI.TRAF_VOL_UL.hashCode()) {
				if(qci.getServiceTrafficVolUL() > 9900) {
					qci.setCssClass(CSS_CLASS.CRITICAL);
				} else if(qci.getServiceTrafficVolUL() > 9850) {
					qci.setCssClass(CSS_CLASS.MAJOR);
				} else if(qci.getServiceTrafficVolUL() > 9700) {
					qci.setCssClass(CSS_CLASS.MINOR);
				}				
				log.warning("QCI: " + qci.toString() + " VALUE=" + qci.getServiceAvgThruDL() + " CLASS=" + qci.getCssClassName());				
			}
		}
		return top10;
	}
	
	public static int[] getRandomPercent(int numSlices) {
		int[] slices = new int[numSlices];
		int total = 100;
		for(int i=0; i < (numSlices - 1); i++) {
			slices[i] = new Long(getRandomLongWithinRange(total)).intValue();
			total -= slices[i];
		}
		slices[numSlices - 1] = total;
		String output = "RandomPercent[" + numSlices + "]: ";
		for(int i = 0; i < numSlices; i++) {
			output.concat(String.valueOf(slices[i])).concat(" ");
		}
		return slices;
	}
	
	public static int getRandomChoice(int[] choices) {
		int randomIndex = new Random().nextInt(choices.length - 1);
		return choices[randomIndex];
	}
}
