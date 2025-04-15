package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

// Essa tela mostra as opções de configurações do aplicativo
public class ConfiguracoesActivity extends AppCompatActivity {

    // Opções clicáveis da tela (como "Aparência" e "Sobre")
    private LinearLayout opcaoAparencia, opcaoSobre;

    // Textos de navegação para voltar à home ou acessar o perfil do usuário
    private TextView textHomeConfiguracoes, textUsuarioConfiguracoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define qual layout XML essa tela vai usar
        setContentView(R.layout.activity_configuracoes);

        // Ligação entre o layout e o código Java
        opcaoAparencia = findViewById(R.id.opcaoAparencia);
        opcaoSobre = findViewById(R.id.opcaoSobre);
        textHomeConfiguracoes = findViewById(R.id.textHomeConfiguracoes);
        textUsuarioConfiguracoes = findViewById(R.id.textUsuarioConfiguracoes);

        // Se o usuário clicar na opção "Aparência", ele é redirecionado pra tela de personalização visual
        opcaoAparencia.setOnClickListener(v -> {
            Intent intent = new Intent(ConfiguracoesActivity.this, AparenciaActivity.class);
            startActivity(intent);
        });

        // Ao clicar em "Sobre", o app mostra uma tela com informações gerais do projeto
        opcaoSobre.setOnClickListener(v -> {
            Intent intent = new Intent(ConfiguracoesActivity.this, SobreActivity.class);
            startActivity(intent);
        });

        // Abaixo temos botões de atalho pra facilitar a navegação

        // Clica e volta pra tela principal (home)
        textHomeConfiguracoes.setOnClickListener(v -> {
            Intent intent = new Intent(ConfiguracoesActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        // Clica e vai pra tela de perfil do usuário
        textUsuarioConfiguracoes.setOnClickListener(v -> {
            Intent intent = new Intent(ConfiguracoesActivity.this, UsuarioActivity.class);
            startActivity(intent);
        });
    }
}