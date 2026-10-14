package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activitate3 extends AppCompatActivity {


    private int nr1;
    private int nr2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it = getIntent();
        Bundle bundle = it.getExtras();

        String mesaj = bundle.getString("Mesaj","");
        this.nr1 = bundle.getInt("Numar 1", 0);
        this.nr2 = bundle.getInt("Numar 2", 0);

        StringBuilder stringBuilder = new StringBuilder(mesaj);
        stringBuilder.append(" ");
        stringBuilder.append(this.nr1);
        stringBuilder.append(" ");
        stringBuilder.append(this.nr2);

        Toast.makeText(this,stringBuilder.toString(),Toast.LENGTH_SHORT).show();
    }


    public void intoarcereInActivitate(View view) {
        String altMesaj = "Mesaj de intoarcere";
        int suma = this.nr1 + this.nr2;

        Intent it = new Intent();
        it.putExtra("mesaj", altMesaj);
        it.putExtra("suma", suma);
        setResult(RESULT_OK,it);
        this.finish();
    }
}