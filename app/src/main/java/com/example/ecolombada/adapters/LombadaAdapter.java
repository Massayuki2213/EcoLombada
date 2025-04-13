package com.example.ecolombada.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecolombada.R;
import com.example.ecolombada.activities.DadosLombadaActivity;
import com.example.ecolombada.models.Lombada;

import java.util.List;

public class LombadaAdapter extends RecyclerView.Adapter<LombadaAdapter.LombadaViewHolder> {

    private List<Lombada> listaLombadas;
    private Context context;

    public LombadaAdapter(Context context, List<Lombada> listaLombadas) {
        this.context = context;
        this.listaLombadas = listaLombadas;
    }

    @NonNull
    @Override
    public LombadaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lombada, parent, false);
        return new LombadaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LombadaViewHolder holder, int position) {
        Lombada lombada = listaLombadas.get(position);

        holder.textNomeLombada.setText(lombada.getNome());
        holder.textEnderecoLombada.setText(lombada.getEndereco());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DadosLombadaActivity.class);
            intent.putExtra("nome_lombada", lombada.getNome());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listaLombadas.size();
    }

    static class LombadaViewHolder extends RecyclerView.ViewHolder {
        TextView textNomeLombada, textEnderecoLombada;

        public LombadaViewHolder(@NonNull View itemView) {
            super(itemView);
            textNomeLombada = itemView.findViewById(R.id.textNomeLombada);
            textEnderecoLombada = itemView.findViewById(R.id.textEnderecoLombada);
        }
    }
}
