package cz.vse.adventura.logika;

/**
 * Třida PrikazZabit ve hře implementuje příkaz zabit.
 * <p>
 * Tato třída je součástí jednoduché textové hry
 *
 * @author Matvii Stonaiev
 * @version pro školní rok 2021-2022
 */

import java.util.ArrayList;
import java.util.List;

public class PrikazZabit implements IPrikaz {

    private static final String NAZEV = "zabit";
    private HerniPlan plan;
    private Hra hra;
    private Batoh mujBatoh;

    /**
     * Konstruktor tridy
     * @param plan
     * @param hra
     * @param mujBatoh
     */
    public PrikazZabit(HerniPlan plan, Hra hra, Batoh mujBatoh) {
        this.plan = plan;
        this.hra = hra;
        this.mujBatoh = mujBatoh;
    }

    /**
     *Provádí příkaz zabit, ve kterém kovboj zabíje zloděje a hra se skončí.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return zpráva, u které všechno závísí na podminkách
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getAktualniProstor().equals(plan.getHospodaSmrt())) {
            if (mujBatoh.getVeci().contains("cz.vse.adventura.logika.Vec@1f17ae12")) {
                hra.setKonecHry(true);
                return "Jste zabili zlodeje";
            }
            return "vole nemate revolver";
        }
        return "V tomto prostoru nemůžete níkoho zabit";

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
