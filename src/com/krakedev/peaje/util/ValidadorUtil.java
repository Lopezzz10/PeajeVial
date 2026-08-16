package com.krakedev.peaje.util;

public class ValidadorUtil {

	public boolean esMontoValido(double monto) {
		if(monto>0) {
			return true;
		}else {
			return false;
		}
	}
	public boolean esTipoValido(String tipo) {
		if (tipo.equals("L") || tipo.equals("P")) {
			return true;
		} else {
			return false;
		}
	}
}