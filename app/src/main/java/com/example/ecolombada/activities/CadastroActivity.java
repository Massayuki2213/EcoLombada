package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

// Esta é a tela de cadastro do aplicativo
public class CadastroActivity extends AppCompatActivity {

    // Campos que o usuário vai preencher
    private EditText editTextNome, editTextEmailCadastro, editTextUsuario, editTextSenhaCadastro, editTextConfirmarSenha;

    // Botões para confirmar o cadastro ou voltar
    private Button buttonCadastrar, buttonVoltarCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Define o layout usado nessa tela
        setContentView(R.layout.activity_cadastro);

        // Conecta os elementos do layout com as variáveis do código
        editTextNome = findViewById(R.id.editTextNome);
        editTextEmailCadastro = findViewById(R.id.editTextEmailCadastro);
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextSenhaCadastro = findViewById(R.id.editTextSenhaCadastro);
        editTextConfirmarSenha = findViewById(R.id.editTextConfirmarSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        buttonVoltarCadastro = findViewById(R.id.buttonVoltarCadastro);

        // Quando o botão de cadastrar for clicado, esse código aqui executa
        buttonCadastrar.setOnClickListener(v -> {
            // Captura os dados digitados pelo usuário
            String nome = editTextNome.getText().toString();
            String email = editTextEmailCadastro.getText().toString();
            String usuario = editTextUsuario.getText().toString();
            String senha = editTextSenhaCadastro.getText().toString();
            String confirmarSenha = editTextConfirmarSenha.getText().toString();

            // Verifica se todos os campos foram preenchidos
            if (nome.isEmpty() || email.isEmpty() || usuario.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
                Toast.makeText(CadastroActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
            // Verifica se as senhas digitadas são iguais
            else if (!senha.equals(confirmarSenha)) {
                Toast.makeText(CadastroActivity.this, "As senhas não conferem", Toast.LENGTH_SHORT).show();
            }
            // Se tudo estiver certo, simula o cadastro
            else {
                Toast.makeText(CadastroActivity.this, "Cadastro efetuado", Toast.LENGTH_SHORT).show();

                // Prepara os dados para mandar de volta pra tela anterior (lista de usuários)
                Intent resultIntent = new Intent();
                resultIntent.putExtra("novoUsuarioNome", nome);
                setResult(RESULT_OK, resultIntent);
                finish(); // Fecha a tela e volta pra anterior
            }
        });

        // Botão para voltar pro login — aqui a gente limpa a pilha de telas e volta pro início
        buttonVoltarCadastro.setOnClickListener(v -> {
            Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}