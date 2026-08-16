package com.krakedev.peaje.testJUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.servicios.EstacionPeaje;

public class TestCobrarPeaje {

    @Test
    public void cobrarPeaje() {
        EstacionPeaje estacion = new EstacionPeaje();

        Vehiculo vehiculo = new Vehiculo("ABC-123");
        vehiculo.setTipo("L");

        TagElectronico tag = new TagElectronico("TAG001");
        tag.setSaldo(5.0);
        vehiculo.setTag(tag);

        estacion.cobrarPeaje(vehiculo);

        assertEquals(4.0, tag.getSaldo());
    }
}