package com.example.hyejung.p1315842_10;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HyeJung on 2015-11-11.
 */
public class UpdateForm2 extends AppCompatActivity {

    String update_name;

    EditText et_name;
    RadioGroup rg_gender;
    RadioButton rb_male;
    RadioButton rb_female;

    CheckBox chk_coding;
    CheckBox chk_sports;
    CheckBox chk_traveling;
    CheckBox chk_movie;

    EditText et_phone;
    EditText et_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_form2);

        setTitle("주소록수정");

        Intent it = getIntent();
        update_name = it.getStringExtra("name");

        et_name = (EditText)findViewById(R.id.name);
        rg_gender  = (RadioGroup)findViewById(R.id.radiogroup_gender);
        rb_male   = (RadioButton)findViewById(R.id.male);
        rb_female = (RadioButton)findViewById(R.id.female);

        chk_coding = (CheckBox)findViewById(R.id.coding);
        chk_sports = (CheckBox)findViewById(R.id.sports);
        chk_traveling = (CheckBox)findViewById(R.id.traveling);
        chk_movie = (CheckBox)findViewById(R.id.movie);

        et_phone = (EditText)findViewById(R.id.phone);
        et_address = (EditText)findViewById(R.id.address);


        SQLiteDatabase sqlitedb;
        DBManager dbmanager;
        try {
            dbmanager = new DBManager(this);
            sqlitedb = dbmanager.getReadableDatabase();
            //Cursor cursor = sqlitedb.query("addressBook", null, "name is not null", null, null, null, null);
            String query = "Select * FROM addressBook WHERE name =  \"" + update_name + "\"";
            Cursor cursor = sqlitedb.rawQuery(query, null);

            cursor.moveToNext();

            String name   = cursor.getString(0);
            String gender = cursor.getString(1);
            String coding    = cursor.getString(2);
            String sports  = cursor.getString(3);
            String traveling   = cursor.getString(4);
            String movie = cursor.getString(5);
            String phone    = cursor.getString(6);
            String address  = cursor.getString(7);

            cursor.close();
            sqlitedb.close();
            dbmanager.close();

            et_name.setText(name);
            if(gender.equals("여"))
                rb_female.setChecked(true);
            else
                rb_male.setChecked(true);
            if(coding.equals("코딩"))
                chk_coding.setChecked(true);
            if(sports.equals("운동"))
                chk_sports.setChecked(true);
            if(traveling.equals("여행"))
                chk_traveling.setChecked(true);
            if(movie.equals("영화보기"))
                chk_movie.setChecked(true);
            et_phone.setText(phone);
            et_address.setText(address);

        } catch(SQLiteException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void updateProcess2(View v) {

        et_name = (EditText)findViewById(R.id.name);
        String str_name = et_name.getText().toString();

        rg_gender  = (RadioGroup)findViewById(R.id.radiogroup_gender);
        rb_male   = (RadioButton)findViewById(R.id.male);
        rb_female = (RadioButton)findViewById(R.id.female);
        String str_gender = "";
        if (rg_gender.getCheckedRadioButtonId() == R.id.male) {
            str_gender = rb_male.getText().toString();
        } else if (rg_gender.getCheckedRadioButtonId() == R.id.female) {
            str_gender = rb_female.getText().toString();
        }

        chk_coding = (CheckBox)findViewById(R.id.coding);
        String str_coding = "";
        if (chk_coding.isChecked()) {
            str_coding = (String)chk_coding.getText();
        }
        chk_sports = (CheckBox)findViewById(R.id.sports);
        String str_sports = "";
        if (chk_sports.isChecked()) {
            str_sports = (String)chk_sports.getText();
        }
        chk_traveling = (CheckBox)findViewById(R.id.traveling);
        String str_traveling = "";
        if (chk_traveling.isChecked()) {
            str_traveling = (String)chk_traveling.getText();
        }
        chk_movie = (CheckBox)findViewById(R.id.movie);
        String str_movie = "";
        if (chk_movie.isChecked()) {
            str_movie = (String)chk_movie.getText();
        }

        et_phone = (EditText)findViewById(R.id.phone);
        String str_phone = et_phone.getText().toString();

        et_address = (EditText)findViewById(R.id.address);
        String str_address = et_address.getText().toString();

        Intent it = new Intent(this, Update.class);

        it.putExtra("update_name", update_name);
        it.putExtra("it_name",   str_name);
        it.putExtra("it_gender", str_gender);
        it.putExtra("it_coding",    str_coding);
        it.putExtra("it_sports",    str_sports);
        it.putExtra("it_traveling",  str_traveling);
        it.putExtra("it_movie",    str_movie);
        it.putExtra("it_phone",   str_phone);
        it.putExtra("it_address",   str_address);

        startActivity(it);

        finish();
    }

    public void home (View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }
}