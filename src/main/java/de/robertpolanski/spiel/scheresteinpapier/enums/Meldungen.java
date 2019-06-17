package de.robertpolanski.spiel.scheresteinpapier.enums;

/**
 * Aufzählungstyp der Meldungen
 */
public enum Meldungen {

    WAEHL_EINE_STRATEGIE_FUER_DEN_ERSTEN_SPIELER("Wähl eine Strategie für den ersten Spieler: "),
    WAEHL_EINE_STRATEGIE_FUER_DEN_ZWEITEN_SPIELER("Wähl eine Strategie für den zweiten Spieler: "),
    GIB_DIE_ANZAHL_DER_RUNDEN_EIN("Gib die Anzahl der Runden ein: "),
    ES_IST_KEINE_ZAHL("Es ist keine Zahl!"),
    ANZAHL_DER_RUNDEN("Anzahl der Runden: "),
    SPIELER_1_HAT_PUNKTE("Spieler1 hat: {0} Punkte"),
    SPIELER_2_HAT_PUNKTE("Spieler2 hat: {0} Punkte");

    private String text;

    Meldungen(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
