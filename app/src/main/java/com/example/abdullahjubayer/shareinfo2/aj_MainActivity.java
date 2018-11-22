package com.example.abdullahjubayer.shareinfo2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class aj_MainActivity extends AppCompatActivity {
    Button user,admin;
    TextView new_account,sh_title;
    Typeface typeface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aj_activity_main);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("");


        user=findViewById(R.id.user_id);
        admin=findViewById(R.id.admin_id);
        new_account=findViewById(R.id.new_account);
        sh_title=findViewById(R.id.share_info_title);

        typeface=Typeface.createFromAsset(getAssets(),"font/AlexBrush_Regular.ttf");
        sh_title.setTypeface(typeface);

        if(internet_connection()){

        }
        else{
            buildDialog(aj_MainActivity.this);
        }

        new_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_account();
            }
        });


        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(aj_MainActivity.this,aj_UserLogin.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);

            }
        });


        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(aj_MainActivity.this,aj_AdminLogin.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);

            }
        });
    }

    public void new_account(){
        Intent intent=new Intent(aj_MainActivity.this,aj_SignUpType.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }



    boolean internet_connection(){
        //Check if connected to internet, output accordingly
        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }


}
