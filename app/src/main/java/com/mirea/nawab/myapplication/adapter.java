package com.mirea.nawab.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewholder>{
    API api;
    List<CityEntity> cities;
    private AdapterView.OnItemClickListener onItemClickListener;
    Context context;


    public adapter(List<CityEntity> cities) throws IOException {
        this.cities = cities;
        this.api = new API();
    }

    @NonNull
    @NotNull
    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.single_item,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull viewholder holder, int position) {
        String cityName = cities.get(position).name;


        try {
            CityModel city = API.getApi().getCity(cityName).execute().body();
            holder.setCityModel(city);
            Float temp = city.main.temp - 273.15F;
            holder.textView.setText(cityName);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        CityModel cityModel;
        private TextView textView;
        private TextView textView1;
        private TextView textView3;
        private TextView textView4;
        public ImageView del;

        public viewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.text);
          //  textView1=(TextView)itemView.findViewById(R.id.text1);
           // textView3=(TextView)itemView.findViewById(R.id.text3);
         //   textView4=(TextView)itemView.findViewById(R.id.text4);
            del=(ImageView)itemView.findViewById(R.id.delete);
del.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int pos = getAdapterPosition();
        App.getInstance().getDatabase().employeeDao().delete(cities.get(pos));
        cities.remove(pos);
        notifyItemRemoved(pos);
    }
});



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), MainActivity2.class);
                    Float temp = cityModel.main.temp - 273.15F;
                    Integer pressure = cityModel.main.pressure;
                    String main = cityModel.weather.get(0).main;
                    String disc = cityModel.weather.get(0).description;
                    intent.putExtra("desc", disc);
                    intent.putExtra("main", main);
                    intent.putExtra("pres", pressure.toString());
                    intent.putExtra("temp", temp.toString());
                    itemView.getContext().startActivity(intent);
                }
            });

        }

        public void setCityModel(CityModel cityModel) {
            this.cityModel = cityModel;
        }
    }

}
