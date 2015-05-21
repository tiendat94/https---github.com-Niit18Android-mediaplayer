package com.dh.mediaplayer.bean;

import java.util.Date;

/**
 * Created by DH on 21/05/2015.
 */
public class SongDetails {
    private int id;
    private String nameSong;
    private String nameSing;
    private String artists;
    private Date time;
    private String image;

    public SongDetails() {
    }

    public SongDetails(int id, String nameSong, String nameSing, String artists, Date time, String image) {
        this.id = id;
        this.nameSong = nameSong;
        this.nameSing = nameSing;
        this.artists = artists;
        this.time = time;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSing() {
        return nameSing;
    }

    public void setNameSing(String nameSing) {
        this.nameSing = nameSing;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
