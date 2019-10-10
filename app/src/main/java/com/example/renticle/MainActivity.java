package com.example.renticle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText username, password;
    private TextView forgotPassword;
    private Button login, signUp;
    private final String INTENT_KEY = "intent";
    private final String USER_INTENT = "user";
    private final String ADMIN_INTENT = "admin";
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        forgotPassword = findViewById(R.id.forgot_password);
        login = findViewById(R.id.login);
        signUp = findViewById(R.id.signUp);
        back = findViewById(R.id.back);
        Intent intent = getIntent();
        String loggedInAs = intent.getStringExtra(INTENT_KEY);

        if (loggedInAs.equals(ADMIN_INTENT))
            signUp.setVisibility(View.INVISIBLE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForgotPasswordActivity.class));
            }
        });
    }
}
