package com.example.testapp2.Model;

import android.content.Context;
import android.util.Log;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Created by smccullough on 6/15/2017.
 */

public class CharacterSvcImpl implements ISaveSVC {

    private final String filename = "CharactersList.sio";
    private List<Character> Character;
    private Context appContext;

    public CharacterSvcImpl (Context context){

        Character = null;

        //Store context passed in, needed to open files
        appContext = context;
        readfile();
    }

    private void readfile(){
        try{
            ObjectInputStream ois = new ObjectInputStream(appContext.openFileInput(filename)); //Using appContext to open files.
            this.Character = (List<Character>) ois.readObject();
            ois.close();
        } catch(Exception e){
            String TAG = "CharacterSvcImpl";
            Log.e(TAG, e.getMessage());
        }
    }

    private void writeFile(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(appContext.openFileOutput(filename, Context.MODE_PRIVATE));
            oos.writeObject(Character);
            oos.flush();
            oos.close();
        } catch (Exception e){
            String TAG = "CharacterSvcImpl";
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public Character Create(Character character) {
        Character.add(character);
        writeFile();
        return character;
    }

    @Override
    public List<Character> retrieveallcontacts() {
        return null;
    }

    @Override
    public Character update() {
        return null;
    }

    @Override
    public Character delete() {
        return null;
    }

}
