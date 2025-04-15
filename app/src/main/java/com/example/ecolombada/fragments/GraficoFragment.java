package com.example.ecolombada.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.ecolombada.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class GraficoFragment extends Fragment {

    private static final String ARG_VEICULOS = "arg_veiculos";
    private static final String ARG_ENERGIA = "arg_energia";

    private int[] veiculos;
    private int[] energia;
    private BarChart barChart;

    public static GraficoFragment newInstance(int[] veiculos, int[] energia) {
        GraficoFragment fragment = new GraficoFragment();
        Bundle args = new Bundle();
        args.putIntArray(ARG_VEICULOS, veiculos);
        args.putIntArray(ARG_ENERGIA, energia);
        fragment.setArguments(args);
        return fragment;
    }

    public GraficoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grafico, container, false);

        barChart = view.findViewById(R.id.barChart);

        if (getArguments() != null) {
            veiculos = getArguments().getIntArray(ARG_VEICULOS);
            energia = getArguments().getIntArray(ARG_ENERGIA);
            configurarGrafico();
        }

        return view;
    }

    private void configurarGrafico() {
        List<BarEntry> entriesVeiculos = new ArrayList<>();
        List<BarEntry> entriesEnergia = new ArrayList<>();

        for (int i = 0; i < veiculos.length; i++) {
            entriesVeiculos.add(new BarEntry(i, veiculos[i]));
            entriesEnergia.add(new BarEntry(i, energia[i]));
        }

        BarDataSet dataSetVeiculos = new BarDataSet(entriesVeiculos, "Veículos");
        dataSetVeiculos.setColor(Color.parseColor("#4FC3F7")); // Azul claro

        BarDataSet dataSetEnergia = new BarDataSet(entriesEnergia, "Energia");
        dataSetEnergia.setColor(Color.parseColor("#81C784")); // Verde claro

        BarData data = new BarData(dataSetVeiculos, dataSetEnergia);
        data.setBarWidth(0.4f);

        barChart.setData(data);
        barChart.groupBars(0f, 0.2f, 0.05f); // agrupamento: espaço entre conjuntos de barras
        barChart.getDescription().setEnabled(false);

        // 🔥 IMPORTANTE: Habilitar o scroll (drag e zoom)
        barChart.setDragEnabled(true);        // permitir arrastar (scroll horizontal)
        barChart.setScaleEnabled(false);      // desativar zoom por pinch (dois dedos)

        // 🔥 Ajustar o zoom inicial para forçar barra de rolagem
        barChart.setVisibleXRangeMaximum(3); // Exibe no máximo 3 grupos de barras sem scroll

        barChart.animateY(1000); // Animação vertical

        Legend legend = barChart.getLegend();
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
        xAxis.setAxisMinimum(0f);

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularity(1f);

        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setEnabled(false);
    }
}