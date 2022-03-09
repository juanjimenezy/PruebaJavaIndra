package com.indra.prueba.enums;

public enum Estado {

	A("Activo"), I("Inactivo");

	private String value;

	private Estado(String string) {

	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
