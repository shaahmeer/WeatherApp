package com.mirea.nawab.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity
{

    TextView textView1,textView2,textView3,textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView1=(TextView)findViewById(R.id.text1);
        textView2=(TextView)findViewById(R.id.text2);
        textView3=(TextView)findViewById(R.id.text3);
        textView4=(TextView)findViewById(R.id.text4);

        Intent intent= getIntent();
        textView3.setText(intent.getStringExtra("temp"));
        textView4.setText(intent.getStringExtra("pres"));
        textView1.setText(intent.getStringExtra("desc"));
        textView2.setText(intent.getStringExtra("main"));

        //textView4.setText(intent.getStringExtra(""));

      //  holder.textView1.setText(city.main.pressure.toString());
     //   holder.textView3.setText(temp.toString());
      //  holder.textView4.setText(city.weather.get(0).main);



    }
}