package com.example.jared.myfirstapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import android.util.Log;

/**
 * Created by Jared on 6/1/2015.
 */
public class FilePrint
{
    //TAG
    private static final String TAG = "MyActivity";

    // File Writer Object Instantiation
    Writer w;

    // File location
    File statText;

    // Constructor for the file
    public FilePrint(File fileIn)
    {
        Log.i(TAG,"Constructing File Printer: "+fileIn.toString());
        try
        {
            // File path
            statText = fileIn;
            // Steps to output to file and create it if it dne
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            w = new BufferedWriter(osw);
        }
        catch (IOException e)
        {
            // Display any errors
            Log.i(TAG,e.getMessage());
        }
    }

    // Method to print to the file desired
    public String print(String putThis)
    {
        Log.i(TAG,"Printing String: "+putThis);
        try
        {
            // write to the file the input text
            w.write(putThis);
        }
        catch (IOException e)
        {
            // Display error
            Log.i(TAG, e.getMessage());
        }
        return "Printing String";
    }

    // Close the file when done
    public String close()
    {
        Log.i(TAG,"Closing the file");
        try
        {
            // Close the file
            w.close();
        }
        catch (IOException e)
        {
            // Display error
            Log.i(TAG, e.getMessage());
        }
        return "Closing the file";
    }
}
