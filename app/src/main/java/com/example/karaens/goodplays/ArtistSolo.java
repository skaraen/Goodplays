package com.example.karaens.goodplays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ArtistSolo extends AppCompatActivity {

    TextView asArtist,asCountry,asRating,asGenre;
    JsonTopArtists.Artist Solo;
    Button asFavs;
    int pos,code;
    int fcode=0;
    fArtist artist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_solo);
        pos=getIntent().getIntExtra("pos",0);
        code=getIntent().getIntExtra("code",0);

        asArtist=findViewById(R.id.asArtist);
        asCountry=findViewById(R.id.asCountry);
        asGenre=findViewById(R.id.asGenre);
        asRating=findViewById(R.id.asRating);
        asFavs=findViewById(R.id.asFavs);
        if(code==1) {
            Solo = Main.ArtistList.get(pos);

            if (findFavArtist(Solo.getArtistId()) != -1) {
                fcode = 1;
                asFavs.setText("Remove from\nFavourites");
            }

            asArtist.setText(Solo.getArtistName());
            asCountry.setText(Solo.getArtistCountry());
            asRating.setText(String.valueOf(Solo.getArtistRating()));
            if (Solo.getPrimaryGenres().getMusic_genre_list().isEmpty()) {
                asGenre.setText("NIL");
            } else {
                String Genres = "";
                for (int i = 0; i < Solo.getPrimaryGenres().getMusic_genre_list().size(); i++) {
                    if (i == 0) {
                        Genres = Genres.concat(Solo.getPrimaryGenres().getMusic_genre_list().get(i).getMusic_genre().getMusic_genre_name());
                    } else
                        Genres = Genres.concat("/" + Solo.getPrimaryGenres().getMusic_genre_list().get(i).getMusic_genre().getMusic_genre_name());
                }
                asGenre.setText(Genres);
            }

        }
        else {
            artist=Main.FavArtistList.get(pos);
            asArtist.setText(artist.ArtistName);
            asCountry.setText(artist.getCountry());
            asGenre.setText(artist.getGenre());
            asRating.setText(artist.getRating());
            asFavs.setText("Remove from\nFavourites");
        }
        asFavs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Solo==null) {
                    DatabaseHelper myDb=new DatabaseHelper(getBaseContext());
                    if(myDb.deleteArtist(artist.ArtistId)>0) {
                        Main.FavArtistList.remove(pos);
                        startActivity(new Intent(ArtistSolo.this,Favorites.class));
                    }
                } else {
                    if (fcode == 0) {
                        DatabaseHelper myDb = new DatabaseHelper(getBaseContext());
                        if (myDb.addArtist(Solo.getArtistId(), Solo.getArtistName(), Solo.getArtistCountry(), asGenre.getText().toString(),
                                Solo.getArtistRating().toString())) {
                            Toast.makeText(getBaseContext(), "Added to Favourites", Toast.LENGTH_LONG).show();
                            fArtist artist = new fArtist(Solo.getArtistName(), Solo.getArtistCountry(), asGenre.getText().toString(),
                                    Solo.getArtistRating().toString(), Solo.getArtistId());
                            Main.FavArtistList.add(artist);
                            fcode = 1;
                            asFavs.setText("Remove from\nFavourites");
                        } else
                            Toast.makeText(getBaseContext(), "Problem encountered", Toast.LENGTH_LONG).show();
                    } else {
                        DatabaseHelper myDb = new DatabaseHelper(getBaseContext());
                        if (findFavArtist(Solo.getArtistId()) != -1) {
                            if (myDb.deleteArtist(Solo.getArtistId()) > 0) {
                                Toast.makeText(getBaseContext(), "Removed from favorites", Toast.LENGTH_LONG).show();
                                fcode = 0;
                                Main.FavArtistList.remove(findFavArtist(Solo.getArtistId()));
                                asFavs.setText("Add to\nFavourites");
                            } else
                                Toast.makeText(getBaseContext(), "Problem encountered", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });


    }

    int findFavArtist(int ArtistId){
        int p=-1;
        for(int i=0;i<Main.FavArtistList.size();i++){
            if(Main.FavArtistList.get(i).getArtistId()==ArtistId){
                p=i;
                break;
            }
        }
        return p;
    }
}
