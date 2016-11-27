package com.example.bavly.todolistnew;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button signIn;
    TextView text;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firebaseAuth = FirebaseAuth.getInstance();

        username = (EditText) findViewById(R.id.etUserName);
        password = (EditText) findViewById(R.id.etPass);
        signIn = (Button) findViewById(R.id.btnSingUp);
        text = (TextView) findViewById(R.id.registered);
        progressDialog = new ProgressDialog(this);

        signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                registeruser();
            }


        });
        text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent( getApplicationContext() ,signUp.class));
            }


        });


    }

    public void registeruser() {
        String email = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {

            Toast.makeText(this, "Enter your email!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {

            Toast.makeText(this, "Enter your password!", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.show();
        progressDialog.setMessage("Registeration user ...");
        progressDialog.setCancelable(false);

        firebaseAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Registiration is completed ", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this, "Registiration is failed ", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }



}
