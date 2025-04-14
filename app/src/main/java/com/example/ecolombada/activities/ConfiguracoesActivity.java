package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

public class ConfiguracoesActivity extends AppCompatActivity {

    private LinearLayout opcaoAparencia, opcaoSobre;

    private TextView textHomeConfiguracoes, textUsuarioConfiguracoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        opcaoAparencia = findViewById(R.id.opcaoAparencia);
        opcaoSobre = findViewById(R.id.opcaoSobre);
        textHomeConfiguracoes = findViewById(R.id.textHomeConfiguracoes);
        textUsuarioConfiguracoes = findViewById(R.id.textUsuarioConfiguracoes);

        opcaoAparencia.setOnClickListener(v -> {
            Intent intent = new Intent(ConfiguracoesActivity.this, AparenciaActivity.class);
            startActivity(intent);
        });
        opcaoSobre.setOnClickListener(v -> {
            Intent intent = new Intent(ConfiguracoesActivity.this, SobreActivity.class);
            startActivity(intent);
        });

        textHomeConfiguracoes.setOnClickListener(v -> {
            Intent intent = new Intent(ConfiguracoesActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        textUsuarioConfiguracoes.setOnClickListener(v -> {
            Intent intent = new Intent(ConfiguracoesActivity.this, UsuarioActivity.class);
            startActivity(intent);
        });
    }
}
