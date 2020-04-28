package com.bucket.mission3.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AppModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String director;
    private String genre;
    private String year;

}