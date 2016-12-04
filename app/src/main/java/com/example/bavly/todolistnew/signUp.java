package com.example.bavly.todolistnew;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.google.firebase.auth.FirebaseUser;

public class signUp extends Activity {
    EditText username1;
    EditText password1;
    Button signIn1;
    TextView text1 ;
    ProgressDialog progressDialog ;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();
       /* if(firebaseAuth.getCurrentUser()!= null){
            finish();
            startActivity(new Intent( getApplicationContext() ,ProfileActivity.class));


        }*/
        FirebaseUser user =  firebaseAuth.getCurrentUser();
        username1 = (EditText)findViewById(R.id.etEmail);

        password1 = (EditText)findViewById(R.id.etPass);
        signIn1 = (Button)findViewById(R.id.btnSingIn);
        text1 = (TextView)findViewById(R.id.textView) ;
        progressDialog = new ProgressDialog(this);
        signIn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                userLogin();
            }



        });
        text1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                startActivity(new Intent( getApplicationContext() ,MainActivity.class));

            }



        });




    }

    public void userLogin() {
        String email = username1.getText().toString().trim();
        String pass = password1.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {

            Toast.makeText(this, "Enter your email!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {

            Toast.makeText(this, "Enter your password!", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.show();
        progressDialog.setMessage("Logging in ...");

        firebaseAuth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            startActivity(new Intent( getApplicationContext() ,Main2Activity.class));

                        }else {
                            Toast.makeText(signUp.this, "The email or The password is wrong ", Toast.LENGTH_SHORT).show();

                        }
                    }
                });



    }

}
