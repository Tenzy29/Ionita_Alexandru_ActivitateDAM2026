package com.example.lab4_exercitiu;

import java.io.Serializable;

public class Autoturism implements java.io.Serializable {

    private String denumire;
    private String model;
    private int anFabricate;
    private boolean transmisieAutomata;
    private String tractiune;
    private boolean areClima;
    private boolean areIncalzireScaune;
    private float ratingStare;

    public Autoturism() {
        this.denumire = " ";
        this.model =" ";
        this.anFabricate = 2000;
        this.transmisieAutomata = false;
        this.tractiune = "Față";
        this.areClima = false;
        this.areIncalzireScaune = false;
        this.ratingStare = 0.0f;
    }

    public Autoturism(String denumire, String model, int anFabricate,
                      boolean transmisieAutomata, String tractiune, boolean areClima,
                      boolean areIncalzireScaune, float ratingStare)
    {
        this.denumire = denumire;
        this.model = model;
        this.anFabricate = anFabricate;
        this.transmisieAutomata = transmisieAutomata;
        this.tractiune = tractiune;
        this.areClima = areClima;
        this.areIncalzireScaune = areIncalzireScaune;
        this.ratingStare = ratingStare;

    }

    @Override
    public String toString() {
        return "denumire='" + denumire + "\n" +
                "model=" + model + "\n" +
                "anFabricate=" + anFabricate +"\n"+
                "transmisieAutomata=" + transmisieAutomata + "\n"+
                "tractiune='" + tractiune + "\n" +
                "areClima=" + areClima +"\n"+
                "areIncalzireScaune=" + areIncalzireScaune +"\n"+
                "ratingStare=" + ratingStare;
    }

    public boolean isTransmisieAutomata() {
        return transmisieAutomata;
    }

    public void setTransmisieAutomata(boolean transmisieAutomata) {
        this.transmisieAutomata = transmisieAutomata;
    }

    public String getTractiune() {
        return tractiune;
    }

    public void setTractiune(String tractiune) {
        this.tractiune = tractiune;
    }

    public boolean isAreClima() {
        return areClima;
    }

    public void setAreClima(boolean areClima) {
        this.areClima = areClima;
    }

    public boolean isAreIncalzireScaune() {
        return areIncalzireScaune;
    }

    public void setAreIncalzireScaune(boolean areIncalzireScaune) {
        this.areIncalzireScaune = areIncalzireScaune;
    }

    public float getRatingStare() {
        return ratingStare;
    }

    public void setRatingStare(float ratingStare) {
        this.ratingStare = ratingStare;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAnFabricate() {
        return anFabricate;
    }

    public void setAnFabricate(int anFabricate) {
        this.anFabricate = anFabricate;
    }


}
