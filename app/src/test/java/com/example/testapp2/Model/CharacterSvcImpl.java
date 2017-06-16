package com.example.testapp2.Model;

import android.content.Context;
import android.util.Log;

import com.example.testapp2.CharactersList;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by smccullough on 6/15/2017.
 */

public class CharacterSvcImpl implements ISaveSVC {

    private final String filename = "CharactersList.sio";
    private list<CharactersList> character;
    private Context appContext;

    public CharacterSvcImpl (Context context){

        character = null;

        //Store context passed in, needed to open files
        appContext = context;
        readfile();
    }

    private void readfile(){
        try{
            ObjectInputStream ois = new ObjectInputStream(appContext.openFileInput(filename)); //Using appContext to open files.
            character = (list<CharactersList>) ois.readObject();
            ois.close();
        } catch(Exception e){
            String TAG = "CharacterSvcImpl";
            Log.e(TAG, e.getMessage());
        }
    }

    private void writeFile(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(appContext.openFileOutput(filename, Context.MODE_PRIVATE));
            oos.writeObject(character);
            oos.flush();
            oos.close();
        } catch (Exception e){
            String TAG = "CharacterSvcImpl";
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public character create(character character) {
        character.add(CharactersList);
        writeFile();
        return character;
    }

    @Override
    public list<CharactersList> retrieveAllCharacters() {
        return character;
    }

    public Character update(Character character) {
        return character;
    }

    public Character delete(Character character) {
        return character;
    }

}
