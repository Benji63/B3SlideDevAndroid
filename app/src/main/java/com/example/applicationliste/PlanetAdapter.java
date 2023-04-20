package com.example.applicationliste;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationliste.databinding.PlaneteBinding;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlaneteViewHolder> {
    private final List<Planete> liste;

    PlanetAdapter(List<Planete> liste)
    {
        this.liste = liste;
    }

    @NonNull
    @Override
    public PlaneteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        PlaneteBinding binding = PlaneteBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new PlaneteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaneteViewHolder holder, int position)
    {
        Planete planete = liste.get(position);
        holder.setPlanete(planete);
        holder.setOnItemClickListener(this.listener);
    }

    @Override
    public int getItemCount()
    {
        return liste.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener l) {
        this.listener = l;
    }
}