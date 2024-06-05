package com.tccapp.luximetro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class resultado<idade> extends AppCompatActivity {

    private String idadeglobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        // Retrieve values passed by Carregamento activity
        String ambiente = getIntent().getStringExtra("ambiente");
        String idade = getIntent().getStringExtra("idade");
        idadeglobal = idade;
        float maxValue = getIntent().getFloatExtra("MAX_VALUE", 0.0f);
        float minValue = getIntent().getFloatExtra("MIN_VALUE", 0.0f);
        float avgValue = getIntent().getFloatExtra("AVG_VALUE", 0.0f);
        float currentValue = getIntent().getFloatExtra("currentValue", 0.0f); // Recuperando o valor atual do sensor


        DecimalFormat df = new DecimalFormat("#.00");

        // Initialize TextViews
        TextView avgValueTextView = findViewById(R.id.avgValueTextView);
        TextView ambienteTextView = findViewById(R.id.ambienteTextView);
        TextView idadeTextView = findViewById(R.id.idadeTextView);
        TextView quantidadeLuzTextView = findViewById(R.id.txtQuantidadeDeLuz);
        TextView detalhamentoTextView = findViewById(R.id.txtDetalhamento);
        TextView ProcureUmProfissional = findViewById(R.id.txtProcureUmProfissional);

        ImageButton imageInsta = findViewById(R.id.imageInsta);
        imageInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.instagram.com/lealclaita?igsh=M2wxb2tvNjJoMGhv";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });


        ImageButton imageBLinkedin = findViewById(R.id.imageBLinkedin);
        imageBLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.linkedin.com/in/claita-leal?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        // Set values to TextViews
        avgValueTextView.setText("Média (lx): " + df.format(avgValue));
        ambienteTextView.setText("Ambiente: " + ambiente);
        idadeTextView.setText(idade);
        ProcureUmProfissional.setMovementMethod(LinkMovementMethod.getInstance());

        int idadeInt = Integer.parseInt(idade);

        // Set idadeTextView
        idadeTextView.setText("Idade: " + idadeInt);


        try {
            if (ambiente.equals("Cozinha")) {
                if (maxValue <= 460) {
                    quantidadeLuzTextView.setText("Pouca luz");
                    detalhamentoTextView.setText("Como melhorar:\n" +
                            "\n" +
                            "Para melhorar o nível de iluminação do seu ambiente você pode:\n\n" +
                            "1- Trocar sua luminária por uma com mais lumens, com temperatura de cor de 4000k;\n" +
                            "2- Caso tenha uma luminária com várias lâmpadas, você pode troca-las por lâmpadas mais eficientes, com temperatura de cor de 4000k\n");


                } else if (maxValue >= 540) {
                    quantidadeLuzTextView.setText("Muita luz");
                    detalhamentoTextView.setText("Como melhorar:\n" +
                            "\n" +
                            "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                            "1- Trocar sua luminária por uma com menos lumens, com temperatura de cor de 4000k;\n" +
                            "2- Caso tenha uma luminária com várias lâmpadas, você pode trocá-las por lâmpadas com menos lumens, com temperatura de cor de 4000k;\n");
                } else {
                    quantidadeLuzTextView.setText("Luz ideal");
                    detalhamentoTextView.setText("Sua iluminação está ideal!\n" +
                            "A iluminação existente na sua cozinha está adequada.");
                }
            }


            if (ambiente.equals("Sala")) {
                if (idadeInt <= 40) {
                    if (maxValue <= 150) {
                        quantidadeLuzTextView.setText("Pouca luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente na sua sala de estar pode ser ineficiente.\n" +
                                "\n" +
                                "Iluminação geral: 150 a 300 lux geralmente é adequado. Jovens têm olhos mais sensíveis e podem se sentir confortáveis com níveis mais baixos de luz.\n" +
                                "\n" +
                                "Iluminação de tarefa: Para atividades de como leitura, ou estudo, 300 a 500 lux é recomendado.\n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Utilizar luminárias de teto com mais lumens com temperatura de cor de 2700 a 3000k;\n" +
                                "2- Incluir luminárias de piso ou abajures na decoração para tornar a iluminação mais eficiente, com temperatura de cor de 2700 a 3000k;\n");
                    } else if (maxValue >= 350) {
                        quantidadeLuzTextView.setText("Muita luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente na sua sala de estar pode ser exagerada.\n" +
                                "\n" +
                                "Iluminação geral: 150 a 300 lux geralmente é adequado. Jovens têm olhos mais sensíveis e podem se sentir confortáveis com níveis mais baixos de luz.\n" +
                                "\n" +
                                "Iluminação de tarefa: Para atividades de como leitura, ou estudo, 300 a 500 lux é recomendado.\n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Diminuir a quantidade de luminárias no teto;\n" +
                                "2- Trocar luminárias de teto existentes, para luminárias com menos lumens, com temperatura de cor de 2700 a 3000k;\n" +
                                "3- Trocar luminárias de teto por luminárias de piso, abajures ou luminárias de parede para uma iluminação mais eficiente, com temperatura de cor de 2700 a 3000k;\n");
                    } else {
                        quantidadeLuzTextView.setText("Quantidade de luz adequada");
                        detalhamentoTextView.setText("Parabéns! Sua iluminação está ideal para sua faixa etária!");
                    }
                }
                if (idadeInt >= 41 && idadeInt <= 60) {
                    if (maxValue <= 200) {
                        quantidadeLuzTextView.setText("Pouca luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente na sua sala de estar pode ser ineficiente.\n" +
                                "\n" +
                                "Iluminação geral: 200 a 400 lux geralmente é adequado. Com o passar dos anos, a sensibilidade à luz diminui, portanto, um pouco mais de luz pode ser necessário\n" +
                                "\n" +
                                "Iluminação de tarefa: 400 a 600 lux para garantir que atividades detalhadas possam ser realizadas sem esforço visual. \n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode: \n" +
                                "1- Utilizar luminárias de teto com mais lumens com temperatura de cor de 2700 a 3000k; \n" +
                                "2- Incluir luminárias de piso ou abajures na decoração para tornar a iluminação mais eficiente, com temperatura de cor de 2700 a 3000k; \n");
                    } else if (maxValue >= 450) {
                        quantidadeLuzTextView.setText("Muita luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente na sua sala de estar pode ser exagerada.\n" +
                                "\n" +

                                "Iluminação geral: 200 a 400 lux geralmente é adequado. Com o passar dos anos, a sensibilidade à luz diminui, portanto, um pouco mais de luz pode ser necessário\n" +
                                "\n" +
                                "Iluminação de tarefa: 400 a 600 lux para garantir que atividades detalhadas possam ser realizadas sem esforço visual. \n" +

                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode: \n" +

                                "1- Diminuir a quantidade de luminárias no teto; \n" +
                                "2- Trocar luminárias de teto existentes, para luminárias com menos lumens, com temperatura de cor de 2700 a 3000k; \n" +
                                "3- Trocar luminárias de teto por luminárias de piso, abajures ou luminárias de parede a iluminação mais eficiente, com temperatura de cor de 2700 a 3000k; \n");
                    } else {
                        quantidadeLuzTextView.setText("Quantidade de luz adequada");
                        detalhamentoTextView.setText("Parabéns! Sua iluminação está ideal para sua faixa etária!");
                    }
                }

                if (idadeInt > 61) {
                    if (maxValue <= 250) {
                        quantidadeLuzTextView.setText("Pouca luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente na sua sala de estar pode ser ineficiente.\n" +
                                "\n" +
                                "Iluminação geral: Entre 300 a 500 lux. Pessoas idosas geralmente necessitam de mais luz para enxergar confortavelmente. \n" +
                                "\n" +
                                "Iluminação de tarefa: 500 a 700 lux. Para atividades como leitura, costura ou outras tarefas que requerem boa visão, é importante fornecer iluminação adicional.\n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode: \n" +
                                "1- Utilizar luminárias de teto com mais lumens com temperatura de cor de 2700 a 3000k; \n" +
                                "2- Incluir luminárias de piso ou abajures na decoração para tornar a iluminação mais eficiente, com temperatura de cor de 2700 a 3000k; \n");
                    } else if (maxValue >= 550) {
                        quantidadeLuzTextView.setText("Muita luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente na sua sala de estar pode ser exagerada. .\n" +
                                "\n" +
                                "Iluminação geral: Entre 300 a 500 lux. Pessoas idosas geralmente necessitam de mais luz para enxergar confortavelmente. .\n" +
                                "\n" +
                                "Iluminação de tarefa: 500 a 700 lux. Para atividades como leitura, costura ou outras tarefas que requerem boa visão, é importante fornecer iluminação adicional.\n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode: .\n" +
                                "1- Diminuir a quantidade de luminárias no teto; .\n" +
                                "2- Trocar luminárias de teto existentes, para luminárias com menos lumens, com temperatura de cor de 2700 a 3000k; .\n" +
                                "3- Trocar luminárias de teto por luminárias de piso, abajures ou luminárias de parede para uma iluminação mais eficiente, com temperatura de cor de 2700 a 3000k; .\n");
                    } else {
                        quantidadeLuzTextView.setText("Quantidade de luz adequada");
                        detalhamentoTextView.setText("Parabéns! Sua iluminação está ideal para sua faixa etária!");
                    }
                }

            }


            if (ambiente.equals("Quarto")) {
                if (idadeInt <= 40) {
                    if (maxValue < 100) {
                        quantidadeLuzTextView.setText("Pouca luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente em seu quarto pode ser ineficiente.\n" +
                                "\n" +
                                "Iluminação geral: 100 a 200 lux é geralmente suficiente. Jovens têm olhos mais sensíveis e não necessitam de níveis muito altos de iluminação.\n" +
                                "\n" +
                                "Iluminação de tarefa: 300 a 500 lux para áreas de estudo ou leitura, como uma mesa de estudos.\n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Utilizar luminárias de teto com mais lumens com temperatura de cor de 2700 a 3000k;\n" +
                                "2- Incluir Arandelas ou abajures na decoração para tornar a iluminação mais eficiente, com temperatura de cor de 2700 a 3000k;\n");
                    } else if (maxValue > 210) {
                        quantidadeLuzTextView.setText("Muita luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente em seu quarto pode ser exagerada.\n" +
                                "\n" +
                                "Iluminação geral: 100 a 200 lux é geralmente suficiente. Jovens têm olhos mais sensíveis e não necessitam de níveis muito altos de iluminação.\n" +
                                "\n" +
                                "Iluminação de tarefa: 300 a 500 lux para áreas de estudo ou leitura, como uma mesa de estudos.\n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Diminuir a quantidade de luminárias no teto;\n" +
                                "2- Trocar luminárias de teto existentes, para luminárias com menos lumens, com temperatura de cor de 2700 a 3000k; \n" +
                                "3- Trocar luminárias de teto por luminárias de piso, abajures ou luminárias de parede para uma iluminação mais eficiente, com temperatura de cor de 2700 a 3000k; \n");
                    } else {
                        quantidadeLuzTextView.setText("Quantidade de luz adequada");
                        detalhamentoTextView.setText("Parabéns! Sua iluminação está ideal para sua faixa etária!");
                    }
                }

                if (idadeInt >= 41 && idadeInt <= 60) {
                    if (maxValue < 200) {
                        quantidadeLuzTextView.setText("Pouca luz");
                        detalhamentoTextView.setText("Como melhorar: \n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente em seu quarto pode ser ineficiente. \n" +
                                "\n" +
                                "Iluminação geral: 200 a 300 lux. A necessidade de luz aumenta com a idade, então níveis um pouco mais altos são recomendados. \n" +
                                "\n" +
                                "Iluminação de tarefa: 400 a 600 lux para leitura ou trabalho em áreas específicas, como mesas de cabeceira com luminárias ajustáveis. \n" +
                                "\n" +
                                "Luz Ambiente Suave: Para criar um ambiente relaxante antes de dormir, luzes suaves e reguláveis são ideais. \n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode: \n" +
                                "1- Utilizar luminárias de teto com mais lumens com temperatura de cor de 2700 a 3000k; \n" +
                                "2- Incluir arandelas ou abajures na decoração para tornar a iluminação mais eficiente, com temperatura de cor de 2700 a 3000k; \n")
                        ;
                    } else if (maxValue > 350) {
                        quantidadeLuzTextView.setText("Muita luz");
                        detalhamentoTextView.setText("Como melhorar: \n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente em seu quarto pode ser exagerada. \n" +
                                "\n" +
                                "Iluminação geral: 200 a 300 lux. A necessidade de luz aumenta com a idade, então níveis um pouco mais altos são recomendados. \n" +
                                "\n" +
                                "Iluminação de tarefa: 400 a 600 lux para leitura ou trabalho em áreas específicas, como mesas de cabeceira com luminárias ajustáveis. \n" +
                                "\n" +
                                "Luz Ambiente Suave: Para criar um ambiente relaxante antes de dormir, luzes suaves e reguláveis são ideais. \n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode: \n" +
                                "1- Diminuir a quantidade de luminárias no teto; \n" +
                                "2- Trocar luminárias de teto existentes, para luminárias com menos lumens, com temperatura de cor de 2700 a 3000k; \n" +
                                "3- Trocar luminárias de teto por luminárias de piso, abajures ou luminárias de parede para uma iluminação mais eficiente, com temperatura de cor de 2700 a 3000k; \n");
                    } else {
                        quantidadeLuzTextView.setText("Quantidade de luz adequada");
                        detalhamentoTextView.setText("Parabéns! Sua iluminação está ideal para sua faixa etária!");
                    }
                }


                if (idadeInt > 61) {
                    if (maxValue < 300) {
                        quantidadeLuzTextView.setText("Pouca luz");
                        detalhamentoTextView.setText("Como melhorar: \n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente em seu quarto pode ser ineficiente. \n" +
                                "\n" +
                                "Iluminação geral: 300 a 500 lux. Idosos necessitam de mais luz para realizar atividades confortavelmente e para prevenir acidentes.\n" +
                                "\n" +
                                "Iluminação de tarefa: 500 a 700 lux. Áreas específicas para leitura ou atividades detalhadas devem ter iluminação adequada. \n" +
                                "\n" +
                                "Iluminação noturna: Luzes suaves (20 a 50 lux) para orientar o caminho durante a noite podem ajudar a evitar quedas e facilitar a mobilidade sem perturbar o sono. \n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode: \n" +
                                "1- Utilizar luminárias de teto com mais lumens com temperatura de cor de 2700 a 3000k; \n" +
                                "2- Incluir arandelas ou abajures na decoração para tornar a iluminação mais eficiente, com temperatura de cor de 2700 a 3000k; \n"
                        )
                        ;
                    } else if (maxValue > 550) {
                        quantidadeLuzTextView.setText("Muita luz");
                        detalhamentoTextView.setText("Como melhorar: \n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente em seu quarto pode ser exagerada. \n" +
                                "\n" +
                                "Iluminação geral: 300 a 500 lux. Idosos necessitam de mais luz para realizar atividades confortavelmente e para prevenir acidentes. \n" +
                                "\n" +
                                "Iluminação de tarefa: 500 a 700 lux. Áreas específicas para leitura ou atividades detalhadas devem ter iluminação adequada. \n" +
                                "\n" +
                                "Iluminação noturna: Luzes suaves (20 a 50 lux) para orientar o caminho durante a noite podem ajudar a evitar quedas e facilitar a mobilidade sem perturbar o sono. \n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Diminuir a quantidade de luminárias no teto; \n" +
                                "2- Trocar luminárias de teto existentes, para luminárias com menos lumens, com temperatura de cor de 2700 a 3000k; \n" +
                                "3- Trocar luminárias de teto por luminárias de piso, abajures ou luminárias de parede para uma iluminação mais eficiente, com temperatura de cor de 2700 a 3000k; \n"
                        );
                    } else {
                        quantidadeLuzTextView.setText("Quantidade de luz adequada");
                        detalhamentoTextView.setText("Parabéns! Sua iluminação está ideal para sua faixa etária!");
                    }
                }

            }

            if (ambiente.equals("Escritorio")) {
                if (idadeInt <= 40) {
                    if (maxValue < 250) {
                        quantidadeLuzTextView.setText("Pouca luz");
                        detalhamentoTextView.setText("Como melhorar: \n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente na sua sala de estar pode ser ineficiente. \n" +
                                "\n" +
                                "Iluminação geral: 300 a 500 lux é geralmente suficiente. \n" +
                                "\n" +
                                "Iluminação de tarefa: 400 a 500 lux para áreas de estudo ou leitura, como uma mesa de estudos. \n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode: \n" +
                                "1- Utilizar luminárias de teto com mais lumens com temperatura de cor de 4000k; \n" +
                                "2- Incluir abajures de mesa para tornar a iluminação mais eficiente nas áreas de tarefa, com temperatura de cor de 4000k; \n"
                        );
                    } else if (maxValue > 550) {
                        quantidadeLuzTextView.setText("Muita luz");
                        detalhamentoTextView.setText("Como melhorar: \n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente na sua sala de estar pode ser exagerada.\n" +
                                "\n" +
                                "Iluminação geral: 300 a 500 lux é geralmente suficiente.\n" +
                                "\n" +
                                "Iluminação de tarefa: 400 a 500 lux para áreas de estudo ou leitura, como uma mesa de estudos.\n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode: \n" +
                                "1- Diminuir a quantidade de luminárias no teto; \n" +
                                "2- Trocar luminárias de teto existentes, para luminárias com menos lumens, com temperatura de cor de 4000k; \n" +
                                "3- Trocar luminárias de teto por luminárias de piso, abajures ou luminárias de mesa para uma iluminação mais eficiente, com temperatura de cor de 4000k;\n");
                    } else {
                        quantidadeLuzTextView.setText("Quantidade de luz adequada");
                        detalhamentoTextView.setText("Parabéns! Sua iluminação está ideal para sua faixa etária!");
                    }
                }


                if (idadeInt >= 41 && idadeInt <= 60) {
                    if (maxValue < 450) {
                        quantidadeLuzTextView.setText("Pouca luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente no seu Escritório pode ser ineficiente.\n" +
                                "\n" +
                                "Iluminação geral e de tarefa: 500 a 750 lux. Com o envelhecimento, a necessidade de iluminação aumenta devido à diminuição da sensibilidade visual e da capacidade de adaptação a diferentes níveis de luz.\n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Utilizar luminárias de teto com mais lumens com temperatura de cor de 4000k;\n" +
                                "2- Incluir arandelas ou abajures de mesa na decoração para tornar a iluminação mais eficiente, com temperatura de cor 4000k;\n");
                    } else if (maxValue > 800) {
                        quantidadeLuzTextView.setText("Muita luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente no seu Escritório pode ser exagerada.\n" +
                                "\n" +
                                "Iluminação geral e de tarefa: 500 a 750 lux. Com o envelhecimento, a necessidade de iluminação aumenta devido à diminuição da sensibilidade visual e da capacidade de adaptação a diferentes níveis de luz.\n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Diminuir a quantidade de luminárias no teto;\n" +
                                "2- Trocar luminárias de teto existentes, para luminárias com menos lumens, com temperatura de cor de 4000k;\n" +
                                "3- Trocar luminárias de teto por luminárias de piso, abajures ou luminárias de mesa para uma iluminação mais eficiente, com temperatura de cor de 4000k;\n");
                    } else {
                        quantidadeLuzTextView.setText("Quantidade de luz adequada");
                        detalhamentoTextView.setText("Parabéns! Sua iluminação está ideal para sua faixa etária!");
                    }
                }

                if (idadeInt > 61) {
                    if (maxValue < 700) {
                        quantidadeLuzTextView.setText("Pouca luz");
                        detalhamentoTextView.setText("Como melhorar: \n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente no seu Escritório pode ser ineficiente.\n" +
                                "\n" +
                                "Iluminação geral e de tarefa: 750 a 1000 lux. Idosos geralmente requerem níveis de iluminação mais altos para compensar a redução da acuidade visual, a sensibilidade ao contraste e a velocidade de adaptação. \n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Utilizar luminárias de teto com mais lumens com temperatura de cor de 4000k; \n" +
                                "2- Incluir arandelas ou abajures de mesa na decoração para tornar a iluminação mais eficiente, com temperatura de cor de 4000k;\n");
                    } else if (maxValue > 1000) {
                        quantidadeLuzTextView.setText("Muita luz");
                        detalhamentoTextView.setText("Como melhorar:\n" +
                                "\n" +
                                "Para sua Faixa etária a iluminação existente no seu Escritório pode ser exagerada.\n" +
                                "\n" +
                                "Iluminação geral e de tarefa: 750 a 1000 lux. Idosos geralmente requerem níveis de iluminação mais altos para compensar a redução da acuidade visual, a sensibilidade ao contraste e a velocidade de adaptação.\n" +
                                "\n" +
                                "Para melhorar o nível de iluminação do seu ambiente você pode:\n" +
                                "1- Diminuir a quantidade de luminárias no teto;\n" +
                                "2- Trocar luminárias de teto existentes, para luminárias com menos lumens, com temperatura de cor de 2700 a 3000k;\n" +
                                "3- Trocar luminárias de teto por luminárias de piso, abajures ou luminárias de parede para uma iluminação mais eficiente, com temperatura de cor de 2700 a 3000k;\n");
                    } else {
                        quantidadeLuzTextView.setText("Quantidade de luz adequada");
                        detalhamentoTextView.setText("Parabéns! Sua iluminação está ideal para sua faixa etária!");
                    }
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
            // Lidar com a exceção aqui, por exemplo, exibir uma mensagem de erro para o usuário
            Toast.makeText(getApplicationContext(), "Erro! .", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, erroapp.class);
            startActivity(intent);
        }

    }

    public void onBackPressed() {
        // Inicia a MainActivity

        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Limpa a pilha de atividades
        startActivity(intent);
    }

}

