package com.t1908e.activitydemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE = 1;
    //static components
    private TextView labelUsername;
    private Button btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        labelUsername = (TextView) findViewById(R.id.labelUsername);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        //set event listenner
        btnEdit.setOnClickListener(this);
        //lay du lieu dc chuyen tu man login
        Intent intent = getIntent();
        String userName = intent.getStringExtra("USER_NAME");
        //set text cho label
        labelUsername.setText(userName);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnEdit:
                onEdit();
                break;
            default:
                break;
        }
    }

    private void onEdit() {
        Intent intent = new Intent(this, EditUserActivity.class);
        intent.putExtra("USER_NAME", labelUsername.getText().toString());
        // mở màn EditUser nên chờ ng dùng nhập r quay lại đây
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // xử lý khi mà màn edit xong rồi quay lại
        if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK ) {
                String result = data.getStringExtra("RESULT");
                labelUsername.setText(result);
            }
        }
    }
}