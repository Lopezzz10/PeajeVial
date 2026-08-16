package com.krakedev.peaje.servicios;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.util.ValidadorUtil;

public class EstacionPeaje {
	private int codigoEstacion = 500;
	private double tarifaLiviano = 1.00;
	private double tarifaPesado = 2.50;
	
	public EstacionPeaje() {
		
	}

	public int getCodigoEstacion() {
		return codigoEstacion;
	}

	public void setCodigoEstacion(int codigoEstacion) {
		this.codigoEstacion = codigoEstacion;
	}

	public double getTarifaLiviano() {
		return tarifaLiviano;
	}

	public void setTarifaLiviano(double tarifaLiviano) {
		this.tarifaLiviano = tarifaLiviano;
	}

	public double getTarifaPesado() {
		return tarifaPesado;
	}

	public void setTarifaPesado(double tarifaPesado) {
		this.tarifaPesado = tarifaPesado;
	}
	public Vehiculo registrarVehiculo(String placa, String tipo, String cedula, String nombre, String apellido, String idTag) {
	    ValidadorUtil validador = new ValidadorUtil();

	    if (validador.esTipoValido(tipo)) {
	        Vehiculo vehiculo = new Vehiculo(placa);
	        vehiculo.setTipo(tipo);

	        Conductor conductor = new Conductor(cedula, nombre, apellido);
	        vehiculo.setPropietario(conductor);

	        TagElectronico tag = new TagElectronico(idTag);
	        vehiculo.setTag(tag);

	        return vehiculo;
	    } else {
	        System.out.println("Tipo de vehículo inválido");
	        return null;
	    }
	}
	public void recargarTag(TagElectronico tag, double monto) {
	    ValidadorUtil validador = new ValidadorUtil();

	    if (validador.esMontoValido(monto)) {
	        double nuevoSaldo = tag.getSaldo() + monto;
	        tag.setSaldo(nuevoSaldo);
	    } else {
	        System.out.println("Monto inválido");
	    }
	}
	
	public void cobrarPeaje(Vehiculo vehiculo) {
	    ValidadorUtil validador = new ValidadorUtil();

	    double tarifa;

	    if (vehiculo.getTipo().equals("L")) {
	        tarifa = tarifaLiviano;
	    } else {
	        tarifa = tarifaPesado;
	    }

	    if (!validador.esMontoValido(tarifa)) {
	        System.out.println("Tarifa inválida");
	        return;
	    }

	    TagElectronico tag = vehiculo.getTag();

	    if (tag.getSaldo() >= tarifa) {
	        double nuevoSaldo = tag.getSaldo() - tarifa;
	        tag.setSaldo(nuevoSaldo);
	    } else {
	        System.out.println("Saldo insuficiente");
	    }
	}
	public void transferirSaldoTag(TagElectronico origen, TagElectronico destino, double monto) {
	    ValidadorUtil validador = new ValidadorUtil();

	    if (!validador.esMontoValido(monto)) {
	        System.out.println("Monto inválido");
	        return;
	    }

	    if (origen.getSaldo() >= monto) {
	        double nuevoSaldoOrigen = origen.getSaldo() - monto;
	        origen.setSaldo(nuevoSaldoOrigen);

	        double nuevoSaldoDestino = destino.getSaldo() + monto;
	        destino.setSaldo(nuevoSaldoDestino);
	    } else {
	        System.out.println("Saldo insuficiente en el tag origen");
	    }
	}
}