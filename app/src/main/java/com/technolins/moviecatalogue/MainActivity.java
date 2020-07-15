package com.technolins.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.technolins.moviecatalogue.adapter.MovieAdapter;
import com.technolins.moviecatalogue.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private MovieAdapter adapter;
    private String [] dataTitle,dataOverview,dataRelease,dataGenre,dataRevenue,dataBudget,dataRuntime,dataTopBilledCast,dataLanguage;
    private TypedArray dataPhoto;
    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);
        adapter = new MovieAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent moveToDetailMovies = new Intent(MainActivity.this,DetailActivity.class);

                moveToDetailMovies.putExtra(DetailActivity.EXTRA_MOVIES,adapter.getMovies().get(position));
                startActivity(moveToDetailMovies);
            }
        };
        listView.setOnItemClickListener(listener);
    }

    private void prepare(){
        dataTitle = getResources().getStringArray(R.array.data_name);
        dataOverview = getResources().getStringArray(R.array.data_overview);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataBudget = getResources().getStringArray(R.array.data_budget);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataRelease = getResources().getStringArray(R.array.data_release);
        dataRevenue = getResources().getStringArray(R.array.data_revenue);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataTopBilledCast = getResources().getStringArray(R.array.data_top_billed_cast);
        dataLanguage = getResources().getStringArray(R.array.data_language);
    }

    private void addItem(){
        movies = new ArrayList<>();

        for(int i=0; i < dataTitle.length; i++){
            Movie movie = new Movie();
            movie.setTitle(dataTitle[i]);
            movie.setOverview(dataOverview[i]);
            movie.setPhoto(dataPhoto.getResourceId(i,-1));
            movie.setBudget(dataBudget[i]);
            movie.setGenre(dataGenre[i]);
            movie.setReleasedDate(dataRelease[i]);
            movie.setRevenue(dataRevenue[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setTopBilledCast(dataTopBilledCast[i]);
            movie.setOriginalLanguage(dataLanguage[i]);
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }
}
