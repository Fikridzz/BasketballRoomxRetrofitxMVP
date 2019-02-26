package com.example.fikridzakwan.basketballroomxretrofitxmvp.View;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Detail.DetailConstract;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Detail.DetailPresenter;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Model.TeamsItem;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailConstract.View {

    @BindView(R.id.imgStadium)
    ImageView imgStadium;
    @BindView(R.id.txtTempatStadium)
    TextView txtTempatStadium;
    @BindView(R.id.myToolbar)
    Toolbar myToolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.imgLogoClub)
    ImageView imgLogoClub;
    @BindView(R.id.txtNamaClub)
    TextView txtNamaClub;
    @BindView(R.id.txtDetailClub)
    TextView txtDetailClub;
    @BindView(R.id.cordinator_layout)
    CoordinatorLayout cordinatorLayout;

    private ProgressDialog progressDialog;
    private TeamsItem teamsItem;
    private Menu menu;

    private DetailPresenter detailPresenter = new DetailPresenter(this);
    private Boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(myToolbar);

        Bundle bundle = getIntent().getExtras();
        detailPresenter.getDetailClub(bundle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.favorite, menu);
        setFavorite();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_favorite:
                if (isFavorite) {
                    detailPresenter.deleteFavorite(this, teamsItem);
                } else {
                    detailPresenter.addFavorite(this, teamsItem);
                }
                isFavorite = detailPresenter.checkFavorite(this, teamsItem);
                setFavorite();
                break;
            case android.R.id.home:
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
        }
        return true;
    }

    private void setFavorite() {
        if (isFavorite) {
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_favorite));
        } else {
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_favorite_border));
        }
    }

    @Override
    public void showDetailClub(TeamsItem teamsItem) {
        this.teamsItem = teamsItem;
        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image).placeholder(R.drawable.ic_broken_image);
        Glide.with(this).load(teamsItem.getGambar_team()).apply(options).into(imgLogoClub);
        Glide.with(this).load(teamsItem.getGambar_stadium()).apply(options).into(imgStadium);
        txtNamaClub.setText(teamsItem.getNama_team());
        txtDetailClub.setText(teamsItem.getTeam_description());
        txtTempatStadium.setText(teamsItem.getStadium_location());
        isFavorite = detailPresenter.checkFavorite(this, teamsItem);

        getSupportActionBar().setTitle(teamsItem.getNama_stadium());

    }

    @Override
    public void showFailureMessage(String msg) {
        Snackbar.make(cordinatorLayout, msg, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void showSuccessMessage(String msg) {
        Snackbar.make(cordinatorLayout, msg, Snackbar.LENGTH_SHORT).show();

    }
}
