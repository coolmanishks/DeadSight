package com.subham.deadsight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button chooseAdmin,chooseContracter,chooseSupervisor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            setVar();

            //when choose admin is clicked
            chooseAdmin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, admin_sign_in.class));
                }
            });

            //when chooseContracter is clicked
            chooseContracter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, contracter_sign_in.class));
                }
            });

            //when choose Supervisor is clicked
            chooseSupervisor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, supervisor_sign_in.class));
                }
            });

        }

        private void setVar(){
            chooseAdmin  = (Button) findViewById(R.id.choose_admin_post_button);
            chooseContracter  = (Button) findViewById(R.id.choose_contracter_post_button);
            chooseSupervisor  = (Button) findViewById(R.id.choose_supervisor_post_button);
        }
}
