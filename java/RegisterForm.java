package com.example.hyejung.p1315842_10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by HyeJung on 2015-11-10.
 */
public class RegisterForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_form);

        setTitle("주소록등록");
    }

    public void register(View v) {

        EditText et_name = (EditText)findViewById(R.id.name);
        String str_name = et_name.getText().toString();

        RadioGroup rg_gender  = (RadioGroup)findViewById(R.id.radiogroup_gender);
        RadioButton rb_male   = (RadioButton)findViewById(R.id.male);
        RadioButton rb_female = (RadioButton)findViewById(R.id.female);
        String str_gender     = "";
        if (rg_gender.getCheckedRadioButtonId() == R.id.male) {
            str_gender = rb_male.getText().toString();
        } else if (rg_gender.getCheckedRadioButtonId() == R.id.female) {
            str_gender = rb_female.getText().toString();
        }

        CheckBox chk_coding = (CheckBox)findViewById(R.id.coding);
        String str_coding = "";
        if (chk_coding.isChecked()) {
            str_coding = (String)chk_coding.getText();
        }
        CheckBox   chk_sports = (CheckBox)findViewById(R.id.sports);
        String str_sports = "";
        if (chk_sports.isChecked()) {
            str_sports = (String)chk_sports.getText();
        }
        CheckBox   chk_traveling = (CheckBox)findViewById(R.id.traveling);
        String str_traveling = "";
        if (chk_traveling.isChecked()) {
            str_traveling = (String)chk_traveling.getText();
        }
        CheckBox   chk_movie = (CheckBox)findViewById(R.id.movie);
        String str_movie = "";
        if (chk_movie.isChecked()) {
            str_movie = (String)chk_movie.getText();
        }

        EditText et_phone = (EditText)findViewById(R.id.phone);
        String str_phone = et_phone.getText().toString();

        EditText et_address = (EditText)findViewById(R.id.address);
        String str_address = et_address.getText().toString();

        Intent it = new Intent(this, Register.class);

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