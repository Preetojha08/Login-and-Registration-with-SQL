package com.creatures.sqlloginandregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button btn_open_log_L,btn_open_reg_L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();

        btn_open_log_L=(Button)findViewById(R.id.open_login_layout_btn);
        btn_open_reg_L=(Button)findViewById(R.id.open_reg_layout_btn);

        btn_open_log_L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        btn_open_reg_L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(WelcomeActivity.this,RegistrationActivity.class);
                startActivity(i);

            }
        });

    }
}