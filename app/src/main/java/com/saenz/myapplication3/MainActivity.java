package com.saenz.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button mButton_send;
    EditText mEditText1, mEditText2, mEditText3, mEditText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton_send=findViewById(R.id.bt_send);
        mEditText1 = findViewById(R.id.et_user);
        mEditText2 = findViewById(R.id.et_pass);
        mEditText3 = findViewById(R.id.et_email);
        mEditText4 = findViewById(R.id.et_gender);

        mButton_send.setOnClickListener(v -> {
            Intent mIntent = new Intent(MainActivity.this, Main2Activity.class);
            mIntent.putExtra(AppConstants.USER_KEY,mEditText1.getText().toString());
            mIntent.putExtra(AppConstants.PASS_KEY,mEditText2.getText().toString());
            mIntent.putExtra(AppConstants.EMAIL_KEY,mEditText3.getText().toString());
            mIntent.putExtra(AppConstants.GENDER_KEY,mEditText4.getText().toString());
            startActivity(mIntent);
        });
    }
}
