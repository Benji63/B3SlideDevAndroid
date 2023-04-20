package com.example.applicationliste;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationliste.databinding.PlaneteBinding;

public class PlaneteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final PlaneteBinding ui;

    public PlaneteViewHolder(PlaneteBinding ui) {
        super(ui.getRoot());
        this.ui = ui;
        itemView.setOnClickListener(this);
    }

    public void setPlanete(Planete planete) {
        ui.nomplanete.setText(planete.getNom());
        ui.distanceplanete.setText(Integer.toString(planete.getDistance()));
    }

    private PlanetAdapter.OnItemClickListener listener;
    public void setOnItemClickListener(PlanetAdapter.OnItemClickListener l) {
        this.listener = l;
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(getAdapterPosition());
    }
}
