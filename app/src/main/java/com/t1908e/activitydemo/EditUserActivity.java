package com.t1908e.activitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditUserActivity extends AppCompatActivity implements View.OnClickListener {
    //static elements
    private EditText txtEditUsername;
    private Button btnDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        txtEditUsername = findViewById(R.id.txtEditUsername);
        btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);
        //set user name for edit text
        Intent intent = getIntent();
        String userName = intent.getStringExtra("USER_NAME");
        txtEditUsername.setText(userName);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDone:
                onDone();
                break;
            default:
                break;
        }
    }

    private void onDone() {
        //return về màn user profile với result là ok
        Intent returnIntent = new Intent();
        returnIntent.putExtra("RESULT", txtEditUsername.getText().toString());
        setResult(RESULT_OK, returnIntent);
        finish();

    }
}