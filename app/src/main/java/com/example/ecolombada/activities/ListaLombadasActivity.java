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

public class ListaLombadasActivity extends AppCompatActivity {

    private static final int REQUEST_CADASTRO = 1;

    private Button buttonVoltarListaLombadas;
    private EditText editTextBuscarLombada;
    private RecyclerView recyclerViewLombadas;
    private LombadaAdapter lombadaAdapter;
    private List<Lombada> listaLombadas;
    private List<Lombada> listaLombadasFiltrada;
    private FloatingActionButton fabAdicionarLombada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lombadas);

        buttonVoltarListaLombadas = findViewById(R.id.buttonVoltarListaLombadas);
        editTextBuscarLombada = findViewById(R.id.editTextBuscarLombada);
        recyclerViewLombadas = findViewById(R.id.recyclerViewLombadas);
        fabAdicionarLombada = findViewById(R.id.fabAdicionarLombada);

        listaLombadas = new ArrayList<>();
        listaLombadas.add(new Lombada(
                "ABC_SP",
                "Sorocaba",
                "Rua Francisco Henrique da Rosa",
                new int[]{5, 10, 15},
                new int[]{6, 12, 18}
        ));
        listaLombadas.add(new Lombada(
                "DEF_SP",
                "Campinas",
                "Avenida Brasil",
                new int[]{1, 2, 1},
                new int[]{1, 2, 1}
        ));
        listaLombadas.add(new Lombada(
                "GHI_SP",
                "São Paulo",
                "Rua Augusta",
                new int[]{7, 14, 21},
                new int[]{8, 16, 24}
        ));

        listaLombadasFiltrada = new ArrayList<>(listaLombadas);

        lombadaAdapter = new LombadaAdapter(this, listaLombadasFiltrada);
        recyclerViewLombadas.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLombadas.setAdapter(lombadaAdapter);

        buttonVoltarListaLombadas.setOnClickListener(v -> finish());

        fabAdicionarLombada.setOnClickListener(v -> {
            Intent intent = new Intent(ListaLombadasActivity.this, CadastroLombadaActivity.class);
            startActivityForResult(intent, REQUEST_CADASTRO);
        });

        editTextBuscarLombada.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filtrarLombadas(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filtrarLombadas(String texto) {
        List<Lombada> filtradas = new ArrayList<>();
        for (Lombada lombada : listaLombadas) {
            if (lombada.getNome().toLowerCase().contains(texto.toLowerCase())
                    || lombada.getCidade().toLowerCase().contains(texto.toLowerCase())
                    || lombada.getEndereco().toLowerCase().contains(texto.toLowerCase())) {
                filtradas.add(lombada);
            }
        }
        listaLombadasFiltrada.clear();
        listaLombadasFiltrada.addAll(filtradas);
        lombadaAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CADASTRO && resultCode == RESULT_OK && data != null) {
            String nomeLombada = data.getStringExtra("nomeLombada");
            String cidadeLombada = data.getStringExtra("cidadeLombada");
            String enderecoLombada = data.getStringExtra("enderecoLombada");

            Lombada novaLombada = new Lombada(
                    nomeLombada,
                    cidadeLombada,
                    enderecoLombada,
                    new int[]{0, 0, 0},
                    new int[]{0, 0, 0}
            );

            listaLombadas.add(novaLombada);
            listaLombadasFiltrada.add(novaLombada);
            lombadaAdapter.notifyItemInserted(listaLombadasFiltrada.size() - 1);
        }
    }
}