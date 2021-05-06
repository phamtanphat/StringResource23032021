package com.example.stringresource23032021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText mEdtUser,mEdtPassword;
    Button mBtnLogin;
    TextView mTvInfo;
    ToggleButton mToggleLan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale("en");
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

                String textKeyUser = getResources().getString(R.string.text_user_name);
                String textKeyPassword = getResources().getString(R.string.text_password);

                mTvInfo.setText(textKeyUser + " : " + username + "\n" + textKeyPassword + " : " + password);
            }
        });
    }
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = getResources().getConfiguration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
}