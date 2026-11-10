package com.example.lab4_exercitiu;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class AfisareLista extends AppCompatActivity {

    ListView listView;
    ArrayList<Autoturism> listaAutoturisme = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_afisare_lista);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.lvAutotuisme);

        listaAutoturisme = (ArrayList<Autoturism>) getIntent().getSerializableExtra("lista");

        if (listaAutoturisme == null) {
            listaAutoturisme = new ArrayList<>();
        }

//        ArrayAdapter<Autoturism> adapter=new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                listaAutoturisme);


        AutoturismAdaptor adapter =new AutoturismAdaptor(this,listaAutoturisme);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), listaAutoturisme.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listaAutoturisme.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Sters", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

}