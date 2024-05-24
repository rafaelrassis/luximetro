package com.tccapp.luximetro;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class resultado extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Retrieve values passed by Carregamento activity
        String ambiente = getIntent().getStringExtra("ambiente");
        String idade = getIntent().getStringExtra("idade");
        float maxValue = getIntent().getFloatExtra("MAX_VALUE", 0.0f);
        float minValue = getIntent().getFloatExtra("MIN_VALUE", 0.0f);
        float avgValue = getIntent().getFloatExtra("AVG_VALUE", 0.0f);
        float currentValue = getIntent().getFloatExtra("currentValue", 0.0f); // Recuperando o valor atual do sensor


        DecimalFormat df = new DecimalFormat("#.00");

        // Initialize TextViews
        TextView maxValueTextView = findViewById(R.id.maxValueTextView);
        TextView minValueTextView = findViewById(R.id.minValueTextView);
        TextView avgValueTextView = findViewById(R.id.avgValueTextView);
        TextView ambienteTextView = findViewById(R.id.ambienteTextView);
        TextView idadeTextView = findViewById(R.id.idadeTextView);
        TextView quantidadeLuzTextView = findViewById(R.id.txtQuantidadeDeLuz);
        TextView detalhamentoTextView = findViewById(R.id.txtDetalhamento);

        // Set values to TextViews
        maxValueTextView.setText("Valor máximo: " + df.format(maxValue));
        minValueTextView.setText("Valor mínimo: " + df.format(minValue));
        avgValueTextView.setText("Média: " + df.format(avgValue));
        ambienteTextView.setText(ambiente);
        idadeTextView.setText(idade);


            int idadeInt = Integer.parseInt(idade);

            // Set idadeTextView
            idadeTextView.setText("Idade: " + idadeInt);


            if (ambiente.equals("cozinha")) {
                if (idadeInt < 40) {
                    if (maxValue < 460) {
                        quantidadeLuzTextView.setText("Pouca luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "Para sua idadeInt a iluminação existente na sua cozinha pode ser ineficiente.\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Trocar sua luminária por uma com mais lumens, com temperatura de cor de 4000k;\n" +
                                "2- Caso tenha uma luminária com várias lâmpadas, você pode trocá-las por lâmpadas mais eficientes, com temperatura de cor de 4000k;\n" +
                                "3- Encontrar um profissional para te auxiliar.\n");
                    } else if (maxValue > 540) {
                        quantidadeLuzTextView.setText("Muita luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "Para sua idadeInt a iluminação existente na sua cozinha pode ser exagerada.\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Trocar sua luminária por uma com menos lumens, com temperatura de cor de 4000k;\n" +
                                "2- Caso tenha uma luminária com várias lâmpadas, você pode trocá-las por lâmpadas com menos lumens, com temperatura de cor de 4000k;\n" +
                                "3- Encontrar um profissional para te auxiliar.\n");
                    } else {
                        quantidadeLuzTextView.setText("Quantidade de luz adequada");
                        detalhamentoTextView.setText("Sua iluminação está ideal!\n" +
                                "A iluminação existente na sua cozinha está adequada para sua idadeInt.");
                    }
                }
                // Faixa etária para adultos de meia-idadeInt e idosos podem ser adicionados aqui...
            }

            if (ambiente.equals("sala")) {
                if (idadeInt <= 40) {
                    if (maxValue < 150) {
                        quantidadeLuzTextView.setText("Pouca luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "Para sua Faixa etária a iluminação existente na sua sala de estar pode ser ineficiente.\n" +
                                "Iluminação geral: 150 a 300 lux geralmente é adequado. Jovens têm olhos mais sensíveis e podem se sentir confortáveis com níveis mais baixos de luz.\n" +
                                "Iluminação de tarefa: Para atividades de como leitura, ou estudo, 300 a 500 lux é recomendado.\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Utilizar luminárias de teto com mais lumens com temperatura de cor de 2700 a 3000k;\n" +
                                "2- Incluir luminárias de piso ou abajures na decoração para tornar a iluminação mais eficiente, com temperatura de cor de 2700 a 3000k;\n" +
                                "3- Encontrar um profissional para te auxiliar.\n");
                    } else if (maxValue > 350) {
                        quantidadeLuzTextView.setText("Muita luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "Para sua Faixa etária a iluminação existente na sua sala de estar pode ser exagerada.\n" +
                                "Iluminação geral: 150 a 300 lux geralmente é adequado. Jovens têm olhos mais sensíveis e podem se sentir confortáveis com níveis mais baixos de luz.\n" +
                                "Iluminação de tarefa: Para atividades de como leitura, ou estudo, 300 a 500 lux é recomendado.\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Diminuir a quantidade de luminárias no teto;\n" +
                                "2- Trocar luminárias de teto existentes, para luminárias com menos lumens, com temperatura de cor de 2700 a 3000k;\n" +
                                "3- Trocar luminárias de teto por luminárias de piso, abajures ou luminárias de parede para uma iluminação mais eficiente, com temperatura de cor de 2700 a 3000k;\n" +
                                "4- Encontrar um profissional para te auxiliar.\n");
                    } else {
                        quantidadeLuzTextView.setText("Quantidade de luz adequada");
                        detalhamentoTextView.setText("Parabéns! Sua iluminação está ideal para sua faixa etária!");
                    }
                }
                // Faixa etária para adultos de meia-idadeInt e idosos podem ser adicionados aqui...
            }

            if (ambiente.equals("quarto")) {
                if (idadeInt <= 40) {
                    if (maxValue < 100) {
                        quantidadeLuzTextView.setText("Pouca luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "Para sua Faixa etária a iluminação existente em seu quarto pode ser ineficiente.\n" +
                                "Iluminação geral: 100 a 200 lux é geralmente suficiente. Jovens têm olhos mais sensíveis e não necessitam de níveis muito altos de iluminação.\n" +
                                "Iluminação de tarefa: 300 a 500 lux para áreas de estudo ou leitura, como uma mesa de estudos.\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Utilizar luminárias de teto com mais lumens com temperatura de cor de 2700 a 3000k;\n" +
                                "2- Incluir arandelas ou abajures na decoração para tornar a iluminação mais eficiente, com temperatura de cor de 2700 a 3000k;\n" +
                                "3- Encontrar um profissional para te auxiliar.\n");
                    } else if (maxValue > 210) {
                        quantidadeLuzTextView.setText("Muita luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "Para sua Faixa etária a iluminação existente em seu quarto pode ser exagerada.\n" +
                                "Iluminação geral: 100 a 200 lux é geralmente suficiente. Jovens têm olhos mais sensíveis e não necessitam de níveis muito altos de iluminação.\n" +
                                "Iluminação de tarefa: 300 a 500 lux para áreas de estudo ou leitura, como uma mesa de estudos.\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Diminuir a quantidade de luminárias no teto;\n" +
                                "2- Trocar luminárias de teto existentes, para luminárias com menos lumens, com temperatura de cor de 2700 a 3000k;\n" +
                                "3- Trocar luminárias de teto por luminárias de piso, abajures ou luminárias de parede para uma iluminação mais eficiente, com temperatura de cor de 2700 a 3000k;\n" +
                                "4- Encontrar um profissional para te auxiliar.\n");
                    } else {
                        quantidadeLuzTextView.setText("Quantidade de luz adequada");
                        detalhamentoTextView.setText("Parabéns! Sua iluminação está ideal para sua faixa etária!");
                    }
                }
            }

            if (ambiente.equals("escritorio")) {
                if (idadeInt <= 40) {
                    if (maxValue < 250) {
                        quantidadeLuzTextView.setText("Pouca luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "Para sua Faixa etária a iluminação existente no seu escritório pode ser ineficiente.\n" +
                                "Iluminação geral: 300 a 500 lux é geralmente suficiente.\n" +
                                "Iluminação de tarefa: 400 a 500 lux para áreas de estudo ou leitura, como uma mesa de estudos.\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1. Utilizar luminárias de teto com mais lumens com temperatura de cor de 4000k;\n" +
                                "2. Incluir abajures de mesa para tornar a iluminação mais eficiente nas áreas de tarefa, com temperatura de cor de 4000k;\n" +
                                "3. Encontrar um profissional para te auxiliar.\n");
                    } else if (maxValue > 550) {
                        quantidadeLuzTextView.setText("Muita luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "Para sua Faixa etária a iluminação existente no seu escritório pode ser exager");
                    }
                }
            }
                    }

}
