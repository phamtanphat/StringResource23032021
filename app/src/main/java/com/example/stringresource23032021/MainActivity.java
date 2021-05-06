package com.example.stringresource23032021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText mEdtUser,mEdtPassword;
    Button mBtnLogin;
    TextView mTvInfo;
    ToggleButton mToggleLan;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("AppCache",MODE_PRIVATE);
        setLocale(sharedPreferences.getString("lang",""));
        setContentView(R.layout.activity_main);

        mEdtPassword = findViewById(R.id.editTextPassWord);
        mEdtUser = findViewById(R.id.editTextUser);
        mBtnLogin = findViewById(R.id.buttonLogin);
        mTvInfo = findViewById(R.id.textViewInfo);
        mToggleLan = findViewById(R.id.toggleLanguage);

        mToggleLan.setChecked(sharedPreferences.getBoolean("checked",false));

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
        mToggleLan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor = sharedPreferences.edit();
                if (b){
                    // language vn
                    // no sql : dùng key và value để lưu trữ
                    editor.putString("lang","vi");
                    editor.putBoolean("checked",true);
                }else{
                    editor.putString("lang","en");
                    editor.putBoolean("checked",false);
                }
                editor.apply();
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
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