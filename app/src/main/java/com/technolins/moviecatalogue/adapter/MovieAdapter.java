package com.technolins.moviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.technolins.moviecatalogue.R;
import com.technolins.moviecatalogue.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private List<Movie> movies = new ArrayList<>();;

    public MovieAdapter() {
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);
        Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);
        return itemView;
    }

    private class ViewHolder{
        private TextView txtTitle;
        private TextView txtOverview;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.text_title);
            txtOverview = view.findViewById(R.id.text_overview);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Movie movie){
            txtTitle.setText(movie.getTitle());
            txtOverview.setText(movie.getOverview());
            imgPhoto.setImageResource(movie.getPhoto());
        }
    }
}
