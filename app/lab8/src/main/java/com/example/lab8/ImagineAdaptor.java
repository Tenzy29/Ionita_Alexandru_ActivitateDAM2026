package com.example.lab8;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImagineAdaptor extends BaseAdapter {
    Context ctx;
    ArrayList<Imagine> listaImagini;

    public ImagineAdaptor(Context ctx, ArrayList<Imagine> listaImagini) {
        this.ctx = ctx;
        this.listaImagini = listaImagini;
    }

    @Override
    public int getCount() {
        return listaImagini.size();
    }

    @Override
    public Object getItem(int position) {
        return listaImagini.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = LayoutInflater.from(ctx);
        v = inflater.inflate(R.layout.custom_layout, parent, false);

        TextView titlu = v.findViewById(R.id.textView3);
        TextView desc = v.findViewById(R.id.textView4);
        ImageView img1 = v.findViewById(R.id.imageView2);



        Imagine i = (Imagine) getItem(position);
        if (i != null) {
            titlu.setText(i.titlu);
            desc.setText(i.descriere);
            img1.setImageBitmap(i.imagine);
        }

        return  v;
    }
}
