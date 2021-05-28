package com.creatures.sqlloginandregistration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class ShowUserDataActivity extends AppCompatActivity {

    RecyclerView recyclerView_reg_user_data;
    ArrayList<model_user_registration_data> reg_data_holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_data);
        getSupportActionBar().hide();

        recyclerView_reg_user_data=(RecyclerView)findViewById(R.id.recycler_view_screeen_reg_user_details);
        recyclerView_reg_user_data.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Cursor rv_cursor = new DatabaseManager(this).read_all_user_data();
        reg_data_holder = new ArrayList<>();

        while(rv_cursor.moveToNext())
        {
            model_user_registration_data obj=new model_user_registration_data(rv_cursor.getString(1),rv_cursor.getString(2),rv_cursor.getString(3));
            reg_data_holder.add(obj);
        }

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(reg_data_holder);
        recyclerView_reg_user_data.setAdapter(recyclerViewAdapter);

    }
}