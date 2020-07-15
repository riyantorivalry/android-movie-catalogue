package com.technolins.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.technolins.moviecatalogue.model.Movie;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIES ="extra_movies";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView img = findViewById(R.id.img_photo);
        TextView tvTitle = findViewById(R.id.data_detail_title);
        TextView tvRelease = findViewById(R.id.data_detail_releasedate);
        TextView tvLanguage = findViewById(R.id.data_detail_language);
        TextView tvGenre = findViewById(R.id.data_detail_genre);
        TextView tvRuntime = findViewById(R.id.data_detail_runtime);
        TextView tvRevenue = findViewById(R.id.data_detail_revenue);
        TextView tvBudget = findViewById(R.id.data_detail_budget);
        TextView tvOverview = findViewById(R.id.data_detail_overview);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIES);
        img.setImageResource(movie.getPhoto());
        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());
        tvBudget.setText(movie.getBudget());
        tvGenre.setText(movie.getGenre());
        tvLanguage.setText(movie.getOriginalLanguage());
        tvRelease.setText(movie.getReleasedDate());
        tvRevenue.setText(movie.getRevenue());
        tvRuntime.setText(movie.getRuntime());

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Detail Movie Catalogue");
        }
    }
}
