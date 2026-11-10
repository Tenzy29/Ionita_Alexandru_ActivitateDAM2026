package com.example.lab4_exercitiu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AutoturismAdaptor extends BaseAdapter {

    private Context ctx;
    private List<Autoturism> autoturisme;

    public AutoturismAdaptor(Context ctx, List<Autoturism> autoturisme) {
        this.ctx = ctx;
        this.autoturisme = autoturisme;
    }

    @Override
    public int getCount() {
        return this.autoturisme.size();
    }

    @Override
    public Object getItem(int position) {
        return this.autoturisme.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(R.layout.listview_layout, parent,false);

        TextView tv1 = v.findViewById(R.id.text1);
        TextView tv2 = v.findViewById(R.id.text2);
        TextView tv3 = v.findViewById(R.id.text3);


        Autoturism a = (Autoturism) getItem(position);
        tv1.setText(a.getDenumire());
        tv2.setText(a.getModel());
        tv3.setText(String.valueOf(a.getAnFabricate()));

//        DE CONTINUAT CU CELELALTE ATRIBUTE

        return v;
    }
}
