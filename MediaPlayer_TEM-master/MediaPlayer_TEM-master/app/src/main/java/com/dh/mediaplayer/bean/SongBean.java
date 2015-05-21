package com.dh.mediaplayer.bean;

/**
 * Created by DH on 5/13/2015.
 */
public class SongBean {
    private int musicID;
    private String musicName;
    private String music_EN;
    private String link;
    private String lyrics;
    private int singerID;
    private String thumbImage;
    private int categoriesId;
    private int composerID;
    private String description;




    public SongBean() {
    }

    public SongBean(int musicID, String musicName, String music_EN, String link, String lyrics, int singerID, String thumbImage, int categoriesId, int composerID, String description) {
        this.musicID = musicID;
        this.musicName = musicName;
        this.music_EN = music_EN;
        this.link = link;
        this.lyrics = lyrics;
        this.singerID = singerID;
        this.thumbImage = thumbImage;
        this.categoriesId = categoriesId;
        this.composerID = composerID;
        this.description = description;
    }

    public int getMusicID() {
        return musicID;
    }

    public void setMusicID(int musicID) {
        this.musicID = musicID;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusic_EN() {
        return music_EN;
    }

    public void setMusic_EN(String music_EN) {
        this.music_EN = music_EN;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getSingerID() {
        return singerID;
    }

    public void setSingerID(int singerID) {
        this.singerID = singerID;
    }

    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }

    public int getComposerID() {
        return composerID;
    }

    public void setComposerID(int composerID) {
        this.composerID = composerID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
