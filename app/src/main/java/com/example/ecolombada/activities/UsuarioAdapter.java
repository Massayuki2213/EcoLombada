package com.example.ecolombada.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecolombada.R;
import com.example.ecolombada.models.Usuario;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {

    private List<Usuario> listaUsuarios;

    public UsuarioAdapter(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuario = listaUsuarios.get(position);
        holder.textNomeUsuario.setText(usuario.getNome());
        holder.textStatusUsuario.setText(usuario.isAtivo() ? "Ativo" : "Inativo");
        holder.buttonAtivarUsuario.setText(usuario.isAtivo() ? "✅" : "❌");

        holder.buttonAtivarUsuario.setOnClickListener(v -> {
            usuario.setAtivo(!usuario.isAtivo());
            notifyItemChanged(position);
        });

        holder.buttonEditarUsuario.setOnClickListener(v -> {
            // Aqui seria para editar - mockado
        });
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView textNomeUsuario, textStatusUsuario;
        Button buttonEditarUsuario, buttonAtivarUsuario;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            textNomeUsuario = itemView.findViewById(R.id.textNomeUsuario);
            textStatusUsuario = itemView.findViewById(R.id.textStatusUsuario);
            buttonEditarUsuario = itemView.findViewById(R.id.buttonEditarUsuario);
            buttonAtivarUsuario = itemView.findViewById(R.id.buttonAtivarUsuario);
        }
    }
}