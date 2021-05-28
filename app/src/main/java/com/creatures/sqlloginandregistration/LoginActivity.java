package com.creatures.sqlloginandregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    Button btn_log;
    TextInputEditText ti_et_user_name,ti_et_user_pass;
    DatabaseManager databaseManager = new DatabaseManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        btn_log=(Button)findViewById(R.id.button_login);

        ti_et_user_name=(TextInputEditText)findViewById(R.id.text_input_edit_text_log_user_name);
        ti_et_user_pass=(TextInputEditText)findViewById(R.id.text_input_edit_text_log_user_pass);

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }
    public void validate(){
        String log_u_name,log_u_pass;

        log_u_name=ti_et_user_name.getText().toString();
        log_u_pass=ti_et_user_pass.getText().toString();

        if (log_u_name.isEmpty() || log_u_pass.isEmpty())
        {
            Toast.makeText(this, "Fill All the details first", Toast.LENGTH_SHORT).show();
        }
        else {
            boolean log_result=databaseManager.check_validate_login(log_u_name,log_u_pass);
            if (log_result){
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this , HomeActivity.class));
                finish();
            }else{
                Toast.makeText(this, "Login Failed !!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}