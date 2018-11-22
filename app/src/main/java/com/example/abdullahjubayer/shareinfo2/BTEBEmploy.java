package com.example.abdullahjubayer.shareinfo2;

import android.app.ActionBar;
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

public class BTEBEmploy extends AppCompatActivity implements View.OnClickListener {
    Button homeBtn,employBtn,userBtn,noticebtn,jobBtn,photosBtn,

    call_btn1,sms_btn1,email1,
    call_btn2,sms_btn2,email2,
    call_btn3,sms_btn3,email3,
    call_btn4,sms_btn4,email4,
    call_btn5,sms_btn5,email5

            ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btebemploy);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        findId();
        homeBtn.setOnClickListener(this);
        employBtn.setOnClickListener(this);
        userBtn.setOnClickListener(this);
        noticebtn.setOnClickListener(this);
        jobBtn.setOnClickListener(this);
        photosBtn.setOnClickListener(this);
        employBtn.setOnClickListener(this);
        sms_btn1.setOnClickListener(this);
        call_btn1.setOnClickListener(this);
        sms_btn2.setOnClickListener(this);
        call_btn2.setOnClickListener(this);
        sms_btn3.setOnClickListener(this);
        call_btn3.setOnClickListener(this);
        sms_btn4.setOnClickListener(this);
        call_btn4.setOnClickListener(this);
        call_btn5.setOnClickListener(this);
        sms_btn5.setOnClickListener(this);

        email1.setOnClickListener(this);
        email2.setOnClickListener(this);
        email3.setOnClickListener(this);
        email4.setOnClickListener(this);
        email5.setOnClickListener(this);



    }


    public void findId() {
        homeBtn=findViewById(R.id.HomeBtnId);
        employBtn=findViewById(R.id.EmployBtnId);
        userBtn=findViewById(R.id.UserBtnId);
        noticebtn=findViewById(R.id.NoticeBtnId);
        jobBtn=findViewById(R.id.JobBtnId);
        photosBtn=findViewById(R.id.PhotosBtnId);
        call_btn1=findViewById(R.id.CallBtnIdPrincipalBTEB);
        sms_btn1=findViewById(R.id.emailBtnIdPrincipalBTEB);
        call_btn2=findViewById(R.id.BTEBBtnIdCiFPI);
        sms_btn2=findViewById(R.id.emailBtnIdCiBTEB);
        sms_btn3=findViewById(R.id.emailBtnIdHCSTBTEB);
        call_btn3=findViewById(R.id.CallBtnIdHCSTBTEB);
        sms_btn4=findViewById(R.id.emailBtnIdHDNTBTEB);
        call_btn4=findViewById(R.id.CallBtnIdHDNTBTEB);
        call_btn5=findViewById(R.id.CallBtnIdHTCTBTEB);
        sms_btn5=findViewById(R.id.emailBtnIdHTCTBTEB);

        email1=findViewById(R.id.messageBtnIdPrincipalBTEB);
        email2=findViewById(R.id.messageBtnIdCiBTEB);
        email3=findViewById(R.id.messageBtnIdHCSTBTEB);
        email4=findViewById(R.id.messageBtnIdHDNTBTEB);
        email5=findViewById(R.id.messageBtnIdHTCTBTEB);
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
                Intent intent=new Intent(BTEBEmploy.this,BTEBHome.class);
                startActivity(intent);
                finishActivity(0);
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
                Intent i=new Intent(this,BTEBHome.class);
                startActivity(i);
            }else if(v.getId()==R.id.EmployBtnId){
                Intent i=new Intent(this,BTEBEmploy.class);
                startActivity(i);
            }else if(v.getId()==R.id.UserBtnId){
                Intent i=new Intent(this,BTEBUser.class);
                startActivity(i);
            }else if(v.getId()==R.id.NoticeBtnId){
                Intent i=new Intent(this,BTEBNotification.class);
                startActivity(i);
            }else if(v.getId()==R.id.JobBtnId){
            Intent i=new Intent(this,BTEBJob.class);
            startActivity(i);
        }else if(v.getId()==R.id.PhotosBtnId){
            Intent i=new Intent(this,BTEBPhotos.class);
            startActivity(i);
        }
        else if (v.getId()==R.id.CallBtnIdPrincipalBTEB){
                call("01819258958");
            }
            else if (v.getId()==R.id.emailBtnIdPrincipalBTEB){
                mail("chairman@bteb.gov.bd");
            }

            else if (v.getId()==R.id.BTEBBtnIdCiFPI){
                call("01714077005");
            }
            else if (v.getId()==R.id.emailBtnIdCiBTEB){
                mail("secretary@bteb.gov.bd");
            }
            else if(v.getId()==R.id.CallBtnIdHCSTBTEB){
                call("01714073726");
            }
            else if(v.getId()==R.id.emailBtnIdHCSTBTEB){
                mail("director@bteb.gov.bd");
            }
            else if(v.getId()==R.id.CallBtnIdHDNTBTEB){
                call("01708518270");
            }
            else if(v.getId()==R.id.emailBtnIdHDNTBTEB){
                mail("inspector.bteb@outlook.com");
            }
            else if(v.getId()==R.id.CallBtnIdHTCTBTEB){
                call("01714075838");
            }
            else if(v.getId()==R.id.emailBtnIdHTCTBTEB){
                mail("paulksusil@yahoo.com");

            }else if(v.getId()==R.id.emailBtnIdHTCTBTEB){
                mail("paulksusil@yahoo.com");

            }else if(v.getId()==R.id.messageBtnIdPrincipalBTEB){
               sms("01819258958");

            }
            if (v.getId()==R.id.messageBtnIdHDNTBTEB){
                sms("01819258958");

            }
            if (v.getId()==R.id.messageBtnIdCiBTEB){
                sms("01714077005");

            }if (v.getId()==R.id.messageBtnIdHCSTBTEB){
                sms("01714073726");

            }if (v.getId()==R.id.messageBtnIdHDNTBTEB){
                sms("01708518270");

            }if (v.getId()==R.id.messageBtnIdHTCTBTEB){
                sms("01714075838");
            }

        }catch (Exception e){
            Toast("Exception is:"+e);
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

