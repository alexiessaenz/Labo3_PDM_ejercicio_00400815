package com.saenz.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class Main3Activity extends AppCompatActivity {
    TextView mTextView_Received;
    String message = "", json="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mTextView_Received = findViewById(R.id.tv_received);


        //Creamos un objeto Gson
        Gson gson = new Gson();

        Intent m_intent = this.getIntent();
        if(m_intent !=  null){


            if(m_intent.getType().equals("text/plain")){
                //Recuperamos la cadena json
                json = m_intent.getStringExtra(Intent.EXTRA_TEXT);
                Usuario usuario = gson.fromJson(json, Usuario.class);
                
                //Creamos un nuevo Usuario a partir de json
                message=usuario.getmUser() + "\n" + usuario.getmPass() + "\n" + usuario.getmEmail() + "\n" + usuario.getmGender();
                mTextView_Received.setText(message);
            }
        }


    }
}
