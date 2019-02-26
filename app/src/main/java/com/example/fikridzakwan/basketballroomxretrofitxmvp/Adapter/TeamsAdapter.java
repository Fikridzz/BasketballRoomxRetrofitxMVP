package com.example.fikridzakwan.basketballroomxretrofitxmvp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Model.TeamsItem;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.R;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.Utilts.Constants;
import com.example.fikridzakwan.basketballroomxretrofitxmvp.View.DetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    private Context context;
    private List<TeamsItem> teamsItemList;

    public TeamsAdapter(Context context, List<TeamsItem> teamsItemList) {
        this.context = context;
        this.teamsItemList = teamsItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_team, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final TeamsItem teamsItem = teamsItemList.get(i);

        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image).placeholder(R.drawable.ic_broken_image);
        viewHolder.txtNamaClub.setText(teamsItem.getNama_team());
        Glide.with(context).load(teamsItem.getGambar_team()).apply(options).into(viewHolder.imgClub);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,DetailActivity.class).putExtra(Constants.KEY_DATA,teamsItem));
            }
        });

    }

    @Override
    public int getItemCount() {
        return teamsItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_club)
        ImageView imgClub;
        @BindView(R.id.txtNamaClub)
        TextView txtNamaClub;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
