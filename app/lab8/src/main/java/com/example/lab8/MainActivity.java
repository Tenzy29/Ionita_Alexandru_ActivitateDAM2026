package com.example.lab8;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    Button buton;
    ArrayList<Imagine> listaImagini = new ArrayList<>();


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


        ArrayList<String> linkuriImagini = new ArrayList<>();

        linkuriImagini.add("https://lcdn.altex.ro/resize/media/catalog/product/g/t/16fa6a9aef7ffd6209d5fd9338ffa0b1/gta_vi_ps5_11_410b9d1e.jpg");
        linkuriImagini.add("https://lcdn.altex.ro/resize/media/catalog/product/J/O/16fa6a9aef7ffd6209d5fd9338ffa0b1/JOCPS5UNCHLOTC_1.jpg");
        linkuriImagini.add("https://lcdn.altex.ro/resize/media/catalog/product/G/h/16fa6a9aef7ffd6209d5fd9338ffa0b1/Ghost-of-Tsushima-Directors-Cut-PS5-2D-Coperta.jpg");
        linkuriImagini.add("https://lcdn.altex.ro/resize/media/catalog/product/m/i/16fa6a9aef7ffd6209d5fd9338ffa0b1/minecraft_01_1b3265f2.jpg");
        linkuriImagini.add("https://lcdn.altex.ro/resize/media/catalog/product/G/r/16fa6a9aef7ffd6209d5fd9338ffa0b1/Grand-Theft-Auto-V-GTA-5-PS5-2D-Coperta.jpg");


        ArrayList<Bitmap> imagini = new ArrayList<>();


        buton = findViewById(R.id.button);
        buton.setEnabled(false);

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());


        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (String link : linkuriImagini) {
                    HttpURLConnection connection = null;

                    try {
                        URL url = new URL(link);
                        connection = (HttpURLConnection) url.openConnection();

                        try (InputStream is = connection.getInputStream()) {
                            Bitmap bitmap = BitmapFactory.decodeStream(is);

                            if (bitmap != null) {
                                imagini.add(bitmap);
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (connection != null) {
                            connection.disconnect();
                        }
                    }
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                            listaImagini.add(new Imagine(imagini.get(0), "GTA VI", "Cel mai nou joc gen"));
                            listaImagini.add(new Imagine(imagini.get(1), "Uncharted", "Cel mai nou joc gen"));
                            listaImagini.add(new Imagine(imagini.get(2), "Ghost of Tsushima", "Cel mai nou joc gen"));
                            listaImagini.add(new Imagine(imagini.get(3), "Minecraft", "Cel mai nou joc gen"));
                            listaImagini.add(new Imagine(imagini.get(4), "GTA V", "Cel mai nou joc gen"));


                        buton.setEnabled(true);
                    }
                });
            }
        });




        buton.setOnClickListener(v -> {
            Intent intent1 = new Intent(this,ListActivity.class);
            intent1.putParcelableArrayListExtra("listaImagini",listaImagini);
            startActivity(intent1);
        });


    }



}
