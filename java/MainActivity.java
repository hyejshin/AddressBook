package com.example.hyejung.p1315842_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("주소록");
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

