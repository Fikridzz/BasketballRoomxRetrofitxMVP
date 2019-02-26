package com.example.fikridzakwan.basketballroomxretrofitxmvp.Detail;

import android.content.Context;
import android.os.Bundle;

import com.example.fikridzakwan.basketballroomxretrofitxmvp.Model.TeamsItem;

public interface DetailConstract {
    interface View {
        void showDetailClub(TeamsItem teamsItem);
        void showFailureMessage(String msg);
        void showSuccessMessage(String msg);
    }
    interface Presenter {
        void getDetailClub(Bundle bundle);
        void addFavorite(Context context, TeamsItem teamsItem);
        void deleteFavorite(Context context, TeamsItem teamsItem);
        Boolean checkFavorite(Context context, TeamsItem teamsItem);
    }
}
