package com.example.databasesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Add extends AppCompatActivity {
    sql dbHelpers;
    Button btnAddSimpan;
    EditText edAddJudulBuku;
    EditText edAddNamaPengarang;
    EditText edAddTahunTerbit;
    EditText edAddPenerbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dbHelpers = new sql(this);
        edAddJudulBuku = (EditText) findViewById(R.id.edAddJudulBuku);
        edAddNamaPengarang = (EditText) findViewById(R.id.edAddNamaPengarang);
        edAddTahunTerbit = (EditText) findViewById(R.id.edAddTahunTerbit);
        edAddPenerbit = (EditText) findViewById(R.id.edAddPenerbit);

        btnAddSimpan = (Button) findViewById(R.id.btnAddSimpan);
        btnAddSimpan.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0){
                SQLiteDatabase db = dbHelpers.getWritableDatabase();

                db.execSQL("insert into buku(judul_buku, nama_pengarang, tahun_terbit, penerbit) values ('"+edAddJudulBuku.getText().toString()+"','"+edAddNamaPengarang.getText().toString()+"','"+edAddTahunTerbit.getText().toString()+"','"+edAddPenerbit.getText().toString()+"') ");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}