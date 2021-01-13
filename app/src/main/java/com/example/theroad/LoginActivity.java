package com.example.theroad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity {

    EditText tloginuser, tloginpassword;
    Button btnlogin, Register;
    CheckBox chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        SharedPreferences sh = getSharedPreferences("RoadShared", MODE_PRIVATE);
        String u = sh.getString("user", null);
        String p = sh.getString("pass", null);
        if ((u != null) && (p != null)) {
            startActivity(new Intent(LoginActivity.this, MainUserActivity.class));
        }

        tloginuser = findViewById(R.id.txtloginuser);
        tloginpassword = findViewById(R.id.txtloginpassword);
        chk = findViewById(R.id.checkbox);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Database db1 = new Database();
                Connection conn1 = db1.ConnectDB();
                if (conn1 == null)
                    Toast.makeText(LoginActivity.this, "Check Internet Access", Toast.LENGTH_LONG).show();
                else {
                    ResultSet rslogin = db1.RunSearch("select * from Users where user_name='" + tloginuser.getText() + "'and password='" + tloginpassword.getText() + "'");
                    try {
                        btnlogin = findViewById(R.id.btnlogin);
                        if (rslogin.next()) {
                            if (chk.isChecked()) {

                                getSharedPreferences("RoadShared", MODE_PRIVATE)
                                        .edit()
                                        .putString("user", tloginuser.getText().toString())
                                        .putString("pass", tloginpassword.getText().toString())
                                        .commit();

                            }

                            startActivity(new Intent(LoginActivity.this, MainUserActivity.class));

                        } else {
                            tloginuser.setError("Invalid username Or Password");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        Register = (Button) findViewById(R.id.btnRegister);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, onBoard.class));

            }
        });


    }

}
