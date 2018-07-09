package com.example.karaens.goodplays;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class JsonTopTracks {
    @SerializedName("message")
    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    static class PrimaryGenres {

        @SerializedName("music_genre_list")
        private List<MusicGenreList> musicGenreList = new ArrayList<>();

        public List<MusicGenreList> getMusicGenreList() {
            return musicGenreList;
        }

        public void setMusicGenreList(List<MusicGenreList> musicGenreList) {
            this.musicGenreList = musicGenreList;
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

    static class SecondaryGenres {

        @SerializedName("music_genre_list")
        private List<MusicGenreList> musicGenreList = new ArrayList<>();

        public List<MusicGenreList> getMusicGenreList() {
            return musicGenreList;
        }

        public void setMusicGenreList(List<MusicGenreList> musicGenreList) {
            this.musicGenreList = musicGenreList;
        }

    }

    static class MusicGenre {

        @SerializedName("music_genre_id")
        private Integer musicGenreId;
        @SerializedName("music_genre_parent_id")
        private Integer musicGenreParentId;
        @SerializedName("music_genre_name")
        private String musicGenreName;
        @SerializedName("music_genre_name_extended")
        private String musicGenreNameExtended;
        @SerializedName("music_genre_vanity")
        private String musicGenreVanity;

        public Integer getMusicGenreId() {
            return musicGenreId;
        }

        public void setMusicGenreId(Integer musicGenreId) {
            this.musicGenreId = musicGenreId;
        }

        public Integer getMusicGenreParentId() {
            return musicGenreParentId;
        }

        public void setMusicGenreParentId(Integer musicGenreParentId) {
            this.musicGenreParentId = musicGenreParentId;
        }

        public String getMusicGenreName() {
            return musicGenreName;
        }

        public void setMusicGenreName(String musicGenreName) {
            this.musicGenreName = musicGenreName;
        }

        public String getMusicGenreNameExtended() {
            return musicGenreNameExtended;
        }

        public void setMusicGenreNameExtended(String musicGenreNameExtended) {
            this.musicGenreNameExtended = musicGenreNameExtended;
        }

        public String getMusicGenreVanity() {
            return musicGenreVanity;
        }

        public void setMusicGenreVanity(String musicGenreVanity) {
            this.musicGenreVanity = musicGenreVanity;
        }


    }

    static class MusicGenreList {

        @SerializedName("music_genre")
        private MusicGenre musicGenre=new MusicGenre();

        public MusicGenre getMusicGenre() {
            return musicGenre;
        }

        public void setMusicGenre(MusicGenre musicGenre) {
            this.musicGenre = musicGenre;
        }

    }

    public static class Track {
        @SerializedName("track_id")
        private Integer trackId;
        @SerializedName("track_mbid")
        private String trackMbid;
        @SerializedName("track_isrc")
        private String trackIsrc;
        @SerializedName("track_spotify_id")
        private String trackSpotifyId;
        @SerializedName("track_soundcloud_id")
        private String trackSoundcloudId;
        @SerializedName("track_xboxmusic_id")
        private String trackXboxmusicId;
        @SerializedName("track_name")
        private String trackName;
        @SerializedName("track_name_translation_list")
        private List<Object> trackNameTranslationList = new ArrayList<>();
        @SerializedName("track_rating")
        private Integer trackRating;
        @SerializedName("track_length")
        private Integer trackLength;
        @SerializedName("commontrack_id")
        private Integer commontrackId;
        @SerializedName("instrumental")
        private Integer instrumental;
        @SerializedName("explicit")
        private Integer explicit;
        @SerializedName("has_lyrics")
        private Integer hasLyrics;
        @SerializedName("has_lyrics_crowd")
        private Integer hasLyricsCrowd;
        @SerializedName("has_subtitles")
        private Integer hasSubtitles;
        @SerializedName("has_richsync")
        private Integer hasRichsync;
        @SerializedName("num_favourite")
        private Integer numFavourite;
        @SerializedName("lyrics_id")
        private Integer lyricsId;
        @SerializedName("subtitle_id")
        private Integer subtitleId;
        @SerializedName("album_id")
        private Integer albumId;
        @SerializedName("album_name")
        private String albumName;
        @SerializedName("artist_id")
        private Integer artistId;
        @SerializedName("artist_mbid")
        private String artistMbid;
        @SerializedName("artist_name")
        private String artistName;
        @SerializedName("album_coverart_100x100")
        private String albumCoverart100x100;
        @SerializedName("album_coverart_350x350")
        private String albumCoverart350x350;
        @SerializedName("album_coverart_500x500")
        private String albumCoverart500x500;
        @SerializedName("album_coverart_800x800")
        private String albumCoverart800x800;
        @SerializedName("track_share_url")
        private String trackShareUrl;
        @SerializedName("track_edit_url")
        private String trackEditUrl;
        @SerializedName("commontrack_vanity_id")
        private String commontrackVanityId;
        @SerializedName("restricted")
        private Integer restricted;
        @SerializedName("first_release_date")
        private String firstReleaseDate;
        @SerializedName("updated_time")
        private String updatedTime;
        @SerializedName("primary_genres")
        private PrimaryGenres primaryGenres=new PrimaryGenres();
        @SerializedName("secondary_genres")
        private SecondaryGenres secondaryGenres=new SecondaryGenres();

        public Integer getTrackId() {
            return trackId;
        }

        public void setTrackId(Integer trackId) {
            this.trackId = trackId;
        }

        public String getTrackMbid() {
            return trackMbid;
        }

        public void setTrackMbid(String trackMbid) {
            this.trackMbid = trackMbid;
        }

        public String getTrackIsrc() {
            return trackIsrc;
        }

        public void setTrackIsrc(String trackIsrc) {
            this.trackIsrc = trackIsrc;
        }

        public String getTrackSpotifyId() {
            return trackSpotifyId;
        }

        public void setTrackSpotifyId(String trackSpotifyId) {
            this.trackSpotifyId = trackSpotifyId;
        }

        public String getTrackSoundcloudId() {
            return trackSoundcloudId;
        }

        public void setTrackSoundcloudId(String trackSoundcloudId) {
            this.trackSoundcloudId = trackSoundcloudId;
        }

        public String getTrackXboxmusicId() {
            return trackXboxmusicId;
        }

        public void setTrackXboxmusicId(String trackXboxmusicId) {
            this.trackXboxmusicId = trackXboxmusicId;
        }

        public String getTrackName() {
            return trackName;
        }

        public void setTrackName(String trackName) {
            this.trackName = trackName;
        }

        public List<Object> getTrackNameTranslationList() {
            return trackNameTranslationList;
        }

        public void setTrackNameTranslationList(List<Object> trackNameTranslationList) {
            this.trackNameTranslationList = trackNameTranslationList;
        }

        public Integer getTrackRating() {
            return trackRating;
        }

        public void setTrackRating(Integer trackRating) {
            this.trackRating = trackRating;
        }

        public Integer getTrackLength() {
            return trackLength;
        }

        public void setTrackLength(Integer trackLength) {
            this.trackLength = trackLength;
        }

        public Integer getCommontrackId() {
            return commontrackId;
        }

        public void setCommontrackId(Integer commontrackId) {
            this.commontrackId = commontrackId;
        }

        public Integer getInstrumental() {
            return instrumental;
        }

        public void setInstrumental(Integer instrumental) {
            this.instrumental = instrumental;
        }

        public Integer getExplicit() {
            return explicit;
        }

        public void setExplicit(Integer explicit) {
            this.explicit = explicit;
        }

        public Integer getHasLyrics() {
            return hasLyrics;
        }

        public void setHasLyrics(Integer hasLyrics) {
            this.hasLyrics = hasLyrics;
        }

        public Integer getHasLyricsCrowd() {
            return hasLyricsCrowd;
        }

        public void setHasLyricsCrowd(Integer hasLyricsCrowd) {
            this.hasLyricsCrowd = hasLyricsCrowd;
        }

        public Integer getHasSubtitles() {
            return hasSubtitles;
        }

        public void setHasSubtitles(Integer hasSubtitles) {
            this.hasSubtitles = hasSubtitles;
        }

        public Integer getHasRichsync() {
            return hasRichsync;
        }

        public void setHasRichsync(Integer hasRichsync) {
            this.hasRichsync = hasRichsync;
        }

        public Integer getNumFavourite() {
            return numFavourite;
        }

        public void setNumFavourite(Integer numFavourite) {
            this.numFavourite = numFavourite;
        }

        public Integer getLyricsId() {
            return lyricsId;
        }

        public void setLyricsId(Integer lyricsId) {
            this.lyricsId = lyricsId;
        }

        public Integer getSubtitleId() {
            return subtitleId;
        }

        public void setSubtitleId(Integer subtitleId) {
            this.subtitleId = subtitleId;
        }

        public Integer getAlbumId() {
            return albumId;
        }

        public void setAlbumId(Integer albumId) {
            this.albumId = albumId;
        }

        public String getAlbumName() {
            return albumName;
        }

        public void setAlbumName(String albumName) {
            this.albumName = albumName;
        }

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

        public String getAlbumCoverart100x100() {
            return albumCoverart100x100;
        }

        public void setAlbumCoverart100x100(String albumCoverart100x100) {
            this.albumCoverart100x100 = albumCoverart100x100;
        }

        public String getAlbumCoverart350x350() {
            return albumCoverart350x350;
        }

        public void setAlbumCoverart350x350(String albumCoverart350x350) {
            this.albumCoverart350x350 = albumCoverart350x350;
        }

        public String getAlbumCoverart500x500() {
            return albumCoverart500x500;
        }

        public void setAlbumCoverart500x500(String albumCoverart500x500) {
            this.albumCoverart500x500 = albumCoverart500x500;
        }

        public String getAlbumCoverart800x800() {
            return albumCoverart800x800;
        }

        public void setAlbumCoverart800x800(String albumCoverart800x800) {
            this.albumCoverart800x800 = albumCoverart800x800;
        }

        public String getTrackShareUrl() {
            return trackShareUrl;
        }

        public void setTrackShareUrl(String trackShareUrl) {
            this.trackShareUrl = trackShareUrl;
        }

        public String getTrackEditUrl() {
            return trackEditUrl;
        }

        public void setTrackEditUrl(String trackEditUrl) {
            this.trackEditUrl = trackEditUrl;
        }

        public String getCommontrackVanityId() {
            return commontrackVanityId;
        }

        public void setCommontrackVanityId(String commontrackVanityId) {
            this.commontrackVanityId = commontrackVanityId;
        }

        public Integer getRestricted() {
            return restricted;
        }

        public void setRestricted(Integer restricted) {
            this.restricted = restricted;
        }

        public String getFirstReleaseDate() {
            return firstReleaseDate;
        }

        public void setFirstReleaseDate(String firstReleaseDate) {
            this.firstReleaseDate = firstReleaseDate;
        }

        public String getUpdatedTime() {
            return updatedTime;
        }

        public void setUpdatedTime(String updatedTime) {
            this.updatedTime = updatedTime;
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
    }

    public static class TrackCapsule {
        @SerializedName("track")
        private Track track=new Track();

        public Track getTrack() {
            return track;
        }

        public void setTrack(Track track) {
            this.track = track;
        }
    }

    public static class Header {
        @SerializedName("status_code")
        private Integer statusCode;
        @SerializedName("execute_time")
        private Double executeTime;

        public Integer getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(Integer statusCode) {
            this.statusCode = statusCode;
        }

        public Double getExecuteTime() {
            return executeTime;
        }

        public void setExecuteTime(Double executeTime) {
            this.executeTime = executeTime;
        }
    }

    public static class Body {
        @SerializedName("track_list")
        private List<TrackCapsule> trackList=new ArrayList<>();

        public List<TrackCapsule> getTrackList() {
            return trackList;
        }

        public void setTrackList(List<TrackCapsule> trackList) {
            this.trackList = trackList;
        }
    }
}
