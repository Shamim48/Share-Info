package com.example.abdullahjubayer.shareinfo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity implements View.OnClickListener {
private Button sendBtn,clearBtn;
private EditText nameEditx,msgEditeTx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sendBtn=findViewById(R.id.SendBtnId);
         clearBtn=findViewById(R.id.ClearBtnId);
         nameEditx=findViewById(R.id.NameEditeTextId);
         msgEditeTx=findViewById(R.id.MessageEditeTextId);

         sendBtn.setOnClickListener(this);
         clearBtn.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        try {
            String name=nameEditx.getText().toString();
            String msg=msgEditeTx.getText().toString();

            if(v.getId()==R.id.SendBtnId){
                Intent i=new Intent(Intent.ACTION_SEND);

                i.setType("text/email");
                i.putExtra(Intent.EXTRA_EMAIL,new String[] {"shamim04091997@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,"Feedback form app");
                i.putExtra(Intent.EXTRA_TEXT,"name: "+name+"\n"+"Message: \n"+msg);
                startActivity(Intent.createChooser(i,"Feedback with "));

            }else if(v.getId()==R.id.ClearBtnId){
                msgEditeTx.setText(null);
                nameEditx.setText(null);

            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Exception in"+e,Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuinflater=getMenuInflater();

        menuinflater.inflate(R.menu.menuitem,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.SettingMenuid){
            Toast("Setting Menu is Selected");
        }else if(item.getItemId()==R.id.SerchMenuId){
            Toast("Share Menu is Selected");
        }else if(item.getItemId()==R.id.FeedbackMenuid){
            Toast("Feedback Menu is Selected");
            Intent i=new Intent(getApplicationContext(),Feedback.class);
            startActivity(i);
        }else if(item.getItemId()==R.id.AboutMenuid) {
            Toast("About Menu is Selected");
        }
        else if (item.getItemId()==android.R.id.home){
            Intent intent=new Intent(Feedback.this,fciHome.class);
            startActivity(intent);
            finishActivity(0);
        }
        return super.onOptionsItemSelected(item);
    }
    public void Toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}


