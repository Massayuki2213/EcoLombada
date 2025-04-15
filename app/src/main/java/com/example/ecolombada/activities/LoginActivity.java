package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

// Essa é a tela de login do app
// Aqui o usuário pode inserir o nome e a senha pra acessar o sistema
public class LoginActivity extends AppCompatActivity {

    // Declaração dos campos que vão pegar o que o usuário digita
    private EditText editTextUsuario, editTextSenha;

    // Botão de login
    private Button buttonLogin;

    // Textos clicáveis: "esqueci a senha" e "quero me cadastrar"
    private TextView textEsqueciSenha, textCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Aqui o layout da tela de login é carregado
        setContentView(R.layout.activity_login);

        // Conecta os elementos da tela com as variáveis do código
        editTextUsuario = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonLogin = findViewById(R.id.buttonLogin);
        textEsqueciSenha = findViewById(R.id.textEsqueciSenha);
        textCadastrar = findViewById(R.id.textCadastrar);

        // Quando o botão de login for clicado, esse bloco aqui vai ser executado
        buttonLogin.setOnClickListener(v -> {
            String usuario = editTextUsuario.getText().toString(); // pega o texto do campo "usuário"
            String senha = editTextSenha.getText().toString();     // pega o texto do campo "senha"

            // Verifica se algum campo está vazio
            if (usuario.isEmpty() || senha.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
            // Verifica se o usuário e senha estão corretos (aqui é só um teste com "1" e "1")
            else if (usuario.equals("1") && senha.equals("1")) {
                Toast.makeText(LoginActivity.this, "Login efetuado!", Toast.LENGTH_SHORT).show();

                // Se estiver certo, vai pra tela principal (HomeActivity)
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish(); // finaliza essa tela de login pra não voltar nela com o botão "voltar"
            }
            // Se estiver errado, mostra mensagem de erro
            else {
                Toast.makeText(LoginActivity.this, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show();
            }
        });

        // Quando clicar no "Cadastrar", vai pra tela de cadastro
        textCadastrar.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, CadastroActivity.class));
        });

        // Quando clicar em "Esqueci minha senha", mostra que ainda não temos essa função
        textEsqueciSenha.setOnClickListener(v -> {
            Toast.makeText(LoginActivity.this, "Função de recuperação de senha ainda não implementada", Toast.LENGTH_SHORT).show();
        });
    }
}