package com.example.testapp2.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smccullough on 6/17/2017.
 */

public class CharacterTable_DB_SVC_Impl extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "characterDB.db";
    private static final String TABLE_CHARACTERS = "character";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CHARACTERNAME = "characterName";
    public static final String COLUMN_STR = "STR";
    public static final String COLUMN_DEX = "DEX";
    public static final String COLUMN_CON = "CON";
    public static final String COLUMN_INT = "INT";
    public static final String COLUMN_WIS = "WIS";
    public static final String COLUMN_CHA = "CHA";

    public CharacterTable_DB_SVC_Impl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {

        super(context, DATABASE_NAME, factory, DATABASE_VERSION, errorHandler);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String Create_characterDB_Table = "CREATE TABLE" + Character_Table + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_CHARACTERNAME + " VARCHAR(20) NOT NULL," + COLUMN_STR + " INTEGER NOT NULL," + COLUMN_DEX + " INTEGER NOT NULL," +
                COLUMN_CON + " INTEGER NOT NULL," + COLUMN_INT + " INTEGER NOT NULL," + COLUMN_WIS +
                " INTEGER NOT NULL," + COLUMN_CHA + " INTEGER NOT NULL," + ")";

        db.execSQL(Create_characterDB_Table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Character_Table);
        onCreate(db);

    }

    @Override
    public Character Create(Character character) {

        //Get Database Object
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //Create object to hold row values that go in table
        ContentValues values = new ContentValues();
        //Add values for row
        values.put(COLUMN_CHARACTERNAME, character.getName());
        values.put("Str", character.getNumericValue());
        values.put("Dex", character.getNumericValue());
        values.put("Con", character.getNumericValue());
        values.put("Int", character.getNumericValue());
        values.put("Wis", character.getNumericValue());
        values.put("Cha", character.getNumericValue());

        //insert row into database. This returns the id of the new row
        //or -1 if the insert failed. It is a good idea to check the value
        //of the returned row id.
        long rowIdOfInsertedRecord = sqLiteDatabase.insert("character", null, values);

        //Close database
        sqLiteDatabase.close();

        return character;

    }

    @Override
    public List<Character> retrieveallcontacts() {

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

    @Override
    public Character update(Character character) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        //Add values for row to update
        contentValues.put("characterName", character.getName());
        contentValues.put("Str", character.getNumericValue());
        contentValues.put("Dex", character.getNumericValue());
        contentValues.put("Con", character.getNumericValue());
        contentValues.put("Int", character.getNumericValue());
        contentValues.put("Wis", character.getNumericValue());
        contentValues.put("Cha", character.getNumericValue());
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

    public void delete() {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        int rowsDeleted = sqLiteDatabase.delete("character",
                "id = ?", new String[] {String.valueOf(COLUMN_ID)});
        sqLiteDatabase.close();

        //Check the number of rows deleted
        if (rowsDeleted == 0){
            throw new SomeServiceException("Failed to delete character");
        }

    }

}
