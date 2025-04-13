package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

public class CadastroLombadaActivity extends AppCompatActivity {

    private EditText editTextNomeLombada, editTextEnderecoLombada;
    private Button buttonCadastrarLombada, buttonVoltarCadastroLombada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_lombada);

        editTextNomeLombada = findViewById(R.id.editTextNomeLombada);
        editTextEnderecoLombada = findViewById(R.id.editTextEnderecoLombada);
        buttonCadastrarLombada = findViewById(R.id.buttonCadastrarLombada);
        buttonVoltarCadastroLombada = findViewById(R.id.buttonVoltarCadastroLombada);

        buttonCadastrarLombada.setOnClickListener(v -> {
            String nomeLombada = editTextNomeLombada.getText().toString();
            String enderecoLombada = editTextEnderecoLombada.getText().toString();

            if (nomeLombada.isEmpty() || enderecoLombada.isEmpty()) {
                Toast.makeText(CadastroLombadaActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {
                // Aqui no futuro você poderia salvar no banco de dados
                Toast.makeText(CadastroLombadaActivity.this, "Lombada cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CadastroLombadaActivity.this, ListaLombadasActivity.class));
                finish();
            }
        });

        buttonVoltarCadastroLombada.setOnClickListener(v -> {
            finish(); // Apenas volta para a tela anterior
        });
    }
}
