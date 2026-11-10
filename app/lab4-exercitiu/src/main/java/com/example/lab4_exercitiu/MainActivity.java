package com.example.lab4_exercitiu;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Autoturism autoturism;

    ArrayList<Autoturism> listaAutoturisme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        textView = findViewById(R.id.tvAuto);
        listaAutoturisme = new ArrayList<>();
    }

    public void deschideActivitatePreluareDate(View view)
    {
        Intent it = new Intent(this,PreluareDate.class);
        startActivityForResult(it,70);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 70 && resultCode == RESULT_OK)
        {
            autoturism = (Autoturism) data.getParcelableExtra("auto");


            String mesaj = "Salvat: "+"\n"+ autoturism.toString();
            Toast.makeText(this, mesaj, Toast.LENGTH_SHORT).show();



            listaAutoturisme.add(autoturism);

            Intent it2 = new Intent(this,AfisareLista.class);

            it2.putExtra("lista",listaAutoturisme);
            startActivityForResult(it2,80);
        }
    }
}