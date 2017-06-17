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

    public class CharacterTable {
        private int id;
        private String characterName;
        private int Str;
        private int Dex;
        private int Con;
        private int Int;
        private int Wis;
        private int Cha;
    }

    public CharacterTable(){

    }


}
