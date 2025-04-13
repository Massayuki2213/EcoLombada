package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout cardConsultarLombadas, cardUsuarios;
    private TextView textUsuario, textConfiguracoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cardConsultarLombadas = findViewById(R.id.cardConsultarLombadas);
        cardUsuarios = findViewById(R.id.cardUsuarios);
        textUsuario = findViewById(R.id.textUsuario);
        textConfiguracoes = findViewById(R.id.textConfiguracoes);

        cardConsultarLombadas.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, ListaLombadasActivity.class));
        });

        cardUsuarios.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, ListaUsuariosActivity.class));
        });

        textUsuario.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, UsuarioActivity.class));
        });

        textConfiguracoes.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, ConfiguracoesActivity.class));
        });
    }
}