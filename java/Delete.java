package com.example.hyejung.p1315842_10;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HyeJung on 2015-11-11.
 */
public class Delete extends AppCompatActivity {

    SQLiteDatabase sqlitedb;
    DBManager dbmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);

        setTitle("주소록 삭제");

        Intent it = getIntent();
        String delete_name = it.getStringExtra("name");

        try {
            dbmanager = new DBManager(this);
            sqlitedb = dbmanager.getWritableDatabase();
            long newRowId = sqlitedb.delete("addressBook", "name = ?", new String[]{delete_name});
            sqlitedb.close();
            dbmanager.close();

            if (newRowId != -1) {
                Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_LONG).show();
                TextView tv = (TextView)findViewById(R.id.textView);
                tv.setText(delete_name + " 님의 주소록이 삭제되었습니다.");
            } else {
                Toast.makeText(this, "주소록 등록 에러!", Toast.LENGTH_LONG).show();
            }

        } catch (SQLiteException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void home (View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }

    public void view (View v){
        Intent it = new Intent(this, List.class);
        startActivity(it);
        finish();
    }

    public void update (View v){
        Intent it = new Intent(this, UpdateForm.class);
        startActivity(it);
        finish();
    }

    public void insert (View v){
        Intent it = new Intent(this, RegisterForm.class);
        startActivity(it);
        finish();
    }
}