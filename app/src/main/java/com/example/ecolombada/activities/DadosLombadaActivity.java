package com.example.ecolombada.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.example.ecolombada.R;
import com.example.ecolombada.activities.GraficoFragment;

public class DadosLombadaActivity extends AppCompatActivity {

    private Button buttonVoltarDados;
    private TextView textTituloLombada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_lombada);

        buttonVoltarDados = findViewById(R.id.buttonVoltarDados);
        textTituloLombada = findViewById(R.id.textTituloLombada);

        String nome = getIntent().getStringExtra("nome_lombada");
        String endereco = getIntent().getStringExtra("endereco_lombada");

        if (nome != null) {
            textTituloLombada.setText(nome);
        }


        buttonVoltarDados.setOnClickListener(v -> finish());

        // Carregar o fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutGrafico, new GraficoFragment());
        transaction.commit();
    }
}