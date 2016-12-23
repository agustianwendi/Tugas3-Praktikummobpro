package com.byethost31.mobpro.tugas4pmp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by acer on 11/7/2016.
 */

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    DataHelper dbHelper;

    EditText edtUsername, edtPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        dbHelper = new DataHelper(getApplicationContext());
        btnLogin= (Button)findViewById(R.id.buttonLogin);
        edtUsername=(EditText)findViewById(R.id.editTextUsername);
        edtPassword=(EditText)findViewById(R.id.editTextPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username , Password;

                Username = edtUsername.getText().toString();
                Password = edtPassword.getText().toString();

                int row = dbHelper.cekLogin(Username,Password);
                if (row != 0)
                {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
