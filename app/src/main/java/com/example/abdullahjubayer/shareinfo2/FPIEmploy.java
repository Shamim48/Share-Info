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

public class FPIEmploy extends AppCompatActivity implements View.OnClickListener {
    Button homeBtn,employBtn,userBtn,noticebtn,jobBtn,photosBtn;
    private Button callBtnprincipalfci,callBtncifci,callBtnHcstfci,callBtnHdntfci,callBtnHtctfci;
    private Button smsBtnprincipalfci,smsbtncifci,smsbtnhcstfci,smsbtnhdntfci,smsbtnhtctfci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpiemploy);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findId();
        homeBtn.setOnClickListener(this);
        employBtn.setOnClickListener(this);
        noticebtn.setOnClickListener(this);

        callBtnprincipalfci.setOnClickListener(this);
        callBtncifci.setOnClickListener(this);
        callBtnHcstfci.setOnClickListener(this);
        callBtnHdntfci.setOnClickListener(this);
        callBtnHtctfci.setOnClickListener(this);
//set onclick listener by sms btn
        smsBtnprincipalfci.setOnClickListener(this);
        smsbtncifci.setOnClickListener(this);
        smsbtnhcstfci.setOnClickListener(this);
        smsbtnhdntfci.setOnClickListener(this);
        smsbtnhtctfci.setOnClickListener(this);
    }

    public void findId() {
        homeBtn=findViewById(R.id.HomeBtnId);
        employBtn=findViewById(R.id.TheacherBtnId);
        userBtn=findViewById(R.id.UserBtnId);
        noticebtn=findViewById(R.id.NoticeBtnId);
        jobBtn=findViewById(R.id.JobBtnId);
        photosBtn=findViewById(R.id.PhotosBtnId);

        ////find Id by call Btn
        callBtnprincipalfci=findViewById(R.id.CallBtnIdPrincipalFPI);
        callBtncifci=findViewById(R.id.CallBtnIdCiFPI);
        callBtnHcstfci=findViewById(R.id.CallBtnIdHCSTFPI);
        callBtnHdntfci=findViewById(R.id.CallBtnIdHDNTFPI);
        callBtnHtctfci=findViewById(R.id.CallBtnIdHTCTFPI);
        //find Id by sms Btn
        smsBtnprincipalfci=findViewById(R.id.messageBtnIdPrincipalFPI);
        smsbtncifci=findViewById(R.id.messageBtnIdCiFPI);
        smsbtnhcstfci=findViewById(R.id.messageBtnIdHCSTFPI);
        smsbtnhdntfci=findViewById(R.id.messageBtnIdHDNTFPI);
        smsbtnhtctfci=findViewById(R.id.messageBtnIdHTCTFPI);
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
            Intent intent=new Intent(FPIEmploy.this,FPIHome.class);
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
        if(v.getId()==R.id.HomeBtnId){
            Intent i=new Intent(this,FPIHome.class);
            startActivity(i);
        }else if(v.getId()==R.id.TheacherBtnId){
            Intent i=new Intent(this,FPIEmploy.class);
            startActivity(i);
        }else if(v.getId()==R.id.UserBtnId){
            Intent i=new Intent(this,FPIUser.class);
            startActivity(i);
        }else if(v.getId()==R.id.NoticeBtnId){
            Intent i=new Intent(this,FPINotification.class);
            startActivity(i);
        }else if(v.getId()==R.id.JobBtnId){
            Intent i=new Intent(this,FPIJob.class);
            startActivity(i);
        }else if(v.getId()==R.id.PhotosBtnId){
            Intent i=new Intent(this,FPIPhotos.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.CallBtnIdPrincipalFPI){
            call("01688709257");
        }else if(v.getId()==R.id.messageBtnIdPrincipalFPI){
            sms("01688709257");
        }else if(v.getId()==R.id.CallBtnIdCiFPI){
            call("01552496220");
        }else if(v.getId()==R.id.messageBtnIdCiFPI){
            sms("01552496220");
        }else if(v.getId()==R.id.CallBtnIdHCSTFPI){
            call("01819945267");
        }else if(v.getId()==R.id.messageBtnIdHCSTFPI){
            sms("01819945267");
        }else if(v.getId()==R.id.CallBtnIdHDNTFPI){
            call("01712215825");
        }else if(v.getId()==R.id.messageBtnIdHDNTFPI){
            sms("01712215825");
        }else if(v.getId()==R.id.CallBtnIdHTCTFPI){
            call("01715492741");
        }else if(v.getId()==R.id.messageBtnIdHTCTFPI){
            sms("01715492741");
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

}
