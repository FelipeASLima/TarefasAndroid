package com.tarefas.android.Tarefa3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.tarefas.android.R;

public class Tarefa3Activity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText editLogin;
    private EditText editSenha;
    private TextView textStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa3);

        mAuth = FirebaseAuth.getInstance();
        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById(R.id.editSenha);
    }

    public void signIn(View view) {
        final String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();

        emptyValidation();

        if (!emptyValidation()) {

            mAuth.signInWithEmailAndPassword(login, senha).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(Tarefa3Activity.this, "Logado com sucesso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    intent.putExtra("login do usuario", login);
                    startActivity(intent);
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Tarefa3Activity.this, "Não foi possivel, tente novamente!", Toast.LENGTH_SHORT).show();
                        }
                    });
        }else {
            Toast.makeText(Tarefa3Activity.this, "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean emptyValidation() {
        return TextUtils.isEmpty(editLogin.getText().toString()) || TextUtils.isEmpty(editSenha.getText().toString());
    }

    void updateUI(FirebaseUser currentUser){
        if(currentUser != null){
            menuRedirect();
        }
        else{
            Toast.makeText(this, "Usuário não logado.", Toast.LENGTH_SHORT).show();
        }
    }

    void menuRedirect(){
        Intent novaTela = new Intent(Tarefa3Activity.this,MenuActivity.class);
        startActivity(novaTela);
    }
}
