package de.robertpolanski.spiel.scheresteinpapier.pojos;

/**
 * Eine Klasse die Spiel-Kontext representiert.
 * Die Klasse beinhaltet alle nötigen Daten und Konfiguration.
 */
public class SpielParameters {

    private Spieler spieler1;
    private Spieler spieler2;
    private int rundenAnzahl;

    public SpielParameters(Spieler spieler1, Spieler spieler2, int rundenAnzahl) {
        this.spieler1 = spieler1;
        this.spieler2 = spieler2;
        this.rundenAnzahl = rundenAnzahl;
    }


    public int getRundenAnzahl() {
        return rundenAnzahl;
    }

    public void setRundenAnzahl(int rundenAnzahl) {
        this.rundenAnzahl = rundenAnzahl;
    }

    public Spieler getSpieler1() {
        return spieler1;
    }

    public void setSpieler1(Spieler spieler1) {
        this.spieler1 = spieler1;
    }

    public Spieler getSpieler2() {
        return spieler2;
    }

    public void setSpieler2(Spieler spieler2) {
        this.spieler2 = spieler2;
    }
}
