package com.example.nhom1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataSQL extends SQLiteOpenHelper {
    public static final String TAG = "SQLite";
    public static final String DATABASE_NAME = "mySQL";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_SESSION = "SESSION";
    public static final String COLUMN_SESSION_ID = "Ses_Id";
    public static final String COLUMN_SESSION_TIME = "Ses_Time";
    public static final String COLUMN_SESSION_LABLE = "Ses_Label";
    public static final String COLUMN_SESSION_ADDSESSION = "Ses_addSes";

    public DataSQL(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// Script to create table.
        String script = "CREATE TABLE " + TABLE_SESSION + "("
                + COLUMN_SESSION_ID + " INTEGER PRIMARY KEY,"+ COLUMN_SESSION_ADDSESSION + " INTEGER," + COLUMN_SESSION_TIME + " TEXT,"
                + COLUMN_SESSION_LABLE + " TEXT" +")";
        // Execute script.
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SESSION);


        // Recreate
        onCreate(db);
    }
    public void addSession(Session session) {
        Log.i(TAG, "MyDatabaseHelper.addNote ... " + session.getSes_Time());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_SESSION_TIME, session.getSes_Time());
        values.put(COLUMN_SESSION_LABLE, session.getSes_Title());
        values.put(COLUMN_SESSION_ADDSESSION, session.getSes_addSes());

        // Trèn một dòng dữ liệu vào bảng.
        db.insert(TABLE_SESSION, null, values);


        // Đóng kết nối database.
        db.close();
    }
    public List<Session> getAllSessions() {
        Log.i(TAG, "MyDatabaseHelper.getAllNotes ... ");

        List<Session> sessionList = new ArrayList<Session>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SESSION;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // Duyệt trên con trỏ, và thêm vào danh sách.
        if (cursor.moveToFirst()) {
            do {
                Session session = new Session();
                session.setSes_id(Integer.parseInt(cursor.getString(0)));
//                session.setSes_addSes(Integer.parseInt(cursor.getString(1)));
                session.setSes_addSes(Integer.parseInt(cursor.getString(1)));
                session.setSes_Time(cursor.getString(2));
                session.setSes_Title(cursor.getString(3));

                // Thêm vào danh sách.
                sessionList.add(session);
            } while (cursor.moveToNext());
        }
        return sessionList;
    }

    public int getSessionsCount() {
        Log.i(TAG, "MyDatabaseHelper.getSessionsCount ... ");

        String countQuery = "SELECT  * FROM " + TABLE_SESSION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }

    public void updateSession(Session session) {
//        Log.i(TAG, "MyDatabaseHelper.updateNote ... " + session.getSes_Time());
        String[] string = {String.valueOf(session.getSes_id())};
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_SESSION_TIME, session.getSes_Time());
        values.put(COLUMN_SESSION_LABLE, session.getSes_Title());
        values.put(COLUMN_SESSION_ADDSESSION, session.getSes_addSes());

        // updating row
//        return db.update(TABLE_SESSION, values, COLUMN_SESSION_ID + " = ?",
//                new String[]{String.valueOf(session.getSes_id())});
        db.update(TABLE_SESSION,values,COLUMN_SESSION_ID + " = ?",string);
        Log.e( "updateSession: ","Update complete" );
    }

    public void deleteSession(Session session) {
        Log.i(TAG, "MyDatabaseHelper.updateNote ... " + session.getSes_Time());

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SESSION, COLUMN_SESSION_ID + " = ?",
                new String[]{String.valueOf(session.getSes_id())});
        db.close();
    }
    public void deleteAllSession() {
        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_SESSION, COLUMN_SESSION_ID + " = ?",
//                new String[]{String.valueOf(session.getSes_id())});
        db.delete(TABLE_SESSION, COLUMN_SESSION_ID + " <> ?",
                new String[]{"1000"});
        db.close();
    }
}
