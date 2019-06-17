package de.robertpolanski.spiel.scheresteinpapier.pojos;

import de.robertpolanski.spiel.scheresteinpapier.enums.StrategieEnum;

/**
 * Pojo Klasse, die einen Spieler repräsentiert.
 */
public class Spieler {

    private StrategieEnum strategieEnum;

    private int punkte;

    public Spieler(StrategieEnum strategieEnum) {
        this.strategieEnum = strategieEnum;
    }

    public Spieler(StrategieEnum strategieEnum, int punkte) {
        this.strategieEnum = strategieEnum;
        this.punkte = punkte;
    }

    public StrategieEnum getStrategieEnum() {
        return strategieEnum;
    }

    public void setStrategieEnum(StrategieEnum strategieEnum) {
        this.strategieEnum = strategieEnum;
    }

    public void inkrementierEinenPunkt() {
        this.punkte++;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
}
