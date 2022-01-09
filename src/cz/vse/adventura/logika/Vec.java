package cz.vse.adventura.logika;


/**
 * Trida Vec - popisuje jednotlivé veci v prostorech hry
 * <p>
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Matvii Stonaiev
 * @version pro školní rok 2021-2022
 */
public class Vec {
    private final String nazev;
    private final boolean prenositelna;


    public Vec(String nazev, boolean prenositelnost) {
        this.nazev = nazev;
        this.prenositelna = prenositelnost;
    }

    /**
     * Tato metoda vratí nazev veci
     *
     * @return nazev  veci
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Metoda vrati boolean muzeme prenest vec anebo ne
     *
     * @return zda vec je prenositelna nebo ne
     */
    public boolean isPrenositelna() {
        return prenositelna;
    }
}
