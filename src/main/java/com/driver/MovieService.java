package com.driver;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie){
        String ans=movieRepository.addMovie(movie);
        return ans;
    }
    public String addDirector(Director director){
        String ans=movieRepository.addDirector(director);
        return ans;
    }
    public String addMovieDirectorPair(String movieName,String directorName){
        String ans=movieRepository.addMovieDirectorPair(movieName,directorName);
        return ans;
    }
    public Movie getMovieByName(String movieName){
        Movie movie=movieRepository.getMovieByName(movieName);
        return movie;
    }
    public Director getDirectorByName(String directorName){
        Director director=movieRepository.getDirectorByName(directorName);
        return director;
    }
    public List<Movie> getMoviesByDirectorName(String directorName){
        List<Movie> movies=movieRepository.getMoviesByDirectorName(directorName);
        return movies;
    }
    public List<Movie> findAllMovies(){
        List<Movie> movies=movieRepository.findAllMovies();
        return movies;
    }
    public String deleteDirectorByName(String directorName){
        String ans=movieRepository.deleteDirectorByName(directorName);
        return ans;
    }
    public String deleteAllDirectors(){
        String ans=movieRepository.deleteAllDirectors();
        return ans;
    }
}
