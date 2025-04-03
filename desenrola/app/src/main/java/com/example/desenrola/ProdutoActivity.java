package com.example.desenrola;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProdutoActivity extends AppCompatActivity {
    EditText editNome, editMarca;
    Button buttonAdicionar, buttonExcluir;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DatabaseHelper(this);
        editNome = findViewById(R.id.editNome);
        editMarca = findViewById(R.id.editMarca);
        buttonAdicionar = findViewById(R.id.buttonAdicionar);
        buttonExcluir = findViewById(R.id.buttonExcluir);

        buttonAdicionar.setOnClickListener(v -> {
            String nome = editNome.getText().toString();
            String marca = editMarca.getText().toString();
            if (db.insertProduto(nome, marca)) {
                Toast.makeText(this, "Produto adicionado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Erro ao adicionar produto", Toast.LENGTH_SHORT).show();
            }
        });

        buttonExcluir.setOnClickListener(v -> {
            String nome = editNome.getText().toString();
            if (db.deleteProduto(nome)) {
                Toast.makeText(this, "Produto excluído", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Erro ao excluir produto", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
