package com.emaple.calenderproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ScheduleRequestDto {
    private String name;
    private String password;
    private String title;
    private String contents;
    private String createDate;
    private String modifiedDate;
}
