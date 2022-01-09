package cz.vse.adventura;


import cz.vse.adventura.logika.Hra;
import cz.vse.adventura.logika.IHra;
import cz.vse.adventura.uiText.TextoveRozhrani;

/*******************************************************************************
 * Třída  Start je hlavní třídou projektu,
 * který představuje jednoduchou textovou adventuru určenou k dalším úpravám a rozšiřování
 *
 * @author Matvii Stonaiev
 * @version ZS 2021-2022
 */
public class Start {
    /***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args) {

        IHra hra = new Hra();
        TextoveRozhrani ui = new TextoveRozhrani(hra);

        if (args.length == 0) {
            ui.hraj();
        } else {
            ui.hrajZeSouboru(args[0]);
        }


    }
}
