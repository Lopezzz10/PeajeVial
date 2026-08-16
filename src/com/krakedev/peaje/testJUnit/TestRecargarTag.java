package com.krakedev.peaje.testJUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.servicios.EstacionPeaje;

public class TestRecargarTag {

    @Test
    public void recargarTag() {
        EstacionPeaje estacion = new EstacionPeaje();
        TagElectronico tag = new TagElectronico("TAG001");

        estacion.recargarTag(tag, 10.0);

        assertEquals(10.0, tag.getSaldo());
    }
}