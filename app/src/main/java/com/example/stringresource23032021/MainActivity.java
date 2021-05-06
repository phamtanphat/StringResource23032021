package com.example.stringresource23032021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText mEdtUser,mEdtPassword;
    Button mBtnLogin;
    TextView mTvInfo;
    ToggleButton mToggleLan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtPassword = findViewById(R.id.editTextPassWord);
        mEdtUser = findViewById(R.id.editTextUser);
        mBtnLogin = findViewById(R.id.buttonLogin);
        mTvInfo = findViewById(R.id.textViewInfo);
        mToggleLan = findViewById(R.id.toggleLanguage);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mEdtUser.getText().toString();
                String password = mEdtPassword.getText().toString();


            }
        });


    }
}