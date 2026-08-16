package com.krakedev.peaje.testJUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.servicios.EstacionPeaje;

public class TestTransferirSaldoTag {

    @Test
    public void transferirSaldoTag() {
        EstacionPeaje estacion = new EstacionPeaje();

        TagElectronico origen = new TagElectronico("TAG001");
        origen.setSaldo(10.0);

        TagElectronico destino = new TagElectronico("TAG002");
        destino.setSaldo(0.0);

        estacion.transferirSaldoTag(origen, destino, 4.0);

        assertEquals(6.0, origen.getSaldo());
        assertEquals(4.0, destino.getSaldo());
    }
}