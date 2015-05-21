package com.dh.mediaplayer.bean;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by DH on 21/05/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "mediaplayer.db";
    private static int DB_VERSION = 1;

    public static final String TABLE_NAME_SONG = "song_details";
    public static final String ID_SONG = "_id";
    public static final String NAME_SONG = "name_songs";
    public static final String NAME_SING = "name_sings";
    public static final String ARTISTS = "artists";
    public static final String TIME = "time";
    public static final String IMAGE = "image";

    public static final String TABLE_NAME_PLAYLIST = "playlistoff";
    public static final String ID_PLAYLIST = "_id";
    public static final String NAME_PLAYLIST = "name_playlist";
    public static final String ID_SONG_PLAYLIST = "_id_song";

    private Context context;
    String DB_PATH="";
    private SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        DB_PATH = context.getFilesDir().getParent()+"/databases/"+DB_NAME;
    }

    public boolean checkDB(){
        SQLiteDatabase checkDB =null;
        try {
            checkDB = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READONLY);
        } catch (Exception e) {

        }
        if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null?true:false ;
    }
    public SQLiteDatabase openDatabase(){
        SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
        return db;
    }
    public void createDatabase(){
        boolean kt= checkDB();
        if(!kt){
            this.getReadableDatabase();
            try {
                Log.d("ERROR", "Not create Database!");
            } catch (Exception e) {
            }finally{
                this.close();
            }
        }
    }

    @Override
    public synchronized void close() {
        super.close();
        if(db!=null){
            db.close();
            SQLiteDatabase.releaseMemory();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSong = "CREATE TABLE IF NOT EXISTS"+TABLE_NAME_SONG+" ("+ID_SONG+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME_SONG+" Address TEXT, Phone INTEGER)";
        db.execSQL(createTableSong);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
