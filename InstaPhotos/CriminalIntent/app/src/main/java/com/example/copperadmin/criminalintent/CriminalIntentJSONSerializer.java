package com.example.copperadmin.criminalintent;

import android.content.Context;

import com.example.copperadmin.criminalintent.Crime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by Copper Admin on 10/3/2014.
 */
public class CriminalIntentJSONSerializer {

    private Context mContext;
    private String mFileName;

    public CriminalIntentJSONSerializer(Context c, String f){
        mContext = c;
        mFileName = f;
    }

    public void saveCrimes(ArrayList<Crime> crimes) throws JSONException, IOException{
        JSONArray array = new JSONArray();
        for (Crime c :crimes){
            array.put(c.toJSON());
        }

        //Write the file to disk

        Writer writer = null;
        try{
            OutputStream out = mContext.openFileOutput(mFileName, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        }finally{
            if(writer!=null)
                writer.close();
        }
    }

    public ArrayList<Crime> loadCrimes() throws IOException, JSONException{
        ArrayList<Crime> crimes = new ArrayList<Crime>();
        BufferedReader reader = null;
        try{
            //open and read the file into the StringBuilder
            InputStream in = mContext.openFileInput(mFileName);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while((line = reader.readLine())!=null){
                //line breaks are omitted and irrelevant
                jsonString.append(line);
            }

            //Parse the JSON using JSONTokener
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            for (int i = 0 ; i<array.length(); i++){
                crimes.add(new Crime(array.getJSONObject(i)));
            }
        }catch (FileNotFoundException e){
            //Ignore for now
        }finally {
            if(reader!=null)
                reader.close();
        }
        return crimes;
    }
}
