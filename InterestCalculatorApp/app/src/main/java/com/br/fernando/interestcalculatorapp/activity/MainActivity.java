package com.br.fernando.interestcalculatorapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.SimpleDateFormat;

import com.br.fernando.interestcalculatorapp.utils.DatePickerDialogHelper;
import com.br.fernando.interestcalculatorapp.R;


public class MainActivity extends AppCompatActivity {

    private EditText campoValor;
    private EditText campoVencimento;
    private EditText campoPagamento;
    private EditText campoJurosTextView;
    private RadioButton campoJurosDinheiroRadioButoon;
    private RadioButton campoJurosPorcentagemRadioButoon;
    private RadioButton campoJurosDiaRadioButton;
    private RadioButton campoJurosMesRadioButton;
    private EditText campoMultaTextView;
    private RadioButton campoMultaDinheiroRadioButton;
    private RadioButton campoMultaPorcentagemRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoValor = (EditText) findViewById(R.id.valor_editText);
        campoVencimento = (EditText) findViewById(R.id.vencimento_editText);
        campoPagamento = (EditText) findViewById(R.id.pagamento_editText);

        campoJurosTextView = (EditText) findViewById(R.id.jurosTextField);
        campoJurosDinheiroRadioButoon = (RadioButton) findViewById(R.id.dinheiro_juros_radioButton);
        campoJurosPorcentagemRadioButoon = (RadioButton) findViewById(R.id.porcentagem_juros_radioButton);
        campoJurosDiaRadioButton = (RadioButton) findViewById(R.id.dia_juros_radioButton);
        campoJurosMesRadioButton = (RadioButton) findViewById(R.id.mes_juros_radioButton);

        campoMultaTextView = (EditText) findViewById(R.id.multa_TextField);
        campoMultaDinheiroRadioButton = (RadioButton) findViewById(R.id.dinheiro_multa_radioButton);
        campoMultaPorcentagemRadioButton = (RadioButton) findViewById(R.id.porcentagem_juros_radioButton);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DatePickerDialogHelper.setDatePickerDialog(campoVencimento, this, simpleDateFormat);
        DatePickerDialogHelper.setDatePickerDialog(campoPagamento, this, simpleDateFormat);

        Button salvarDados = findViewById(R.id.salvar_button);
        salvarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateFields()){
                    changeToResultActivity();
                }
            }
        });
    }



    private boolean validateFields() {
        boolean correctValidation = true;
        if (campoValor.getText().toString().length() == 0) {
            //ethanolPriceEditText.setError ("Digite o valor do etanol");
            campoValor.setError(null);
            correctValidation = false;
        }
        if (campoJurosTextView.getText().toString().length() == 0) {
            campoJurosTextView.setError(getString(R.string.erro_juros_EditText));
            correctValidation = false;
        }
        if (campoMultaTextView.getText().toString().length() == 0) {
            campoMultaTextView.setError(getString(R.string.erro_multa_EditText));
            correctValidation = false;
        }
        return correctValidation;
    }

    private void changeToResultActivity() {
        Intent intent = new Intent(this, ResultadoActivity.class);

        // CONVERTE OS VALORES PARA DOUBLE
        double valor = Double.parseDouble(campoValor.getText().toString());
        double juros = Double.parseDouble(campoJurosTextView.getText().toString());
        double multa = Double.parseDouble(campoMultaTextView.getText().toString());

        /* PEGANDO AS DATAS
        String dataVencimento = campoVencimento.getText().toString();
        String dataPagamento = campoPagamento.getText().toString();
        */

        intent.putExtra("VALOR", valor);
        intent.putExtra("JUROS",juros);
        intent.putExtra("MULTA", multa);
        //intent.putExtra("DATA_VENCIMENTO", dataVencimento);
        //intent.putExtra("DATA_PAGAMENTO", dataPagamento);

        startActivity(intent);
    }

}