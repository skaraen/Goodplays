package com.example.karaens.goodplays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResults extends AppCompatActivity {

    int flag;
    String element;
    ListView SearchList;
    static List<JsonTopTracks.Track> SList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        flag=getIntent().getIntExtra("flag",0);
        element=Main.sElement;
        SearchList=findViewById(R.id.SearchList);
        Api api=ApiClient.getClient().create(Api.class);
        Call<JsonTopTracks> call;

        if(flag==1)
            call = api.getByTrack(element, "desc", 100, Main.API_KEY);
        else
            call = api.getByArtist(element, "desc", 100, Main.API_KEY);

            call.enqueue(new Callback<JsonTopTracks>() {
                @Override
                public void onResponse(Call<JsonTopTracks> call, Response<JsonTopTracks> response) {
                    for (int i = 0; i < response.body().getMessage().getBody().getTrackList().size(); i++) {
                        SList.add(response.body().getMessage().getBody().getTrackList().get(i).getTrack());
                    }
                    if (SList.isEmpty())
                        Toast.makeText(getBaseContext(), "No matches found", Toast.LENGTH_LONG).show();
                    else {
                        TracksAdapter tracksAdapter = new TracksAdapter(getBaseContext(), R.layout.list_element, SList);
                        SearchList.setAdapter(tracksAdapter);
                    }
                }

                @Override
                public void onFailure(Call<JsonTopTracks> call, Throwable t) {
                    Toast.makeText(getBaseContext(), "Search Failed", Toast.LENGTH_LONG).show();
                }
            });

            SearchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(SearchResults.this, TrackSolo.class);
                    intent.putExtra("pos", position);
                    intent.putExtra("code", 2);
                    startActivity(intent);
                }
            });
        }
    }

