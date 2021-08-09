package com.mirea.nawab.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton btnOpen;
    adapter ad;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpen = findViewById(R.id.Add);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        recyclerView = findViewById(R.id.recycle);
        List<CityEntity> cities = App.getInstance().getDatabase().employeeDao().getAllPeople();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
            ad = new adapter(cities);
            recyclerView.setAdapter(ad);
        } catch (IOException e) {
            e.printStackTrace();
        }


        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update);
                EditText editText = dialog.findViewById(R.id.addweather);
                Button btn = dialog.findViewById(R.id.Add);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!editText.getText().toString().equals("")) {
                            CityEntity city = new CityEntity() {{
                                name = editText.getText().toString();
                            }};
                            App.getInstance().getDatabase().employeeDao().insertAll(city);
                            ad.cities.add(city);
                            dialog.dismiss();

                        }
                    }
                });
                dialog.show();

            }
        });
    }

;


}




