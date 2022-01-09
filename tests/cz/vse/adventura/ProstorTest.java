package cz.vse.adventura;

import cz.vse.adventura.logika.Hra;
import cz.vse.adventura.logika.Prostor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testovací třída {@code ProstorTest} slouží ke komplexnímu otestování
 * třídy {@link Prostor}.
 *
 * @author Matvii Stonaiev
 * @version pro školní rok 2021-2022
 */

public class ProstorTest {


    /**
     * Testuje trida prostor, ze muzeme nastavit vychody a vratit sousedni prostory (spojovat mistnosti mezi sebou)
     */
    @Test
    public void testProstor() {

        Prostor prostor1 = new Prostor("Domecek", "odkud kovboj zacina");
        Prostor prostor2 = new Prostor("Ulice", "ulice");
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor1, prostor2.vratSousedniProstor("Domecek"));
        assertEquals(null, prostor2.vratSousedniProstor("Hospoda"));

    }
}
