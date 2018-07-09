package com.example.karaens.goodplays;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main extends AppCompatActivity {

    static String API_KEY="d779882d6782b9fddab3a87acf460c7a";
    Api api = ApiClient.getClient().create(Api.class);
    ListView TopList;
    static List<fTrack> FavTrackList=new ArrayList<>();
    static List<fArtist> FavArtistList=new ArrayList<>();
    static List<JsonTopTracks.Track> TrackList=new ArrayList<>();
    static List<JsonTopArtists.Artist> ArtistList=new ArrayList<>();
    Button buttonTracks,buttonArtists,buttonSearch1,buttonSearch2,buttonFavourites;
    EditText SearchElement;
    int flag=1;
    static String sElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonTracks=findViewById(R.id.buttonTracks);
        buttonArtists=findViewById(R.id.buttonArtists);
        buttonFavourites=findViewById(R.id.buttonFavorites);
        buttonSearch1=findViewById(R.id.buttonSearch1);
        buttonSearch2=findViewById(R.id.buttonSearch2);
        SearchElement=findViewById(R.id.Search_element);
        TopList = findViewById(R.id.TopList);
        buttonTracks.setEnabled(false);
        setTopTracks();
        restoreData(this);

        TopList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(flag==1){
                    Intent intent=new Intent(Main.this,TrackSolo.class);
                    intent.putExtra("pos",position);
                    intent.putExtra("code",1);
                    startActivity(intent);
                }
                else {
                    Intent intent=new Intent(Main.this,ArtistSolo.class);
                    intent.putExtra("pos",position);
                    intent.putExtra("code",1);
                    startActivity(intent);
                }
            }
        });

        buttonSearch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SearchElement.getText()!=null) {
                    Intent intent = new Intent(Main.this, SearchResults.class);
                    intent.putExtra("flag", 1);
                    sElement=SearchElement.getText().toString();
                    startActivity(intent);
                }
                else
                Toast.makeText(getBaseContext(),"Search Field cannot be empty",Toast.LENGTH_LONG).show();
            }
        });

        buttonSearch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SearchElement.getText()!=null) {
                    Intent intent = new Intent(Main.this, SearchResults.class);
                    intent.putExtra("flag", 2);
                    sElement=SearchElement.getText().toString();
                    startActivity(intent);
                }
                else
                Toast.makeText(getBaseContext(),"Search Field cannot be empty",Toast.LENGTH_LONG).show();
            }
        });

        buttonTracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonArtists.setEnabled(true);
                buttonTracks.setEnabled(false);
                flag=1;
                setTopTracks();
            }
        });
        buttonArtists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonArtists.setEnabled(false);
                buttonTracks.setEnabled(true);
                flag=2;
                setTopArtists();
            }
        });
        buttonFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main.this,Favorites.class));
            }
        });

    }

    void setTopTracks()
    {
        Call<JsonTopTracks> call=api.getTracks(100,API_KEY);
        call.enqueue(new Callback<JsonTopTracks>() {
            @Override
            public void onResponse(Call<JsonTopTracks> call, Response<JsonTopTracks> response) {
                Log.d("tag","a");
                if(response.body().getMessage().getBody().getTrackList()==null)
                    Log.d("tag","null array");
                else {
                    Log.d("tag", String.valueOf(response.body().getMessage().getBody().getTrackList().size()));
                    for(int i=0;i<response.body().getMessage().getBody().getTrackList().size();i++){
                        TrackList.add(response.body().getMessage().getBody().getTrackList().get(i).getTrack());
                    }
                        TracksAdapter tracksAdapter = new TracksAdapter(getBaseContext(), R.layout.list_element, TrackList);
                        TopList.setAdapter(tracksAdapter);
                }
            }

            @Override
            public void onFailure(Call<JsonTopTracks> call, Throwable t) {
                Log.d("tag","b");
            }
        });
    }

    void setTopArtists(){
        Call<JsonTopArtists> call=api.getArtists(100,API_KEY);
        call.enqueue(new Callback<JsonTopArtists>() {
            @Override
            public void onResponse(Call<JsonTopArtists> call, Response<JsonTopArtists> response) {
                Log.d("tag","a");
                if(response.body().getMessage().getBody().getArtist_list()==null)
                    Log.d("tag","null array");
                else {
                    for(int i=0;i<response.body().getMessage().getBody().getArtist_list().size();i++){
                        ArtistList.add(response.body().getMessage().getBody().getArtist_list().get(i).getArtist());
                    }
                    ArtistsAdapter artistsAdapter=new ArtistsAdapter(getBaseContext(),R.layout.list_element_artist,ArtistList);
                    TopList.setAdapter(artistsAdapter);
                }
            }

            @Override
            public void onFailure(Call<JsonTopArtists> call, Throwable t) {
                Log.d("tag","b");
            }
        });
    }

    static void restoreData(Context context) {
        if (FavTrackList.isEmpty() || FavArtistList.isEmpty()) {
            DatabaseHelper myDb = new DatabaseHelper(context);
            FavTrackList.clear();
            FavArtistList.clear();
            Cursor trackRes = myDb.getTrack();
            while (trackRes.moveToNext()) {
               fTrack track=new fTrack(trackRes.getString(2),trackRes.getString(3),trackRes.getString(4),
                       trackRes.getString(5),trackRes.getString(6),trackRes.getString(7),trackRes.getInt(1));
               FavTrackList.add(track);
            }
            Cursor artistRes=myDb.getArtist();
            while(artistRes.moveToNext()){
                fArtist artist=new fArtist(artistRes.getString(2),artistRes.getString(3),artistRes.getString(4),
                        artistRes.getString(5),artistRes.getInt(1));
                FavArtistList.add(artist);
            }
            Toast.makeText(context,"Data updated",Toast.LENGTH_LONG).show();
        }
    }
}
