package com.saenz.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button mButton, mButton2;
    EditText mEditText1, mEditText2, mEditText3, mEditText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=findViewById(R.id.btn);
        mEditText1 = findViewById(R.id.et_user)
        mButton.setOnLongClickListener(v -> {
            Intent mIntent = new Intent(MainActivity.this, Main2Activity.class);
            mIntent.putExtra(AppConstants.USER_KEY,mEditText1.getText());
            mIntent.putExtra("text","hola actividad 2");
            mIntent.putExtra("text","hola actividad 2");
            mIntent.putExtra("text","hola actividad 2");

            startActivity(mIntent);
        });

        mButton2.setOnLongClickListener(v -> {
            Intent mIntent2 = new Intent();
            mIntent2.setType("text/plain");
            mIntent2.setAction(Intent.ACTION_SEND)
            mIntent2.putExtra("text","hola actividad 2");
            mIntent2.putExtra(Intent.EXTRA_TEXT, "kjdsfvedkjhfgdsgg");
            startActivity(mIntent2);
        });
    }
}
