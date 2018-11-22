package com.example.abdullahjubayer.shareinfo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GCFHome extends AppCompatActivity implements View.OnClickListener {
    Button homeBtn,employBtn,userBtn,noticebtn,jobBtn,photosBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcfhome);

        findId();

        homeBtn.setOnClickListener(this);
        employBtn.setOnClickListener(this);
        userBtn.setOnClickListener(this);
        noticebtn.setOnClickListener(this);
        jobBtn.setOnClickListener(this);
        photosBtn.setOnClickListener(this);

    }


    public void findId() {
        homeBtn=findViewById(R.id.HomeBtnId);
        employBtn=findViewById(R.id.TheacherBtnId);
        userBtn=findViewById(R.id.UserBtnId);
        noticebtn=findViewById(R.id.NoticeBtnId);
        jobBtn=findViewById(R.id.JobBtnId);
        photosBtn=findViewById(R.id.PhotosBtnId);
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
        else if (item.getItemId()==R.id.ge_to_online){

            Intent intent=new Intent(getApplicationContext(),aj_UserHomePage.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
    public void Toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.HomeBtnId){
            Intent i=new Intent(this,GCFHome.class);
            startActivity(i);
        }else if(v.getId()==R.id.TheacherBtnId){
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
        }

    }
}
