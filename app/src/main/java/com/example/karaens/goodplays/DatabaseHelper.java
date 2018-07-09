package com.example.karaens.goodplays;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME="Favourites.db";
    public static String TABLE_NAME_T="Tracks_table";
    public static String TABLE_NAME_A="Artists_table";
    public static String COL1T="ID_T";
    public static String COL2T="TRACK_ID";
    public static String COL3T="TRACK";
    public static String COL4T="ALBUM";
    public static String COL5T="ARTIST";
    public static String COL6T="DATE";
    public static String COL7T="GENRE";
    public static String COL8T="LYRICS";
    public static String COL1A="ID_A";
    public static String COL2A="ARTIST_ID";
    public static String COL3A="ARTIST";
    public static String COL4A="COUNTRY";
    public static String COL5A="GENRE";
    public static String COL6A="RATING";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME_T+" (ID_T INTEGER PRIMARY KEY AUTOINCREMENT,TRACK_ID INTEGER,TRACK TEXT,ALBUM TEXT," +
                "ARTIST TEXT,DATE TEXT,GENRE TEXT,LYRICS TEXT)");
        db.execSQL("create table "+TABLE_NAME_A+" (ID_A INTEGER PRIMARY KEY AUTOINCREMENT,ARTIST_ID INTEGER,ARTIST TEXT,COUNTRY TEXT," +
                "GENRE TEXT,RATING TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME_T);
        db.execSQL("drop table if exists "+TABLE_NAME_A);
        onCreate(db);
    }

    boolean addTrack(int TrackId,String TrackName,String AlbumName,String ArtistName,String Date,String Genre,String Lyrics){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2T,TrackId);
        contentValues.put(COL3T,TrackName);
        contentValues.put(COL4T,AlbumName);
        contentValues.put(COL5T,ArtistName);
        contentValues.put(COL6T,Date);
        contentValues.put(COL7T,Genre);
        contentValues.put(COL8T,Lyrics);
        long result=db.insert(TABLE_NAME_T,null,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

    boolean addArtist(int ArtistId,String Artist,String Country,String Genre,String Rating){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2A,ArtistId);
        contentValues.put(COL3A,Artist);
        contentValues.put(COL4A,Country);
        contentValues.put(COL5A,Genre);
        contentValues.put(COL6A,Rating);
        long result=db.insert(TABLE_NAME_A,null,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

    Cursor getTrack(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME_T,null);
        return res;
    }

    Cursor getArtist(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME_A,null);
        return res;
    }

    int deleteTrack(int TrackId){
        SQLiteDatabase db = this.getWritableDatabase();
        int res=db.delete(TABLE_NAME_T,"TRACK_ID=?",new String[] {String.valueOf(TrackId)});
        return res;
    }

    int deleteArtist(int ArtistId){
        SQLiteDatabase db = this.getWritableDatabase();
        int res=db.delete(TABLE_NAME_A,"ARTIST_ID=?",new String[] {String.valueOf(ArtistId)});
        return res;
    }

    int resetData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("drop table if exists "+TABLE_NAME_T);
        db.execSQL("drop table if exists "+TABLE_NAME_A);
        onCreate(db);
        Cursor rowsT=getTrack();
        Cursor rowsA=getArtist();
        if(rowsT.getCount()==0&&rowsA.getCount()==0){
            return 0;
        }
        else
            return 1;
    }

}
