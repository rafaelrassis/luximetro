package com.tccapp.luximetro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class erroapp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_erroapp);

        // Configuração do TextView clicável
        TextView tvLink = findViewById(R.id.tv_link);
        tvLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtém o texto do TextView (o link)
                String url = tvLink.getText().toString();
                // Cria um intent para abrir o link em um navegador
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        // Configuração do padding para a área de conteúdo
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onBackPressed() {
        // Inicia a MainActivity
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Limpa a pilha de atividades
        startActivity(intent);
    }
}
