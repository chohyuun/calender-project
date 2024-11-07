package com.emaple.calenderproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String name;
    private String password;
    private String title;
    private String contents;
    private String createDate;
    private String modifiedDate;

    public Schedule(String name, String password, String title, String contents, String createDate, String modifiedDate) {
        this.name = name;
        this.password = password;
        this.title = title;
        this.contents = contents;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public Schedule(String password) {
        this.password = password;
    }
}
