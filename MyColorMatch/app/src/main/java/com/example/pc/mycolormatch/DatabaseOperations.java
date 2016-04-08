package com.example.pc.mycolormatch;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by PC on 08/04/2016.
 */
public class DatabaseOperations extends SQLiteOpenHelper {
    public final static int databaseVersion = 1;
    public String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "+ Score.TableInfo.TABLE_NAME +
            "("+ Score.TableInfo.PLAYER_NAME+" TEXT, "+ Score.TableInfo.SCORE_DATE+" TEXT , "+ Score.TableInfo.PLAYER_SCORE+" INT, " +
            "PRIMARY KEY ("+ Score.TableInfo.SCORE_DATE+") );";
    //public String UPDATE_USERNAME_QUERY= "Update "+TableInfo.TABLE_NAME+ " "
    public DatabaseOperations(Context context) {
        super(context, Score.TableInfo.DATABASE_NAME, null, databaseVersion);
        Log.d("Database Operation ", " Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database Operation ", " Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertInformation(DatabaseOperations dop, String name, String date, int score){
        SQLiteDatabase sDB = dop.getWritableDatabase();
        Cursor c = sDB.rawQuery("SELECT MAX( "+ Score.TableInfo.PLAYER_SCORE+" ) FROM "+ Score.TableInfo.TABLE_NAME,null);
        c.moveToFirst();
        int scoreTmp = c.getInt(0);
        Log.d("Database Operation ","Max score = "+scoreTmp);
        if(score > scoreTmp){
            ContentValues cv = new ContentValues();
            cv.put(Score.TableInfo.SCORE_DATE,date);
            cv.put(Score.TableInfo.PLAYER_NAME,name);
            cv.put(Score.TableInfo.PLAYER_SCORE, score);

            long k = sDB.insert(Score.TableInfo.TABLE_NAME,null,cv);
            Log.d("Database Operation "," One row inserted");
        }else{
            Log.d("Database Operation "," Score has not been inserted");
        }



    }

    public Cursor selectInformation(DatabaseOperations dop){
        SQLiteDatabase sDB = dop.getReadableDatabase();
        String[]columns = {Score.TableInfo.PLAYER_NAME, Score.TableInfo.PLAYER_SCORE, Score.TableInfo.SCORE_DATE};
        Cursor cursor = sDB.query(Score.TableInfo.TABLE_NAME, columns, null, null, null, null, Score.TableInfo.PLAYER_SCORE + " DESC");
        return cursor;
    }

    public void clearDataBase(DatabaseOperations dop){
        SQLiteDatabase sDB = dop.getWritableDatabase();
        sDB.delete(Score.TableInfo.TABLE_NAME,null,null);
        Log.d("Database Operation "," Table data cleared");
    }

    public void updatePlayerName(DatabaseOperations dop, String oldName, String newName){
        SQLiteDatabase sDB = dop.getWritableDatabase();

        Log.d("Database Operation ","Player name updated");
    }
}

