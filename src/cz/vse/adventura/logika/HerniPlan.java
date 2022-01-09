package cz.vse.adventura.logika;

/**
 * Trida HerniPlan - popisuje všechny prostory, věci, a NPC ve hře
 *
 * Tato třída je součástí jednoduché textové hry
 *
 * @author Stonaiev Matvii
 * @version pro školní rok 2021-2022
 */

public class HerniPlan {
    private Prostor aktualniProstor;
    private Prostor hospodaSmrtProstor;
    private Batoh mujBatoh;

    /**
     * Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();
    }

    /**
     * Vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor dum = new Prostor("domeček", "domeček, ve kterém bydlí starý kovboj");
        Prostor ulice = new Prostor("ulice", "prázdná ulice s mnoha bezdomovci a žebráky  ");
        Prostor hospoda = new Prostor("hospoda", "hospoda. Levný bar s línými číšníky a nejlepším pivem ve městě");
        Prostor obchodSeZbranemi = new Prostor("obchodSeZbraněmi", "obchod se zbraněmi se zbraní pro každý vkus a barvu");
        Prostor pristav = new Prostor("přístav", " přístav, ze kterého se dostanete do kterékoli části světa");
        Prostor mestoBoston = new Prostor("Boston", " Město se silným basketbalovým týmem Celtics");
        Prostor hospodaSmrt = new Prostor("hospodaSmrť", "tahle hospoda se tak jmenuje, protože tady někdo někoho zabije ");


        // přiřazují se průchody mezi prostory (sousedící prostory)
        dum.setVychod(ulice);
        ulice.setVychod(dum);
        hospoda.setVychod(ulice);
        ulice.setVychod(hospoda);
        obchodSeZbranemi.setVychod(ulice);
        ulice.setVychod(obchodSeZbranemi);
        pristav.setVychod(ulice);
        ulice.setVychod(pristav);
        pristav.setVychod(mestoBoston);
        mestoBoston.setVychod(pristav);
        mestoBoston.setVychod(hospodaSmrt);
        hospodaSmrt.setVychod(mestoBoston);

        Vec revolver = new Vec("revolverE95", true);
        Vec trezor = new Vec("trezor", false);

        Vec lucerna = new Vec("lucerna", false);

        Vec pivoSSebou = new Vec("pivoSsebou", true);

        Vec patronaE95 = new Vec("patronaE95", true);
        Vec patronaS66 = new Vec("patronaS66", true);
        Vec patronaM01 = new Vec("patronaM01", true);

        Vec lod = new Vec("lod", false);


        dum.setVec(revolver);
        dum.vlozVec(revolver);
        dum.setVec(trezor);
        dum.vlozVec(trezor);


        ulice.setVec(lucerna);
        ulice.vlozVec(lucerna);

        hospoda.setVec(pivoSSebou);
        hospoda.vlozVec(pivoSSebou);

        obchodSeZbranemi.setVec(patronaE95);
        obchodSeZbranemi.vlozVec(patronaE95);
        obchodSeZbranemi.setVec(patronaS66);
        obchodSeZbranemi.vlozVec(patronaS66);
        obchodSeZbranemi.setVec(patronaM01);
        obchodSeZbranemi.vlozVec(patronaM01);

        pristav.setVec(lod);
        pristav.vlozVec(lod);


        NPC bezdomovec = new NPC("bezdomovec", "Dej mi prosím peníze pro pivičko");
        NPC cisnik = new NPC("číšník", "Slyšel jsem, že ten kdo tebe okradl zítra bude pít pivičko v hospodě Smrť v Bostoně. Tak Spíchej. Jestli chceš můžeš vzit pivo s sebou pro štěstí.");
        NPC prodavacZbrane = new NPC("prodejce", "Ahoj kamoš. Vídím, že potřebuješ patrony pro svůj revolver. Tak vyber z těch které máme. Pro tebe je všechno zdarma");
        NPC kontrolor = new NPC("kontrolor", "Ahoj. Nedávno mi někdo okradl." + "\n" + "Hm... tak jestli jedeš do Bostona aby se pomstit tak dám ti tu jizdenku zdarma.Hlavně položi tomu konec");
        NPC zlodej = new NPC("zloděj", "Ahoj. Kdo jsi, že chceš se mnou mluvit?");


        ulice.vlozNPC(bezdomovec);
        hospoda.vlozNPC(cisnik);
        obchodSeZbranemi.vlozNPC(prodavacZbrane);
        pristav.vlozNPC(kontrolor);
        hospodaSmrt.vlozNPC(zlodej);

        aktualniProstor = dum;// hra začíná v domečku
        hospodaSmrtProstor = hospodaSmrt;
        mujBatoh = new Batoh(5);
    }

    /**
     * Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     * @return aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    public Prostor getHospodaSmrt() {
        return hospodaSmrtProstor;
    }


    public Batoh getMujBatoh() {
        return mujBatoh;
    }

    /**
     * Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     * @param prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }
}
