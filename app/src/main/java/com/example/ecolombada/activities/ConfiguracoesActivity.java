package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

public class ConfiguracoesActivity extends AppCompatActivity {

    private LinearLayout opcaoAparencia, opcaoSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        opcaoAparencia = findViewById(R.id.opcaoAparencia);
        opcaoSobre = findViewById(R.id.opcaoSobre);

        opcaoAparencia.setOnClickListener(v -> {
            // Agora abre a Activity de Aparência
            Intent intent = new Intent(ConfiguracoesActivity.this, AparenciaActivity.class);
            startActivity(intent);
        });

        opcaoSobre.setOnClickListener(v -> {
            // Agora abre a Activity de Sobre
            Intent intent = new Intent(ConfiguracoesActivity.this, SobreActivity.class);
            startActivity(intent);
        });
    }
}
