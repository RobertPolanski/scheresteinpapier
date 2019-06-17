package de.robertpolanski.spiel.scheresteinpapier;

import de.robertpolanski.spiel.scheresteinpapier.helper.EingabeDatenHelper;
import de.robertpolanski.spiel.scheresteinpapier.helper.SpielHelper;
import de.robertpolanski.spiel.scheresteinpapier.helper.ZusammenFassungHelper;
import de.robertpolanski.spiel.scheresteinpapier.pojos.SpielParameters;

/**
 * Die Hauptklasse der Applikation
 */
public class SpielApp {

    private EingabeDatenHelper eingabeDatenHelper;
    private SpielHelper spielHelper;
    private ZusammenFassungHelper zusammenFassungHelper;

    private SpielApp() {
        this.eingabeDatenHelper = new EingabeDatenHelper();
        this.spielHelper = new SpielHelper();
        this.zusammenFassungHelper = new ZusammenFassungHelper();
    }

    public static void main(String[] args) {
        new SpielApp().startApp();
    }

    private void startApp() {
        SpielParameters spielParameters = eingabeDatenHelper.fuellSpielParametersAus();

        spielParameters = spielHelper.simulierDasSpiel(spielParameters);

        zusammenFassungHelper.fassAllesZussamen(spielParameters);
    }
}
