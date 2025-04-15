package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

// Esta é a tela principal do aplicativo após o login
public class HomeActivity extends AppCompatActivity {

    // Elementos visuais que representam os botões/cards de navegação
    private LinearLayout cardConsultarLombadas, cardUsuarios;
    private TextView textUsuario, textConfiguracoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Define qual layout será usado para essa tela
        setContentView(R.layout.activity_home);

        // Conecta os componentes do XML às variáveis do Java
        cardConsultarLombadas = findViewById(R.id.cardConsultarLombadas);
        cardUsuarios = findViewById(R.id.cardUsuarios);
        textUsuario = findViewById(R.id.textUsuario);
        textConfiguracoes = findViewById(R.id.textConfiguracoes);

        // Ao clicar no card de lombadas, o usuário será redirecionado à lista de lombadas
        cardConsultarLombadas.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, ListaLombadasActivity.class));
        });

        // Ao clicar no card de usuários, o usuário será redirecionado à tela de usuários
        cardUsuarios.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, ListaUsuariosActivity.class));
        });

        // A área de texto com o nome do usuário leva à tela de informações do usuário
        textUsuario.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, UsuarioActivity.class));
        });

        // A opção de configurações leva à tela de ajustes do aplicativo
        textConfiguracoes.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, ConfiguracoesActivity.class));
        });
    }
}