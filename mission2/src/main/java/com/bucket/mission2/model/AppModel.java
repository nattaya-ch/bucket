package com.bucket.mission2.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AppModel {
    private String id ;
    private String title;
    private String director;
    private String genre;
    private String year;

}