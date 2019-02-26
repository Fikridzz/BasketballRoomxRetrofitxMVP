package com.example.fikridzakwan.basketballroomxretrofitxmvp.View;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fikridzakwan.basketballroomxretrofitxmvp.Adapter.TeamsAdapter;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Home.HomeConstract;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Home.HomePresenter;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Model.TeamsItem;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeConstract.View {


    @BindView(R.id.rvClub)
    RecyclerView rvClub;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    Unbinder unbinder;

    private ProgressDialog progressDialogl;
    private HomePresenter homePresenter = new HomePresenter(this);

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        homePresenter.getDataListTeams();

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                homePresenter.getDataListTeams();
            }
        });

        return view;
    }

    @Override
    public void showProgress() {
        progressDialogl = new ProgressDialog(getContext(), R.style.ProgressDialogColor);
        progressDialogl.setMessage("Loading...");
        progressDialogl.setTitle("Get Data");
        progressDialogl.setCancelable(false);
        progressDialogl.show();

    }

    @Override
    public void hideProgress() {
        progressDialogl.dismiss();
        swipeRefresh.setRefreshing(false);

    }

    @Override
    public void showFailurMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showDataListTeams(List<TeamsItem> teamsItemList) {
        rvClub.setLayoutManager(new GridLayoutManager(getContext(),2));
        rvClub.setAdapter(new TeamsAdapter(getContext(),teamsItemList));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
