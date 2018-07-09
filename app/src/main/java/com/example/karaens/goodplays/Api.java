package com.example.karaens.goodplays;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("chart.tracks.get")
    Call<JsonTopTracks> getTracks(@Query("page_size") int pageSize,@Query("apikey") String apikey);

    @GET("chart.artists.get")
    Call<JsonTopArtists> getArtists(@Query("page_size") int pageSize,@Query("apikey") String apikey);

    @GET("track.lyrics.get")
    Call<JsonLyrics> getLyrics(@Query("track_id") int trackId,@Query("apikey") String apikey);

    @GET("track.search")
    Call<JsonTopTracks> getByTrack(@Query("q_track") String trackName,@Query("s_track_rating") String order,@Query("page_size") int pageSize,@Query("apikey") String apikey);

    @GET("track.search")
    Call<JsonTopTracks> getByArtist(@Query("q_artist") String trackName,@Query("s_track_rating") String order,@Query("page_size") int pageSize,@Query("apikey") String apikey);

}
