package com.tarefas.android.Tarefa3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tarefas.android.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void cadastrar(){
        cadastrarRedirect();
    }

    public void consultar(){
        consultarRedirect();
    }

    void cadastrarRedirect(){
        Intent novaTela = new Intent(MenuActivity.this,ConsultarActivity.class);
        startActivity(novaTela);
    }

    void consultarRedirect(){
        Intent novaTela = new Intent(MenuActivity.this,ConsultarActivity.class);
        startActivity(novaTela);
    }
}