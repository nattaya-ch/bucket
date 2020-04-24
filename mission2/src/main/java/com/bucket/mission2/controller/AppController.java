package com.bucket.mission2.controller;

import com.bucket.mission2.model.AppModel;
import com.bucket.mission2.service.AppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private AppService cinemaService;

    //GET movie lists
    @GetMapping("/movie")
    public List<AppModel> allMovie() {
        return cinemaService.getMovieList();
    }

    //GET movie by id
    @GetMapping("/movie/{id}")
    public AppModel getMovieById(@PathVariable("id") String id) {
        return cinemaService.getMovie(id);
    }

    //GET movie by title using stream -> equals()
//    @GetMapping("/movie/title/{title}")
//    public AppModel getMovieByTitle(@PathVariable("title") String title) {
//        return cinemaService.getMovieByTitle(title);
//    }

    //GET movie by title using stream -> contains()
    @GetMapping("/movie/title/{title}")
    public AppModel getMovieByTitle(@PathVariable("title") String title) {
        return cinemaService.getMovieByTitleUsingStream(title);
    }

    //GET movie by title using iterator
    @GetMapping("/movie/title2/{title}")
    public AppModel getMovieByTitle2(@PathVariable("title") String title) {
        return cinemaService.getMovieByTitleUsingIterator(title, allMovie());
    }

    //POST method
    @PostMapping("/movie")
    public void addMovie(@RequestBody AppModel cinemaModel) {
        cinemaService.addMovie(cinemaModel);
    }

    //PUT method
    @PutMapping("/movie/{id}")
    public void updateMovie(@RequestBody AppModel cinemaModel, @PathVariable("id") String id) {
        cinemaService.updateMovie(cinemaModel, id);
    }

    //DELETE method
    @DeleteMapping("/movie/{id}")
    public void removeMovie(@PathVariable("id") String id) {
        cinemaService.removeMovie(id);
    }
}
