package cz.vse.adventura;

import cz.vse.adventura.logika.Hra;
import cz.vse.adventura.logika.NPC;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NPCTest {


    /**
     * Testuje trida NPC, ze muze vratit jmeno NPC a co on rika pri komunikace s nim
     */
    @Test
    public void testNPC() {
        NPC npc1 = new NPC("Matvii", "Dekuji za max bod z adventury:)");
        assertEquals("Matvii", npc1.getJmeno());
        assertEquals("Matvii", npc1.getJmeno());
        assertEquals("Dekuji za max bod z adventury:)", npc1.getCoRika());

    }

}
