package com.example.testapp2.Model;

/**
 * Created by smccullough on 6/15/2017.
 */

public interface ISaveSVC {
    public characteritem create(Create create);
    public list<charactersArray> retrieveallcontacts();
    public characteritem update();
    public characteritem delete();
}
