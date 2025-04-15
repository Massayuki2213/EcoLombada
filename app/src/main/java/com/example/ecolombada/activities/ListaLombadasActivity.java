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
import com.example.ecolombada.adapters.LombadaAdapter;
import com.example.ecolombada.models.Lombada;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

// Esta é a tela onde o usuário pode ver e buscar as lombadas cadastradas
public class ListaLombadasActivity extends AppCompatActivity {

    private static final int REQUEST_CADASTRO = 1; // Código para identificar o retorno do cadastro

    // Elementos da tela
    private Button buttonVoltarListaLombadas;
    private EditText editTextBuscarLombada;
    private RecyclerView recyclerViewLombadas;
    private FloatingActionButton fabAdicionarLombada;

    // Adapter e listas de lombadas
    private LombadaAdapter lombadaAdapter;
    private List<Lombada> listaLombadas;            // Lista completa
    private List<Lombada> listaLombadasFiltrada;    // Lista filtrada pela busca

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lombadas);

        // Ligação entre layout e código
        buttonVoltarListaLombadas = findViewById(R.id.buttonVoltarListaLombadas);
        editTextBuscarLombada = findViewById(R.id.editTextBuscarLombada);
        recyclerViewLombadas = findViewById(R.id.recyclerViewLombadas);
        fabAdicionarLombada = findViewById(R.id.fabAdicionarLombada);

        // Criando uma lista com alguns dados simulados (mockados)
        listaLombadas = new ArrayList<>();
        listaLombadas.add(new Lombada("ABC_SP", "Sorocaba", "Rua Francisco Henrique da Rosa", new int[]{5, 10, 15}, new int[]{6, 12, 18}));
        listaLombadas.add(new Lombada("DEF_SP", "Campinas", "Avenida Brasil", new int[]{1, 2, 1}, new int[]{1, 2, 1}));
        listaLombadas.add(new Lombada("GHI_SP", "São Paulo", "Rua Augusta", new int[]{7, 14, 21}, new int[]{8, 16, 24}));

        // Cópia da lista original para aplicar filtro de busca
        listaLombadasFiltrada = new ArrayList<>(listaLombadas);

        // Configurando o adapter para mostrar os dados em formato de lista vertical
        lombadaAdapter = new LombadaAdapter(this, listaLombadasFiltrada);
        recyclerViewLombadas.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLombadas.setAdapter(lombadaAdapter);

        // Botão para voltar à tela anterior
        buttonVoltarListaLombadas.setOnClickListener(v -> finish());

        // Botão flutuante para adicionar nova lombada
        fabAdicionarLombada.setOnClickListener(v -> {
            Intent intent = new Intent(ListaLombadasActivity.this, CadastroLombadaActivity.class);
            startActivityForResult(intent, REQUEST_CADASTRO);
        });

        // Aqui é onde tratamos o campo de busca, atualizando a lista enquanto o usuário digita
        editTextBuscarLombada.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filtrarLombadas(s.toString()); // Chama a função que filtra as lombadas
            }
            @Override public void afterTextChanged(Editable s) {}
        });
    }

    // Essa função filtra a lista com base no texto digitado
    private void filtrarLombadas(String texto) {
        List<Lombada> filtradas = new ArrayList<>();

        for (Lombada lombada : listaLombadas) {
            // Verifica se o texto digitado está no nome, cidade ou endereço
            if (lombada.getNome().toLowerCase().contains(texto.toLowerCase())
                    || lombada.getCidade().toLowerCase().contains(texto.toLowerCase())
                    || lombada.getEndereco().toLowerCase().contains(texto.toLowerCase())) {
                filtradas.add(lombada);
            }
        }

        // Atualiza a lista exibida com os resultados filtrados
        listaLombadasFiltrada.clear();
        listaLombadasFiltrada.addAll(filtradas);
        lombadaAdapter.notifyDataSetChanged(); // Atualiza a tela
    }

    // Aqui a gente trata o retorno da tela de cadastro
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Verifica se voltamos do cadastro com sucesso
        if (requestCode == REQUEST_CADASTRO && resultCode == RESULT_OK && data != null) {
            // Recupera os dados enviados da nova lombada
            String nomeLombada = data.getStringExtra("nomeLombada");
            String cidadeLombada = data.getStringExtra("cidadeLombada");
            String enderecoLombada = data.getStringExtra("enderecoLombada");

            // Cria uma nova lombada com dados zerados de tráfego (simulados)
            Lombada novaLombada = new Lombada(
                    nomeLombada,
                    cidadeLombada,
                    enderecoLombada,
                    new int[]{0, 0, 0},
                    new int[]{0, 0, 0}
            );

            // Adiciona na lista original e na lista filtrada
            listaLombadas.add(novaLombada);
            listaLombadasFiltrada.add(novaLombada);
            lombadaAdapter.notifyItemInserted(listaLombadasFiltrada.size() - 1); // Atualiza a tela
        }
    }
}