package com.tccapp.luximetro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {
    Button botaoCozinha, botaoSala, botaoQuarto, botaoEscritorio, botaoMedir;
    float sliderValue;
    TextView selected_value_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botaoCozinha = findViewById(R.id.button_cozinha);
        botaoSala = findViewById(R.id.button_sala);
        botaoQuarto = findViewById(R.id.button_quarto);
        botaoEscritorio = findViewById(R.id.button_escritorio);
        botaoMedir = findViewById(R.id.button_medir);

        selected_value_textview = findViewById(R.id.selected_value_textview);
        Slider slider = findViewById(R.id.slider);
        slider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(Slider sliderComponent, float value, boolean fromUser) {


                if (value == (int) value) {
                    // Atualiza o texto do TextView com o número inteiro selecionado
                    selected_value_textview.setText(String.valueOf((int) value) + " Anos");

                }

                // Atualiza o valor do slider
                sliderValue = value;
            }
        });

        botaoCozinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int idadeInt = (int) sliderValue;
                if (idadeInt == 0) {
                    Toast.makeText(MainActivity.this, "Adicione uma idade", Toast.LENGTH_SHORT).show();
                } else {
                    abrirAtividade("Cozinha");
                }

            }
        });

        botaoSala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idadeInt = (int) sliderValue;
                if (idadeInt == 0) {
                    Toast.makeText(MainActivity.this, "Adicione uma idade", Toast.LENGTH_SHORT).show();
                } else {
                    abrirAtividade("Sala");
                }
            }
        });

        botaoQuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idadeInt = (int) sliderValue;
                if (idadeInt == 0) {
                    Toast.makeText(MainActivity.this, "Adicione uma idade", Toast.LENGTH_SHORT).show();
                } else {
                    abrirAtividade("Quarto");
                }
            }
        });

        botaoEscritorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idadeInt = (int) sliderValue;
                if (idadeInt == 0) {
                    Toast.makeText(MainActivity.this, "Adicione uma idade", Toast.LENGTH_SHORT).show();
                } else {
                    abrirAtividade("Escritorio");
                }
            }
        });

        botaoMedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aqui você pode adicionar o código para enviar os dados para a tela de carregamento
                // Por exemplo, você pode criar um Intent para a tela de carregamento e adicionar os dados necessários como extras
                Intent intent = new Intent(MainActivity.this, carregamento_medir.class);
                intent.putExtra("idade", String.valueOf((int) sliderValue)); // Adiciona a idade selecionada como extra
                startActivity(intent); // Inicia a atividade de carregamento
            }
        });
    }

    private void abrirAtividade(String local) {
        // Cria um Intent para a atividade de carregamento
        Intent it = new Intent(MainActivity.this, Carregamento.class);
        // Adiciona o valor do slider como extra
        int idadeInt = (int) sliderValue;
        String idade = String.valueOf(idadeInt);
        it.putExtra("idade", idade);
        // Adiciona a indicação de qual botão foi clicado
        it.putExtra("local", local);
        // Inicia a atividade de carregamento
        startActivity(it);
    }



}
