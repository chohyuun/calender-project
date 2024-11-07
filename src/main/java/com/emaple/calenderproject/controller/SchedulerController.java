package com.emaple.calenderproject.controller;

import com.emaple.calenderproject.dto.ScheduleRequestDto;
import com.emaple.calenderproject.dto.ScheduleResponseDto;
import com.emaple.calenderproject.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
public class SchedulerController {
    private final ScheduleService scheduleService;

    public SchedulerController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.createSchedule(requestDto), HttpStatus.CREATED);
    }

}
