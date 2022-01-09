package cz.vse.adventura.logika;

import java.util.List;

/**
 * Třida PrikazProhlednout ve hře implementuje příkaz prohlednout.
 * <p>
 * Tato třída je součástí jednoduché textové hry
 *
 * @author Matvii Stonaiev
 * @version pro školní rok 2021-2022
 */

public class PrikazProhlednout implements IPrikaz {

    private static final String NAZEV = "prohlednout";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     *
     * @param plan herní plán, ve kterém se bude ve hře "hledat"
     */
    public PrikazProhlednout(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Provádí příkaz "prohlednout".
     *
     * @param parametry - jako  parametr nic neobsahuje .
     * @return zpráva, která závísí na podminkách
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return popisVec();
        } else {
            return "Co mi říkaš?";
        }

    }

    private String popisVec() {
        Prostor kdeJa = plan.getAktualniProstor();
        List<Vec> veciVProstoru = kdeJa.getVeciVProstoru();
        if (veciVProstoru.size() == 0) {
            return "Nic tu není";
        } else {
            String vracenyText = "věci:";
            for (Vec neco : veciVProstoru) {
                vracenyText += " " + neco.getNazev();
            }
            if (vracenyText.equals("věci:")) {
                vracenyText = "";
            } else {
                vracenyText = vracenyText + ".";
            }
            return vracenyText;
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
