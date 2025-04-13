package com.example.ecolombada.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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

    private Button buttonVoltarListaLombadas;
    private EditText editTextBuscarLombada;
    private RecyclerView recyclerViewLombadas;
    private LombadaAdapter lombadaAdapter;
    private List<Lombada> listaLombadas;

    private FloatingActionButton fabAdicionarLombada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lombadas);

        buttonVoltarListaLombadas = findViewById(R.id.buttonVoltarListaLombadas);
        editTextBuscarLombada = findViewById(R.id.editTextBuscarLombada);
        recyclerViewLombadas = findViewById(R.id.recyclerViewLombadas);

        listaLombadas = new ArrayList<>();
        listaLombadas.add(new Lombada("ABC_SP", "Rua Francisco Henrique da Rosa, 333 - Sorocaba, SP - Brasil"));
        listaLombadas.add(new Lombada("Lombada_UF", "Exemplo - Endereço 1"));
        listaLombadas.add(new Lombada("Lombada_UF", "Exemplo - Endereço 2"));
        listaLombadas.add(new Lombada("Lombada_UF", "Exemplo - Endereço 3"));

        lombadaAdapter = new LombadaAdapter(this, listaLombadas);

        recyclerViewLombadas.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLombadas.setAdapter(lombadaAdapter);

        buttonVoltarListaLombadas.setOnClickListener(v -> finish());
        fabAdicionarLombada = findViewById(R.id.fabAdicionarLombada);

        fabAdicionarLombada.setOnClickListener(v -> {
            Intent intent = new Intent(ListaLombadasActivity.this, CadastroLombadaActivity.class);
            startActivity(intent);
        });

    }
}