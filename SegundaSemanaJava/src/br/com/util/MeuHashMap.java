package br.com.util;

import java.util.HashMap;

public class MeuHashMap extends HashMap<Boolean, String> {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MeuHashMap putCustom(Boolean key, String value) {
		super.put(key, value);
		return this;
	}

}
