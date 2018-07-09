package com.example.karaens.goodplays;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class fTracksAdapter extends ArrayAdapter<fTrack>{
    int mResource;
    Context mContext;
    String TrackName,AlbumName,AlbumCover;
    TextView textAlbum,textTrack;

    public fTracksAdapter(@NonNull Context context, int resource, @NonNull List<fTrack> objects) {
        super(context, resource, objects);
        mResource = resource;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TrackName = getItem(position).getTrackName();
        AlbumName = getItem(position).getAlbumName();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (convertView == null) {
            convertView = inflater.inflate(mResource, parent, false);
        }

        textTrack = convertView.findViewById(R.id.TrackTitle);
        textAlbum = convertView.findViewById(R.id.AlbumTitle);

        textTrack.setText(TrackName);
        textAlbum.setText(AlbumName);

        return convertView;
    }
}
