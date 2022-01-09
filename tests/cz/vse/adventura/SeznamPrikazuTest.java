package cz.vse.adventura;

import cz.vse.adventura.logika.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testovací třída {@code SeznamPrikazuTest} slouží ke komplexnímu otestování
 * třídy {@link SeznamPrikazu}.
 *
 * @author Matvii Stonaiev
 * @version pro školní rok 2021-2022
 */

public class SeznamPrikazuTest {
    private Hra hra;
    private PrikazKonec prikazKonec;
    private PrikazJdi prikazJdi;


    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @BeforeEach
    public void setUp() {
        hra = new Hra();
        prikazKonec = new PrikazKonec(hra);
        prikazJdi = new PrikazJdi(hra.getHerniPlan());

    }


    @Test
    public void testVlozeniVybraniPrikazu() {
        SeznamPrikazu seznamPrikazu = new SeznamPrikazu();
        seznamPrikazu.vlozPrikaz(prikazKonec);
        seznamPrikazu.vlozPrikaz(prikazJdi);
        assertEquals(prikazKonec, seznamPrikazu.vratPrikaz("konec"));
        assertEquals(prikazJdi, seznamPrikazu.vratPrikaz("jdi"));
        assertEquals(null, seznamPrikazu.vratPrikaz("přidej"));
    }

    @Test
    public void testJePlatnyPrikaz() {
        SeznamPrikazu seznamPrikazu = new SeznamPrikazu();
        seznamPrikazu.vlozPrikaz(prikazKonec);
        seznamPrikazu.vlozPrikaz(prikazJdi);
        assertEquals(true, seznamPrikazu.jePlatnyPrikaz("konec"));
        assertEquals(true, seznamPrikazu.jePlatnyPrikaz("jdi"));
        assertEquals(false, seznamPrikazu.jePlatnyPrikaz("Zabit"));
        assertEquals(false, seznamPrikazu.jePlatnyPrikaz("Konec"));
    }

    @Test
    public void testVratNazvyPrikazu() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prikazJdi);
        seznPrikazu.vlozPrikaz(prikazKonec);
        String nazvy = seznPrikazu.vratNazvyPrikazu();
        assertEquals(true, nazvy.contains("konec"));
        assertEquals(true, nazvy.contains("jdi"));
        assertEquals(false, nazvy.contains("zabit"));
        assertEquals(false, nazvy.contains("Konec"));
    }


}
