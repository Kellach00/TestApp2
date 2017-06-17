package com.example.testapp2.Model;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by smccullough on 6/17/2017.
 */

public class CharactersSvc extends IntentService implements ICharacterSvc {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public CharactersSvc(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //Grab data from incoming Intent
        String dataString = workIntent.getDataString();

        //Do work here based on the contents of the data string
        //TODO: Create an array

    }

    @Override
    public Character Create(Character character) {
        return null;
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
