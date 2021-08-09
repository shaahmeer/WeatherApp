package com.mirea.nawab.myapplication;

import java.util.List;

public class CityModel {
    public List<Weather> weather = null;
    public Main main;

    public class Main {
        public Float temp;
        public Integer pressure;
    }

    public class Weather {
        public String main;
        public String description;

    }



}
