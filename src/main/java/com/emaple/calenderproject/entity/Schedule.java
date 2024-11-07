package com.emaple.calenderproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String name;
    private String password;
    private String createDate;
    private String modifiedDate;
    private String title;
    private String contents;

    public Schedule(String name, String password, String createDate, String modifiedDate, String title, String contents) {
        this.name = name;
        this.password = password;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.title = title;
        this.contents = contents;
    }
}
