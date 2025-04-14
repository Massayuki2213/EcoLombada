package com.example.ecolombada.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BarGraphView extends View {

    private int[] dadosVeiculos = new int[0];
    private int[] dadosEnergia = new int[0];
    private Paint paintVeiculos;
    private Paint paintEnergia;
    private Paint paintTexto;
    private Paint paintLegenda;

    public BarGraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paintVeiculos = new Paint();
        paintVeiculos.setColor(Color.parseColor("#4FC3F7")); // Azul claro
        paintEnergia = new Paint();
        paintEnergia.setColor(Color.parseColor("#81C784")); // Verde suave
        paintTexto = new Paint();
        paintTexto.setColor(Color.BLACK);
        paintTexto.setTextSize(32);
        paintTexto.setTextAlign(Paint.Align.CENTER);
        paintLegenda = new Paint();
        paintLegenda.setColor(Color.BLACK);
        paintLegenda.setTextSize(28);
    }

    public void setDados(int[] veiculos, int[] energia) {
        this.dadosVeiculos = veiculos;
        this.dadosEnergia = energia;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (dadosVeiculos.length == 0 || dadosEnergia.length == 0) return;

        int width = getWidth();
        int height = getHeight();
        int paddingTop = 100;
        int paddingBottom = 150;
        int graphHeight = height - paddingTop - paddingBottom;
        int numDias = dadosVeiculos.length;

        float larguraTotalPorDia = width / (float) numDias;
        float larguraBarra = larguraTotalPorDia / 3;

        for (int i = 0; i < numDias; i++) {
            float xInicio = i * larguraTotalPorDia + larguraBarra / 2;

            float alturaMaxima = Math.max(dadosVeiculos[i], dadosEnergia[i]);
            float fatorAltura = graphHeight / (alturaMaxima * 1.2f);

            float alturaVeiculos = dadosVeiculos[i] * fatorAltura;
            float alturaEnergia = dadosEnergia[i] * fatorAltura;

            canvas.drawRect(
                    xInicio,
                    paddingTop + (graphHeight - alturaVeiculos),
                    xInicio + larguraBarra,
                    height - paddingBottom,
                    paintVeiculos
            );

            canvas.drawRect(
                    xInicio + larguraBarra + 10,
                    paddingTop + (graphHeight - alturaEnergia),
                    xInicio + 2 * larguraBarra + 10,
                    height - paddingBottom,
                    paintEnergia
            );

            canvas.drawText(
                    "Dia " + (i + 1),
                    xInicio + larguraBarra,
                    height - paddingBottom + 40,
                    paintTexto
            );
        }

        // Legenda
        canvas.drawRect(30, 20, 80, 50, paintVeiculos);
        canvas.drawText("Veículos", 120, 45, paintLegenda);
        canvas.drawRect(30, 70, 80, 100, paintEnergia);
        canvas.drawText("Energia", 120, 95, paintLegenda);
    }
}