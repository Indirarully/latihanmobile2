package com.example.databasesqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class sql extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db.db";
    private static final int DATABASE_VERSION =1;

    public sql(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table buku(id integer primary key autoincrement, judul_buku text null," + "nama_pengarang text null, tahun_terbit text null, penerbit text null);";
        Log.d("Data","onCreate: " + sql);
        db.execSQL(sql);
        sql = "insert into buku (id, judul_buku, nama_pengarang, tahun_terbit, penerbit) values (1, 'Penerapan Sistem', 'Jogiyanto', '2010', 'Andi') ";
        db.execSQL(sql);
        sql = "insert into buku (id, judul_buku, nama_pengarang, tahun_terbit, penerbit) values (2, 'Pengantar TI', 'Sutarman', '2012', 'Bumi Aksara') ";
        db.execSQL(sql);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO Auto-generated constructor stub
    }
}


