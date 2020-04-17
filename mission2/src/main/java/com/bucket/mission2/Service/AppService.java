package com.bucket.mission2.Service;

import com.bucket.mission2.Model.AppModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service

public class AppService {
    private List<AppModel> movieList = new ArrayList<>(Arrays.asList(

            new AppModel("1","Saw","James wan","Horror","2004"),
            new AppModel("2","The Aeronauts","Tom Harper","Action","2019"),
            new AppModel("3","Titanic","James Cameron","Romantic","1997")

    ));

    public List<AppModel> getMovieList() {
        return movieList;
    }

    public AppModel getMovie(String id) {
        return movieList.stream().filter(movie -> movie.getId().equals(id)).findFirst().get();
    }

    public AppModel getMovieByTitle(String title) {
        return movieList.stream().filter(movie -> movie.getTitle().equals(title)).findFirst().get();
    }

    public void addMovie(AppModel cinemaModel) {
        movieList.add(cinemaModel);

    }
    public void updateMovie(AppModel cinemaModel, String id) {
        int counter = 0;
        for (AppModel cinemaModel1 : movieList) {
            if (cinemaModel1.getId().equals(id)) {
                movieList.set(counter, cinemaModel);
            }
            counter++;
        }

    }

    public void removeMovie(String id) {
        movieList.removeIf(cinemaModel -> cinemaModel.getId().equals(id));
    }


}
