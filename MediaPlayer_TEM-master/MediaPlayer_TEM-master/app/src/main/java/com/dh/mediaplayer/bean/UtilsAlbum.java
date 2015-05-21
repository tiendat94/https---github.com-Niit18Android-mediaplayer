package com.dh.mediaplayer.bean;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

/**
 * Created by tiendat on 5/21/2015.
 */
public class UtilsAlbum {
    public ArrayList<Albums> getAllAudio(final String endWith, Context context) {
        ArrayList<Albums> arrayArtist = null;
        try {

            Albums objSong;
            arrayArtist = new ArrayList<Albums>();
            Uri uri;
            Cursor mCursor;

            String[] m_data = {
                    MediaStore.Audio.Media.ALBUM,
                    MediaStore.Audio.Media.ALBUM_ID,
                    MediaStore.Audio.Media.ALBUM_KEY, MediaStore.Audio.Media.DISPLAY_NAME,
                    MediaStore.Audio.Media.DATA};

            //Lay danh sach file nhac trong bo nho may
            uri = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
            mCursor = context.getContentResolver().query(uri, m_data,null, null, null);;

            if (mCursor != null) {
                for (mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()) {
                    objSong = new Albums();
                    objSong.setNameAlbum(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM)));
                    objSong.setNameSongs(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)));
                    arrayArtist.add(objSong);
                }
            }
            //Lay danh sach file nhac trong the nho ngoai
            uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            mCursor = context.getContentResolver().query(uri, m_data, null, null, null);;

            if (mCursor != null) {
                for (mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()) {
                    objSong = new Albums();
                    objSong.setNameAlbum(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM)));
                    objSong.setNameSongs(mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)));
                    arrayArtist.add(objSong);

                    arrayArtist.add(objSong);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return arrayArtist;
    }
}
