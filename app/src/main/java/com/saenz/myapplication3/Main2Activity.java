package com.saenz.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class Main2Activity extends AppCompatActivity {
    TextView mTextView1, mTextView2, mTextView3, mTextView4;
    String user, pass, email, gender, string_share;
    Button mButton_Share;
    String json="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextView1 = findViewById(R.id.tv_user);
        mTextView2 = findViewById(R.id.tv_pass);
        mTextView3 = findViewById(R.id.tv_email);
        mTextView4 = findViewById(R.id.tv_gender);

        mButton_Share = findViewById(R.id.bt_share);


        Intent mIntent = this.getIntent();

        //Creamos un objeto Gson
        Gson gson = new Gson();

        if(mIntent != null){
            //Recuperamos la cadena json
             json = mIntent.getStringExtra("json");

            //Creamos un nuevo Usuario a partir de json
            Usuario usuario = gson.fromJson(json, Usuario.class);

            mTextView1.setText(usuario.getmUser());
            mTextView2.setText(usuario.getmPass());
            mTextView3.setText(usuario.getmEmail());
            mTextView4.setText(usuario.getmGender());

        }

        final String mJson_share = json;

        mButton_Share.setOnClickListener(v -> {
            Intent mIntent_Share = new Intent();

            mIntent_Share.setAction(Intent.ACTION_SEND);
            mIntent_Share.setType("text/plain");
            string_share=user + "\n" + pass + "\n" + email + "\n" + gender;

            mIntent_Share.putExtra(Intent.EXTRA_TEXT,mJson_share);

            if (mIntent_Share.resolveActivity(getPackageManager()) != null) {
                startActivity(mIntent_Share);
            }


        });
    }

    @Override
    protected void onResume(){
        super.onResume();





    }
}

/*tipos de mime type
* recibir texto con intent*/