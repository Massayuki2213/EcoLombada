package com.example.ecolombada.activities;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecolombada.R;

public class SobreActivity extends AppCompatActivity {

    private Button buttonVoltarSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        buttonVoltarSobre = findViewById(R.id.buttonVoltarSobre);

        buttonVoltarSobre.setOnClickListener(v -> finish());
    }
}