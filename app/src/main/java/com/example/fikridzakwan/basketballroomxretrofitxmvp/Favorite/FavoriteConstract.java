package com.example.fikridzakwan.basketballroomxretrofitxmvp.Favorite;

import android.content.Context;

import com.example.fikridzakwan.basketballroomxretrofitxmvp.Model.TeamsItem;

import java.util.List;

public interface FavoriteConstract {
    interface View {
        void showDataList(List<TeamsItem> teamsItemList);
        void showFailurMessage(String msg);
        void hideRefresh();
    }
    interface Presenter {
        void getDataListClub(Context context);
    }
}
