package com.example.produto2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.produto2.R;

public class MainActivity extends AppCompatActivity {

    EditText nome, preco, desconto;
    Button buttonCalcula;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalcula = findViewById(R.id.button_calcularValor);
        nome = findViewById(R.id.nomeProduto);
        preco = findViewById(R.id.precoProduto);
        desconto = findViewById(R.id.porcentagemDesconto);

        buttonCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputNome = nome.getText().toString();
                String inputPreco = preco.getText().toString();
                String inputDesconto = desconto.getText().toString();
                if (inputNome.isEmpty()||inputPreco.isEmpty() || inputDesconto.isEmpty()) {
                    Toast.makeText(activity, "Preencha os campos necessários", Toast.LENGTH_LONG).show();
                } else {
                    int preco = Integer.parseInt(inputPreco);
                    int desconto = Integer.parseInt(inputDesconto);
                    double valorPagar = calcularValorAPagar(preco, desconto);
                    String textoFinal = "O "+inputNome+" terá total de R$ "+String.valueOf(valorPagar);
                    Toast.makeText(activity, textoFinal, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public double calcularValorAPagar(double x, double y){
        return x - (x*(y/100));

    }

}
