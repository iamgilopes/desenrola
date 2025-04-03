package com.example.desenrola;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText editUsuario, editSenha;
    Button buttonLogin;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Nome do layout corrigido

        db = new DatabaseHelper(this);
        editUsuario = findViewById(R.id.editUsuario); // IDs corrigidos para bater com o XML
        editSenha = findViewById(R.id.editSenha);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(v -> {
            String usuario = editUsuario.getText().toString().trim();
            String senha = editSenha.getText().toString().trim();

            // Verificar se os campos estão vazios
            if (usuario.isEmpty() || senha.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Verifica no banco de dados
            if (db.checkUser(usuario, senha)) {
                Toast.makeText(LoginActivity.this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, ProdutoActivity.class));
                finish(); // Fecha a tela de login
            } else {
                Toast.makeText(LoginActivity.this, "Usuário ou senha inválidos!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
