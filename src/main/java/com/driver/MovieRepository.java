package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDb=new HashMap<>();
    HashMap<String,Director> directorDb=new HashMap<>();
    HashMap<String,String> movieDirectorPair=new HashMap<>();
    public String addMovie(Movie movie){
        String key=movie.getName();
        movieDb.put(key,movie);
        return "Movie added successfully";
    }
    public String addDirector(Director director){
        String key=director.getName();
        directorDb.put(key,director);
        return "Director added successfully";
    }
    public String addMovieDirectorPair(String movieName,String directorName){
        movieDirectorPair.put(movieName,directorName);
        return "added successfully";
    }
    public Movie getMovieByName(String movieName){
        return movieDb.get(movieName);
    }
    public Director getDirectorByName(String directorName){
        return directorDb.get(directorName);
    }
    public List<Movie> getMoviesByDirectorName(String directorName) {
        List<Movie> movies=new ArrayList<>();
        for(String movie:movieDirectorPair.keySet()){
            if(movieDirectorPair.get(movie).equals(directorName)) {
                Movie movieObj=movieDb.get(movie);
                movies.add(movieObj);
            }
        }
        return movies;
    }
    public List<Movie> findAllMovies(){
        List<Movie> movies=new ArrayList<>();
        for(Movie movie:movieDb.values())
            movies.add(movie);
        return movies;
    }
    public String deleteDirectorByName(String directorName){
        directorDb.remove(directorName);
        for(String movie:movieDirectorPair.keySet()){
            if(movieDirectorPair.get(movie).equals(directorName)){
                movieDb.remove(movie);
                movieDirectorPair.remove(movie);
            }
        }
        return "Director records deleted";
    }
    public String deleteAllDirectors(){
        for(String director:directorDb.keySet()){
            directorDb.remove(director);
            for(String movie:movieDirectorPair.keySet()){
                if(movieDirectorPair.get(movie).equals(director)){
                    movieDb.remove(movie);
                    movieDirectorPair.remove(movie);
                }
            }
        }
        return "All records deleted";
    }
}
