package com.moon.giuakymodulectdh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static String DB_NAME = "QuanLyDonHang.db";
    public static Integer DB_VERSION = 1;
    private SQLiteDatabase db;
    private String myFormat = "dd-MM-yyyy HH:mm:ss:SSS";
    public DatabaseHandler(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        db = sqLiteDatabase;
        String scriptTBKhachHang = "CREATE TABLE KHACHHANG(" +
                "MAKH" + " Varchar(20) PRIMARY KEY NOT NULL, " +
                "TENKH" + " Nvarchar(50) NOT NULL)";
        db.execSQL(scriptTBKhachHang);
        String scriptTBDonDH = "CREATE TABLE DONDH(" +
                "SODDH" + " INTEGER PRIMARY KEY NOT NULL, " +
                "MAKH" + " Varchar(20) NOT NULL," +
                "NGAYDH" + " DATETIME NOT NULL," +
                "SONGAY" + " INTEGER NOT NULL," +
                "TINHTRANG" + " Nvarchar(100)," +
                "FOREIGN KEY (MAKH) REFERENCES KHACHHANG(MAKH) ON DELETE CASCADE)";
        db.execSQL(scriptTBDonDH);
        String scriptTBMatHang = "CREATE TABLE MATHANG(" +
                "MAHG" + " Varchar(20) PRIMARY KEY NOT NULL, " +
                "TENHG" + " Nvarchar(50) NOT NULL," +
                "DACDIEM" + " TEXT," +
                "DVT" + " Nvarchar(40) NOT NULL," +
                "DONGIA" + " INTEGER NOT NULL)";
        db.execSQL(scriptTBMatHang);
        String scriptTBCTDonDH = "CREATE TABLE CTDONDH(" +
                "SODDH" + " INTEGER, " +
                "MAHG" + " Varchar(20)," +
                "SLDAT" + " INTEGER NOT NULL," +
                "PRIMARY KEY(SODDH, MAHG),"+
                "FOREIGN KEY (SODDH) REFERENCES DONDH(SODDH) ON DELETE CASCADE,"+
                "FOREIGN KEY (MAHG) REFERENCES MATHANG(MAHG) ON DELETE CASCADE )";
        db.execSQL(scriptTBCTDonDH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "DONDH");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "KHACHHANG");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "MATHANG");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "CTDONDH");
        onCreate(sqLiteDatabase);
    }

    public void getCTDonDHs(ArrayList<CT_DonHang> ctDonDHS) {
        String sql = "select * from CTDONDH";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                CT_DonHang ctDonDH = new CT_DonHang();
                ctDonDH.setSODDH(Integer.parseInt(cursor.getString(cursor.getColumnIndex("SODDH"))));
                ctDonDH.setMAHG(cursor.getString(cursor.getColumnIndex("MAHG")));
                ctDonDH.setSLDAT(Integer.parseInt(cursor.getString(cursor.getColumnIndex("SLDAT"))));
                ctDonDHS.add(ctDonDH);
            } while (cursor.moveToNext());
        }
    }

    public ArrayList<CT_DonHang> getCTDonDHWhereSoDDH(Integer soDDH) {
        ArrayList<CT_DonHang> ctDonDHS = new ArrayList<>();
        String sql = "select * from CTDONDH where SODDH =" + soDDH;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                CT_DonHang ctDonDH = new CT_DonHang();
                ctDonDH.setSODDH(Integer.parseInt(cursor.getString(cursor.getColumnIndex("SODDH"))));
                ctDonDH.setMAHG(cursor.getString(cursor.getColumnIndex("MAHG")));
                ctDonDH.setSLDAT(Integer.parseInt(cursor.getString(cursor.getColumnIndex("SLDAT"))));
                ctDonDHS.add(ctDonDH);
            } while (cursor.moveToNext());
        }
        return ctDonDHS;
    }

    public ArrayList<CT_DonHang> getCTDonDHWhereMaHG(String maHG) {
        ArrayList<CT_DonHang> ctDonDHS = new ArrayList<>();
        String sql = "select * from CTDONDH where MAHG ='" + maHG + "'";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                CT_DonHang ctDonDH = new CT_DonHang();
                ctDonDH.setSODDH(Integer.parseInt(cursor.getString(cursor.getColumnIndex("SODDH"))));
                ctDonDH.setMAHG(cursor.getString(cursor.getColumnIndex("MAHG")));
                ctDonDH.setSLDAT(Integer.parseInt(cursor.getString(cursor.getColumnIndex("SLDAT"))));
                ctDonDHS.add(ctDonDH);
            } while (cursor.moveToNext());
        }
        return ctDonDHS;
    }

    public void saveCTDonDH(CT_DonHang ctDonDH) {
        ContentValues values = new ContentValues();
        values.put("SODDH", ctDonDH.getSODDH());
        values.put("MAHG", ctDonDH.getMAHG());
        values.put("SLDAT", ctDonDH.getSLDAT());
        db.insert("CTDONDH", null, values);
    }

    public void deleteCTDonDH(Integer soDDH, String maHG) {
        String sql = "delete from CTDONDH where SODDH=" + soDDH + " and MAHG='" + maHG + "'";
        db.execSQL(sql);
    }

    public void updateCTDonDH(CT_DonHang ctDonDH) {
        ContentValues values = new ContentValues();
        values.put("SODDH", ctDonDH.getSODDH());
        values.put("MAHG", ctDonDH.getMAHG());
        values.put("SLDAT", ctDonDH.getSLDAT());
        db.update("CTDONDH", values, "SODDH" + "=" + ctDonDH.getSODDH() + " and MAHG='" + ctDonDH.getMAHG() + "'", null);
    }


    public void getListSoDDH(ArrayList<String> arr) {
        arr.add("Chọn Số Đơn Đặt Hàng");
        String sql = "select * from DONDH";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                arr.add(cursor.getString(cursor.getColumnIndex("SODDH")));
            } while (cursor.moveToNext());
        }

    }

    public void getListMaMH(ArrayList<String> arr) {
        arr.add("Chọn Mã Mặt Hàng");
        String sql = "select * from MATHANG";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                arr.add(cursor.getString(cursor.getColumnIndex("MAHG")));
            } while (cursor.moveToNext());
        }
    }
}
