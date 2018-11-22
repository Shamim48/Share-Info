package com.example.abdullahjubayer.shareinfo2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
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


import com.bumptech.glide.Glide;
import com.github.ybq.android.spinkit.style.FadingCircle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class aj_admin_signUp extends AppCompatActivity {
    EditText ad_name,ad_company,ad_email,ad_mobile,ad_pass,ad_re_pass;
    Button admin_signup;
    TextView editText;
    CircleImageView imageView;
    Uri profileImage;
    String downloadUrl;
    FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private static final int RQ_CODE =101 ;
    FirebaseStorage firebaseStorage;
    ProgressBar progressBar ;


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser!=null){
            Toast.makeText(aj_admin_signUp.this,"A User Already Login",Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aj_activity_admin_sign_up);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Admin Signup");


        progressBar = (ProgressBar)findViewById(R.id.spin_kit_admin_sign);
        FadingCircle fadingCircle = new FadingCircle();
        progressBar.setIndeterminateDrawable(fadingCircle);

        ad_name=findViewById(R.id.admin_name);
        ad_company=findViewById(R.id.admin_company_name);
        ad_email=findViewById(R.id.admin_email_name);
        ad_mobile=findViewById(R.id.admin_mobile_number);
        ad_pass=findViewById(R.id.admin_pass_name);
        ad_re_pass=findViewById(R.id.admin_re_pass);
        imageView=findViewById(R.id.admin_profile_image);
        admin_signup=findViewById(R.id.admin_sign_up_btn);
        editText=findViewById(R.id.admin_to_login_back);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        firebaseStorage=FirebaseStorage.getInstance();


        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser!=null){
            admin_signup.setEnabled(false);
        }

        admin_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate()){
                    Toast.makeText(aj_admin_signUp.this,"Please Fill All Data Correctly",Toast.LENGTH_LONG).show();
                }
                else {

                   createUserr();
                   progressBar.setVisibility(View.VISIBLE);

                }
            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });


        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(aj_admin_signUp.this,aj_AdminLogin.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                finish();
            }
        });

    }


    private void createUserr() {


        final String email = ad_email.getText().toString();
        final String password = ad_pass.getText().toString();


            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser==null){

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                String firebase_email = user.getEmail();

                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("infoooooooo", "createUserWithEmail:success");
                                    uploadImage(firebase_email);

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("infoooooooo", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(aj_admin_signUp.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
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

    }

    private void uploadImage(String firebase_email) {

                    final StorageReference storageReference=
                            FirebaseStorage.getInstance().getReference("All_Admin_photo/"+"admin_image"+firebase_email+".jpg");

                    if (profileImage!=null){
                        storageReference.putFile(profileImage).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                            @Override
                            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                                if (!task.isSuccessful()){
                                    throw task.getException();
                                }
                                return storageReference.getDownloadUrl();
                            }
                        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                                if (task.isSuccessful()){
                                     downloadUrl = task.getResult().toString();
                                     UploadUserData();

                                    Log.i("downloadUrllllll", "onComplete: Url: "+ downloadUrl);
                                }
                                else {
                                    Toast.makeText(aj_admin_signUp.this, "Picture Upload failed.",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressBar.setVisibility(View.INVISIBLE);

                            }
                        });

                    }

    }

    private void UploadUserData() {

        final String name= ad_name.getText().toString();
        final String company=ad_company.getText().toString();
        final String email = ad_email.getText().toString();
        final String mobile = ad_mobile.getText().toString();
        final String password = ad_pass.getText().toString();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String firebase_email = user.getEmail();

        if (!(downloadUrl.isEmpty())){
            Map< String, Object > newContact = new HashMap< >();
            newContact.clear();

            newContact.put("Name", name);
            newContact.put("Company", company);
            newContact.put("Email", email);
            newContact.put("Mobile", mobile);
            newContact.put("Password", password);
            newContact.put("Picture", downloadUrl);

            db.collection("Admin_Account").document(firebase_email).set(newContact)

                    .addOnSuccessListener(new OnSuccessListener < Void > () {

                        @Override

                        public void onSuccess(Void aVoid) {

                            Toast.makeText(aj_admin_signUp.this, "User Registered Success",

                                    Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);

                        }

                    })

                    .addOnFailureListener(new OnFailureListener() {

                        @Override

                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(aj_admin_signUp.this, "User Registered Failed" + e.toString(),

                                    Toast.LENGTH_SHORT).show();

                            Log.d("TAG", e.toString());
                            progressBar.setVisibility(View.INVISIBLE);


                        }

                    });

        }else {
            Toast.makeText(aj_admin_signUp.this, "Download URL Null.",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==RQ_CODE && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            profileImage=data.getData();
            try {
                Bitmap bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(),profileImage);
                Glide.with(aj_admin_signUp.this).load(bitmap).into(imageView);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            Toast.makeText(aj_admin_signUp.this,"Error in Select Image",Toast.LENGTH_LONG).show();
        }
    }

    public void selectImage(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select image"),RQ_CODE);
    }


    public boolean validate() {
        boolean valid = true;

        String name= ad_name.getText().toString();
        String company=ad_company.getText().toString();
        String email = ad_email.getText().toString();
        String mobile = ad_mobile.getText().toString();
        String password = ad_pass.getText().toString();
        String reEnterPassword = ad_re_pass.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            ad_name.setError("at least 3 characters");
            valid = false;
        } else {
            ad_name.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ad_email.setError("enter a valid email address");
            valid = false;
        } else {
            ad_email.setError(null);
        }

        if (mobile.isEmpty()) {
            ad_mobile.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
            ad_mobile.setError(null);
        }

        if (password.isEmpty() || password.length() < 6 || password.length() > 10) {
            ad_pass.setError("between 6 and 10 alphanumeric characters");
            valid = false;
        } else {
            ad_pass.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 6 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            ad_re_pass.setError("Password Do not match");
            valid = false;

        } else {
            ad_re_pass.setError(null);
        }
        if (company.isEmpty()){
            ad_company.setError("Company/Institute Required");
            valid=false;
        } else {
            ad_company.setError(null);
        }

        return valid;
    }

}
