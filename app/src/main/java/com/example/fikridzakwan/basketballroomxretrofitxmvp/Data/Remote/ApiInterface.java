package com.example.fikridzakwan.basketballroomxretrofitxmvp.Data.Remote;

import com.example.fikridzakwan.basketballroomxretrofitxmvp.Model.TeamsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/v1/json/1/lookup_all_teams.php")
    Call<TeamsResponse> getTeams (@Query("id") int idClub);

    @GET("api/v1/json/1/lookupteam.php")
    Call<TeamsResponse> getTeamsDetail (@Query("id") int idDetail);
}
