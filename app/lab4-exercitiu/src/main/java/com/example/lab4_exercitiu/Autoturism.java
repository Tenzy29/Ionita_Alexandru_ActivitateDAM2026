package com.example.lab4_exercitiu;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Autoturism implements Parcelable {

    private String denumire;
    private String model;
    private int anFabricate;
    private boolean transmisieAutomata;
    private String tractiune;
    private boolean areClima;
    private boolean areIncalzireScaune;
    private float ratingStare;

    public Autoturism() {
        this.denumire = "fds ";
        this.model ="fds ";
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

    protected Autoturism(Parcel in) {
        denumire = in.readString();
        model = in.readString();
        anFabricate = in.readInt();
        transmisieAutomata = in.readByte() != 0;
        tractiune = in.readString();
        areClima = in.readByte() != 0;
        areIncalzireScaune = in.readByte() != 0;
        ratingStare = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(denumire);
        dest.writeString(model);
        dest.writeInt(anFabricate);
        dest.writeByte((byte) (transmisieAutomata ? 1 : 0));
        dest.writeString(tractiune);
        dest.writeByte((byte) (areClima ? 1 : 0));
        dest.writeByte((byte) (areIncalzireScaune ? 1 : 0));
        dest.writeFloat(ratingStare);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Autoturism> CREATOR = new Creator<Autoturism>() {
        @Override
        public Autoturism createFromParcel(Parcel in) {
            return new Autoturism(in);
        }

        @Override
        public Autoturism[] newArray(int size) {
            return new Autoturism[size];
        }
    };

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
