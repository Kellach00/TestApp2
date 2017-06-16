package com.example.testapp2.Model;

import java.util.List;

/**
 * Created by smccullough on 6/15/2017.
 */

public interface ISaveSVC {
    public Character Create(Character character);
    public List<Character> retrieveallcontacts();
    public Character update();
    public Character delete();
}
