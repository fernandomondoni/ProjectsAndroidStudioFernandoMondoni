package com.br.fernando.aula01.tictactoeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindViews({R.id.b_00, R.id.b_01, R.id.b_02, R.id.b_10, R.id.b_11, R.id.b_12, R.id.b_20, R.id.b_21, R.id.b_22})
    List<Button> buttons;

    private String[] matriz = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        funReinicia();
    }

    private String xo = "O";
    public  void simbolo() {
        if (xo.equals("O")){
            xo = "X";
        } else if (xo.equals("X")){
            xo = "O";
        }
    }

    @OnClick(R.id.reini)
    public void reinicia()
    {
        funReinicia();
    }

    private void Informe() {

    }

    public void Vitoria(){
        if (buttons.get(0).getText().equals("X") && buttons.get(1).getText().equals("X") && buttons.get(2).getText().equals("X")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador X");
        }
        if (buttons.get(0).getText().equals("O") && buttons.get(1).getText().equals("O") && buttons.get(2).getText().equals("O")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador O");
        }
        if (buttons.get(0).getText().equals("X") && buttons.get(3).getText().equals("X") && buttons.get(6).getText().equals("X")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador X");
        }
        if (buttons.get(0).getText().equals("O") && buttons.get(3).getText().equals("O") && buttons.get(6).getText().equals("O")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador O");
        }
        if (buttons.get(4).getText().equals("X") && buttons.get(1).getText().equals("X") && buttons.get(7).getText().equals("X")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador X");
        }
        if (buttons.get(4).getText().equals("O") && buttons.get(1).getText().equals("O") && buttons.get(7).getText().equals("O")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador O");
        }
        if (buttons.get(5).getText().equals("X") && buttons.get(8).getText().equals("X") && buttons.get(2).getText().equals("X")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador X");
        }
        if (buttons.get(5).getText().equals("O") && buttons.get(8).getText().equals("O") && buttons.get(2).getText().equals("O")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador O");
        }
        if (buttons.get(4).getText().equals("X") && buttons.get(3).getText().equals("X") && buttons.get(5).getText().equals("X")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador X");
        }
        if (buttons.get(4).getText().equals("O") && buttons.get(3).getText().equals("O") && buttons.get(5).getText().equals("O")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador O");
        }
        if (buttons.get(8).getText().equals("X") && buttons.get(6).getText().equals("X") && buttons.get(7).getText().equals("X")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador X");
        }
        if (buttons.get(8).getText().equals("O") && buttons.get(6).getText().equals("O") && buttons.get(7).getText().equals("O")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador O");
        }
        if (buttons.get(0).getText().equals("X") && buttons.get(4).getText().equals("X") && buttons.get(8).getText().equals("X")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador X");
        }
        if (buttons.get(0).getText().equals("O") && buttons.get(4).getText().equals("O") && buttons.get(8).getText().equals("O")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador O");
        }
        if (buttons.get(6).getText().equals("X") && buttons.get(4).getText().equals("X") && buttons.get(2).getText().equals("X")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador X");
        }
        if (buttons.get(6).getText().equals("O") && buttons.get(4).getText().equals("O") && buttons.get(2).getText().equals("O")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "Vitoria Do Jogador O");
        }

        if (!buttons.get(1).getText().equals("") && !buttons.get(2).getText().equals("") && !buttons.get(3).getText().equals("") && !buttons.get(4).getText().equals("") && !buttons.get(5).getText().equals("") && !buttons.get(6).getText().equals("") && !buttons.get(7).getText().equals("") && !buttons.get(8).getText().equals("") && !buttons.get(0).getText().equals("")) {
            AlertDialogHelper.show(this,"Fim De Jogo!", "DEU VELHA!! HUE");
        }
    }

    public void funReinicia()
    {
        for (int i=0;i<buttons.size();i++)
        {
            buttons.get(i).setText("");
            buttons.get(i).setEnabled(true);
        }
    }

    @OnClick(R.id.b_00)
    public void button01()
    {
        simbolo();
        buttons.get(0).setText(xo);
        buttons.get(0).setEnabled(false);
        Vitoria();
    }
    @OnClick(R.id.b_01)
    public void button02()
    {
        simbolo();
        buttons.get(1).setText(xo);
        buttons.get(1).setEnabled(false);
        Vitoria();
    }
    @OnClick(R.id.b_02)
    public void button03()
    {
        simbolo();
        buttons.get(2).setText(xo);
        buttons.get(2).setEnabled(false);
        Vitoria();
    }
    @OnClick(R.id.b_10)
    public void button04()
    {
        simbolo();
        buttons.get(3).setText(xo);
        buttons.get(3).setEnabled(false);
        Vitoria();
    }
    @OnClick(R.id.b_11)
    public void button05()
    {
        simbolo();
        buttons.get(4).setText(xo);
        buttons.get(4).setEnabled(false);
        Vitoria();
    }
    @OnClick(R.id.b_12)
    public void button06()
    {
        simbolo();
        buttons.get(5).setText(xo);
        buttons.get(5).setEnabled(false);
        Vitoria();
    }
    @OnClick(R.id.b_20)
    public void button07()
    {
        simbolo();
        buttons.get(6).setText(xo);
        buttons.get(6).setEnabled(false);
        Vitoria();
    }
    @OnClick(R.id.b_21)
    public void button08()
    {
        simbolo();
        buttons.get(7).setText(xo);
        buttons.get(7).setEnabled(false);
        Vitoria();
    }
    @OnClick(R.id.b_22)
    public void button09()
    {
        simbolo();
        buttons.get(8).setText(xo);
        buttons.get(8).setEnabled(false);
        Vitoria();
    }





}
