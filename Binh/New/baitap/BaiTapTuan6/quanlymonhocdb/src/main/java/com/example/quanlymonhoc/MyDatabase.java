package com.example.quanlymonhoc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    public static String DB_NAME = "dbMonHoc.db";
    public static Integer DB_VERSION = 1;

    public static final String TB_MONHOCS = "tbMonHoc";
    public static final String COL_MONHOC_ID = "monhoc_id";
    public static final String COL_MONHOC_MA = "monhoc_ma";
    public static final String COL_MONHOC_TEN = "monhoc_ten";
    public static final String COL_MONHOC_SOTIET = "monhoc_sotiet";

    public MyDatabase(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String scriptTBMonHocs = "CREATE TABLE " + TB_MONHOCS + "(" +
                COL_MONHOC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COL_MONHOC_MA + " TEXT," +
                COL_MONHOC_TEN + " TEXT," +
                COL_MONHOC_SOTIET + " TEXT)";
        sqLiteDatabase.execSQL(scriptTBMonHocs);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TB_MONHOCS);
        onCreate(sqLiteDatabase);
    }
    public void getMonHocS(ArrayList<MonHoc> monHocs){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor  = db.query(TB_MONHOCS,
                new String[]{COL_MONHOC_MA, COL_MONHOC_TEN,COL_MONHOC_SOTIET},
                null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                MonHoc monHoc = new MonHoc();
                monHoc.setMa(cursor.getString(cursor.getColumnIndex(COL_MONHOC_MA)));
                monHoc.setTen(cursor.getString(cursor.getColumnIndex(COL_MONHOC_TEN)));
                monHoc.setSotiet(cursor.getString(cursor.getColumnIndex(COL_MONHOC_SOTIET)));
                monHocs.add(monHoc);
            } while (cursor.moveToNext());
        }
    }
    public void saveMonHocs(MonHoc monHoc){
        SQLiteDatabase db  = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_MONHOC_MA, monHoc.getMa());
        values.put(COL_MONHOC_TEN, monHoc.getTen());
        values.put(COL_MONHOC_SOTIET, monHoc.getSotiet());
        db.insert(TB_MONHOCS, null, values);
        db.close();

    }
}
