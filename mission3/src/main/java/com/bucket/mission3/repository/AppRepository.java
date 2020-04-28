package com.bucket.mission3.repository;

import com.bucket.mission3.mapper.AppRowMapper;
import com.bucket.mission3.config.SpringJdbcConfig;
import com.bucket.mission3.model.AppModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AppRepository {
    //Initialize Data source
    DataSource dataSource = new SpringJdbcConfig().mysqlDataSource();
    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    //Select ALL
    public List<AppModel> selectAll() {
        return jdbcTemplate.query("SELECT * FROM tbl_movie", new AppRowMapper());
    }

    //Select ONE by ID
    public List<AppModel> selectOne(Long id) {
        return jdbcTemplate.query("SELECT * FROM tbl_movie WHERE id = ?", new Object[]{id}, new AppRowMapper());
    }

    //Select ONE by TITLE
    public List<AppModel> selectByTitle(String title) {
        return jdbcTemplate.query("SELECT * FROM tbl_movie WHERE title = ?", new Object[]{title}, new AppRowMapper());
    }

    public int addNewMovie(AppModel movie) {
        return jdbcTemplate.update("INSERT INTO tbl_movie(id, title, director, genre, year) VALUES (?, ?, ?, ?, ?)", movie.getId(),
                movie.getTitle(), movie.getDirector(), movie.getGenre(), movie.getYear());
    }

    public int updateNewMovie(Long id, AppModel movie) {
        return jdbcTemplate.update("UPDATE tbl_movie set title = ?, director = ?, genre = ?, year = ? where id = ?",
                movie.getTitle(), movie.getDirector(), movie.getGenre(), movie.getYear(), id);
    }

    public int deleteExistMovie(Long id) {
        return jdbcTemplate.update("DELETE FROM tbl_movie WHERE id = ?", id);
    }
}
