package cz.vse.adventura.logika;

public class PrikazBatoh implements IPrikaz {
    private static final String NAZEV = "getBatoh";
    private Batoh mujBatoh;

    public PrikazBatoh(Batoh mujBatoh) {
        this.mujBatoh = mujBatoh;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        return "Batoh: " + mujBatoh.getNazevVec(mujBatoh.getNazvy());

    }


    @Override
    public String getNazev() {
        return NAZEV;
    }
}


