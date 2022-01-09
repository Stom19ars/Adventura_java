package cz.vse.adventura.logika;

/**
 * Trida NPC - popisuje postavy se kterými můžete mluvit běhěm hry
 * <p>
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author Matvii Stonaiev
 * @version pro školní rok 2021-2022.
 */

public class NPC {
    private String jmeno;
    private String coRika;

    public NPC(String jmeno, String coRika) {
        this.jmeno = jmeno;
        this.coRika = coRika;
    }

    /**
     * Tato metoda vratí jmeno NPC
     *
     * @return jmeno NPC
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * @return text který říká postava
     */
    public String getCoRika() {
        return coRika;
    }
}
