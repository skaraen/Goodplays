package com.example.karaens.goodplays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Favorites extends AppCompatActivity {

    ListView FavList;
    int flag=1;
    Button fTracks,fArtists,reset,Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        FavList = findViewById(R.id.FavList);
        fTracks = findViewById(R.id.fTracks);
        fArtists = findViewById(R.id.fArtists);
        reset=findViewById(R.id.reset);
        Back=findViewById(R.id.Back);
        Main.restoreData(this);

        fTracksAdapter ftAdapter=new fTracksAdapter(this,R.layout.list_element,Main.FavTrackList);
        FavList.setAdapter(ftAdapter);

        fTracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fTracksAdapter ftAdapter=new fTracksAdapter(getBaseContext(),R.layout.list_element,Main.FavTrackList);
                FavList.setAdapter(ftAdapter);
                flag=1;
            }
        });

        fArtists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fArtistsAdapter faAdapter=new fArtistsAdapter(getBaseContext(),R.layout.list_element_artist,Main.FavArtistList);
                FavList.setAdapter(faAdapter);
                flag=2;
            }
        });
        FavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(flag ==1){
                    Intent intent=new Intent(Favorites.this,TrackSolo.class);
                    intent.putExtra("pos",position);
                    intent.putExtra("code",3);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(Favorites.this, ArtistSolo.class);
                    intent.putExtra("pos",position);
                    intent.putExtra("code",3);
                    startActivity(intent);
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDb=new DatabaseHelper(getBaseContext());
                myDb.resetData();
                Main.FavTrackList.clear();
                Main.FavArtistList.clear();
                startActivity(new Intent(Favorites.this,Favorites.class));
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Favorites.this,Main.class));
            }
        });
    }
}
