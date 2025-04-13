package com.example.ecolombada.activities;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

public class AparenciaActivity extends AppCompatActivity {

    private Button buttonVoltarAparencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aparencia);

        buttonVoltarAparencia = findViewById(R.id.buttonVoltarAparencia);

        buttonVoltarAparencia.setOnClickListener(v -> finish());
    }
}