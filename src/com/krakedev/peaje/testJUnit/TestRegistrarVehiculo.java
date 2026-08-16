package com.krakedev.peaje.testJUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.servicios.EstacionPeaje;

public class TestRegistrarVehiculo {

    @Test
    public void registrarVehiculo() {
        EstacionPeaje estacion = new EstacionPeaje();

        Vehiculo vehiculo = estacion.registrarVehiculo("ABC-123", "L", "1234567890", "Juan", "Perez", "TAG001");

        assertNotNull(vehiculo);
        assertEquals("ABC-123", vehiculo.getPlaca());
        assertEquals("L", vehiculo.getTipo());
        assertNotNull(vehiculo.getPropietario());
        assertEquals("Juan", vehiculo.getPropietario().getNombre());
        assertNotNull(vehiculo.getTag());
        assertEquals("TAG001", vehiculo.getTag().getIdTag());
    }
}