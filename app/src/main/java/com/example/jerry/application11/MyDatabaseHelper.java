package com.example.jerry.application11;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by jerry on 16/5/16.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_VEGETABLE = "create table vegetable("
            +"id integer primary key autoincrement,"
            +"name text,"
            +"location text,"
            +"category text,"
            +"days integer)";
    public static final String CREATE_NUMBER = "create table number("
            +"id integer primary key autoincrement,"
            +"number integer)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_VEGETABLE);
        db.execSQL(CREATE_NUMBER);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }




}

