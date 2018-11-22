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

public class GlobalEmploy extends AppCompatActivity implements View.OnClickListener {
    Button homeBtn,employBtn,userBtn,noticebtn,jobBtn,photosBtn,

            call_btn1,sms_btn1,email1,
            call_btn2,sms_btn2,email2,
            call_btn3,sms_btn3,email3,
            call_btn4,sms_btn4,email4,
            call_btn5,sms_btn5,email5,
            call_btn6,sms_btn6,email6
            ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_employ);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findId();
        homeBtn.setOnClickListener(this);
        employBtn.setOnClickListener(this);
        userBtn.setOnClickListener(this);
        noticebtn.setOnClickListener(this);
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
        call_btn5.setOnClickListener(this);
        sms_btn5.setOnClickListener(this);
        call_btn6.setOnClickListener(this);
        sms_btn6.setOnClickListener(this);
        email1.setOnClickListener(this);
        email2.setOnClickListener(this);
        email3.setOnClickListener(this);
        email4.setOnClickListener(this);
        email5.setOnClickListener(this);
        email6.setOnClickListener(this);

    }

    public void findId() {
        homeBtn=findViewById(R.id.HomeBtnId);
       employBtn=findViewById(R.id.EmployBtnId);
        userBtn=findViewById(R.id.UserBtnId);
        noticebtn=findViewById(R.id.NoticeBtnId);
        jobBtn=findViewById(R.id.JobBtnId);
        photosBtn=findViewById(R.id.PhotosBtnId);
        call_btn1=findViewById(R.id.CallBtnIdPrincipalGlobal);
        sms_btn1=findViewById(R.id.emailBtnIdPrincipalGlobal);
        call_btn2=findViewById(R.id.BTEBBtnIdCiGlobal);
        sms_btn2=findViewById(R.id.emailBtnIdCiGlobal);
        call_btn3=findViewById(R.id.CallBtnIdHCSTGlobal);
        sms_btn3=findViewById(R.id.emailBtnIdHCSTGlobal);
        call_btn4=findViewById(R.id.CallBtnIdHDNTGlobal);
        sms_btn4=findViewById(R.id.emailBtnIdHDNTGlobal);
        call_btn5=findViewById(R.id.CallBtnIdHTCTGlobal);
        sms_btn5=findViewById(R.id.emailBtnIdHTCTGlobal);
        call_btn6=findViewById(R.id.CallBtnIdHTCTGlobal6);
        sms_btn6=findViewById(R.id.emailBtnIdHTCTGlobal6);
        email1=findViewById(R.id.messageBtnIdPrincipalGlobal);
        email2=findViewById(R.id.messageBtnIdCiGlobal);
        email3=findViewById(R.id.messageBtnIdHCSTGlobal);
        email4=findViewById(R.id.messageBtnIdHDNTGlobal);
        email5=findViewById(R.id.messageBtnIdHTCTGlobal);
        email6=findViewById(R.id.messageBtnIdHTCTGlobal6);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.HomeBtnId){
            Intent i=new Intent(this,GCFHome.class);
            startActivity(i);
        }else if(v.getId()==R.id.EmployBtnId){
            Intent i=new Intent(this,GlobalEmploy.class);
            startActivity(i);
        }else if(v.getId()==R.id.UserBtnId){
            Intent i=new Intent(this,GlobalUser.class);
            startActivity(i);
        }else if(v.getId()==R.id.NoticeBtnId){
            Intent i=new Intent(this,GlobalNotification.class);
            startActivity(i);
        }else if(v.getId()==R.id.JobBtnId){
            Intent i=new Intent(this,GlobalJob.class);
            startActivity(i);
        }else if(v.getId()==R.id.PhotosBtnId){
            Intent i=new Intent(this,GlobalPhotos.class);
            startActivity(i);
        }else if (v.getId()==R.id.CallBtnIdPrincipalGlobal){

                    call("+8801919757695");
        }
        else if (v.getId()==R.id.emailBtnIdPrincipalGlobal){
            mail("asif@globalcomputer.com");
        }
        else if (v.getId()==R.id.BTEBBtnIdCiGlobal){
            call("+8801919757678");
        }
        else if (v.getId()==R.id.emailBtnIdCiGlobal){
            mail("iqbal@globalcomputer.com");
        }
        else if (v.getId()==R.id.CallBtnIdHCSTGlobal){
            call("+8801828514610");
        }
        else if (v.getId()==R.id.CallBtnIdHDNTGlobal){
            call("+8801919757684");
        }
        else if (v.getId()==R.id.emailBtnIdHDNTGlobal){

        }else if (v.getId()==R.id.CallBtnIdHTCTGlobal){
            call("+8801919757683");
        }else if (v.getId()==R.id.emailBtnIdHTCTGlobal){

        }else if (v.getId()==R.id.CallBtnIdHTCTGlobal6){
            call("+8801919757682");
        }else if (v.getId()==R.id.emailBtnIdHTCTGlobal6){
            sms("+8801919757682");
        }
        if (v.getId()==R.id.messageBtnIdPrincipalGlobal){
            sms("8801919757695");
        }
        if (v.getId()==R.id.messageBtnIdCiGlobal){
            sms("+8801919757678");
        }if (v.getId()==R.id.messageBtnIdPrincipalGlobal){
            sms("+8801919757695");

        }if (v.getId()==R.id.messageBtnIdHTCTGlobal){
            sms("+8801919757684");

        }if (v.getId()==R.id.messageBtnIdHTCTGlobal6){
            sms("+8801919757683");
        }
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
            Intent intent=new Intent(getApplicationContext(),GCFHome.class);
            startActivity(intent);
            finishActivity(0);
        }
        return super.onOptionsItemSelected(item);
    }
    public void Toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
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