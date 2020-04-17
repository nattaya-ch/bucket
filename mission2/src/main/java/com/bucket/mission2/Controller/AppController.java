package com.bucket.mission2.Controller;

import com.bucket.mission2.Model.AppModel;
import com.bucket.mission2.Service.AppService;

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

    //GET movie by title
    @GetMapping("/movie/title/{title}")
    public AppModel getMovieByTitle(@PathVariable("title") String title) {
        return cinemaService.getMovieByTitle(title);
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
