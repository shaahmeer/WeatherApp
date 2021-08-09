package com.mirea.nawab.myapplication;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class API extends Application {
    static final String BASE_URL = "https://api.openweathermap.org";
    static final String API_KEY = "a560c345bcdcd8ad22a6baaf70f7a1ab";
    public static API instance = new API();
    private static Queries queries;

    public API() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        queries = retrofit.create(Queries.class);
    }
    public static Queries getApi() {
        return queries;
    }
    interface Queries {
        @GET("/data/2.5/weather?appid=" + API_KEY)
        Call<CityModel> getCity(@Query("q") String city);
    }
}