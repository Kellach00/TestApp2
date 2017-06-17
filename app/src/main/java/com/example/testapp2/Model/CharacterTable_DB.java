package com.example.testapp2.Model;

/**
 * Created by smccullough on 6/17/2017.
 */

public class CharacterTable_DB {

        private int id;
        private String characterName;
        private int Str;
        private int Dex;
        private int Con;
        private int Int;
        private int Wis;
        private int Cha;

    public CharacterTable_DB(){
    }

    public CharacterTable_DB(int id, String characterName,
                             int Str, int Dex , int Con, int Int,
                             int Wis, int Cha){
        this.id = id;
        this.characterName = characterName;
        this.Str = Str;
        this.Dex = Dex;
        this.Con = Con;
        this.Int = Int;
        this.Wis = Wis;
        this.Cha = Cha;
    }

    public CharacterTable_DB(String characterName, int Str, int Dex, int Con,
                             int Int, int Wis, int Cha){
        this.characterName = characterName;
        this.Str = Str;
        this.Dex = Dex;
        this.Con = Con;
        this.Int = Int;
        this.Wis = Wis;
        this.Cha = Cha;
    }

    public void setID(int id){
        this.id = id;
    }

    public int getID(){
        return this.id;
    }

    public void setCharacterName(String characterName){
        this.characterName = characterName;
    }

    public String getCharacterName(){
        return this.characterName;
    }

    public void setStr(int Str){
        this.Str = Str;
    }

    public int getStr(){
        return this.Str;
    }


    public void setDex(int Dex){
        this.Dex = Dex;
    }

    public int getDex(){
        return this.Dex;
    }

    public void setCon(int Con){
        this.Con = Con;
    }

    public int getCon(){
        return this.Con;
    }

    public void setInt(int Int){
        this.Int = Int;
    }

    public int getInt(){
        return this.Int;
    }

    public void setWis(int Wis){
        this.Wis = Wis;
    }

    public int getWis(){
        return this.Wis;
    }

    public void setCha(int Cha){
        this.Cha = Cha;
    }

    public int getCha(){
        return this.Cha;
    }

}
