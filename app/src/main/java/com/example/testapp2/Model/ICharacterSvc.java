package com.example.testapp2.Model;

import java.util.List;

/**
 * Created by smccullough on 6/17/2017.
 */

public interface ICharacterSvc  {

    Character Create(Character character);
    List<Character> retrieveallcontacts();
    Character update();
    Character delete();

}
