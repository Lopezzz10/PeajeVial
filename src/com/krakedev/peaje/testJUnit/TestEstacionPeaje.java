package com.krakedev.peaje.testJUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.servicios.EstacionPeaje;

public class TestEstacionPeaje {

    @Test
    public void testRegistrarVehiculoConTipoValido() {
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

    @Test
    public void testRegistrarVehiculoConTipoInvalido() {
        EstacionPeaje estacion = new EstacionPeaje();

        Vehiculo vehiculo = estacion.registrarVehiculo("XYZ-999", "M", "0987654321", "Ana", "Lopez", "TAG002");

        assertNull(vehiculo);
    }
}