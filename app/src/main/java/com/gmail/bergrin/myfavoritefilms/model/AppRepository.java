package com.gmail.bergrin.myfavoritefilms.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AppRepository {
    private GenreDAO genreDAO;
    private MovieDAO movieDAO;
    private LiveData<List<Genre>> genres;
    private LiveData<List<Movie>> movies;

    public AppRepository(Application application) {
        MoviesDatabase database = MoviesDatabase.getInstance(application);
        genreDAO = database.getGenreDao();
        movieDAO = database.getMovieDao();
    }

    public LiveData<List<Genre>> getAllGenres() {
        return genreDAO.getAllGenres();
    }

    public LiveData<List<Movie>> getGenreMovies(int genreId) {
        return movieDAO.getGenreMovies(genreId);
    }

    /**
     *insert methods and async tasks
     */
    public void insertGenre(Genre genre) {
        new InsertGenreAsyncTask(genreDAO).execute(genre);
    }

    public void insertMovie(Movie movie) {
        new InsertMovieAsyncTask(movieDAO).execute(movie);
    }

    private static class InsertGenreAsyncTask extends AsyncTask<Genre, Void, Void> {

        private GenreDAO genreDAO;

        public InsertGenreAsyncTask(GenreDAO genreDAO) {
            this.genreDAO = genreDAO;
        }

        @Override
        protected Void doInBackground(Genre... genres) {
            genreDAO.insert(genres[0]);
            return null;
        }
    }

    private static class InsertMovieAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDAO movieDAO;

        public InsertMovieAsyncTask(MovieDAO movieDAO) {
            this.movieDAO = movieDAO;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDAO.insert(movies[0]);
            return null;
        }
    }

    /**
     *update methods and async tasks
     */
    public void updateGenre(Genre genre) {
        new UpdateGenreAsyncTask(genreDAO).execute(genre);
    }

    public void updateMovie(Movie movie) {
        new UpdateMovieAsyncTask(movieDAO).execute(movie);
    }

    private static class UpdateGenreAsyncTask extends AsyncTask<Genre, Void, Void> {

        private GenreDAO genreDAO;

        public UpdateGenreAsyncTask(GenreDAO genreDAO) {
            this.genreDAO = genreDAO;
        }

        @Override
        protected Void doInBackground(Genre... genres) {
            genreDAO.update(genres[0]);
            return null;
        }
    }

    private static class UpdateMovieAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDAO movieDAO;

        public UpdateMovieAsyncTask(MovieDAO movieDAO) {
            this.movieDAO = movieDAO;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDAO.update(movies[0]);
            return null;
        }
    }

    /**
     *delete methods and async tasks
     */
    public void deleteGenre(Genre genre) {
        new DeleteGenreAsyncTask(genreDAO).execute(genre);
    }

    public void deleteMovie(Movie movie) {
        new DeleteMovieAsyncTask(movieDAO).execute(movie);
    }

    private static class DeleteGenreAsyncTask extends AsyncTask<Genre, Void, Void> {

        private GenreDAO genreDAO;

        public DeleteGenreAsyncTask(GenreDAO genreDAO) {
            this.genreDAO = genreDAO;
        }

        @Override
        protected Void doInBackground(Genre... genres) {
            genreDAO.delete(genres[0]);
            return null;
        }
    }

    private static class DeleteMovieAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDAO movieDAO;

        public DeleteMovieAsyncTask(MovieDAO movieDAO) {
            this.movieDAO = movieDAO;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDAO.delete(movies[0]);
            return null;
        }
    }
}
