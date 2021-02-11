package com.example.oneforball;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oneforball.databinding.ActivityCreateAnAccountBinding;
import com.example.oneforball.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAnAccountActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    ActivityCreateAnAccountBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateAnAccountBinding.inflate(getLayoutInflater());
        mAuth = FirebaseAuth.getInstance();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://one-for-ball-default-rtdb.firebaseio.com");
        setContentView(binding.getRoot());
        binding.back.setOnClickListener(this);
        binding.signup.setOnClickListener(this);
        this.getSupportActionBar().hide();
        //editText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.emailicon, 0, 0, 0);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                startActivity(new Intent(CreateAnAccountActivity.this,LoginActivity.class));
                break;
            case R.id.signup:
                registerAccount();
                break;
        }
    }

    private void registerAccount(){
        String fullName = binding.editTextTextName.getText().toString().trim();
        String email = binding.editTextTextEmailAddress.getText().toString().trim();
        String password = binding.editTextTextPassword.getText().toString().trim();
        String repassword = binding.editTextTextRePassword.getText().toString().trim();

        if(fullName.isEmpty())
        {
            binding.editTextTextName.setError("Full name is empty");
            binding.editTextTextName.requestFocus();
            return;
        }else
        {
            binding.editTextTextName.setError(null);
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            binding.editTextTextEmailAddress.setError("Please Provide valid Email");
            binding.editTextTextEmailAddress.requestFocus();
            return;
        }else
        {
            binding.editTextTextEmailAddress.setError(null);
        }

        if(password.length() <= 6)
        {
            binding.editTextTextPassword.setError("Small password");
            binding.editTextTextPassword.requestFocus();
            return;
        }else
        {
            binding.editTextTextPassword.setError(null);
        }

        if(!repassword.equals(password))
        {
            binding.editTextTextRePassword.setError("Password doesnt match");
            binding.editTextTextRePassword.requestFocus();
            return;
        }else
        {
            binding.editTextTextRePassword.setError(null);
        }

      /*  try {
*/
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(CreateAnAccountActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                User user = new User(fullName, email);
                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (!task.isComplete()) {
                                            Toast.makeText(CreateAnAccountActivity.this, "Server authentication failed.",
                                                    Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(CreateAnAccountActivity.this, "Registered successfully",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(CreateAnAccountActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });

      /*  catch (Exception ex)
        {

            Toast.makeText(CreateAnAccountActivity.this, ex + "",
                    Toast.LENGTH_SHORT).show();
        }*/
    }

}