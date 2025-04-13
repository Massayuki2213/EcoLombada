package com.example.ecolombada.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecolombada.R;
import com.example.ecolombada.adapters.UsuarioAdapter;
import com.example.ecolombada.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuariosActivity extends AppCompatActivity {

    private Button buttonVoltarUsuarios;
    private EditText editTextBuscarUsuario;
    private RecyclerView recyclerViewUsuarios;
    private UsuarioAdapter usuarioAdapter;
    private List<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        buttonVoltarUsuarios = findViewById(R.id.buttonVoltarUsuarios);
        editTextBuscarUsuario = findViewById(R.id.editTextBuscarUsuario);
        recyclerViewUsuarios = findViewById(R.id.recyclerViewUsuarios);

        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("Leonardo R.", true));
        listaUsuarios.add(new Usuario("Guilherme M.", false));
        listaUsuarios.add(new Usuario("João Pedro G.", false));
        listaUsuarios.add(new Usuario("Tiago T.", true));

        usuarioAdapter = new UsuarioAdapter(listaUsuarios);

        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewUsuarios.setAdapter(usuarioAdapter);

        buttonVoltarUsuarios.setOnClickListener(v -> finish());
    }
}