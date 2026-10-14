package com.example.lab2;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateNoua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_noua);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    public void deschideActivitate(View view)
    {
        Intent it = new Intent(this,Activitate3.class);
        Bundle bundle = new Bundle();

        bundle.putString("Mesaj","Mesaj din ActivitateNoua");
        bundle.putInt("Numar 1",5);
        bundle.putInt("Numar 2",7);

        it.putExtras(bundle);

        startActivityForResult(it,70);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NonNull ComponentCaller caller) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 70)
        {
            if(resultCode ==RESULT_OK){
                String mesaj = data.getStringExtra("mesaj");
                int suma = data.getIntExtra("suma", 0);
                StringBuilder sb = new StringBuilder(mesaj);
                sb.append(" ").append(suma);
                Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
            }
        }
    }
}