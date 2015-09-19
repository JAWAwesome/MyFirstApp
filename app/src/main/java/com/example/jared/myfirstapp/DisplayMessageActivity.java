package com.example.jared.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;


public class DisplayMessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Objects
        Intent intent = getIntent();

        //Set up text on screen
        String message1 = intent.getStringExtra(MyActivity.Team_Number);
        String message2 = intent.getStringExtra(MyActivity.Your_Name);
        String message3 = intent.getStringExtra(MyActivity.Auto_Action);
        String message4 = intent.getStringExtra(MyActivity.Teleop_Action);
        String message = message1+","+message2+","+message3+","+message4;
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        setContentView(textView);

        //Print to a file
        if(isExternalStorageWritable()){
            //Objects
            Toast toast;
            Context context = getApplicationContext();
            FilePrint out = new FilePrint(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"Text Printed.txt"));

            //Toast Parameters
            int duration = Toast.LENGTH_LONG;

            //Print text
            toast = Toast.makeText(context, out.print(message), duration);
            toast.show();

            //Close file
            toast = Toast.makeText(context, out.close(), duration);
            toast.show();
        }
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

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

}
