package com.example.circleofclass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.circleofclass.acrivityManager.BaseActivity;

import java.util.prefs.PreferenceChangeEvent;

public class LoginActivity extends BaseActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText accountEdit;
    private EditText passwordEdit;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        boolean isRemember = pref .getBoolean("remember_password",false);
        if (isRemember){
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(account.equals("31501370") && password.equals("123456")){
                    editor = pref.edit();
                    if (rememberPass.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else{
                        editor.clear();
                    }
                    editor.apply();
                    Toast.makeText(LoginActivity.this,"请稍候！",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,"账号或密码错误！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this,"正在跳转！",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
    }
}
