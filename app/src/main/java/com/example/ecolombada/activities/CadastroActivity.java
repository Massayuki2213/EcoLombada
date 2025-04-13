package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

public class CadastroActivity extends AppCompatActivity {

    private EditText editTextNome, editTextEmailCadastro, editTextUsuario, editTextSenhaCadastro, editTextConfirmarSenha;
    private Button buttonCadastrar, buttonVoltarCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editTextNome = findViewById(R.id.editTextNome);
        editTextEmailCadastro = findViewById(R.id.editTextEmailCadastro);
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextSenhaCadastro = findViewById(R.id.editTextSenhaCadastro);
        editTextConfirmarSenha = findViewById(R.id.editTextConfirmarSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        buttonVoltarCadastro = findViewById(R.id.buttonVoltarCadastro);

        buttonCadastrar.setOnClickListener(v -> {
            String nome = editTextNome.getText().toString();
            String email = editTextEmailCadastro.getText().toString();
            String usuario = editTextUsuario.getText().toString();
            String senha = editTextSenhaCadastro.getText().toString();
            String confirmarSenha = editTextConfirmarSenha.getText().toString();

            if (nome.isEmpty() || email.isEmpty() || usuario.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
                Toast.makeText(CadastroActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else if (!senha.equals(confirmarSenha)) {
                Toast.makeText(CadastroActivity.this, "As senhas não conferem", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(CadastroActivity.this, "Cadastro efetuado (mock)", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CadastroActivity.this, HomeActivity.class));
                finish();
            }
        });

        buttonVoltarCadastro.setOnClickListener(v -> {
            Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Limpa a pilha para não voltar mais
            startActivity(intent);
            finish();
        });
    }
}