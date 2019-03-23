package com.saenz.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView mTextView_Received;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        String message = "";
        mTextView_Received = findViewById(R.id.tv_received);

        Intent m_intent = this.getIntent();
        if(m_intent !=  null){
            if(m_intent.getType().equals("text/plain")){
                message = m_intent.getStringExtra(Intent.EXTRA_TEXT);
                mTextView_Received.setText(message);
            }
        }


    }
}
