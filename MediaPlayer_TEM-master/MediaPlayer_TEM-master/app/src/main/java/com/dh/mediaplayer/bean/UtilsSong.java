package com.dh.mediaplayer.bean;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 * Created by CHUNGNHIM on 5/14/2015.
 */
public class UtilsSong  {

    /**
     * Lay all danh sach dinh dang file mp3 trong the nho ngoai
     */

    public ArrayList<SongBean> getAllAudio(final String endWith, Context context) {
        ArrayList<SongBean> arraySong = null;
        try {

            SongBean objSong;
            arraySong = new ArrayList<SongBean>();
            Uri uri;
            Cursor mCursor;

            String[] m_data = {MediaStore.Audio.Media.ALBUM_ID,
                    MediaStore.Audio.Media.ARTIST,
                    MediaStore.Audio.Media.ALBUM,
                    MediaStore.Audio.Media.TITLE,
                    MediaStore.Audio.Media.DURATION, MediaStore.Audio.Media.TRACK, MediaStore.Audio.Media.DISPLAY_NAME,
                    MediaStore.Audio.Media.DATA};

            //Lay danh sach file nhac trong bo nho may
            uri = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
            mCursor = context.getContentResolver().query(uri, m_data,null, null, null);;

            if (mCursor != null) {
                for (mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()) {
                    objSong = new SongBean();
                    objSong.setMusicName(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)));
                    objSong.setLink(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));
                    arraySong.add(objSong);
                }
            }
            //Lay danh sach file nhac trong the nho ngoai
            uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            mCursor = context.getContentResolver().query(uri, m_data, null, null, null);;

            if (mCursor != null) {
                for (mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()) {
                    objSong = new SongBean();
                    objSong.setMusicName(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)));
                    objSong.setLink(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));
                    arraySong.add(objSong);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return arraySong;
    }
}
