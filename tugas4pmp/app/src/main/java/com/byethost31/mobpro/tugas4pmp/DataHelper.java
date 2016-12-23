package com.byethost31.mobpro.tugas4pmp;

/**
 * Created by MANZ07 on 15/12/2016.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "biodatadiri.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
// TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub
        String sql = "create table biodata(nim text primary key, nama text null, tgl text null, jk text null, alamat text null, jurusan text null, angkatan text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO biodata (nim, nama, tgl, jk, alamat, jurusan, angkatan) VALUES ('1209705098', 'M Deden Firdaus', '20 Juli 1991', 'Laki-laki','Subang','informatika','2009');";
        db.execSQL(sql);
        String query2 = "create table user(id_user text primary key, Username text null, Password text null);";
        Log.d("Data", "onCreate: " + query2);
        db.execSQL(query2);
        query2 = "INSERT INTO user (id_user, Username, Password) values ('1', 'admin','admin');";
        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
// TODO Auto-generated method stub
    }

    public int cekLogin(String Username, String Password) {
        String query = "SELECT * FROM user WHERE Username='" + Username + "' AND Password ='" + Password + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);
        int rowCount = c.getCount();
        db.close();
        c.close();
        return rowCount;
    }
}