package com.example.christmasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.christmasapp.data.DataStorage;
import com.example.christmasapp.models.Child;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etUsername = findViewById(R.id.et_username);
        EditText etPassword = findViewById(R.id.et_password);
        Button btnLogin = findViewById(R.id.btn_login);
        Button btnRegister = findViewById(R.id.btn_register);

        // Ajouter un administrateur par défaut
        DataStorage.addChild(new Child("Pere", "Noel", 999, "Pôle Nord", "Village", "admin", "admin"));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez entrer tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }

                Child child = DataStorage.findChildByUsername(username);
                if (child != null && child.getPassword().equals(password)) {
                    if (username.equals("admin")) {
                        Intent intent = new Intent(MainActivity.this, AdminMenuActivity.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, ChildMenuActivity.class);
                        intent.putExtra("username", username);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Identifiants incorrects", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Redirection vers la page d'inscription
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
