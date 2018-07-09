package com.example.karaens.goodplays;

public class fArtist {
    String ArtistName,Country,Genre,Rating;
    int ArtistId;

    public fArtist(String artistName, String country, String genre, String rating, int artistId) {
        ArtistName = artistName;
        Country = country;
        Genre = genre;
        Rating = rating;
        ArtistId = artistId;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public int getArtistId() {
        return ArtistId;
    }

    public void setArtistId(int artistId) {
        ArtistId = artistId;
    }
}
