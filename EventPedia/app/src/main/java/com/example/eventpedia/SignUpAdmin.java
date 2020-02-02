package com.example.eventpedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignUpAdmin extends AppCompatActivity {

    Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_admin);

        signIn=findViewById(R.id.signUp2);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(SignUpAdmin.this, DashboardSociety.class);
                startActivity(intent3);
                Toast.makeText(SignUpAdmin.this,"Signed In",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
