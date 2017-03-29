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

public class admin_sign_in extends AppCompatActivity {
    EditText admin_sign_in_email,admin_sign_in_password;
    String admin_email,admin_password;

    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener authListener;

    //TODO(1): initializing variables
    private void initializeVar(){

        admin_sign_in_email = (EditText)findViewById(R.id.admin_sign_in_email_id);
        admin_sign_in_password = (EditText)findViewById(R.id.admin_sign_in_passsword);

        auth = FirebaseAuth.getInstance();
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                //IF USER SIGN IN BUTTON WORKS
                if (user != null) {
                    // User is signed in
                    Toast.makeText(admin_sign_in.this, "Signed In ",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(admin_sign_in.this,admin_project_list.class));
                    //IF SIGN IN BUTTON DONT WORK TOAST
                } else {
                    // User is signed out
                    Toast.makeText(admin_sign_in.this, "not Signing In", Toast.LENGTH_SHORT).show();
                }
                // ...


            }
        };
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_in);
        initializeVar();

    }

    public void signInAdmin(View V){

        admin_email = admin_sign_in_email.getText().toString();
        admin_password = admin_sign_in_password.getText().toString();
        //is text Fields are empty
        if (
                admin_email.isEmpty()||
                        admin_password.isEmpty()  ){

            //display toast to fill
            Toast.makeText(this, "Please fill fields", Toast.LENGTH_SHORT).show();


        }else{

            //sign in the user
            auth.signInWithEmailAndPassword(admin_email,admin_password).addOnCompleteListener(
                    new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //if admin sign is successful
                            if (task.isSuccessful()){
                                Toast.makeText(admin_sign_in.this, "Welcome Admin", Toast.LENGTH_SHORT).show();
                                //startActivity of admin_project_panel

                            }else{
                                Toast.makeText(admin_sign_in.this, "Error Signing In", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
            );

        }


    }

    public void signUpAdmin(View V){
        startActivity(new Intent(admin_sign_in.this,admin_create_account.class));
    }

    public void forgotInAdmin(View V){
        startActivity(new Intent(admin_sign_in.this,forgotPassword.class));
    }

    @Override
    protected void onStart() {
        auth.addAuthStateListener(authListener);
        super.onStart();
    }

    @Override
    protected void onStop() {
        if (authListener!=null){

        }
        super.onStop();
    }

}
