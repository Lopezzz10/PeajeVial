package com.krakedev.peaje.util;

import com.krakedev.peaje.entidades.Vehiculo;

public class ImpresorUtil {
	public void imprimirVehiculo(Vehiculo vehiculo) {
		System.out.println("Placa: "+vehiculo.getPlaca());
		System.out.println("Tipo: "+vehiculo.getTipo());
		vehiculo.getPropietario().imprimir();
		vehiculo.getTag().imprimir();
		System.out.println("Saldo disponible: "+vehiculo.getTag().getSaldo());
	}
}
