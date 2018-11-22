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
import android.widget.ImageView;
import android.widget.Toast;

public class Employ extends AppCompatActivity implements View.OnClickListener {

    private ImageView principalimg,ciimg,csthimg,dnthimg,tcthimg;
    Button homeBtn,teacherBtn,UserBtn,noticeBtn,jobBtn,photosBtn;
    private Button callBtnprincipalfci,callBtncifci,callBtnHcstfci,callBtnHdntfci,callBtnHtctfci;
    private Button smsBtnprincipalfci,smsbtncifci,smsbtnhcstfci,smsbtnhdntfci,smsbtnhtctfci;
    private Button emailbtnprincipal,emailbtncifci,emailbtnhcstfci,emailbtnhdntfci,emailbtnhtctfci;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employ);
        findId();
        homeBtn.setOnClickListener(this);
         teacherBtn.setOnClickListener(this);
         UserBtn.setOnClickListener(this);
         noticeBtn.setOnClickListener(this);
         jobBtn.setOnClickListener(this);
         photosBtn.setOnClickListener(this);

        //set onclick listener by call btn
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

        //set onclick listener by email btn
        emailbtnprincipal.setOnClickListener(this);
        emailbtncifci.setOnClickListener(this);
        emailbtnhcstfci.setOnClickListener(this);

        emailbtnhtctfci.setOnClickListener(this);

      /*  principalimg.setImageResource(R.drawable.cisir);
        ciimg.setImageResource(R.drawable.cisir);
        csthimg.setImageResource(R.drawable.csth);

*/
    }

    public void findId() {

        homeBtn=findViewById(R.id.HomeBtnId);
        teacherBtn=findViewById(R.id.TheacherBtnId);
        UserBtn=findViewById(R.id.UserBtnId);
        noticeBtn=findViewById(R.id.NoticeBtnId);
        jobBtn=findViewById(R.id.JobBtnId);
        photosBtn=findViewById(R.id.PhotosBtnId);
        principalimg=findViewById(R.id.principalImdId);
        ciimg=findViewById(R.id.ciimgBtn);
        csthimg=findViewById(R.id.csthimgId);
        dnthimg=findViewById(R.id.csthimgId);
        tcthimg=findViewById(R.id.tcthimgId);

        //find Id by call Btn
        callBtnprincipalfci=findViewById(R.id.CallBtnIdPrincipalFCI);
        callBtncifci=findViewById(R.id.CallBtnIdCiFCI);
        callBtnHcstfci=findViewById(R.id.CallBtnIdHCSTFCI);
        callBtnHdntfci=findViewById(R.id.CallBtnIdHDNTFCI);
        callBtnHtctfci=findViewById(R.id.CallBtnIdHTCTFCI);
        //find Id by sms Btn
        smsBtnprincipalfci=findViewById(R.id.messageBtnIdPrincipalFCI);
        smsbtncifci=findViewById(R.id.messageBtnIdCiFCI);
        smsbtnhcstfci=findViewById(R.id.messageBtnIdHCSTFCI);
        smsbtnhdntfci=findViewById(R.id.messageBtnIdHDNTFCI);
        smsbtnhtctfci=findViewById(R.id.messageBtnIdHTCTFCI);
        //find Id by email Btn
        emailbtnprincipal=findViewById(R.id.emailBtnIdPrincipalFCI);
        emailbtncifci=findViewById(R.id.emailBtnIdCiFCI);
        emailbtnhcstfci=findViewById(R.id.emailBtnIdHCSTFCI);
        emailbtnhdntfci=findViewById(R.id.emailBtnIdHDNTFCI);
        emailbtnhtctfci=findViewById(R.id.emailBtnIdHTCTFCI);

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
        return super.onOptionsItemSelected(item);
    }
    public void Toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.HomeBtnId){
            Intent i=new Intent(this,fciHome.class);
            startActivity(i);
        }else if(v.getId()==R.id.TheacherBtnId){
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

        else if(v.getId()==R.id.CallBtnIdPrincipalFCI){
            call("01971333888");
        }else if(v.getId()==R.id.messageBtnIdPrincipalFCI){
            sms("01971333888");
        }else if(v.getId()==R.id.emailBtnIdPrincipalFCI){
            email("rehancpi@gmail.com");
        }else if(v.getId()==R.id.CallBtnIdCiFCI){
            call("01553375004");
        }else if(v.getId()==R.id.messageBtnIdCiFCI){
            sms("01553375004");
        }else if(v.getId()==R.id.emailBtnIdCiFCI){
            email("debabratan55@gmail.com");
        }else if(v.getId()==R.id.CallBtnIdHCSTFCI){
            call("01711132353");
        }else if(v.getId()==R.id.messageBtnIdHCSTFCI){
            sms("01711132353");
        }else if(v.getId()==R.id.emailBtnIdHCSTFCI){
            email("afrojajainabmary@gmail.com");
        }else if(v.getId()==R.id.CallBtnIdHDNTFCI){
            call("01818591793");
        }else if(v.getId()==R.id.messageBtnIdHDNTFCI){
            sms("01818591793");
        }else if(v.getId()==R.id.CallBtnIdHTCTFCI){
            call("01711583992");
        }else if(v.getId()==R.id.messageBtnIdHTCTFCI){
            sms("01711583992");
        }else if(v.getId()==R.id.emailBtnIdHTCTFCI){
            email("symahbub@gmail.com");
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

    public void email(String mail){
        Intent intent=new Intent(Intent.ACTION_SENDTO,Uri.fromParts("Mailto",mail,null));
        startActivity(Intent.createChooser(intent,"Send email..."));
    }
}
