package com.example.eventpedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class RegisterActivity extends AppCompatActivity {
   private FirebaseAuth mAuth;
    Button usSignUp, usLogIn, adSignUp, asLogIn;
    EditText email_one, password_one;

       @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
      FirebaseUser currentUser = mAuth.getCurrentUser();
       // updateUI(currentUser);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usSignUp = findViewById(R.id.sign1);
        usLogIn = findViewById(R.id.login1);
        adSignUp = findViewById(R.id.sign2);
        asLogIn = findViewById(R.id.login2);
        mAuth = FirebaseAuth.getInstance();
        email_one = findViewById(R.id.email_user);
        password_one = findViewById(R.id.password_user);

//        final String email=getIntent().getStringExtra("email_one");
//        final String password=getIntent().getStringExtra("password_one");

//        usSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SignUp(email,password);
//            }
//        });
        usSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(RegisterActivity.this, SignUpUser.class);
                startActivity(intent3);
                Toast.makeText(RegisterActivity.this,"Redirecting !",Toast.LENGTH_SHORT).show();
            }
        });

        adSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(RegisterActivity.this, SignUpAdmin.class);
                startActivity(intent4);
                Toast.makeText(RegisterActivity.this,"Redirecting !",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void onLogin(View view) {
        final String myEmail = email_one.getText().toString();
        final String myPass = password_one.getText().toString();
        mAuth.signInWithEmailAndPassword(myEmail, myPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("tag", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(RegisterActivity.this, "Auth Success Yaaay!", Toast.LENGTH_SHORT).show();
                            Intent intent2= new Intent(RegisterActivity.this,CardView2.class);
                            startActivity(intent2);
                            Log.i("User", "USER:" + user.toString());

                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.i("tag", "signInWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }
}
//    public void SignUp(String email,String password)
//    {
//
//        mAuth.createUserWithEmailAndPassword(email,password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            //Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                           // updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                           // Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            //updateUI(null);
//                        }
//
//                        // ...
//                    }
//                });
//    }
//}

