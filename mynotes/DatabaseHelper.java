package com.example.mynotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context){
        super(context,"notesdb",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE notesTable" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, notes TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS notesTable");
        onCreate(db);
    }

    public boolean addData(String addNote){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("notes",addNote);

        long result = db.insert("notesTable",null,contentValues);

        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM notesTable";
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getDataForUpdate(String udNote){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM notesTable WHERE notes=?",new String[]{udNote});
        return data;
    }

    public boolean updateData(String udNote,String udId){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE notesTable SET notes = '"+udNote+"' WHERE id='"+udId+"'");

                return true;
    }

    public boolean deleteData(String udNote){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM notesTable WHERE notes='"+udNote+"'");

        return true;
    }
}
