package com.saenz.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView mTextView1, mTextView2, mTextView3, mTextView4;
    String user, pass, email, gender, string_share;
    Button mButton_Share;

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
        if(mIntent != null){
            user= mIntent.getStringExtra(AppConstants.USER_KEY);
            mTextView1.setText(user);
            pass= mIntent.getStringExtra(AppConstants.PASS_KEY);
            mTextView2.setText(pass);
            email= mIntent.getStringExtra(AppConstants.EMAIL_KEY);
            mTextView3.setText(email);
            gender= mIntent.getStringExtra(AppConstants.GENDER_KEY);
            mTextView4.setText(gender);

        }

        mButton_Share.setOnClickListener(v -> {
            Intent mIntent_Share = new Intent();

            mIntent_Share.setAction(Intent.ACTION_SEND);
            mIntent_Share.setType("text/plain");
            string_share=user + "\n" + pass + "\n" + email + "\n" + gender;

            mIntent_Share.putExtra(Intent.EXTRA_TEXT,string_share);

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