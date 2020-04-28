package com.bucket.mission3.controller;

import com.bucket.mission3.service.AppService;
import com.bucket.mission3.model.AppModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class AppController {

    @Autowired
    AppService movieService;

    @GetMapping()
    public List<AppModel> getMovie() {
        return movieService.getMovieList();
    }

    @GetMapping("/{id}")
    public List<AppModel> getOneMovie(@PathVariable Long id) {
        return movieService.getMovieById(id);    }

    @GetMapping("/lists/{title}")
    public List<AppModel> getMovieByTitle(@PathVariable String title) {
        return movieService.getMovieByTitle(title);    }

    @PostMapping()
    public List<AppModel> addMovie(@RequestBody AppModel body){
        movieService.addMovie(body);
        return movieService.getMovieList();    }

    @PutMapping("/{id}")
    public List<AppModel> updateMovie(@PathVariable Long id, @RequestBody AppModel body){
        movieService.updateMovie(id, body);
        return movieService.getMovieList();
    }


//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
//        if (movieService.deleteMovie(id) == 0) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
//        } else {
//            return ResponseEntity.ok().build();
//        }
//    }
    @DeleteMapping("/{id}")
    public List<AppModel> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return movieService.getMovieList();
    }
}