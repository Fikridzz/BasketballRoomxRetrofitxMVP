package com.example.fikridzakwan.basketballroomxretrofitxmvp.Data.Remote;

import com.example.fikridzakwan.basketballroomxretrofitxmvp.Utilts.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit =null;

    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
