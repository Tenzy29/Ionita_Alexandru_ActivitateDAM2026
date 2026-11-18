package com.example.lab8;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Imagine implements Parcelable {
    Bitmap imagine;
    String titlu;
    String descriere;

    public Imagine(Bitmap imagine, String titlu, String descriere) {
        this.imagine = imagine;
        this.titlu = titlu;
        this.descriere = descriere;
    }


    protected Imagine(Parcel in) {
        imagine = in.readParcelable(Bitmap.class.getClassLoader());
        titlu = in.readString();
        descriere = in.readString();
    }

    public static final Creator<Imagine> CREATOR = new Creator<Imagine>() {
        @Override
        public Imagine createFromParcel(Parcel in) {
            return new Imagine(in);
        }

        @Override
        public Imagine[] newArray(int size) {
            return new Imagine[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(imagine, flags);
        dest.writeString(titlu);
        dest.writeString(descriere);
    }
}
