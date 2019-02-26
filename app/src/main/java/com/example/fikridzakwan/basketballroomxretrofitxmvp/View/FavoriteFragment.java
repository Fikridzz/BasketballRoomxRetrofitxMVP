package com.example.fikridzakwan.basketballroomxretrofitxmvp.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fikridzakwan.basketballroomxretrofitxmvp.Adapter.TeamsAdapter;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Data.Local.BasketballDB;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Favorite.FavoriteConstract;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Favorite.FavoritePresenter;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Model.TeamsItem;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment implements FavoriteConstract.View {

    @BindView(R.id.rv_favorite)
    RecyclerView rvFavorite;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    Unbinder unbinder;

    private FavoritePresenter favoritePresenter = new FavoritePresenter(this);
    private List<TeamsItem> teamsItemList;
    private BasketballDB basketballDB;

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        unbinder = ButterKnife.bind(this, view);

        favoritePresenter.getDataListClub(getContext());

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                favoritePresenter.getDataListClub(getContext());
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        favoritePresenter.getDataListClub(getContext());
    }

    @Override
    public void showDataList(List<TeamsItem> teamsItemList) {
        rvFavorite.setLayoutManager(new GridLayoutManager(getContext(),2));
        rvFavorite.setAdapter(new TeamsAdapter(getContext(), teamsItemList));
    }

    @Override
    public void showFailurMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideRefresh() {
        swipeRefresh.setRefreshing(false);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
