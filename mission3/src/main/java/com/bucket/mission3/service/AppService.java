package com.bucket.mission3.service;

import com.bucket.mission3.repository.AppRepository;
import com.bucket.mission3.model.AppModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    @Autowired
    AppRepository repo = new AppRepository();

    public List<AppModel> getMovieList() {
        return repo.selectAll();
    }

    public List<AppModel> getMovieById(Long id) {
        return repo.selectOne(id);
    }

    public List<AppModel> getMovieByTitle(String title) {
        return repo.selectByTitle(title);
    }

    public int addMovie(AppModel movie) {
        return repo.addNewMovie(movie);
    }

    public int updateMovie(Long id, AppModel movie) {
        return repo.updateNewMovie(id, movie);
    }

    public int deleteMovie(Long id) {
        return repo.deleteExistMovie(id);
    }
}
