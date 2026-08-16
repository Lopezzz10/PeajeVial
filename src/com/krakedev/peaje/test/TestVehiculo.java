package com.krakedev.peaje.test;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.util.ImpresorUtil;
import com.krakedev.peaje.servicios.EstacionPeaje;

public class TestVehiculo {

    public static void main(String[] args) {

        Conductor conductor = new Conductor("1234567890", "Juan", "Perez");
        Vehiculo vehiculo = new Vehiculo("ABC-123");
        vehiculo.setTipo("L");
        TagElectronico tag = new TagElectronico("TAG001");

        vehiculo.setPropietario(conductor);
        vehiculo.setTag(tag);
        vehiculo.imprimir();
        ImpresorUtil impresor = new ImpresorUtil();
        impresor.imprimirVehiculo(vehiculo);
        EstacionPeaje estacion = new EstacionPeaje();

        estacion.recargarTag(tag, 10.0);
        System.out.println("Saldo tras recarga: " + tag.getSaldo());

        estacion.cobrarPeaje(vehiculo);
        System.out.println("Saldo tras cobro de peaje: " + tag.getSaldo());

        TagElectronico tagDestino = new TagElectronico("TAG002");
        estacion.transferirSaldoTag(tag, tagDestino, 3.0);
        System.out.println("Saldo origen tras transferencia: " + tag.getSaldo());
        System.out.println("Saldo destino tras transferencia: " + tagDestino.getSaldo());
    }
}