package cz.vse.adventura.logika;

/**
 * Třída PrikazNapoveda implementuje pro hru příkaz napoveda.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Matvii Stonaiev
 * @version pro školní rok 2021-2022
 */

public class PrikazNapoveda implements IPrikaz {

    private static final String NAZEV = "nápověda";
    private SeznamPrikazu platnePrikazy;

    /**
     * Konstruktor třídy
     *
     * @param platnePrikazy seznam příkazů,
     *                      které je možné ve hře použít,
     *                      aby je nápověda mohla zobrazit uživateli.
     */
    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }

    /**
     * Vrací základní nápovědu po zadání příkazu "napoveda". Nyní se vypisuje
     * vcelku primitivní zpráva a seznam dostupných příkazů.
     *
     * @return napoveda ke hre
     */
    @Override
    public String provedPrikaz(String... parametry) {
        return "Tvým úkolem je zabit zloděje\n"
                + "Pro dosažení cíle můžeš zadat tyto příkazy:\n"
                + platnePrikazy.vratNazvyPrikazu();
    }

    /**
     * Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     * @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
