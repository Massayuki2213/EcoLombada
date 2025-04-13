package com.example.ecolombada.activities;

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

    public BarGraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paintVeiculos = new Paint();
        paintVeiculos.setColor(Color.BLUE);
        paintVeiculos.setStyle(Paint.Style.FILL);

        paintEnergia = new Paint();
        paintEnergia.setColor(Color.GREEN);
        paintEnergia.setStyle(Paint.Style.FILL);

        paintTexto = new Paint();
        paintTexto.setColor(Color.BLACK);
        paintTexto.setTextSize(30);
    }

    public void setDados(int[] veiculos, int[] energia) {
        this.dadosVeiculos = veiculos;
        this.dadosEnergia = energia;
        invalidate(); // Redesenhar
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (dadosVeiculos.length == 0 || dadosEnergia.length == 0) return;

        int width = getWidth();
        int height = getHeight();
        int numDias = dadosVeiculos.length;

        float larguraBarra = width / (numDias * 3f); // espaço para veiculo + energia + espaçamento
        float espacamento = larguraBarra;

        for (int i = 0; i < numDias; i++) {
            float x1 = i * (larguraBarra * 3) + espacamento / 2;
            float x2 = x1 + larguraBarra;

            float alturaMaxima = Math.max(dadosVeiculos[i], dadosEnergia[i]);
            float fatorAltura = (height - 100) / alturaMaxima; // espaço vertical

            // Barra de Veículos
            canvas.drawRect(
                    x1,
                    height - dadosVeiculos[i] * fatorAltura,
                    x1 + larguraBarra,
                    height,
                    paintVeiculos
            );

            // Barra de Energia
            canvas.drawRect(
                    x2,
                    height - dadosEnergia[i] * fatorAltura,
                    x2 + larguraBarra,
                    height,
                    paintEnergia
            );

            // Texto do Dia
            canvas.drawText("Dia " + (i + 1), x1, height - 10, paintTexto);
        }
    }
}