package com.example.fikridzakwan.basketballroomxretrofitxmvp.Home;

import com.example.fikridzakwan.basketballroomxretrofitxmvp.Data.Remote.ApiClient;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Data.Remote.ApiInterface;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Model.TeamsResponse;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Utilts.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter implements HomeConstract.Presenter {

    private final HomeConstract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public HomePresenter(HomeConstract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListTeams() {
        view.showProgress();

        Call<TeamsResponse> call = apiInterface.getTeams(Constants.id);
        call.enqueue(new Callback<TeamsResponse>() {
            @Override
            public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                view.hideProgress();

                if (response.body() != null) {
                    view.showDataListTeams(response.body().getItems());
                } else {
                    view.showFailurMessage("Data is empety");
                }
            }

            @Override
            public void onFailure(Call<TeamsResponse> call, Throwable t) {
                view.hideProgress();
                view.showFailurMessage(t.getMessage());
            }
        });

    }
}
