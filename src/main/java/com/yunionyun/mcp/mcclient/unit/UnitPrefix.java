package com.yunionyun.mcp.mcclient.unit;

import java.util.ArrayList;
import java.util.List;

class UnitPrefix {
	private String rep;
	private int scale;
	private UnitPrefix lower;
	private UnitPrefix higher;
	
	private static List<UnitPrefix> all;
	
	private UnitPrefix(String str, int scale) {
		this.rep = str;
		this.scale = scale;
		this.lower = null;
		this.higher = null;
		
		all.add(this);
	}
	
	public static final UnitPrefix none;
	public static final UnitPrefix n;
	public static final UnitPrefix u;
	public static final UnitPrefix m;
	public static final UnitPrefix K;
	public static final UnitPrefix M;
	public static final UnitPrefix G;
	public static final UnitPrefix T;
	public static final UnitPrefix P;
	public static final UnitPrefix E;
	public static final UnitPrefix Z;
	public static final UnitPrefix Y;
	
	static {
		all = new ArrayList<UnitPrefix>();
		
		n = new UnitPrefix("n", -3); // nano
		u = new UnitPrefix("u", -2); // micro
		m = new UnitPrefix("m", -1); // milli
		none = new UnitPrefix("", 0);
		K = new UnitPrefix("K", 1); // kilo
		M = new UnitPrefix("M", 2); // million
		G = new UnitPrefix("G", 3); // gillion
		T = new UnitPrefix("T", 4); // titan
		P = new UnitPrefix("P", 5);
		E = new UnitPrefix("E", 6);
		Z = new UnitPrefix("Z", 7);
		Y = new UnitPrefix("Y", 8);
		
		n.between(null, u);
		u.between(n, m);
		m.between(u, none);
		none.between(m, K);
		K.between(none, M);
		M.between(K, G);
		G.between(M, T);
		T.between(G, P);
		P.between(T, E);
		E.between(P, Z);
		Z.between(E, Y);
		Y.between(Z, null);
	}
	
	private void between(UnitPrefix lower, UnitPrefix higher) {
		this.lower = lower;
		this.higher = higher;
	}
	
	protected String String() {
		return this.rep;
	}
	
	static protected double convert(double value, int base, UnitPrefix oldpref, UnitPrefix newpref) {		
		int diff = 0;
		if (newpref.scale > oldpref.scale) {
			diff = newpref.scale - oldpref.scale;
		}else if (newpref.scale < oldpref.scale) {
			diff = oldpref.scale - newpref.scale;
		}else {
			return value;
		}
		for (int i = 0; i < diff; i ++) {
			if (newpref.scale > oldpref.scale) {
				value /= base;
			}else {
				value *= base;
			}
		}
		return value;
	}
	
	protected static UnitPrefix parse(String unitstr) {
		UnitPrefix match = null;
		int matchLen = -1;
		for(UnitPrefix pref: all) {
			if (pref.rep != null && unitstr.startsWith(pref.rep) && matchLen < pref.rep.length()) {
				match = pref;
				matchLen = pref.rep.length();
			}
		}
		if (match == null) {
			match = none;
		}
		return match;
	}
	
	protected int length() {
		return this.rep.length();
	}
	
	protected UnitPrefix getLower() {
		return this.lower;
	}
	
	protected UnitPrefix getHigher() {
		return this.higher;
	}
}
