package cz.vse.adventura.logika;


import java.util.ArrayList;
import java.util.List;

/**
*Trida Batoh - popisuje batoh ve ktery uzivatel muze vkladat veci
*
 * Tato třída je součástí jednoduché textové hry
 *
 * @author Stonaiev Matvii
 * @version pro školní rok 2021-2022
*
 */
public class Batoh {

    private final int MAX_POCET_VECI;
    private List<Vec> veci;
    private ArrayList<String> nazevVec;


    public Batoh(int MAX_POCET_VECI) {
        this.MAX_POCET_VECI = MAX_POCET_VECI;
        veci = new ArrayList<Vec>();
        nazevVec = new ArrayList<String>();
    }

    /**
    *Jestli není převyšena kapacita batohu, tak přídáme do něho věc
    *
     */

    public boolean setVec(Vec predmet) {
        if (this.kontrolaKapacity() == true) {
            veci.add(predmet);
            nazevVec.add(predmet.getNazev());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Zkontrolujeme kapacitu batohy pomoci teto metody
     *
     */

    public boolean kontrolaKapacity() {
        if (veci.size() < MAX_POCET_VECI) {
            return true;
        }
        return false;
    }


    /**
     *Pokud máme věc v batohu, můžeme jeji odebrat z batohu
     *
     */
    public Vec odeberVec(String nazevVeci) {
        Vec vecVBatohu = null;
        for (Vec vecZeSeznamu : veci) {
            if (vecZeSeznamu.getNazev().equals(nazevVeci)) {
                vecVBatohu = vecZeSeznamu;
                veci.remove(vecVBatohu);
                break;
            }
        }
        return vecVBatohu;
    }

    public List getVeci() {
        return veci;
    }

    public ArrayList getNazvy() {
        return nazevVec;
    }

    public String getNazevVec(ArrayList nazevVec) {
        String result = " ";
        for (int i = 0; i < nazevVec.size(); i++) {
            result = result + nazevVec.get(i);
        }
        return result;
    }


    public boolean jeVec(String name) {
        for (int i = 0; i < veci.size(); i++) {
            if (veci.get(i).getNazev().equals(name)) {
                return true;
            }
        }
        return false;
    }


}










