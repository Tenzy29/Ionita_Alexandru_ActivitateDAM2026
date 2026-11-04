package com.example.lab4_exercitiu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PreluareDate extends AppCompatActivity {

    EditText editTextDenumire, editTextModel, editTextAnFabricate;
    Switch switchTransmisie;
    RadioButton radioFata, radioSpate, radioIntegrala;
    CheckBox cbClima, cbIncalzire;
    RatingBar ratingBarStare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_preluare_date);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextDenumire = findViewById(R.id.etDenumire);
        editTextModel = findViewById(R.id.etModel);
        editTextAnFabricate = findViewById(R.id.etAnFabricate);
        switchTransmisie = findViewById(R.id.switchTransmisie);
        radioFata = findViewById(R.id.radioFata);
        radioSpate = findViewById(R.id.radioSpate);
        radioIntegrala = findViewById(R.id.radioIntegrala);
        cbClima = findViewById(R.id.checkClima);
        cbIncalzire = findViewById(R.id.checkIncalzire);
        ratingBarStare = findViewById(R.id.ratingBarStare);

        Button buton = findViewById(R.id.butonSalvare);
        buton.setOnClickListener(view -> {
            salveazaDate();
        });

    }


    void salveazaDate()
    {
        String denumire, model, tractiune = null;
        int anFabricate;
        boolean transmisieAutomata,areClima,areIncalzireScaune;
        float ratingStare;

        denumire = editTextDenumire.getText().toString();
        model = editTextModel.getText().toString();
        anFabricate = Integer.parseInt(editTextAnFabricate.getText().toString());
        transmisieAutomata = switchTransmisie.isChecked();
        if(radioFata.isChecked())
            tractiune = "Față";
        if(radioSpate.isChecked())
            tractiune = "Spate";
        if(radioIntegrala.isChecked())
            tractiune = "4x4";

        areClima = cbClima.isChecked();
        areIncalzireScaune = cbIncalzire.isChecked();
        ratingStare = ratingBarStare.getRating();

        Autoturism autoturism = new Autoturism(denumire,model,anFabricate,transmisieAutomata,tractiune,
                areClima,areIncalzireScaune,ratingStare);


        Intent it = new Intent();

//        Bundle bundle = new Bundle();
//        bundle.putSerializable("auto",autoturism);

//        it.putExtras(bundle);

        it.putExtra("auto",autoturism);
        setResult(RESULT_OK,it);

        finish();
    }

}