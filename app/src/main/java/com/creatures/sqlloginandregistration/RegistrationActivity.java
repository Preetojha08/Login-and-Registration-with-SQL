package com.creatures.sqlloginandregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity {

    TextInputEditText U_Name,U_Mail,U_1_pass,U_2_pass;
    Button btn_reg_data,btn_show_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();

        btn_reg_data=(Button)findViewById(R.id.button_add_data_registration);
        U_Name=(TextInputEditText)findViewById(R.id.text_input_edit_text_user_name);
        U_Mail=(TextInputEditText)findViewById(R.id.text_input_edit_text_user_mail_id);
        U_1_pass=(TextInputEditText)findViewById(R.id.text_input_edit_text_first_password);
        U_2_pass=(TextInputEditText)findViewById(R.id.text_input_edit_text_second_password);

        btn_reg_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_text();
            }
        });

        btn_show_data=(Button)findViewById(R.id.button_show_registration_data);
        btn_show_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistrationActivity.this,ShowUserDataActivity.class);
                startActivity(i);
            }
        });
    }
    public void check_text(){

        String user_n,user_m,user_pass_1,user_pass_2;

        user_n=U_Name.getText().toString();
        user_m=U_Mail.getText().toString();
        user_pass_1=U_1_pass.getText().toString();
        user_pass_2=U_2_pass.getText().toString();

        if (user_n.isEmpty() || user_m.isEmpty() || user_pass_1.isEmpty() || user_pass_2.isEmpty())
        {
            Toast.makeText(RegistrationActivity.this, "Fill all the details", Toast.LENGTH_SHORT).show();
        }
        else if (user_pass_1.length()<8 || user_pass_2.length()<8)
        {
            Toast.makeText(RegistrationActivity.this, "Write Appropriate Passwords", Toast.LENGTH_SHORT).show();
        }
        else if ( user_pass_1.equals(user_pass_2))
        {
            String result_reg= new DatabaseManager(this).insert_reg_data(user_n,user_m,user_pass_1);
            Toast.makeText(getApplicationContext(), ""+result_reg, Toast.LENGTH_SHORT).show();
            U_Name.setText("");
            U_Mail.setText("");
            U_1_pass.setText("");
            U_2_pass.setText("");
        }
        else
        {
            Toast.makeText(RegistrationActivity.this, "Check Your Passwords", Toast.LENGTH_SHORT).show();
        }
    }
}