package cz.vse.adventura;

import cz.vse.adventura.logika.Hra;
import cz.vse.adventura.logika.Vec;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testovací třída {@code VecTest} slouží ke komplexnímu otestování
 * třídy {@link Vec}.
 *
 * @author Matvii Stonaiev
 * @version pro školní rok 2021-2022
 */

public class VecTest {


    /**
     * Metoda slouzi pro testovani zda vec muze vratit nazev veci a jeji prenositelnost
     */
    @Test
    public void testVec() {
        Vec vec1 = new Vec("revolver", true);
        Vec vec2 = new Vec("trezor", false);
        assertEquals("revolver", vec1.getNazev());
        assertEquals(true, vec1.isPrenositelna());
    }


}
