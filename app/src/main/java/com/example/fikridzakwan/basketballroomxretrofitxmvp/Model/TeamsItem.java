package com.example.fikridzakwan.basketballroomxretrofitxmvp.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "teams")
public class TeamsItem implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "idTeam")
    @SerializedName("idTeam")
    @NonNull private String idTeam;

    @ColumnInfo(name = "nama_team")
    @SerializedName("strTeam")
    private String nama_team;

    @ColumnInfo(name = "gambar_stadium")
    @SerializedName("strStadiumThumb")
    private String gambar_stadium;

    @ColumnInfo(name = "stadium_description")
    @SerializedName("strStadiumDescription")
    private String stadium_description;

    @ColumnInfo(name = "stadium_location")
    @SerializedName("strStadiumLocation")
    private String stadium_location;

    @ColumnInfo(name = "team_description")
    @SerializedName("strDescriptionEN")
    private String team_description;

    @ColumnInfo(name = "gambar_team")
    @SerializedName("strTeamBadge")
    private String gambar_team;

    @ColumnInfo(name = "nama_stadium")
    @SerializedName("strStadium")
    private String nama_stadium;

    public TeamsItem(String idTeam, String nama_team, String gambar_stadium, String stadium_description, String stadium_location, String team_description, String gambar_team, String nama_stadium) {
        this.idTeam = idTeam;
        this.nama_team = nama_team;
        this.gambar_stadium = gambar_stadium;
        this.stadium_description = stadium_description;
        this.stadium_location = stadium_location;
        this.team_description = team_description;
        this.gambar_team = gambar_team;
        this.nama_stadium = nama_stadium;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public String getNama_team() {
        return nama_team;
    }

    public String getGambar_stadium() {
        return gambar_stadium;
    }

    public String getStadium_description() {
        return stadium_description;
    }

    public String getStadium_location() {
        return stadium_location;
    }

    public String getTeam_description() {
        return team_description;
    }

    public String getGambar_team() {
        return gambar_team;
    }

    public String getNama_stadium() {
        return nama_stadium;
    }
}
