package cz.vse.adventura.logika;

/**
 * Třida PrikazPridajVec ve hře implementuje příkaz přidej.
 * <p>
 * Tato třída je součástí jednoduché textové hry
 *
 * @author Matvii Stonaiev
 * @version pro školní rok 2021-2022
 */

public class PrikazPridajVec implements IPrikaz {

    private static final String NAZEV = "přidej";
    private final HerniPlan herniPlan;

    /**
     * Konstruktor tridy
     *
     * @param herniPlan
     */
    public PrikazPridajVec(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }


    /**
     * Provádí příkaz přidej, který přídává věc do batohu
     * jestli ona nachácí v aktualním prostoru a je přenositelná
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return zpráva, která zavísí na podminkách
     */
    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length == 0) {
            return "Nevim co musim sebrat:( Zadej nazev veci";
        } else if (parametry.length > 1) { //!!!!
            return "Muzu sebrat jen 1 vec";
        }

        Prostor aktualniProstor = herniPlan.getAktualniProstor();
        String nazevVeci = parametry[0];
        Vec vec = aktualniProstor.vratVec(nazevVeci);
        Batoh mujBatoh = herniPlan.getMujBatoh();

        if (vec == null) {
            return nazevVeci + " neni v prostoru";
        } else {
            if (vec.isPrenositelna() && mujBatoh.setVec(vec) == true) {
                mujBatoh.setVec(vec);
                System.out.println(mujBatoh.getNazevVec(mujBatoh.getNazvy()));
                return "Věc " + nazevVeci + " je pridana do batohu";
            } else {
                aktualniProstor.vlozVec(vec);
                if (vec.isPrenositelna()) {
                    return "Nemuzes unest tolik ve svem batohu";
                } else {
                    return "Tuto vec nemuzes sebrat";
                }
            }
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
