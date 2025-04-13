package com.example.ecolombada.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.ecolombada.R;
import com.example.ecolombada.activities.BarGraphView;

public class GraficoFragment extends Fragment {

    private BarGraphView barGraphView;

    public GraficoFragment() {
        // Construtor vazio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grafico, container, false);

        barGraphView = view.findViewById(R.id.barGraphView);

        // Mockando dados
        int[] veiculos = {5, 10, 15};
        int[] energia = {6, 12, 18};

        barGraphView.setDados(veiculos, energia);

        return view;
    }
}