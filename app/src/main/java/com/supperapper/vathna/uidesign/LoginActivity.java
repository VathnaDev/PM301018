package com.supperapper.vathna.uidesign;

import android.content.DialogInterface;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText mUsername;
    EditText mPassword;
    Button btnLogin;
    Button btnRegister;
    AlertDialog alertDialog;
    ConstraintLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = findViewById(R.id.et_username);
        mPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister  = findViewById(R.id.btn_register);
        rootLayout = findViewById(R.id.root_layout);
        alertDialog = new AlertDialog.Builder(this).create();

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();
                if(validateUser(username,password)){
                    Toast.makeText(LoginActivity.this, "You have successfully login", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(rootLayout,"Register button clicked",Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });
    }

    private boolean validateUser(String username, String password) {
        if(TextUtils.isEmpty(username) && TextUtils.isEmpty(password)){
            alertDialog.setTitle("Invalid!");
            alertDialog.setMessage("You must input username and password");
            alertDialog.show();
            return false;
        }else if(TextUtils.isEmpty(username)){
            alertDialog.setTitle("Invalid!");
            alertDialog.setMessage("You must input username");
            alertDialog.show();
            return false;
        }else if(TextUtils.isEmpty(password)){
            alertDialog.setTitle("Invalid!");
            alertDialog.setMessage("You must input password");
            alertDialog.show();
            return false;
        }else if(password.length() < 6){
            alertDialog.setTitle("Invalid!");
            alertDialog.setMessage("Password must be at least 6 characters.");
            alertDialog.show();
            return false;
        }
        return true;
    }
}
