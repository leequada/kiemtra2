package com.example.lequangdao_ktra2_bai2.Control;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.lequangdao_ktra2_bai2.Thi;

import java.util.ArrayList;
import java.util.List;

public class databaseDAO extends SQLiteOpenHelper {
    public databaseDAO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql ){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
    public Long Add(Thi c){
        ContentValues values = new ContentValues();
        values.put("Name",c.getName());
        values.put("Times",c.getTimes());
        values.put("Dates",c.getDates());
        values.put("ischecked",Float.parseFloat(c.getIschecked()));
        SQLiteDatabase sqLiteDatabase =getWritableDatabase();
        return sqLiteDatabase.insert("Thi",null,values);

    }
    public int update(Thi c){
        ContentValues values = new ContentValues();
        values.put("Name",c.getName());
        values.put("Times",c.getTimes());
        values.put("Dates",c.getDates());
        values.put("ischecked",Float.parseFloat(c.getIschecked()));
        String sql = "id = ?";
        String []clause = {c.getId()};
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.update("Thi",values,sql,clause);

    }
    public int delete(String id){
        String clause = "id = ? ";
        String[] values = {id};
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete("Thi",clause,values);
    }
    public List<Thi> SearchbyName(String name){
        List<Thi> list = new ArrayList<>();
        if(name.equals("")){
            String sql ="SELECT * FROM Thi";
            Cursor cursor = getData(sql);
            while(cursor.moveToNext()){
                String id =cursor.getString(0);
                String Name =cursor.getString(1);
                String Citys =cursor.getString(2);
                String Dates =cursor.getString(3);
                String Amount =cursor.getString(4);
                Thi c = new Thi(id,Name,Citys,Dates,Amount);
                list.add(c);
            }
        }
        else {
            String sql = "SELECT * FROM Thi WHERE Name =?";
            String [] values = {name};
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(sql,values);
            while(cursor.moveToNext()){
                String id =cursor.getString(0);
                String Name =cursor.getString(1);
                String Times =cursor.getString(2);
                String Dates =cursor.getString(3);
                String isChecked =cursor.getString(4);
                Thi c = new Thi(id,Name,Times,Dates,isChecked);
                list.add(c);
            }

        }
        return list;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
