package com.dh.mediaplayer.bean;

/**
 * Created by DH on 21/05/2015.
 */
public class PlaylistOff {
    private int id;
    private String namePlaylist;
    private String idSong;

    public PlaylistOff() {
    }

    public PlaylistOff(int id, String namePlaylist, String idSong) {
        this.id = id;
        this.namePlaylist = namePlaylist;
        this.idSong = idSong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePlaylist() {
        return namePlaylist;
    }

    public void setNamePlaylist(String namePlaylist) {
        this.namePlaylist = namePlaylist;
    }

    public String getIdSong() {
        return idSong;
    }

    public void setIdSong(String idSong) {
        this.idSong = idSong;
    }
}
