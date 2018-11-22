package com.example.abdullahjubayer.shareinfo2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class User extends AppCompatActivity implements View.OnClickListener {
    Button homeBtn,teacherBtn,userBtn,noticeBtn,jobBtn,photosBtn,

    call_btn1,sms_btn1,email1,
            call_btn2,sms_btn2,email2,
            call_btn3,sms_btn3,email3,
            call_btn4,sms_btn4,email4

    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        findId();
        homeBtn.setOnClickListener(this);
        teacherBtn.setOnClickListener(this);
        userBtn.setOnClickListener(this);
        noticeBtn.setOnClickListener(this);
        jobBtn.setOnClickListener(this);
        photosBtn.setOnClickListener(this);

        call_btn1.setOnClickListener(this);
        sms_btn1.setOnClickListener(this);
        call_btn2.setOnClickListener(this);
        sms_btn2.setOnClickListener(this);
        call_btn3.setOnClickListener(this);
        sms_btn3.setOnClickListener(this);
        call_btn4.setOnClickListener(this);
        sms_btn4.setOnClickListener(this);
        email1.setOnClickListener(this);
        email2.setOnClickListener(this);
        email3.setOnClickListener(this);
        email4.setOnClickListener(this);


    }
    public void findId() {
        homeBtn=findViewById(R.id.HomeBtnId);
        teacherBtn=findViewById(R.id.EmployBtnId);
        userBtn=findViewById(R.id.UserBtnId);
        noticeBtn=findViewById(R.id.NoticeBtnId);
        jobBtn=findViewById(R.id.JobBtnId);
        photosBtn=findViewById(R.id.PhotosBtnId);

        call_btn1=findViewById(R.id.CallBtnIdshamim);
        sms_btn1=findViewById(R.id.emailBtnIdshamim);
        call_btn2=findViewById(R.id.CallBtnIdjubayer);
        sms_btn2=findViewById(R.id.emailBtnIdjubayer);
        call_btn3=findViewById(R.id.CallBtnIdmejba);
        sms_btn3=findViewById(R.id.emailBtnIdmejba);
        call_btn4=findViewById(R.id.CallBtnIdPrincipalBTEB);
        sms_btn4=findViewById(R.id.emailBtnIdPrincipalBTEB);
        email1=findViewById(R.id.messageBtnIdshamimuser);
        email2=findViewById(R.id.messageBtnIdjubayer);
        email3=findViewById(R.id.messageBtnIdmejba);
        email4=findViewById(R.id.messageBtnIdPrincipalBTEB);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menuitem,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.SettingMenuid){
            Toast("Setting Menu is Selected");
            Intent i=new Intent(getApplicationContext(),Setting.class);
            startActivity(i);

        }else if(item.getItemId()==R.id.SerchMenuId){
            Toast("Serch Menu is Selected");
            Intent i=new Intent(getApplicationContext(),MainActivity3.class);
            startActivity(i);

        }else if(item.getItemId()==R.id.FeedbackMenuid){
            Toast("Feedback Menu is Selected");
            Intent i=new Intent(getApplicationContext(),Feedback.class);
            startActivity(i);
        }else if(item.getItemId()==R.id.AboutMenuid) {
            Toast("About Menu is Selected");
            Intent i=new Intent(getApplicationContext(),AboutUs.class);
            startActivity(i);


        }
        else if (item.getItemId()==android.R.id.home){
            Intent intent=new Intent(getApplicationContext(),fciHome.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void Toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v) {
        try {
            if(v.getId()==R.id.HomeBtnId){

                Intent i=new Intent(this,fciHome.class);
                startActivity(i);
            }else if(v.getId()==R.id.EmployBtnId){
                Intent i=new Intent(this,Employ.class);
                startActivity(i);
            }else if(v.getId()==R.id.UserBtnId){
                Intent i=new Intent(this,User.class);
                startActivity(i);
            }else if(v.getId()==R.id.NoticeBtnId){
                Intent i=new Intent(this,Notification.class);
                startActivity(i);
            }else if(v.getId()==R.id.JobBtnId){
                Intent i=new Intent(this,Job.class);
                startActivity(i);
            }else if(v.getId()==R.id.PhotosBtnId){
                Intent i=new Intent(this,FCIPhotos.class);
                startActivity(i);
            }

            else if (v.getId()==R.id.CallBtnIdshamim){
                call("01719632657");

            }else if (v.getId()==R.id.emailBtnIdshamim){

            }else if (v.getId()==R.id.messageBtnIdshamimuser){
                mail("shamim@gmail.com");
            }else if (v.getId()==R.id.CallBtnIdjubayer){
                call("01770154984");

            }else if (v.getId()==R.id.emailBtnIdjubayer){
                sms("01770154984");
            }else if (v.getId()==R.id.messageBtnIdjubayer){
                mail("abdullahjubayer38@gmail.com");
            }else if (v.getId()==R.id.CallBtnIdmejba){
                call("01719632657");
            }else if (v.getId()==R.id.emailBtnIdmejba){
                sms("01719632657");
            }else if (v.getId()==R.id.messageBtnIdmejba){
                mail("mezbaul@gmail.com");
            }else if (v.getId()==R.id.CallBtnIdPrincipalBTEB){
                call("01989928743");
            }else if (v.getId()==R.id.emailBtnIdPrincipalBTEB){
                sms("01989928743");
            }else if (v.getId()==R.id.messageBtnIdPrincipalBTEB){
                mail("hridoykrisnadas@gmail.com");
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Exception is:"+e,Toast.LENGTH_LONG).show();
        }

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

    public void mail(String mail){
        Intent intent=new Intent(Intent.ACTION_SENDTO,Uri.fromParts("Mailto",mail,null));
        startActivity(Intent.createChooser(intent,"Send email..."));
    }
}
