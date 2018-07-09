package com.example.karaens.goodplays;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class fArtistsAdapter extends ArrayAdapter<fArtist>{
    int mResource;
    Context mContext;
    String ArtistName;
    TextView textArtist;

    public fArtistsAdapter(@NonNull Context context, int resource, @NonNull List<fArtist> objects) {
        super(context, resource, objects);
        mResource = resource;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ArtistName=getItem(position).getArtistName();
        LayoutInflater inflater=LayoutInflater.from(mContext);
        if(convertView==null){
            convertView=inflater.inflate(mResource,parent,false);
        }
        textArtist=convertView.findViewById(R.id.textArtist);
        textArtist.setText(ArtistName);

        return  convertView;
    }
}
