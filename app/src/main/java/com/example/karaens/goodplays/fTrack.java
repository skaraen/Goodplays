package com.example.karaens.goodplays;

public class fTrack {
    String TrackName,AlbumName,ArtistName,Date,Genre,Lyrics;
    int TrackId;

    public fTrack(String trackName, String albumName, String artistName, String date, String genre, String lyrics, int trackId) {
        TrackName = trackName;
        AlbumName = albumName;
        ArtistName = artistName;
        Date = date;
        Genre = genre;
        Lyrics = lyrics;
        TrackId = trackId;
    }

    public String getTrackName() {
        return TrackName;
    }

    public void setTrackName(String trackName) {
        TrackName = trackName;
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String albumName) {
        AlbumName = albumName;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getLyrics() {
        return Lyrics;
    }

    public void setLyrics(String lyrics) {
        Lyrics = lyrics;
    }

    public int getTrackId() {
        return TrackId;
    }

    public void setTrackId(int trackId) {
        TrackId = trackId;
    }
}
