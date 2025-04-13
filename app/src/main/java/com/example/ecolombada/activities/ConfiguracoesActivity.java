package com.example.ecolombada.activities;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
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

        opcaoAparencia.setOnClickListener(v ->
                Toast.makeText(this, "Tela de Aparência (mock)", Toast.LENGTH_SHORT).show()
        );

        opcaoSobre.setOnClickListener(v ->
                Toast.makeText(this, "Tela Sobre (mock)", Toast.LENGTH_SHORT).show()
        );
    }
}