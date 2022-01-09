package cz.vse.adventura;

import cz.vse.adventura.logika.Batoh;
import cz.vse.adventura.logika.Vec;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testovací třída {@code BatohTest} slouží ke komplexnímu otestování
 * třídy {@link Batoh}.
 *
 * @author Matvii Stonaiev
 * @version pro školní rok 2021-2022
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BatohTest {
    private Batoh batoh;
    private Vec vec;

    /**
     * Metoda, která testuje třidu batoh, že do batohu lze přídat věc a odebrat je
     * a taky, že má určitou kapacitu
     */

    @Test
    public void testBatoh() {
        batoh = new Batoh(3);
        Vec vec1 = new Vec("revolver", true);
        Vec vec2 = new Vec("trezor", false);
        Vec vec3 = new Vec("patrona1", true);
        Vec vec4 = new Vec("patrona2", true);
        Vec vec5 = new Vec("patrona3", true);

        assertEquals(true, batoh.setVec(vec1));
        assertEquals(true, batoh.setVec(vec2));
        assertEquals(true, batoh.setVec(vec3));
        assertEquals(vec3, batoh.odeberVec("patrona1"));
        assertEquals(true, batoh.setVec(vec4));
        assertEquals(false, batoh.setVec(vec5));


    }
}
