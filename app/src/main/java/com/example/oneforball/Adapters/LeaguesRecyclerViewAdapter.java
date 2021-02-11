package com.example.oneforball.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oneforball.Apis.Pojos.LeagueItem;
import com.example.oneforball.databinding.LeaguesItemBinding;

import java.util.List;

public class LeaguesRecyclerViewAdapter extends RecyclerView.Adapter<LeaguesRecyclerViewAdapter.ViewHolder> {
    private List<LeagueItem> leagueItems;
    private LayoutInflater inflater;
    private OnClickLeagueItemListener onClickLeagueItemListener;

    public LeaguesRecyclerViewAdapter(List<LeagueItem> leagueItems, LayoutInflater inflater, OnClickLeagueItemListener onClickLeagueItemListener) {
        this.leagueItems = leagueItems;
        this.inflater = inflater;
        this.onClickLeagueItemListener = onClickLeagueItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LeaguesItemBinding binding = LeaguesItemBinding.inflate(inflater);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String leagueName = leagueItems.get(position).getName();
        int leagueId = leagueItems.get(position).getLeagueId();
        holder.binding.leagueNameTextView.setText(leagueName);
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLeagueItemListener.onClickLeagueItem(leagueId);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(leagueItems == null)
            return 0;
        return leagueItems.size();
    }

    public void updateData(List<LeagueItem> leagueItems){
        this.leagueItems = leagueItems;
        notifyDataSetChanged();
    }

    public interface OnClickLeagueItemListener{
        void onClickLeagueItem(int leagueId);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LeaguesItemBinding binding;
        public ViewHolder(@NonNull LeaguesItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
