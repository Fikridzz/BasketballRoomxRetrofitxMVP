package com.example.fikridzakwan.basketballroomxretrofitxmvp.Detail;

import android.content.Context;
import android.os.Bundle;

import com.example.fikridzakwan.basketballroomxretrofitxmvp.Data.Local.BasketballDB;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Model.TeamsItem;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Utilts.Constants;

public class DetailPresenter implements DetailConstract.Presenter{

    private final DetailConstract.View view;
    private BasketballDB basketballDB;

    public DetailPresenter(DetailConstract.View view) {
        this.view = view;
    }

    @Override
    public void getDetailClub(Bundle bundle) {
        if (bundle != null) {
            TeamsItem teamsItem = (TeamsItem) bundle.getSerializable(Constants.KEY_DATA);
            view.showDetailClub(teamsItem);
        }
    }

    @Override
    public void addFavorite(Context context, TeamsItem teamsItem) {
        basketballDB = BasketballDB.getBaskettballDB(context);
        basketballDB.basketballDao().insertItem(teamsItem);
        view.showSuccessMessage("Save");

    }

    @Override
    public void deleteFavorite(Context context, TeamsItem teamsItem) {
        basketballDB = BasketballDB.getBaskettballDB(context);
        basketballDB.basketballDao().delete(teamsItem);
        view.showSuccessMessage("Delete");

    }

    @Override
    public Boolean checkFavorite(Context context, TeamsItem teamsItem) {
        Boolean isFavorite = false;
        basketballDB = BasketballDB.getBaskettballDB(context);
        return isFavorite = basketballDB.basketballDao().selectedItem(teamsItem.getIdTeam()) != null;
    }
}
