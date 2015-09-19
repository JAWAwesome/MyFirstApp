package com.example.jared.myfirstapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MyActivity extends ActionBarActivity {

    public final static String Team_Number ="com.example.jared.myfirstapp.TN";
    public final static String Your_Name ="com.example.jared.myfirstapp.YN";
    public final static String Auto_Action ="com.example.jared.myfirstapp.AA";
    public final static String Teleop_Action ="com.example.jared.myfirstapp.TA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.number);
        String message = editText.getText().toString();
        intent.putExtra(Team_Number, message);
        editText = (EditText)findViewById(R.id.name);
        message = editText.getText().toString();
        intent.putExtra(Your_Name, message);
        editText = (EditText)findViewById(R.id.auto);
        message = editText.getText().toString();
        intent.putExtra(Auto_Action, message);
        editText = (EditText)findViewById(R.id.teleop);
        message = editText.getText().toString();
        intent.putExtra(Teleop_Action, message);
        startActivity(intent);
    }
}
