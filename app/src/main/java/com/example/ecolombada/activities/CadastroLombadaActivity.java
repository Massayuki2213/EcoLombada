package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

// Esta tela é responsável pelo cadastro de uma nova lombada
public class CadastroLombadaActivity extends AppCompatActivity {

    // Campos que o usuário vai preencher com informações da lombada
    private EditText editTextNomeLombada, editTextCidadeLombada, editTextEnderecoLombada;

    // Botões para confirmar o cadastro ou voltar sem salvar
    private Button buttonCadastrarLombada, buttonVoltarCadastroLombada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define qual layout XML será usado nessa tela
        setContentView(R.layout.activity_cadastro_lombada);

        // Ligação entre os elementos da interface e o código
        editTextNomeLombada = findViewById(R.id.editTextNomeLombada);
        editTextCidadeLombada = findViewById(R.id.editTextCidadeLombada);
        editTextEnderecoLombada = findViewById(R.id.editTextEnderecoLombada);
        buttonCadastrarLombada = findViewById(R.id.buttonCadastrarLombada);
        buttonVoltarCadastroLombada = findViewById(R.id.buttonVoltarCadastroLombada);

        // Quando o botão de cadastrar for clicado, os dados digitados são validados
        buttonCadastrarLombada.setOnClickListener(v -> {
            // Coleta os dados dos campos e remove espaços extras com trim()
            String nomeLombada = editTextNomeLombada.getText().toString().trim();
            String cidadeLombada = editTextCidadeLombada.getText().toString().trim();
            String enderecoLombada = editTextEnderecoLombada.getText().toString().trim();

            // Verifica se todos os campos foram preenchidos
            if (nomeLombada.isEmpty() || cidadeLombada.isEmpty() || enderecoLombada.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {
                // Cria um intent para enviar os dados de volta para a tela anterior
                Intent resultIntent = new Intent();
                resultIntent.putExtra("nomeLombada", nomeLombada);
                resultIntent.putExtra("cidadeLombada", cidadeLombada);
                resultIntent.putExtra("enderecoLombada", enderecoLombada);

                // Define o resultado como OK e encerra a tela
                setResult(RESULT_OK, resultIntent);
                finish(); // Fecha essa tela e volta pra anterior
            }
        });

        // Botão para voltar sem cadastrar nada
        buttonVoltarCadastroLombada.setOnClickListener(v -> {
            setResult(RESULT_CANCELED); // Indica que o usuário cancelou o cadastro
            finish(); // Fecha a tela
        });
    }
}