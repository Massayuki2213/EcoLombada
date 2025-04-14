package com.example.ecolombada.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ecolombada.R;
import com.example.ecolombada.activities.DadosLombadaActivity;
import com.example.ecolombada.models.Lombada;

import java.util.List;

public class LombadaAdapter extends RecyclerView.Adapter<LombadaAdapter.LombadaViewHolder> {

    private Context context;
    private List<Lombada> lombadas;

    public LombadaAdapter(Context context, List<Lombada> lombadas) {
        this.context = context;
        this.lombadas = lombadas;
    }

    @Override
    public LombadaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lombada, parent, false);
        return new LombadaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LombadaViewHolder holder, int position) {
        Lombada lombada = lombadas.get(position);
        holder.textViewNome.setText(lombada.getNome());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DadosLombadaActivity.class);
            intent.putExtra("lombada", lombada);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lombadas.size();
    }

    public static class LombadaViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNome;

        public LombadaViewHolder(View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textNomeLombada);
        }
    }

}