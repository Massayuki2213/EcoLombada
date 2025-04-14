package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecolombada.R;
import com.example.ecolombada.adapters.UsuarioAdapter;
import com.example.ecolombada.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuariosActivity extends AppCompatActivity {

    private static final int REQUEST_CADASTRO = 1;

    private Button buttonVoltarUsuarios;
    private EditText editTextBuscarUsuario;
    private RecyclerView recyclerViewUsuarios;
    private UsuarioAdapter usuarioAdapter;
    private List<Usuario> listaUsuarios;           // Lista completa
    private List<Usuario> listaUsuariosFiltrada;    // Lista exibida

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

        listaUsuariosFiltrada = new ArrayList<>(listaUsuarios);

        usuarioAdapter = new UsuarioAdapter(listaUsuariosFiltrada);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewUsuarios.setAdapter(usuarioAdapter);

        buttonVoltarUsuarios.setOnClickListener(v -> finish());

        // Buscar enquanto digita
        editTextBuscarUsuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filtrarUsuarios(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filtrarUsuarios(String texto) {
        List<Usuario> filtrados = new ArrayList<>();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNome().toLowerCase().contains(texto.toLowerCase())) {
                filtrados.add(usuario);
            }
        }
        listaUsuariosFiltrada.clear();
        listaUsuariosFiltrada.addAll(filtrados);
        usuarioAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CADASTRO && resultCode == RESULT_OK && data != null) {
            String nomeNovoUsuario = data.getStringExtra("novoUsuarioNome");
            if (nomeNovoUsuario != null) {
                Usuario novoUsuario = new Usuario(nomeNovoUsuario, true);
                listaUsuarios.add(novoUsuario);
                listaUsuariosFiltrada.add(novoUsuario);
                usuarioAdapter.notifyItemInserted(listaUsuariosFiltrada.size() - 1);
            }
        }
    }
}