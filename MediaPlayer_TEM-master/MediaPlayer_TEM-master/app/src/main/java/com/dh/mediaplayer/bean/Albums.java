package com.dh.mediaplayer.bean;

/**
 * Created by tiendat on 5/21/2015.
 */
public class Albums  {
    private String NameAlbum;
    private String NameSongs;
    private String imageAlbum;

    public Albums(String nameAlbum, String nameSongs, String imageAlbum) {
        NameAlbum = nameAlbum;
        NameSongs = nameSongs;
        this.imageAlbum = imageAlbum;
    }

    public Albums() {
    }

    public String getNameAlbum() {
        return NameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        NameAlbum = nameAlbum;
    }

    public String getNameSongs() {
        return NameSongs;
    }

    public void setNameSongs(String nameSongs) {
        NameSongs = nameSongs;
    }

    public String getImageAlbum() {
        return imageAlbum;
    }

    public void setImageAlbum(String imageAlbum) {
        this.imageAlbum = imageAlbum;
    }
}
