package com.example.abdullahjubayer.shareinfo2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.FadingCircle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class aj_AdminLogin extends AppCompatActivity {
    EditText admin_email,admin_company,admin_pass;
    Button admin_login_button;
    private FirebaseAuth mAuth;
    FirebaseFirestore db;
    TextView textView;
    Typeface typeface;
    ProgressBar progressBar ;

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser!=null){
            Intent intent=new Intent(aj_AdminLogin.this,aj_AdminHomePage.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aj_activity_admin_login);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Admin Login");

        progressBar = (ProgressBar)findViewById(R.id.spin_kit_admin);
        FadingCircle fadingCircle = new FadingCircle();
        progressBar.setIndeterminateDrawable(fadingCircle);


        admin_email=findViewById(R.id.admin_email_id);
        admin_company=findViewById(R.id.admin_company_name);
        admin_pass=findViewById(R.id.admin_password_id);
        admin_login_button=findViewById(R.id.admin_login_btn);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        textView=findViewById(R.id.share_admin_title);

        typeface=Typeface.createFromAsset(getAssets(),"font/AlexBrush_Regular.ttf");
        textView.setTypeface(typeface);




        admin_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminLogin();
            }
        });

    }

    private void adminLogin() {
        if (!admin_login_valid()){
            Toast.makeText(aj_AdminLogin.this,"Please Fill All Data Correctly",Toast.LENGTH_LONG).show();
        }
        else {
            progressBar.setVisibility(View.VISIBLE);
            String _email = admin_email.getText().toString();
            String _pass = admin_pass.getText().toString();
            final FirebaseUser currentUser = mAuth.getCurrentUser();


            if (currentUser==null){
                    mAuth.signInWithEmailAndPassword(_email, _pass)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d("aj_admin log state", "signInWithEmail:success");

                                        Intent intent=new Intent(aj_AdminLogin.this,aj_AdminHomePage.class);
                                        startActivity(intent);
                                        finish();


                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w("adminle log state", "signInWithEmail:failure", task.getException());
                                        Toast.makeText(aj_AdminLogin.this, "Authentication failed : Enter valid Email and pass",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    });
            }
            else {


            }


        }
    }


    private boolean admin_login_valid() {
        String ad_email=admin_email.getText().toString().trim();
        String ad_company=admin_company.getText().toString().trim();
        String ad_pass=admin_pass.getText().toString().trim();


        boolean val=true;

        if (ad_company.isEmpty() ) {
            admin_company.setError("Company Null");
            val = false;
        } else {
            admin_company.setError(null);
        }


        if (ad_email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(ad_email).matches()) {
            admin_email.setError("enter a valid aj_admin email address");
            val = false;
        } else {
            admin_email.setError(null);
        }

        if (ad_pass.isEmpty() ) {
            admin_pass.setError("Password Wrong");
            val = false;
        } else {
            admin_pass.setError(null);
        }

        return val;

    }

//    public void getCompanyName(){
//
//        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//        String firebase_email = firebaseUser.getEmail();
//
//        DocumentReference user = db.collection("Admin_Account").document(firebase_email);
//        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                DocumentSnapshot doc = task.getResult();
//
//                if (!doc.exists()){
//                    Toast.makeText(aj_AdminLogin.this,"Data Not Found",Toast.LENGTH_LONG).show();
//                }else {
//                    String company = doc.get("Company").toString();
//                    String email=doc.get("Email").toString();
//                    String pass=doc.get("Password").toString();
//
//
//                    if (!finalCheck(company,email,pass)){
//                        Intent intent=new Intent(aj_AdminLogin.this,aj_AdminHomePage.class);
//                        startActivity(intent);
//                        finish();
//                    }
//
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(aj_AdminLogin.this,"Company Not Found",Toast.LENGTH_LONG).show();
//            }
//        });
//
//    }
//
//    private boolean finalCheck(String company, String email, String pass) {
//        final String ad_email=admin_email.getText().toString().trim();
//        final String ad_company=admin_company.getText().toString().trim();
//        final String ad_pass=admin_pass.getText().toString().trim();
//        boolean value=true;
//
//        if (!(company.equals(ad_company))){
//            value=false;
//            admin_company.setError("Company Not Match");
//        }
//        else {
//            value=false;
//            admin_company.setError(null);
//        }
//        if (!(email.equals(ad_email))){
//            value=false;
//            admin_email.setError("Email Not Match");
//        }else {
//            admin_email.setError(null);
//        }
//        if (!(pass.equals(ad_pass))){
//            value=false;
//            admin_pass.setError("Password Not Match");
//        }
//        else {
//            admin_pass.setError(null);
//        }
//
//        return value;
//    }

}
