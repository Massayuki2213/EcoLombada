package com.example.ecolombada.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BarGraphView extends View {

    private int[] valores = {30, 70, 50, 90}; // Valores mockados
    private String[] legendas = {"Seg", "Ter", "Qua", "Qui"}; // Legendas mockadas
    private Paint paintBarra;
    private Paint paintTexto;

    public BarGraphView(Context context) {
        super(context);
        init();
    }

    public BarGraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paintBarra = new Paint();
        paintBarra.setColor(Color.parseColor("#4CAF50")); // Verde forte
        paintBarra.setStyle(Paint.Style.FILL);

        paintTexto = new Paint();
        paintTexto.setColor(Color.BLACK);
        paintTexto.setTextSize(30f);
        paintTexto.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int largura = getWidth();
        int altura = getHeight();

        int quantidade = valores.length;
        int espacamento = largura / (quantidade * 2);
        int larguraBarra = espacamento;

        int alturaMaxima = 100; // Valor máximo para normalizar

        for (int i = 0; i < quantidade; i++) {
            // Calcula a altura proporcional da barra
            float alturaBarra = (valores[i] * (altura * 0.6f)) / alturaMaxima;

            // Coordenadas
            float left = espacamento * (2 * i + 1) - larguraBarra / 2f;
            float top = altura * 0.7f - alturaBarra;
            float right = espacamento * (2 * i + 1) + larguraBarra / 2f;
            float bottom = altura * 0.7f;

            // Desenha a barra
            canvas.drawRect(left, top, right, bottom, paintBarra);

            // Desenha o texto (legenda)
            canvas.drawText(legendas[i], (left + right) / 2, altura * 0.8f, paintTexto);
        }
    }

    // Permitir atualizar dados depois (opcional)
    public void setValores(int[] novosValores, String[] novasLegendas) {
        this.valores = novosValores;
        this.legendas = novasLegendas;
        invalidate(); // Redesenha a view
    }
}
