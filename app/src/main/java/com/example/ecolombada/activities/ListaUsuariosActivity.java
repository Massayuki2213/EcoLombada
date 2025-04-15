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

// Essa tela mostra a lista de usuários cadastrados no app
public class ListaUsuariosActivity extends AppCompatActivity {

    // Constante pra identificar quando voltar de um cadastro novo
    private static final int REQUEST_CADASTRO = 1;

    // Elementos da tela
    private Button buttonVoltarUsuarios;
    private EditText editTextBuscarUsuario;
    private RecyclerView recyclerViewUsuarios;

    // Adapter que controla a lista na tela
    private UsuarioAdapter usuarioAdapter;

    // Lista completa dos usuários e uma filtrada pra busca
    private List<Usuario> listaUsuarios;
    private List<Usuario> listaUsuariosFiltrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        // Ligando os elementos visuais aos objetos do código
        buttonVoltarUsuarios = findViewById(R.id.buttonVoltarUsuarios);
        editTextBuscarUsuario = findViewById(R.id.editTextBuscarUsuario);
        recyclerViewUsuarios = findViewById(R.id.recyclerViewUsuarios);

        // Criando a lista de usuários manualmente (pra fins de teste)
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("Leonardo R.", true));
        listaUsuarios.add(new Usuario("Guilherme M.", false));
        listaUsuarios.add(new Usuario("João Pedro G.", false));
        listaUsuarios.add(new Usuario("Tiago T.", true));

        // Copia a lista original pra uma lista filtrada (usada pra exibição)
        listaUsuariosFiltrada = new ArrayList<>(listaUsuarios);

        // Cria o adaptador e define que a lista vai ser exibida em formato de coluna
        usuarioAdapter = new UsuarioAdapter(listaUsuariosFiltrada);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewUsuarios.setAdapter(usuarioAdapter);

        // Quando clicar em "Voltar", a tela se fecha
        buttonVoltarUsuarios.setOnClickListener(v -> finish());

        // Esse bloco permite buscar usuários enquanto digita
        editTextBuscarUsuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Não precisa fazer nada antes da mudança
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Aqui a gente filtra os usuários em tempo real
                filtrarUsuarios(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Não precisa fazer nada depois da mudança
            }
        });
    }

    // Essa função filtra os nomes da lista conforme o que o usuário digitar
    private void filtrarUsuarios(String texto) {
        List<Usuario> filtrados = new ArrayList<>();

        // Passa por toda a lista original
        for (Usuario usuario : listaUsuarios) {
            // Se o nome contém o texto digitado, adiciona na lista de filtrados
            if (usuario.getNome().toLowerCase().contains(texto.toLowerCase())) {
                filtrados.add(usuario);
            }
        }

        // Atualiza a lista filtrada com os novos resultados
        listaUsuariosFiltrada.clear();
        listaUsuariosFiltrada.addAll(filtrados);

        // Avisa o adapter que a lista mudou (pra recarregar na tela)
        usuarioAdapter.notifyDataSetChanged();
    }

    // Esse método é chamado quando voltamos de outra tela (ex: cadastro)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Se for o retorno do cadastro e tiver dado tudo certo
        if (requestCode == REQUEST_CADASTRO && resultCode == RESULT_OK && data != null) {
            String nomeNovoUsuario = data.getStringExtra("novoUsuarioNome");

            // Se veio um nome novo, adiciona à lista
            if (nomeNovoUsuario != null) {
                Usuario novoUsuario = new Usuario(nomeNovoUsuario, true);
                listaUsuarios.add(novoUsuario);
                listaUsuariosFiltrada.add(novoUsuario);

                // Atualiza o adapter mostrando o novo usuário
                usuarioAdapter.notifyItemInserted(listaUsuariosFiltrada.size() - 1);
            }
        }
    }
}