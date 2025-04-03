package com.example.desenrola;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "escovas.db";
    private static final int DB_VERSION = 1;

    private static final String TABLE_USER = "usuarios";
    private static final String TABLE_PRODUCT = "produtos";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_USER + " (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_PRODUCT + " (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, marca TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        onCreate(db);
    }

    public boolean insertUser(String username, String password) {
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        return getWritableDatabase().insert(TABLE_USER, null, values) != -1;
    }

    public boolean checkUser(String username, String password) {
        Cursor cursor = getReadableDatabase().query(TABLE_USER, null, "username=? AND password=?", new String[]{username, password}, null, null, null);
        return cursor.getCount() > 0;
    }

    public boolean insertProduto(String nome, String marca) {
        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("marca", marca);
        return getWritableDatabase().insert(TABLE_PRODUCT, null, values) != -1;
    }

    public boolean deleteProduto(String nome) {
        return getWritableDatabase().delete(TABLE_PRODUCT, "nome=?", new String[]{nome}) > 0;
    }
}