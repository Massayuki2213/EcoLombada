package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

public class UsuarioActivity extends AppCompatActivity {

    private Button buttonEditarDados, buttonLogout;
    private ImageView buttonEditarFoto;
    private TextView textHomeUsuario, textConfiguracoesUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        buttonEditarDados = findViewById(R.id.buttonEditarDados);
        //buttonEditarFoto = findViewById(R.id.buttonEditarFoto);
        buttonLogout = findViewById(R.id.buttonLogout);
        textHomeUsuario = findViewById(R.id.textHomeUsuario);
        textConfiguracoesUsuario = findViewById(R.id.textConfiguracoesUsuario);

        buttonEditarDados.setOnClickListener(v ->
                Toast.makeText(this, "Função de editar dados ainda não implementada", Toast.LENGTH_SHORT).show()
        );

       // buttonEditarFoto.setOnClickListener(v ->
       //         Toast.makeText(this, "Função de alterar foto ainda não implementada", Toast.LENGTH_SHORT).show()
       // );

        buttonLogout.setOnClickListener(v -> {
            // Faz logout e volta para o Login
            Intent intent = new Intent(UsuarioActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        textHomeUsuario.setOnClickListener(v -> finish());
        textConfiguracoesUsuario.setOnClickListener(v -> {
            startActivity(new Intent(UsuarioActivity.this, ConfiguracoesActivity.class));
        });
    }
}