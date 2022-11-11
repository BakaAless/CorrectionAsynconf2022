package me.redstom.exo1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exo1Test {

    private Exo1 exo1;

    @BeforeEach
    public void init() {
        this.exo1 = new Exo1();
    }

    @Test
    void code() {

        assertEquals("J6T4", exo1.code("Jupiter", "Terre"));
        assertEquals("L3T4S5", exo1.code("Lune", "Terre", "Soleil"));
        assertEquals("T4M3Me5", exo1.code("Terre", "Mars", "Mercure"));
        assertEquals("P5M6T4Ma2C6", exo1.code("Pluton", "Mercure", "Terre", "Mars", "Calisto"));

    }
}
