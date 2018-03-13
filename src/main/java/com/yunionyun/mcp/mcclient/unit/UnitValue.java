package com.yunionyun.mcp.mcclient.unit;

public class UnitValue {
	private double value;
	private Unit unit;
	
	public UnitValue(double value, Unit unit) {
		this.value = value;
		this.unit = unit;
	}
	
	public UnitValue(double value, String unit) {
		this.value = value;
		this.unit = Unit.parse(unit);
	}
	
	public void makePretty() {
		while (this.value < 1.0) {
			this.value *= this.unit.getBase();
			this.unit = this.unit.getLowerUnit();
		}
		while (this.value >= this.unit.getBase()) {
			this.value /= this.unit.getBase();
			this.unit = this.unit.getHigherUnit();
		}
	}
	
	public double getValue() {
		return this.value;
	}
	
	public Unit getUnit() {
		return this.unit;
	}
	
	private static int numScale(double num) {
		if (num == 0.0) {
			return 0;
		}
		if (num < 0) {
			num = -num;
		}
		int scale = 0;
		while (num >= 1.0) {
			num /= 10.0;
			scale += 1;
		}
		while (num < 0.1) {
			num *= 10.0;
			scale -= 1;
		}
		return scale;
	}
	
	public static String roundStr(double value, int precision) {
		int scale = numScale(value);
		int minor = 0;
		if (scale < precision) {
			minor = precision - scale;
		}
		int base = 1;
		for(int i = 0; i < minor; i ++) {
			base *= 10;
		}
		if (base == 1) {
			return "" + (int)Math.floor(value + 0.5);
		}else {
			return "" + ((int)Math.floor(value*base + 0.5))/base;
		}
	}
	
	public String String(int precision) {
		return roundStr(this.value, precision) + this.unit.String();
	}
}
