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


public class SignUpUser extends AppCompatActivity {
    private FirebaseAuth mAuth;
    public EditText email,password;
    public Button button;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
       FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_user);

        email=findViewById(R.id.email1);
        password=findViewById(R.id.password1);
        button=findViewById(R.id.signUp);
        mAuth = FirebaseAuth.getInstance();

    }
    public void  onRegister(View view)
    {

        final String myEmail = email.getText().toString();
        final String myPassword =password.getText().toString();
        mAuth.createUserWithEmailAndPassword(myEmail,myPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("TAG", "createUserWithEmail:success");
                            //FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(SignUpUser.this,"Successful",Toast.LENGTH_SHORT).show();
                            Intent intent2= new Intent(SignUpUser.this,CardView2.class);
                            startActivity(intent2);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignUpUser.this,"Failure",Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });
    }

}
