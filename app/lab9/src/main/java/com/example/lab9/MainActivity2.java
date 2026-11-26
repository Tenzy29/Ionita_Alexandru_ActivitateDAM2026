package com.example.lab9;

import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity2 extends AppCompatActivity {

    Button butonAPI;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = findViewById(R.id.editTextOras);
        textView = findViewById(R.id.textView);


        butonAPI = findViewById(R.id.buttonAPI);
        butonAPI.setOnClickListener(v -> {

            String oras = editText.getText().toString();

            Executor executor = Executors.newSingleThreadExecutor();

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Handler handler = new Handler(Looper.getMainLooper());

                        String link = "https://dataservice.accuweather.com/locations/v1/cities/search";
                        String apiKey = "{}";

                        link+= "?apikey=" + apiKey + "&q=" + oras;

                        //primu url si cheie
                        URL url = new URL(link);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        StringBuilder builder = new StringBuilder();
                        String cheie;

                        String linie = reader.readLine();
                        while(linie!=null)
                        {
                            builder.append(linie);
                            linie = reader.readLine();
                        }
                        JSONArray jsonArray = new JSONArray(builder.toString());
                        JSONObject jsonObject = jsonArray.getJSONObject(0);
                        cheie = jsonObject.getString("Key");

//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                textView.setText(cheie);
//                            }
//                        });

                        //al doilea url cu forecast
                        String link2 = "https://dataservice.accuweather.com/forecasts/v1/daily/1day/" +cheie +"?apikey={}&metric=true";
                        URL url2 = new URL(link2);
                        HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();

                        BufferedReader reader2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
                        StringBuilder builder2 = new StringBuilder();

                        String linie2 = reader2.readLine();
                        while(linie2!=null)
                        {
                            builder2.append(linie2);
                            linie2 = reader2.readLine();
                        }
                        JSONObject jsonObject21 = new JSONObject(builder2.toString());
                        JSONArray jsonArray2 = jsonObject21.getJSONArray("DailyForecasts");
                        JSONObject jsonObject22 = jsonArray2.getJSONObject(0);
                        JSONObject temperatura = jsonObject22.getJSONObject("Temperature");
                        JSONObject min = temperatura.getJSONObject("Minimum");
                        Double value = min.getDouble("Value");
                        JSONObject max = temperatura.getJSONObject("Maximum");
                        Double value2 = max.getDouble("Value");

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText("Temp min: " + value.toString() +" \n Temp max: " + value2.toString());
                            }
                        });

                        Log.wtf("tag1",builder.toString());
                        Log.wtf("tag2",cheie);
                        Log.wtf("tag3",value2.toString() + " "+ value.toString());




                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }



                }
            });




        });


    }



}