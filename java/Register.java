package com.example.hyejung.p1315842_10;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by HyeJung on 2015-11-10.
 */
public class Register extends AppCompatActivity {
    SQLiteDatabase sqlitedb;
    DBManager dbmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        setTitle("주소록에 등록 되었습니다.");

        Intent it = getIntent();
        String str_name = it.getStringExtra("it_name");
        String str_gender = it.getStringExtra("it_gender");
        String str_coding = it.getStringExtra("it_coding");
        String str_sports = it.getStringExtra("it_sports");
        String str_traveling = it.getStringExtra("it_traveling");
        String str_movie = it.getStringExtra("it_movie");
        String str_phone = it.getStringExtra("it_phone");
        String str_address = it.getStringExtra("it_address");

        try {
            dbmanager = new DBManager(this);
            sqlitedb = dbmanager.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", str_name);
            values.put("gender", str_gender);
            values.put("coding", str_coding);
            values.put("sports", str_sports);
            values.put("traveling", str_traveling);
            values.put("movie", str_movie);
            values.put("phone", str_phone);
            values.put("address", str_address);
            long newRowId = sqlitedb.insert("addressBook", null, values);
            sqlitedb.close();
            dbmanager.close();

            if (newRowId != -1) {
                TextView tv_name = (TextView)findViewById(R.id.name);
                TextView tv_gender = (TextView)findViewById(R.id.gender);
                TextView tv_hobby = (TextView)findViewById(R.id.hobby);
                TextView tv_phone = (TextView)findViewById(R.id.phone);
                TextView tv_address = (TextView)findViewById(R.id.address);

                tv_name.append(": " + str_name);
                tv_gender.append(": " + str_gender);
                tv_hobby.append(": " + str_coding + " " + str_sports + " " + str_traveling + " " + str_movie);
                tv_phone.append(": " + str_phone);
                tv_address.append(": " + str_address);
            } else {
                Toast.makeText(this, "주소록 등록 에러!", Toast.LENGTH_LONG).show();
            }

        } catch(SQLiteException e) {
            Toast.makeText(this,  e.getMessage(), Toast.LENGTH_LONG).show();
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

    public void insert (View v){
        Intent it = new Intent(this, RegisterForm.class);
        startActivity(it);
        finish();
    }

    public void delete (View v){
        Intent it = new Intent(this, DeleteForm.class);
        startActivity(it);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}