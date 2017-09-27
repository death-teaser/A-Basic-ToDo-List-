package com.example.root.loginexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 7/9/17.
 */

public class DatabaseHalper extends SQLiteOpenHelper {

    private static final int Database_Version =1;
    private static final String Database_Name = "contacts.db";
    private static final String Table_Name = "contacts";
    private static final String Table_Name2 = "todo";
    private static final String Column_Id = "id";
    private static final String Column_task = "task";
    private static final String Column_Name = "name";
    private static final String Column_Email = "email";
    private static final String Column_Uname = "username";
    private static final String Column_Pass = "pass";
    SQLiteDatabase db;
    private static final String Table_Create = "create table contacts (id integer primary key not null, " +
            "name text not null, email text not null, username text not null, pass text not null );";
    private static final String tb_create = "create table todo (id integer primary key not null, "+
            "task text not null );";


    public DatabaseHalper(Context context) {
        super(context, Database_Name, null, Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Table_Create);
        db.execSQL(tb_create);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exist " + Table_Name);
        db.execSQL("drop table if exist "+ Table_Name2);
        this.onCreate(db);

    }

    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        values.put(Column_Id, count);
        values.put(Column_Name, c.getName());
        values.put(Column_Email, c.getEmail());
        values.put(Column_Uname, c.getUsername());
        values.put(Column_Pass, c.getPass());
        db.insert(Table_Name, null, values);
        cursor.close();
        db.close();

    }
    public void insertTask(String task){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from todo";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        values.put(Column_Id, count);
        values.put(Column_task, task);
        db.insert(Table_Name2,null,values);
        cursor.close();
        db.close();
    }
//    public void deleteTask(String task){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(Table_Name2,Column_task+ " = ?",new String[]{task});
//        db.close();
//    }

    public List<String> getTaskList(){
        db = this.getReadableDatabase();
        List<String> taskList = new ArrayList<String>();
        String query = "select task from "+Table_Name2 ;
        Cursor c = db.rawQuery(query,null);
        if(c.moveToFirst()){
            do{
                taskList.add(c.getString(0));
            }while (c.moveToNext());
        }
//        c.close();
//        db.close();
        return taskList;
    }
    public  String searchpass(String uname){
        db = this.getReadableDatabase();
        String query = "select username, pass from "+Table_Name ;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b= "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if(a.equals(uname)){
                    b = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return b;
    }
}
