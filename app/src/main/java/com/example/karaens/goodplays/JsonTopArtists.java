package com.example.karaens.goodplays;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonTopArtists {
    @SerializedName("message")
    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public static class Artist {
        @SerializedName("artist_id")
        private Integer artistId;
        @SerializedName("artist_mbid")
        private String artistMbid;
        @SerializedName("artist_name")
        private String artistName;
        @SerializedName("artist_name_translation_list")
        private List<ArtistNameTranslationList> artistNameTranslationList = null;
        @SerializedName("artist_comment")
        private String artistComment;
        @SerializedName("artist_country")
        private String artistCountry;
        @SerializedName("artist_alias_list")
        private List<ArtistAliasList> artistAliasList = null;
        @SerializedName("artist_rating")
        private Integer artistRating;
        @SerializedName("primary_genres")
        private PrimaryGenres primaryGenres;
        @SerializedName("secondary_genres")
        private SecondaryGenres secondaryGenres;
        @SerializedName("artist_twitter_url")
        private String artistTwitterUrl;
        @SerializedName("artist_vanity_id")
        private String artistVanityId;
        @SerializedName("artist_edit_url")
        private String artistEditUrl;
        @SerializedName("artist_share_url")
        private String artistShareUrl;
        @SerializedName("artist_credits")
        private ArtistCredits artistCredits;
        @SerializedName("restricted")
        private Integer restricted;
        @SerializedName("managed")
        private Integer managed;
        @SerializedName("updated_time")
        private String updatedTime;

        public Integer getArtistId() {
            return artistId;
        }

        public void setArtistId(Integer artistId) {
            this.artistId = artistId;
        }

        public String getArtistMbid() {
            return artistMbid;
        }

        public void setArtistMbid(String artistMbid) {
            this.artistMbid = artistMbid;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public List<ArtistNameTranslationList> getArtistNameTranslationList() {
            return artistNameTranslationList;
        }

        public void setArtistNameTranslationList(List<ArtistNameTranslationList> artistNameTranslationList) {
            this.artistNameTranslationList = artistNameTranslationList;
        }

        public String getArtistComment() {
            return artistComment;
        }

        public void setArtistComment(String artistComment) {
            this.artistComment = artistComment;
        }

        public String getArtistCountry() {
            return artistCountry;
        }

        public void setArtistCountry(String artistCountry) {
            this.artistCountry = artistCountry;
        }

        public List<ArtistAliasList> getArtistAliasList() {
            return artistAliasList;
        }

        public void setArtistAliasList(List<ArtistAliasList> artistAliasList) {
            this.artistAliasList = artistAliasList;
        }

        public Integer getArtistRating() {
            return artistRating;
        }

        public void setArtistRating(Integer artistRating) {
            this.artistRating = artistRating;
        }

        public PrimaryGenres getPrimaryGenres() {
            return primaryGenres;
        }

        public void setPrimaryGenres(PrimaryGenres primaryGenres) {
            this.primaryGenres = primaryGenres;
        }

        public SecondaryGenres getSecondaryGenres() {
            return secondaryGenres;
        }

        public void setSecondaryGenres(SecondaryGenres secondaryGenres) {
            this.secondaryGenres = secondaryGenres;
        }

        public String getArtistTwitterUrl() {
            return artistTwitterUrl;
        }

        public void setArtistTwitterUrl(String artistTwitterUrl) {
            this.artistTwitterUrl = artistTwitterUrl;
        }

        public String getArtistVanityId() {
            return artistVanityId;
        }

        public void setArtistVanityId(String artistVanityId) {
            this.artistVanityId = artistVanityId;
        }

        public String getArtistEditUrl() {
            return artistEditUrl;
        }

        public void setArtistEditUrl(String artistEditUrl) {
            this.artistEditUrl = artistEditUrl;
        }

        public String getArtistShareUrl() {
            return artistShareUrl;
        }

        public void setArtistShareUrl(String artistShareUrl) {
            this.artistShareUrl = artistShareUrl;
        }

        public ArtistCredits getArtistCredits() {
            return artistCredits;
        }

        public void setArtistCredits(ArtistCredits artistCredits) {
            this.artistCredits = artistCredits;
        }

        public Integer getRestricted() {
            return restricted;
        }

        public void setRestricted(Integer restricted) {
            this.restricted = restricted;
        }

        public Integer getManaged() {
            return managed;
        }

        public void setManaged(Integer managed) {
            this.managed = managed;
        }

        public String getUpdatedTime() {
            return updatedTime;
        }

        public void setUpdatedTime(String updatedTime) {
            this.updatedTime = updatedTime;
        }
    }

    public static class Artist_list {
        @SerializedName("artist")
        private Artist artist;

        public Artist getArtist() {
            return artist;
        }

        public void setArtist(Artist artist) {
            this.artist = artist;
        }
    }

    public static class Artist_name_translation {
        @SerializedName("language")
        private String language;
        @SerializedName("translation")
        private String translation;

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getTranslation() {
            return translation;
        }

        public void setTranslation(String translation) {
            this.translation = translation;
        }

    }

    public static class ArtistAliasList {
        @SerializedName("artist_alias")
        private String artistAlias;

        public String getArtistAlias() {
            return artistAlias;
        }

        public void setArtistAlias(String artistAlias) {
            this.artistAlias = artistAlias;
        }
    }

    public static class ArtistCredits {
        @SerializedName("artist_list")
        private List<Artist_list> artist_list = null;

        public List<Artist_list> getArtist_list() {
            return artist_list;
        }

        public void setArtist_list(List<Artist_list> artist_list) {
            this.artist_list = artist_list;
        }
    }

    public static class ArtistNameTranslationList {
        @SerializedName("artist_name_translation")
        private Artist_name_translation artist_name_translation;

        public Artist_name_translation getArtist_name_translation() {
            return artist_name_translation;
        }

        public void setArtist_name_translation(Artist_name_translation artist_name_translation) {
            this.artist_name_translation = artist_name_translation;
        }
    }

    public static class Body {
        @SerializedName("artist_list")
        private List<Artist_list> artist_list = null;

        public List<Artist_list> getArtist_list() {
            return artist_list;
        }

        public void setArtist_list(List<Artist_list> artist_list) {
            this.artist_list = artist_list;
        }
    }

    public static class Header {
        @SerializedName("status_code")
        private Integer status_code;
        @SerializedName("execute_time")
        private Double execute_time;

        public Integer getStatus_code() {
            return status_code;
        }

        public void setStatus_code(Integer status_code) {
            this.status_code = status_code;
        }

        public Double getExecute_time() {
            return execute_time;
        }

        public void setExecute_time(Double execute_time) {
            this.execute_time = execute_time;
        }
    }

    public static class Message {
        @SerializedName("header")
        private Header header;
        @SerializedName("body")
        private Body body;

        public Header getHeader() {
            return header;
        }

        public void setHeader(Header header) {
            this.header = header;
        }

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }
    }

    public static class Music_genre {
        @SerializedName("music_genre_id")
        private Integer music_genre_id;
        @SerializedName("music_genre_parent_id")
        private Integer music_genre_parent_id;
        @SerializedName("music_genre_name")
        private String music_genre_name;
        @SerializedName("music_genre_name_extended")
        private String music_genre_name_extended;
        @SerializedName("music_genre_vanity")
        private String music_genre_vanity;

        public Integer getMusic_genre_id() {
            return music_genre_id;
        }

        public void setMusic_genre_id(Integer music_genre_id) {
            this.music_genre_id = music_genre_id;
        }

        public Integer getMusic_genre_parent_id() {
            return music_genre_parent_id;
        }

        public void setMusic_genre_parent_id(Integer music_genre_parent_id) {
            this.music_genre_parent_id = music_genre_parent_id;
        }

        public String getMusic_genre_name() {
            return music_genre_name;
        }

        public void setMusic_genre_name(String music_genre_name) {
            this.music_genre_name = music_genre_name;
        }

        public String getMusic_genre_name_extended() {
            return music_genre_name_extended;
        }

        public void setMusic_genre_name_extended(String music_genre_name_extended) {
            this.music_genre_name_extended = music_genre_name_extended;
        }

        public String getMusic_genre_vanity() {
            return music_genre_vanity;
        }

        public void setMusic_genre_vanity(String music_genre_vanity) {
            this.music_genre_vanity = music_genre_vanity;
        }
    }

    public static class Music_genre_list {
        @SerializedName("music_genre")
        private Music_genre music_genre;

        public Music_genre getMusic_genre() {
            return music_genre;
        }

        public void setMusic_genre(Music_genre music_genre) {
            this.music_genre = music_genre;
        }
    }

    public static class SecondaryGenres {
        @SerializedName("music_genre_list")
        private List<Music_genre_list> music_genre_list = null;

        public List<Music_genre_list> getMusic_genre_list() {
            return music_genre_list;
        }

        public void setMusic_genre_list(List<Music_genre_list> music_genre_list) {
            this.music_genre_list = music_genre_list;
        }

    }

    public static class PrimaryGenres {
        @SerializedName("music_genre_list")
        private List<Music_genre_list> music_genre_list = null;

        public List<Music_genre_list> getMusic_genre_list() {
            return music_genre_list;
        }

        public void setMusic_genre_list(List<Music_genre_list> music_genre_list) {
            this.music_genre_list = music_genre_list;
        }
    }
}
