package com.bucket.mission3.mapper;

import com.bucket.mission3.model.AppModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppRowMapper implements RowMapper<AppModel> {
    @Override
    public AppModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        AppModel movie = new AppModel();

        movie.setId(rs.getLong("id"));
        movie.setTitle(rs.getString("title"));
        movie.setDirector(rs.getString("director"));
        movie.setGenre(rs.getString("genre"));
        movie.setYear(rs.getString("year"));

        return movie;
    }
}
