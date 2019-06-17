package de.robertpolanski.spiel.scheresteinpapier.strategie.impl;

import de.robertpolanski.spiel.scheresteinpapier.enums.FigurEnum;
import de.robertpolanski.spiel.scheresteinpapier.strategie.Strategie;

/**
 * Eine Implementierung von "ImmerStein" Strategie.
 * Es wird immer nur Stein Figur generiert.
 */
public class ImmerSteinStrategie implements Strategie {


    @Override
    public FigurEnum generiereFigur() {

        return FigurEnum.STEIN;
    }
}
