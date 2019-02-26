package com.example.fikridzakwan.basketballroomxretrofitxmvp.Home;

import com.example.fikridzakwan.basketballroomxretrofitxmvp.Model.TeamsItem;

import java.util.List;

public interface HomeConstract {
    interface View {
        void showProgress();
        void hideProgress();
        void showFailurMessage(String msg);
        void showDataListTeams(List<TeamsItem> teamsItemList);
    }
    interface Presenter {
        void getDataListTeams();
    }
}
