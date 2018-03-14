package com.yunionyun.mcp.mcclient.unit;

import java.util.HashMap;
import java.util.Map;

public class Unit {
	private String desc;
	private UnitPrefix prefix;
	private UnitBase base;
	private UnitSuffix suffix;
	private static Map<String, Unit> unitTable;
	
	private Unit(String desc, UnitPrefix prefix, UnitBase base, UnitSuffix suffix) {
		this.desc = desc;
		this.prefix = prefix;
		this.base = base;
		this.suffix = suffix;
		unitTable.put(this.desc, this);
	}
	
	public static final Unit joule;
	public static final Unit Bytes;
	public static final Unit KB;
	public static final Unit KBps;
	public static final Unit MB;
	public static final Unit MBps;
	public static final Unit Mibps;
	public static final Unit Mhz;
	public static final Unit us;
	public static final Unit ms;
	public static final Unit sec;
	public static final Unit number;
	public static final Unit percent;
	public static final Unit watt;
	public static final Unit millionth;
	
	static {
		unitTable = new HashMap<String, Unit>();
		
		joule = new Unit("joule", UnitPrefix.none, UnitBase.joule, UnitSuffix.none);
		Bytes = new Unit("bytes", UnitPrefix.none, UnitBase.bytes, UnitSuffix.none);
		KB = new Unit("kiloBytes", UnitPrefix.K, UnitBase.bytes, UnitSuffix.none);
		KBps = new Unit("kiloBytesPerSecond", UnitPrefix.K, UnitBase.bytes, UnitSuffix.persecond);
		MB = new Unit("megaBytes", UnitPrefix.M, UnitBase.bytes, UnitSuffix.none);
		MBps = new Unit("megaBytesPerSecond", UnitPrefix.M, UnitBase.bytes, UnitSuffix.persecond);
		Mibps = new Unit("megaBitsPerSecond", UnitPrefix.M, UnitBase.bits, UnitSuffix.persecond);
		Mhz = new Unit("megaHertz", UnitPrefix.M, UnitBase.hz, UnitSuffix.none);
		us = new Unit("microsecond", UnitPrefix.u, UnitBase.seconds, UnitSuffix.none);
		ms = new Unit("millisecond", UnitPrefix.m, UnitBase.seconds, UnitSuffix.none);
		number = new Unit("number", UnitPrefix.none, UnitBase.none, UnitSuffix.none);
		percent = new Unit("percent", UnitPrefix.none, UnitBase.percent, UnitSuffix.none);
		sec = new Unit("second", UnitPrefix.none, UnitBase.seconds, UnitSuffix.none);
		watt = new Unit("watt", UnitPrefix.none, UnitBase.watt, UnitSuffix.none);
		millionth = new Unit("millionth", UnitPrefix.none, UnitBase.millionth, UnitSuffix.none);
	}
	
	public String String() {
		return this.prefix.String() + this.base.String() + this.suffix.String();
	}
	
	public static Unit parse(String unitstr) {
		if (unitTable.containsKey(unitstr)) {
			return unitTable.get(unitstr);
		}
		UnitPrefix prefix = UnitPrefix.parse(unitstr);
		UnitSuffix suffix = UnitSuffix.parse(unitstr);
		UnitBase base = UnitBase.parse(unitstr.substring(prefix.length(), unitstr.length() - suffix.length()));
		return new Unit(unitstr, prefix, base, suffix);
	}
	
	
	
	public static double convert(double value, Unit from, Unit to) {
		return UnitPrefix.convert(value, from.getBase(), from.prefix, to.prefix);
	}
	
	public static double convert(double value, String from, String to) {
		Unit fromUnit = Unit.parse(from);
		Unit toUnit = Unit.parse(to);
		return UnitPrefix.convert(value, fromUnit.getBase(), fromUnit.prefix, toUnit.prefix);
	}
	
	public static String prettyString(double value, int precision, Unit unit) {
		UnitValue uv = new UnitValue(value, unit);
		uv.makePretty();
		return uv.String(precision);
	}
	
	/**
	 * 根据单位自动格式化数值
	 * 
	 * @param value 值
	 * @param precision 精度，需要保留的位数，一般为2
	 * @param unitstr 单位字符串
	 * @return
	 */
	public static String prettyString(double value, int precision, String unitstr) {
		Unit unit = Unit.parse(unitstr);
		return prettyString(value, precision, unit);
	}
	
	protected int getBase() {
		return this.base.getBase();
	}
	
	protected Unit getLowerUnit() {
		if (this.prefix.getLower() != null) {
			return parse(this.prefix.getLower().String() + this.base.String() + this.suffix.String());
		}else {
			return null;
		}
	}
	
	protected Unit getHigherUnit() {
		if (this.prefix.getLower() != null) {
			return parse(this.prefix.getHigher().String() + this.base.String() + this.suffix.String());
		}else {
			return null;
		}
	}
}
