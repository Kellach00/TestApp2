package com.example.testapp2.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smccullough on 6/17/2017.
 */

public abstract class CharacterSvcSQLiteImpl extends SQLiteOpenHelper implements ICharacterSvc
{

    private static final String DBNAME = "Characters.db";
    private static final int DBVERSION = 1;

    private String createCharacterTable =
            "create table character (id integer primary key autoincrement, " + "characterName text not null," +
                    " Str integer not null, Dex integer not null, Con integer not null, Int integer not null," +
                    "Wis integer not null, Cha integer not null)";



    public CharacterSvcSQLiteImpl(Context context)
    {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

        sqLiteDatabase.execSQL(createCharacterTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

        sqLiteDatabase.execSQL("DROP TABLE IF IT EXISTS character");
        onCreate(sqLiteDatabase);

    }

    @Override
    public Character Create(Character character) {

        //Get Database Object
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //Create object to hold row values that go in table
        ContentValues contentValues = ContentValues();
        //Add values for row
        contentValues.put("characterName", character.getcharacterName());
        contentValues.put("Str", character.getStr());
        contentValues.put("Dex", character.getDex());
        contentValues.put("Con", character.getCon());
        contentValues.put("Int", character.getInt());
        contentValues.put("Wis", character.getWis());
        contentValues.put("Cha", character.getCha());
        //insert row into database. This returns the id of the new row
        //or -1 if the insert failed. It is a good idea to check the value
        //of the returned row id.
        long rowIdOfInsertedRecord = sqLiteDatabase.insert("character", null, contentValues);

        //Close database
        sqLiteDatabase.close();

        return character;
    }

    @Override
    public List<Character> retrieveallcontacts()
    {

        List<Character> characters = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("character", //Table name
                //Column      0    1    2    3    4    5   6   7
                new String[] {"id", "characterName", "Str", "Dex", "Con", "Int", "Wis",
                "Cha"}, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Character character = getCharacter(cursor);
            characters.add(character);
            cursor.moveToNext();
        }

        cursor.close();
        return characters;

    }

    public Character update(Character character) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        //Add values for row to update
        contentValues.put("characterName", character.getcharacterName());
        contentValues.put("Str", character.getStr());
        contentValues.put("Dex", character.getDex());
        contentValues.put("Con", character.getCon());
        contentValues.put("Int", character.getInt());
        contentValues.put("Wis", character.getWis());
        contentValues.put("Cha", character.getCha());
        int numberOfRowsUpdated = sqLiteDatabase.update("character", contentValues,
                //Tell the update how to find the record to update...
                "id = ?", new String[] {String.valueOf(character.getId())});
        sqLiteDatabase.close();

        //Check the number of rows actually changed
        if (numberOfRowsUpdated < 1){
            throw new SomeServiceException("Failed to update character");
        }
        return character;
    }

    public void delete(int characterId) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        int rowsDeleted = sqLiteDatabase.delete("character",
                "id = ?", new String[] {String.valueOf(characterId)});
        sqLiteDatabase.close();

        //Check the number of rows deleted
        if (rowsDeleted == 0){
            throw new SomeServiceException("Failed to delete character");
        }

    }

    private Character getCharacter(Cursor cursor){
        Character character = new Character();
        //On getInt and getString the number passed is the index of the column
        //name used in the query... see the string array in retrieveallcontacts
        character.setId(cursor.getInt(0));
        character.setcharacterName(cursor.getString(1));
        character.setStr(cursor.getInt(2));
        character.setDex(cursor.getInt(3));
        character.setCon(cursor.getInt(4));
        character.setInt(cursor.getInt(5));
        character.setWis(cursor.getInt(6));
        character.setCha(cursor.getInt(7));

        return character;
    }
}
