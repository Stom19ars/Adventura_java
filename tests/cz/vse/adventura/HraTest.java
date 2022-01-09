package cz.vse.adventura;

import cz.vse.adventura.logika.Batoh;
import cz.vse.adventura.logika.Hra;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Testovací třída {@code HraTest} slouží ke komplexnímu otestování
 * třídy {@link Hra}.
 *
 * @author Matvii Stonaiev
 * @version pro školní rok 2021-2022
 */

public class HraTest {

    private Hra hra;


    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @BeforeEach
    public void setUp() {
        hra = new Hra();
    }


    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     *
     */
    @Test
    public void testHra() {
        assertEquals("domeček", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("jdi ulice");
        assertFalse(hra.konecHry());

        assertEquals("ulice", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("mluvit bezdomovec");
        assertFalse(hra.konecHry());

        hra.zpracujPrikaz("jdi obchodSeZbraněmi");
        assertFalse(hra.konecHry());
        hra.zpracujPrikaz("prohlednout");
        assertFalse(hra.konecHry());
        hra.zpracujPrikaz("konec");
        assertTrue(hra.konecHry());
    }


    @Test
    public void testVyhratHru() {
        assertEquals("domeček", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("prohlednout");
        assertFalse(hra.konecHry());
        hra.zpracujPrikaz("přidej revolverE95");
        hra.zpracujPrikaz("jdi ulice");
        assertEquals("ulice", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("jdi hospoda");
        assertEquals("hospoda", hra.getHerniPlan().getAktualniProstor().getNazev());
        assertFalse(hra.konecHry());
        hra.zpracujPrikaz("mluvit číšník");
        assertEquals("Slyšel jsem, že ten kdo tebe okradl zítra bude pít pivičko v hospodě Smrť v Bostoně. Tak Spíchej. Jestli chceš můžeš vzit pivo s sebou pro štěstí.", hra.getHerniPlan().getAktualniProstor().vratNPC("číšník").getCoRika());
        hra.zpracujPrikaz("jdi ulice");
        assertEquals("ulice", hra.getHerniPlan().getAktualniProstor().getNazev());
        assertFalse(hra.konecHry());
        hra.zpracujPrikaz("jdi obchodSeZbraněmi");
        hra.zpracujPrikaz("mluvit prodejce");
        assertEquals("Ahoj kamoš. Vídím, že potřebuješ patrony pro svůj revolver. Tak vyber z těch které máme. Pro tebe je všechno zdarma", hra.getHerniPlan().getAktualniProstor().vratNPC("prodejce").getCoRika());
        assertFalse(hra.konecHry());
        hra.zpracujPrikaz("prohlednout");
        hra.zpracujPrikaz("přidej patronaE95");
        hra.zpracujPrikaz("jdi ulice");
        assertEquals("ulice", hra.getHerniPlan().getAktualniProstor().getNazev());
        assertFalse(hra.konecHry());
        hra.zpracujPrikaz("jdi přístav");
        assertEquals("přístav", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("jdi Boston");
        hra.zpracujPrikaz("jdi hospodaSmrť");
        assertEquals("hospodaSmrť", hra.getHerniPlan().getAktualniProstor().getNazev());
        assertFalse(hra.konecHry());
        hra.zpracujPrikaz("mluvit zloděj");
        assertEquals("Ahoj. Kdo jsi, že chceš se mnou mluvit?", hra.getHerniPlan().getAktualniProstor().vratNPC("zloděj").getCoRika());
        assertFalse(hra.konecHry());
        hra.zpracujPrikaz("zabit");
        assertEquals(true, hra.konecHry());


    }


}

