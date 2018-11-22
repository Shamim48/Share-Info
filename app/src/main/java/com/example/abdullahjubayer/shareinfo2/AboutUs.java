package com.example.abdullahjubayer.shareinfo2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AboutUs extends AppCompatActivity implements View.OnClickListener {
Button callBtnshamim,callbtnjubayer,callbtnmejba;

private Button smsBtnshamim,smsBtnjubayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        findId();
        callBtnshamim.setOnClickListener(this);
        callbtnjubayer.setOnClickListener(this);
        callbtnmejba.setOnClickListener(this);
        smsBtnshamim.setOnClickListener(this);
        smsBtnjubayer.setOnClickListener(this);
    }

    public void findId(){
        callBtnshamim=findViewById(R.id.CallBtnIdshamim);
        callbtnjubayer=findViewById(R.id.CallBtnIdjubayer);
        callbtnmejba=findViewById(R.id.CallBtnIdmejba);
        smsBtnshamim=findViewById(R.id.messageBtnIdshamimuser);
        smsBtnjubayer=findViewById(R.id.messageBtnIdjubayer);
    }

    public void call(String str) {

        try {


            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + str));
            startActivity(intent);
        } catch (android.content.ActivityNotFoundException e) {

            Toast.makeText(getApplicationContext(), "App failed", Toast.LENGTH_LONG).show();
        }
    }

    public void sms(String number){
        try {
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
            smsIntent.addCategory(Intent.CATEGORY_DEFAULT);
            smsIntent.setType("vnd.android-dir/mms-sms");
            smsIntent.setData(Uri.parse("sms:" +number));
            startActivity(smsIntent);
        }catch (Exception e){

        }


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.CallBtnIdshamim){
            call("01879713588");
        }else if(v.getId()==R.id.CallBtnIdjubayer){
            call("01770154984");
        }else if (v.getId()==R.id.CallBtnIdmejba){
            call("01719944773");
        }else if(v.getId()==R.id.messageBtnIdjubayer){
            sms("01770154984");
        }else if(v.getId()==R.id.messageBtnIdshamimuser){
            sms("01879713588");
        }

    }
}


