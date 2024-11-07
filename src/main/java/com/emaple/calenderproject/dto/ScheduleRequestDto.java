package com.emaple.calenderproject.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String name;
    private String password;
    private String createDate;
    private String modifiedDate;
    private String title;
    private String contents;
}
