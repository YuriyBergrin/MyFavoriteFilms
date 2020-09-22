package com.gmail.bergrin.myfavoritefilms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gmail.bergrin.myfavoritefilms.databinding.ActivityAddEditBinding;
import com.gmail.bergrin.myfavoritefilms.model.Movie;

import javax.xml.transform.Result;

public class AddEditActivity extends AppCompatActivity {

    private Movie movie;
    public static final String MOVIE_ID = "movieId";
    public static final String MOVIE_NAME = "movieName";
    public static final String MOVIE_DESCRIPTION = "movieDescription";
    private ActivityAddEditBinding activityAddEditBinding;
    private AddEditActivityClickHandler addEditActivityClickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        movie = new Movie();
        activityAddEditBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_edit);
        activityAddEditBinding.setMovie(movie);
        addEditActivityClickHandler = new AddEditActivityClickHandler(this);
        activityAddEditBinding.setClickHandlers(addEditActivityClickHandler);

        Intent intent = getIntent();

        if (intent.hasExtra(MOVIE_ID)) {
            setTitle("Edit Movie");
            movie.setMovieName(intent.getStringExtra(MOVIE_NAME));
            movie.setMovieDescription(intent.getStringExtra(MOVIE_DESCRIPTION));
        } else {
            setTitle("Add Movie");
        }
    }

    public class AddEditActivityClickHandler {
        Context context;

        public AddEditActivityClickHandler(Context context) {
            this.context = context;
        }

        public void onOkButtonClicked(View view) {
            if (movie.getMovieName() == null) {
                Toast.makeText(context, "Please input the name", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent();
                intent.putExtra(MOVIE_NAME, movie.getMovieName());
                intent.putExtra(MOVIE_DESCRIPTION, movie.getMovieDescription());
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}