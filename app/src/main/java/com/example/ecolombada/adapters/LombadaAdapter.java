package com.example.ecolombada.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ecolombada.R;
import com.example.ecolombada.models.Lombada;
import java.util.List;

public class LombadaAdapter extends RecyclerView.Adapter<LombadaAdapter.ViewHolder> {

    private Context context;
    private List<Lombada> lombadas;

    public LombadaAdapter(Context context, List<Lombada> lombadas) {
        this.context = context;
        this.lombadas = lombadas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lombada, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lombada lombada = lombadas.get(position);
        holder.textNomeLombada.setText(lombada.getNome());
        holder.textEnderecoLombada.setText(lombada.getCidadeEndereco());
    }

    @Override
    public int getItemCount() {
        return lombadas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textNomeLombada, textEnderecoLombada;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNomeLombada = itemView.findViewById(R.id.textNomeLombada);
            textEnderecoLombada = itemView.findViewById(R.id.textEnderecoLombada);
        }
    }
}