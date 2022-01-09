package cz.vse.adventura.logika;

/**
 * Třida PrikazMluvit ve hře implementuje příkaz mluvit.
 * <p>
 * Tato třída je součástí jednoduché textové hry
 *
 * @author Matvii Stonaiev
 * @version pro školní rok 2021-2022
 */

public class PrikazMluvit implements IPrikaz {
    private static final String NAZEV = "mluvit";
    private HerniPlan plan;

    /**
     * konstruktor třídy
     *
     * @param plan
     */
    public PrikazMluvit(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Tato metoda provedé příkaz mluvit.Mluví s nějakou postavou která ma standartní neměnnou odpověď
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return zpráva, která zavísí na podminkách
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Nevím s kým mluvit";
        }
        String mluvit = parametry[0];
        Prostor kdeJsem = plan.getAktualniProstor();
        NPC mluvici = kdeJsem.vratNPC(mluvit);


        if (mluvici == null) {
            return "To tu neni";
        } else {
            return mluvici.getCoRika();

        }
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
