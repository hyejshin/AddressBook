package com.example.hyejung.p1315842_10;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by HyeJung on 2015-11-10.
 */
public class List extends AppCompatActivity {

    SQLiteDatabase sqlitedb;
    DBManager dbmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        setTitle("주소록 목록");

        LinearLayout layout = (LinearLayout)findViewById(R.id.customer);

        try {
            dbmanager = new DBManager(this);
            sqlitedb = dbmanager.getReadableDatabase();
            Cursor cursor = sqlitedb.query("addressBook", null, "name is not null", null, null, null, null);

            int i = 0;
            while(cursor.moveToNext()) {
                //String key   = cursor.getString(cursor.getColumnIndex("key"));
                String name   = cursor.getString(cursor.getColumnIndex("name"));
                String gender = cursor.getString(cursor.getColumnIndex("gender"));
                String coding    = cursor.getString(cursor.getColumnIndex("coding"));
                String sports  = cursor.getString(cursor.getColumnIndex("sports"));
                String traveling   = cursor.getString(cursor.getColumnIndex("traveling"));
                String movie = cursor.getString(cursor.getColumnIndex("movie"));
                String phone    = cursor.getString(cursor.getColumnIndex("phone"));
                String address  = cursor.getString(cursor.getColumnIndex("address"));

                LinearLayout layout_list = new LinearLayout(this);
                layout_list.setOrientation(LinearLayout.VERTICAL);
                layout_list.setPadding(20,  10,  20,  10);
                if (i%2 == 1)
                    layout_list.setBackgroundColor(Color.rgb(153, 255, 153));

                TextView tv_list = new TextView(this);
                //tv_list.setText(name+key.toString());
                tv_list.setText(name);
                tv_list.setTextSize(20);
                layout_list.addView(tv_list);

                TextView tv_list2 = new TextView(this);
                tv_list2.setText("성별: " + gender  + "\n");
                tv_list2.append("취미: " + coding + " " + sports + " " + traveling + " " + movie + "\n");
                tv_list2.append("전화번호: " + phone + "\n");
                tv_list2.append("주소: " + address + "\n");
                layout_list.addView(tv_list2);

                layout.addView(layout_list);

                i++;
            }

            cursor.close();
            sqlitedb.close();
            dbmanager.close();

        } catch(SQLiteException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void home (View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }

    public void insert (View v){
        Intent it = new Intent(this, RegisterForm.class);
        startActivity(it);
        finish();
    }

    public void update (View v){
        Intent it = new Intent(this, UpdateForm.class);
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
