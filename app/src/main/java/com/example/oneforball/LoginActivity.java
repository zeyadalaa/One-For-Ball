package com.example.oneforball;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oneforball.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityLoginBinding binding;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.getSupportActionBar().hide();
        binding.createaccount.setOnClickListener(this);
        binding.login.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.createaccount:
                Intent i = new Intent(LoginActivity.this ,CreateAnAccountActivity.class);
                startActivity(i);
                break;
            case R.id.login:
                userLogin();
                break;
        }
    }

    private void userLogin(){
        String email = binding.email.getText().toString().trim();
        String password = binding.password.getText().toString().trim();


        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            binding.email.setError("Please Provide valid Email");
            binding.email.requestFocus();
            return;
        }else
        {
            binding.email.setError(null);
        }

        if (password.isEmpty())
        {
            binding.password.setError("Empty password");
            binding.password.requestFocus();
            return;
        }else
        {
            binding.password.setError(null);
        }

        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Intent i = new Intent(LoginActivity.this,LeaguesActivity.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "Wrong Email or password.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}