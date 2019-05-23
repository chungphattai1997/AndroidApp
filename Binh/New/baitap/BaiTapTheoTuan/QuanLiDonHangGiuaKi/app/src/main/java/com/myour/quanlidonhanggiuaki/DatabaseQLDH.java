package com.myour.quanlidonhanggiuaki;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseQLDH extends SQLiteOpenHelper {
    private static String DBName="DB_QLDH.db";
    private static int DBVersion=1;
    public DatabaseQLDH( Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String scriptTBKhachHang = "CREATE TABLE IF NOT EXISTS KHACHHANG(" +
                "MAKH" + " VARCHAR(20) PRIMARY KEY NOT NULL, " +
                "TENKH" + " Nvarchar(50) NOT NULL)";
        db.execSQL(scriptTBKhachHang);
        String scriptTBDonDH = "CREATE TABLE IF NOT EXISTS DONDH(" +
                "SODDH" + " INTEGER PRIMARY KEY NOT NULL, " +
                "MAKH" + " VARCHAR(20) NOT NULL," +
                "NGAYDH" + " DATETIME NOT NULL," +
                "SONGAY" + " INTEGER NOT NULL," +
                "TINHTRANG" + " Nvarchar(100)," +
                "FOREIGN KEY (MAKH) REFERENCES KHACHHANG(MAKH) ON DELETE CASCADE)";
        db.execSQL(scriptTBDonDH);
        String scriptTBMatHang = "CREATE TABLE IF NOT EXISTS MATHANG(" +
                "MAHG" + " VARCHAR(20) PRIMARY KEY NOT NULL, " +
                "TENHG" + " NVARCHAR(50) NOT NULL," +
                "DACDIEM" + " TEXT," +
                "DVT" + " NVARCHAR(40) NOT NULL," +
                "DONGIA" + " INTEGER NOT NULL)";
        db.execSQL(scriptTBMatHang);
        String scriptTBCTDonDH = "CREATE TABLE IF NOT EXISTS CTDONDH(" +
                "SODDH" + " INTEGER, " +
                "MAHG" + " VARCHAR(20)," +
                "SLDAT" + " INTEGER NOT NULL," +
                "PRIMARY KEY(SODDH, MAHG),"+
                "FOREIGN KEY (SODDH) REFERENCES DONDH(SODDH) ON DELETE CASCADE,"+
                "FOREIGN KEY (MAHG) REFERENCES MATHANG(MAHG) ON DELETE CASCADE )";
        db.execSQL(scriptTBCTDonDH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void queryDataSQL(String sql){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }
    public Cursor queryGetDataSQL(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql,null);
    }
}
