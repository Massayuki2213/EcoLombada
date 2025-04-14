package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

public class CadastroLombadaActivity extends AppCompatActivity {

    private EditText editTextNomeLombada, editTextCidadeLombada, editTextEnderecoLombada;
    private Button buttonCadastrarLombada, buttonVoltarCadastroLombada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_lombada);

        editTextNomeLombada = findViewById(R.id.editTextNomeLombada);
        editTextCidadeLombada = findViewById(R.id.editTextCidadeLombada);
        editTextEnderecoLombada = findViewById(R.id.editTextEnderecoLombada);
        buttonCadastrarLombada = findViewById(R.id.buttonCadastrarLombada);
        buttonVoltarCadastroLombada = findViewById(R.id.buttonVoltarCadastroLombada);

        buttonCadastrarLombada.setOnClickListener(v -> {
            String nomeLombada = editTextNomeLombada.getText().toString().trim();
            String cidadeLombada = editTextCidadeLombada.getText().toString().trim();
            String enderecoLombada = editTextEnderecoLombada.getText().toString().trim();

            if (nomeLombada.isEmpty() || cidadeLombada.isEmpty() || enderecoLombada.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("nomeLombada", nomeLombada);
                resultIntent.putExtra("cidadeLombada", cidadeLombada);
                resultIntent.putExtra("enderecoLombada", enderecoLombada);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        buttonVoltarCadastroLombada.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}