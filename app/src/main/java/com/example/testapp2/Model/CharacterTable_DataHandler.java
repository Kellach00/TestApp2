package com.example.testapp2.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by smccullough on 6/19/2017.
 */

public class CharacterTable_DataHandler extends SQLiteOpenHelper{

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

    public CharacterTable_DataHandler(Context context, String DATABASE_NAME, SQLiteDatabase.CursorFactory factory, int DATABASE_VERSION) {

        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String Create_characterDB_Table = "CREATE TABLE" + TABLE_CHARACTERS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_CHARACTERNAME + " VARCHAR(20) NOT NULL," + COLUMN_STR + " INTEGER NOT NULL," + COLUMN_DEX + " INTEGER NOT NULL," +
                COLUMN_CON + " INTEGER NOT NULL," + COLUMN_INT + " INTEGER NOT NULL," + COLUMN_WIS +
                " INTEGER NOT NULL," + COLUMN_CHA + " INTEGER NOT NULL," + ")";

        db.execSQL(Create_characterDB_Table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHARACTERS);
        onCreate(db);

    }

    public void addCharacter(CharacterTable_DB character){

        ContentValues values = new ContentValues();
        values.put(COLUMN_CHARACTERNAME, character.getCharacterName());
        values.put(COLUMN_STR, character.getStr());
        values.put(COLUMN_DEX, character.getDex());
        values.put(COLUMN_CON, character.getCon());
        values.put(COLUMN_INT, character.getInt());
        values.put(COLUMN_WIS, character.getWis());
        values.put(COLUMN_CHA, character.getCha());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_CHARACTERS, null, values);
        db.close();
    }

    public void updateCharacter(CharacterTable_DB character){

        ContentValues values = new ContentValues();
        //Add values for row to update
        values.put(COLUMN_CHARACTERNAME, character.getCharacterName());
        values.put(COLUMN_STR, character.getStr());
        values.put(COLUMN_DEX, character.getDex());
        values.put(COLUMN_CON, character.getCon());
        values.put(COLUMN_INT, character.getInt());
        values.put(COLUMN_WIS, character.getWis());
        values.put(COLUMN_CHA, character.getCha());

        SQLiteDatabase db = this.getReadableDatabase();

        //Tell the update how to find the record to update...
        int numberOfRowsUpdated = db.update(COLUMN_CHARACTERNAME, values,
                "id = ?" , new String[] {String.valueOf(character.getID())});

        db.close();

        /**Check the number of rows actually changed
        if (numberOfRowsUpdated < 1){
            throw new SomeServiceException("Failed to update character");
        }*/
    }

    public boolean deleteCharacter (String characterName){

        boolean result = false;

        String query = "Select * FROM " + TABLE_CHARACTERS + " WHERE " +
                COLUMN_CHARACTERNAME + " = \"" + characterName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        CharacterTable_DB character = new CharacterTable_DB();

        if (cursor.moveToFirst()){

            character.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_CHARACTERS, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(character.getID())});
            cursor.close();
            result = true;
        }
        else {

            character = null;

        }

        db.close();
        return result;
    }
}
