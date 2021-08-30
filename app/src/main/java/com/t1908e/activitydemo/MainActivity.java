package com.t1908e.activitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //login activity
    //static components
    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

    }
    //handle all onclick of component
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                onLogin();
                break;
            default:
                break;
        }
    }
    private void onLogin() {
        if(txtUsername.getText().toString().isEmpty() || txtPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "Bạn chưa nhập username hoặc password", Toast.LENGTH_SHORT).show();
            return;
        }
        // chuyển màn hình
        Intent intent = new Intent(this, ProfileActivity.class);
        //put thông tin vào màn hifh sau
        intent.putExtra("USER_NAME", txtUsername.getText().toString());
        //mở màn hình profile lên
        startActivity(intent);
    }
}