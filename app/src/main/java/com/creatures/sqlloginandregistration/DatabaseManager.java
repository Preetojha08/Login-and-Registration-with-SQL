package com.creatures.sqlloginandregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String db_name = "ngo_events";

    private static final String col_1="u_r_id";
    private static final String col_2="u_name";
    private static final String col_3="u_mail_id";
    private static final String col_4="u_password";
    private static final String TABLE_NAME ="registration_data";

    public DatabaseManager(@Nullable Context context) {
        super(context, db_name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String create_query = "create table events_details(e_id integer primary key autoincrement, e_name text, e_des text)";
        String create_query_reg_data = "create table registration_data(u_r_id integer primary key autoincrement,u_name text, u_mail_id text,u_password text)";
        db.execSQL(create_query);
        db.execSQL(create_query_reg_data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String update_query = "drop table if exists event_details";
        String update_query_reg_data = "drop table if exists registration_data";
        db.execSQL(update_query);
        db.execSQL(update_query_reg_data);
        onCreate(db);
    }

    public String insert_reg_data(String u_name,String u_mail, String u_password)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("u_name",u_name);
        contentValues.put("u_mail_id",u_mail);
        contentValues.put("u_password",u_password);
        float d_store_result = database.insert("registration_data",null,contentValues);

        if (d_store_result==-1)
        {
            return "Fail";
        }
        else
        {
            return "Registration Done";
        }
    }

    public String add_info(String e_name, String e_des)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("e_name",e_name);
        contentValues.put("e_des",e_des);
        float d_store_result = database.insert("events_details",null,contentValues);

        if (d_store_result==-1)
        {
             return "Fail";
        }
        else
        {
            return "Successfully Done";
        }
    }

    public Cursor readalldata()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String select_query = "select * from events_details ";
        Cursor cursor = database.rawQuery(select_query,null);
        return cursor;

    }

    public Cursor read_all_user_data()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String select_query = "select * from registration_data ";
        Cursor cursor_reg_user = database.rawQuery(select_query,null);
        return cursor_reg_user;

    }

    public boolean check_validate_login(String un , String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {col_1};
        String selection = col_2 + "=?" + " and " + col_4 + "=?";
        String [] selectionargs ={un,pass};
        Cursor cursor = db.query(TABLE_NAME , columns , selection ,selectionargs , null , null , null);
        int count = cursor.getCount();
        db.close();
        cursor.close();
        if(count > 0) {
            return true;
        }
        else{
            return false;
        }
    }


}
