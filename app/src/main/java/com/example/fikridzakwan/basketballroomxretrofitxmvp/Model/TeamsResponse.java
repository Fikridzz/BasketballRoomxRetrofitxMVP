package com.example.fikridzakwan.basketballroomxretrofitxmvp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamsResponse {

    @SerializedName("teams")
    List<TeamsItem> items;

    public List<TeamsItem> getItems() {
        return items;
    }
}
