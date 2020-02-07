package com.br.fernando.interestcalculatorapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import com.br.fernando.interestcalculatorapp.R;

public class ResultadoActivity extends AppCompatActivity {

    private Button voltar_Button;
    private TextView valorOriginal_id;
    private TextView dataVencimento_id;
    private TextView dataPagamento_id;
    private TextView juros_id;
    private TextView multa_id;
    private TextView totalPagar_id;
    private TextView diferenca_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        valorOriginal_id = findViewById(R.id.valorOriginal_resultado);
        //dataVencimento_id = findViewById(R.id.dataVencimento_resultado);
        //dataPagamento_id = findViewById(R.id.dataPagamento_resultado);
        juros_id = findViewById(R.id.juros_resultado);
        multa_id = findViewById(R.id.multa_resultado);
        totalPagar_id = findViewById(R.id.totalPagar_resultado);
        diferenca_id = findViewById(R.id.diferenca_resultado);

        Intent intent = getIntent();
        double valor = intent.getDoubleExtra("VALOR", 0);
        double juros = intent.getDoubleExtra("JUROS", 0);
        double multa = intent.getDoubleExtra("MULTA", 0);
        double totalPagar = (valor+juros+multa);
        double diferenca = (totalPagar - valor);
        //String dataVencimento = intent.getStringExtra("DATA VENCIMENTO");
        //String dataPagamento = intent.getStringExtra("DATA_PAGAMENTO");

        // CALCULAR JUROS E MULTA COM OS CHECK BOX

        Locale locale = new Locale("pt","BR");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);

        valorOriginal_id.setText(nf.format(valor));
        juros_id.setText(nf.format(juros));
        multa_id.setText(nf.format(multa));
        totalPagar_id.setText(nf.format(totalPagar));
        diferenca_id.setText(nf.format(diferenca));

        // VOLTA PRA TELA PRINCIPAL
        voltar_Button = findViewById(R.id.voltar_button);
        voltar_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultadoActivity.super.onBackPressed();
            }
        });
    }
}
