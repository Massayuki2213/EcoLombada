package com.example.ecolombada.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.ecolombada.R;
import com.example.ecolombada.models.Lombada;

public class DadosLombadaActivity extends AppCompatActivity {

    private Button buttonVoltarDados;
    private TextView textTituloLombada;
    private Lombada lombadaRecebida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_lombada);

        buttonVoltarDados = findViewById(R.id.buttonVoltarDados);
        textTituloLombada = findViewById(R.id.textTituloLombada);

        lombadaRecebida = (Lombada) getIntent().getSerializableExtra("lombada");

        if (lombadaRecebida != null) {
            textTituloLombada.setText(lombadaRecebida.getNome());
        }

        buttonVoltarDados.setOnClickListener(v -> finish());

        GraficoFragment fragment = GraficoFragment.newInstance(
                lombadaRecebida.getVeiculosPorDia(),
                lombadaRecebida.getEnergiaPorDia()
        );

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutGrafico, fragment);
        transaction.commit();
    }
}