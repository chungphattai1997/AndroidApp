package com.example.ql_ddh_baocaogk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    public static String DB_NAME = "dbKhachHang.db";
    public static Integer DB_VERSION = 1;


    public MyDatabase(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String scriptTBKhachHang = "CREATE TABLE KHACHHANG(" +
                "MAKH" + " Varchar(20) PRIMARY KEY NOT NULL, " +
                "TENKH" + " Nvarchar(50) NOT NULL)";
        sqLiteDatabase.execSQL(scriptTBKhachHang);

        String scriptTBDonDH = "CREATE TABLE DONDH(" +
                "SODDH" + " INTEGER PRIMARY KEY NOT NULL, " +
                "MAKH" + " Varchar(20) NOT NULL," +
                "NGAYDH" + " DATETIME NOT NULL," +
                "SONGAY" + " INTEGER NOT NULL," +
                "TINHTRANG" + " Nvarchar(100)," +
                "FOREIGN KEY (MAKH) REFERENCES KHACHHANG(MAKH) ON DELETE CASCADE)";
        sqLiteDatabase.execSQL(scriptTBDonDH);

        String scriptTBMatHang = "CREATE TABLE MATHANG(" +
                "MAHG" + " Varchar(20) PRIMARY KEY NOT NULL, " +
                "TENHG" + " Nvarchar(50) NOT NULL," +
                "DACDIEM" + " TEXT," +
                "DVT" + " Nvarchar(40) NOT NULL," +
                "DONGIA" + " INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(scriptTBMatHang);

        String scriptTBCTDonDH = "CREATE TABLE CTDONDH(" +
                "SODDH" + " INTEGER, " +
                "MAHG" + " Varchar(20)," +
                "SLDAT" + " INTEGER NOT NULL," +
                "PRIMARY KEY(SODDH, MAHG),"+
                "FOREIGN KEY (SODDH) REFERENCES DONDH(SODDH) ON DELETE CASCADE,"+
                "FOREIGN KEY (MAHG) REFERENCES MATHANG(MAHG) ON DELETE CASCADE )";
        sqLiteDatabase.execSQL(scriptTBCTDonDH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS KHACHHANG");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DONDH");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MATHANG");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CTDONDH");
        onCreate(sqLiteDatabase);
    }

    public void getKhachHangS(ArrayList<KhachHang> khachHangs){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from KHACHHANG";
        Cursor cursor  = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                KhachHang khachHang = new KhachHang();
                khachHang.setMa(cursor.getString(cursor.getColumnIndex("MAKH")));
                khachHang.setTen(cursor.getString(cursor.getColumnIndex("TENKH")));
                khachHangs.add(khachHang);
            } while (cursor.moveToNext());
        }
    }

    public void saveKhachHangs(KhachHang khachHang){
        SQLiteDatabase db  = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAKH", khachHang.getMa());
        values.put("TENKH", khachHang.getTen());
        db.insert("KHACHHANG", null, values);
        db.close();

    }

    public void deleteKhachHang(String ma) {
        SQLiteDatabase db  = getWritableDatabase();
        db.delete("KHACHHANG","MAKH = '"+ma+"'",null);
        db.close();
    }

    public boolean checkMa(String ma){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from KHACHHANG where MAKH ='"+ ma+"'";
        Cursor cursor  = db.rawQuery(sql,null);
        if(cursor.getCount()==0){
            return true;
        }
        return false;
    }

    public void updateKhachHang(KhachHang khachHang){
        SQLiteDatabase db  = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAKH", khachHang.getMa());
        values.put("TENKH", khachHang.getTen());
        db.update("KHACHHANG", values, "MAKH = '"+khachHang.getMa()+"'", null);
    }

    public KhachHang findKhachHang(String ma){
        KhachHang khachHang = new KhachHang();
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from KHACHHANG where MAKH ='"+ ma+"'";
        Cursor cursor  = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            khachHang.setMa(cursor.getString(cursor.getColumnIndex("MAKH")));
            khachHang.setTen(cursor.getString(cursor.getColumnIndex("TENKH")));
        }
        return khachHang;
    }

    boolean checkKHDaLapDDH(String ma){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "Select * from DONDH where MAKH = '" + ma+ "'";
        Cursor cursor  = db.rawQuery(sql,null);
        if(cursor.getCount()==0){
            return true;
        }
        return false;
    }
}
