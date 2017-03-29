package com.subham.deadsight;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import model.*;
public class admin_create_account extends AppCompatActivity {
    // TODO(1) : editext for admin_screen



    EditText admin_sign_up_name;
    EditText admin_sign_up_org;
    EditText admin_sign_up_email;
    EditText admin_sign_up_password;

    //FLAG FOR ONE TIME DATA push
    int IS_WRITTEN ;

    //admin model will be pushed
    admin_model admin_model;


    //firebase api
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference ref;
    private FirebaseDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_create_account);
    }

    //custom initializtion function
    private void setVar(){

        // TODO (2) : referencing edittext
        admin_sign_up_name = (EditText)findViewById(R.id.admin_create_account_name);
        admin_sign_up_org = (EditText)findViewById(R.id.admin_create_account_organization);
        admin_sign_up_email = (EditText)findViewById(R.id.admin_create_account_email);
        admin_sign_up_password = (EditText)findViewById(R.id.admin_create_account_password);

        //SETTING FLAG TO 0
        IS_WRITTEN = 0;

        //TODO(3) INITIALIZING FIREBASE VARIABLES
        db  = FirebaseDatabase.getInstance();
        ref =  db.getReference();
        mAuth = FirebaseAuth.getInstance();


        //AUTH STATE LISTENER
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                //IF USER CREATE ACCOUNT BUTTON WORKS
                if (user != null) {
                    // User is signed in
                    Toast.makeText(admin_create_account.this, "Signed In id ",Toast.LENGTH_SHORT).show();

                    //this method will be called once and then will move in signIn Activity
                    if (IS_WRITTEN<1){

                        //WRITING TO DATABBASE ONCE ONCE ACCOUNT IS CREATED
                        ref.child("ADMINISTRATOR").child(user.getUid()).setValue(admin_model);
                        IS_WRITTEN++;
                        startActivity(new Intent(admin_create_account.this,admin_sign_in.class));
                    }

                    //IF CREATE ACCOUNT BUTTON DONT WORK TOAST
                } else {
                    // User is signed out
                    Toast.makeText(admin_create_account.this, "User Signed Out", Toast.LENGTH_SHORT).show();
                }
                // ...
            }
        };

    }

    //    when activity will start addling listener
    @Override
    public void onStart() {
        mAuth.addAuthStateListener(mAuthListener);
        super.onStart();
    }


    //    removing listener
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener!=null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void createAdminAccount(View V){
        //if any field is empty
        if (
                admin_sign_up_name.getText().toString().isEmpty() || admin_sign_up_email.getText().toString().isEmpty() || admin_sign_up_org.getText().toString().isEmpty() || admin_sign_up_password.getText().toString().isEmpty()) {

            Toast.makeText(this, "Field can't be left blank", Toast.LENGTH_SHORT).show();


        }
        //else create admin account
        else {

            //initializing for JSON
            admin_model = new admin_model(
                    admin_sign_up_email.getText().toString(),
                    admin_sign_up_name.getText().toString(),
                    admin_sign_up_org.getText().toString());

            Toast.makeText(this, "Initializing process", Toast.LENGTH_SHORT).show();
            //creating admin account
            mAuth.createUserWithEmailAndPassword(admin_sign_up_email.getText().toString(), admin_sign_up_password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {



                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful()) {
                                Toast.makeText(admin_create_account.this, "Error Creating Account",
                                        Toast.LENGTH_SHORT).show();
                            }

                            // else if it get Created
                            else{
                                //if users has created account
                                Toast.makeText(admin_create_account.this, "Account Created",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }


    }
}
