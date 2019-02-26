package com.example.fikridzakwan.basketballroomxretrofitxmvp.Favorite;

import android.content.Context;

import com.example.fikridzakwan.basketballroomxretrofitxmvp.Data.Local.BasketballDB;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Model.TeamsItem;

import java.util.List;

public class FavoritePresenter implements FavoriteConstract.Presenter {

    private final FavoriteConstract.View view;
    private BasketballDB basketballDB;

    public FavoritePresenter(FavoriteConstract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListClub(Context context) {
        basketballDB = BasketballDB.getBaskettballDB(context);

        if (basketballDB.basketballDao().selectFavorite() != null) {
            List<TeamsItem> list = basketballDB.basketballDao().selectFavorite();
            view.showDataList(list);
        } else {
            view.showFailurMessage("There is no favorite in here");
        }
        view.hideRefresh();
    }
}
