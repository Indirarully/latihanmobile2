package com.example.databasesqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit extends AppCompatActivity {
    protected Cursor cursor;
    sql dbHelper;
    Button btnEditSimpan;
    EditText edEditJudulBuku;
    EditText edEditNamaPengarang;
    EditText edEditTahunTerbit;
    EditText edEditPenerbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        dbHelper = new sql(this);
        edEditJudulBuku = findViewById(R.id.edEditJudulBuku);
        edEditNamaPengarang = findViewById(R.id.edEditNamaPengarang);
        edEditTahunTerbit = findViewById(R.id.edEditTahunTerbit);
        edEditPenerbit = findViewById(R.id.edEditPenerbit);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        final String judulBuku = getIntent().getStringExtra("judul_buku");
        cursor = db.rawQuery("SELECT * FROM buku WHERE judul_buku = ?", new String[]{judulBuku});
        if (cursor.moveToFirst()) {
            edEditJudulBuku.setText(cursor.getString(1));
            edEditNamaPengarang.setText(cursor.getString(2));
            edEditTahunTerbit.setText(cursor.getString(3));
            edEditPenerbit.setText(cursor.getString(4));
        }
        cursor.close();

        btnEditSimpan = findViewById(R.id.btnEditSimpan);
        btnEditSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String newJudulBuku = edEditJudulBuku.getText().toString();
                String namaPengarang = edEditNamaPengarang.getText().toString();
                String tahunTerbit = edEditTahunTerbit.getText().toString();
                String penerbit = edEditPenerbit.getText().toString();

                db.execSQL("UPDATE buku SET judul_buku = ?, nama_pengarang = ?, tahun_terbit = ?, penerbit = ? WHERE judul_buku = ?",
                        new String[]{newJudulBuku, namaPengarang, tahunTerbit, penerbit, judulBuku});
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}
