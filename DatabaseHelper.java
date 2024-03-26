package com.DKA4224.mybakery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper  {
    public DatabaseHelper(Context context){


    }

    
    @Override
    public void onCreate(SQLiteDatabase db){
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS menuTable");
        onCreate(db);
    }


    public boolean addData(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("menu",addMenu);
        contentValues.put("price", addPrice);
long result = db.insert("menuTable",null,contentValues);       
 
        if (result ==-1) {
            return false;
        }else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        
    Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getDataForUpdate(String udMenu){
        SQLiteDatabase db=this.getWritableDatabase();
        
    return data;
    }

    public boolean updateData (String udMenu, String udID,int udPrice){
        SQLiteDatabase db = this.getWritableDatabase();
         
        return true;
    }

    public boolean deleteData(String udMenu){
        SQLiteDatabase db = this.getWritableDatabase();
        
 return true;
    }
}
