package de.robertpolanski.spiel.scheresteinpapier.enums;

/**
 * Aufzählungstyp der Figuren.
 */
public enum FigurEnum {
    SCHERE(0, "Schere"), PAPIER(1, "Papier"), STEIN(2, "Stein");

    private int index;
    private String name;


    FigurEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
