package com.example.karaens.goodplays;

import android.content.Intent;
import android.renderscript.Script;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackSolo extends AppCompatActivity {

    int pos,code;
    int fcode=0,fpos;
    TextView tsTrack,tsAlbum,tsYear,tsArtist,tsGenre,tsLyrics;
    Button tsFavs;
    JsonTopTracks.Track Solo;
    ImageView TrackCover;
    fTrack track;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_solo);
        pos=getIntent().getIntExtra("pos",0);
        code=getIntent().getIntExtra("code",0);
        tsTrack=findViewById(R.id.tsTrack);
        tsAlbum=findViewById(R.id.tsAlbum);
        tsArtist=findViewById(R.id.tsArtist);
        tsYear=findViewById(R.id.tsYear);
        tsGenre=findViewById(R.id.tsGenre);
        tsLyrics=findViewById(R.id.tsLyrics);
        TrackCover=findViewById(R.id.TrackCover);
        tsFavs=findViewById(R.id.tsFavs);

        if(code==3){
            track=Main.FavTrackList.get(pos);
            tsTrack.setText(track.getTrackName());
            tsAlbum.setText(track.getAlbumName());
            tsArtist.setText(track.getArtistName());
            tsYear.setText(track.getArtistName());
            tsGenre.setText(track.getGenre());
            tsLyrics.setText(track.getLyrics());
            tsFavs.setText("Remove from\nFavourites");
        }
        else {
            if (code == 1)
                Solo = Main.TrackList.get(pos);
            else if (code == 2)
                Solo = SearchResults.SList.get(pos);

            if (findFavTrack(Solo.getTrackId()) != -1) {
                fcode = 1;
                tsFavs.setText("Remove from\nFavourites");
            }

            tsTrack.setText(Solo.getTrackName());
            tsAlbum.setText(Solo.getAlbumName());
            tsArtist.setText(Solo.getArtistName());
            tsYear.setText(Solo.getFirstReleaseDate().substring(0, 10));
            Picasso.get().load(Solo.getAlbumCoverart100x100()).into(TrackCover);
            if (Solo.getPrimaryGenres().getMusicGenreList().isEmpty())
                tsGenre.setText("NIL");
            else
                tsGenre.setText(Solo.getPrimaryGenres().getMusicGenreList().get(0).getMusicGenre().getMusicGenreName());
            if (Solo.getHasLyrics() == 1) {
                Api api = ApiClient.getClient().create(Api.class);
                Call<JsonLyrics> call = api.getLyrics(Solo.getTrackId(), Main.API_KEY);
                call.enqueue(new Callback<JsonLyrics>() {
                    @Override
                    public void onResponse(Call<JsonLyrics> call, Response<JsonLyrics> response) {
                        tsLyrics.setText(response.body().getMessage().getBody().getLyrics().getLyrics_body().substring(0, response.body().getMessage().getBody().getLyrics().getLyrics_body().length() - 70));
                    }

                    @Override
                    public void onFailure(Call<JsonLyrics> call, Throwable t) {
                        tsLyrics.setText("Lyrics Available");
                    }
                });
            }
        }

            tsFavs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Solo==null) {
                        DatabaseHelper myDb = new DatabaseHelper(getBaseContext());
                        if (myDb.deleteTrack(track.getTrackId()) > 0) {
                            Main.FavTrackList.remove(pos);
                            startActivity(new Intent(TrackSolo.this,Favorites.class));
                        }
                    }
                        else
                            {
                            if (fcode == 0)
                            {
                                DatabaseHelper myDb = new DatabaseHelper(getBaseContext());
                                if (myDb.addTrack(Solo.getTrackId(), tsTrack.getText().toString(), tsAlbum.getText().toString(), tsArtist.getText().toString(),
                                        tsYear.getText().toString(), tsGenre.getText().toString(), tsLyrics.getText().toString())) {
                                    fTrack track = new fTrack(tsTrack.getText().toString(), tsAlbum.getText().toString(), tsArtist.getText().toString(),
                                            tsYear.getText().toString(), tsGenre.getText().toString(), tsLyrics.getText().toString(), Solo.getTrackId());
                                    Main.FavTrackList.add(track);
                                    fcode = 1;
                                    tsFavs.setText("Remove from\nFavourites");
                                } else
                                    Toast.makeText(getBaseContext(), "Problem encountered", Toast.LENGTH_LONG).show();
                            }
                            else {
                                DatabaseHelper myDb = new DatabaseHelper(getBaseContext());
                                if (findFavTrack(Solo.getTrackId()) != -1) {
                                    if (myDb.deleteTrack(Solo.getTrackId()) > 0) {
                                        Main.FavTrackList.remove(findFavTrack(Solo.getTrackId()));
                                        fcode = 0;
                                        tsFavs.setText("Add to\nFavourites");
                                    }
                                }
                            }

                        }
                }
            });


    }

    int findFavTrack(int TrackId){
        int p=-1;
        for(int i=0;i<Main.FavTrackList.size();i++){
            if(Main.FavTrackList.get(i).getTrackId()==TrackId){
                p=i;
                break;
            }
        }
        return p;
    }
    }
