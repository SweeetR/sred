package com.example.sred;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/*
@author roy tendler
@version 1
@since 26/05/2020
 */
public class MainActivity extends AppCompatActivity {
    SharedPreferences settings;
    TextView tv1;
    int counter = 0;
    EditText et1;
    Intent si;

    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 =(TextView)findViewById(R.id.tv1);
        et1 =(EditText) findViewById(R.id.et1);
        si = new Intent(this,Credits.class);
        settings = getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        editor=settings.edit();
       counter = settings.getInt("keepCount",0);
        tv1.setText(counter+"");
        et1.setText(settings.getString("keepWord",""));
    }
/*
this function adds to the counter one
 */
    public void count(View view) {
        counter++;
        tv1.setText(counter+"");

    }
/*
this function resets the counter
 */
    public void reset(View view) {
        counter = 0;
        tv1.setText(counter+"");
    }
/*
this functiom exits the app and saves all the data
 */
    public void exit(View view) {
        editor.putInt("keepCount",counter);
        editor.putString("keepWord",et1.getText().toString());
        editor.commit();
        finish();
    }
/*
this function creates the option menu
 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,250,"Credits");
        return true;
    }
/*
this function send the user to the credits menu when the credits is pressed
 */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String st = item .getTitle().toString();
        if(st.equals("Credits"))
            startActivity(si);
        return true;
    }
}
