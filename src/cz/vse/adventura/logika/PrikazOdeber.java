package cz.vse.adventura.logika;

/**
 * Třida PrikazOdeber ve hře implementuje příkaz odeber.
 * <p>
 * Tato třída je součástí jednoduché textové hry
 *
 * @author Matvii Stonaiev
 * @version pro školní rok 2021-2022
 */

public class PrikazOdeber implements IPrikaz {
    private static final String NAZEV = "odeber";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     */
    public PrikazOdeber(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Provádí příkaz "odeber".
     *
     * @param parametry - jako  parametr obsahuje jmeno veci.
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo tak ....
            return "Co mám odebrat? Napiš název předmětu.";
        }

        String coOdebratNazev = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        Batoh mujBatoh = plan.getMujBatoh();
        Vec vecOdebrat = mujBatoh.odeberVec(coOdebratNazev);


        if (vecOdebrat == null) {
            return "To neni v batohu";
        } else {

            aktualniProstor.vlozVec(vecOdebrat);
            return "odebral jsi " + vecOdebrat.getNazev() + " z batohu.";
        }
    }


    /**
     * Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     * @return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }


}
