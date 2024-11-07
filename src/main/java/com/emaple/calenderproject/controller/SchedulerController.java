package com.emaple.calenderproject.controller;

import com.emaple.calenderproject.dto.ScheduleRequestDto;
import com.emaple.calenderproject.dto.ScheduleResponseDto;
import com.emaple.calenderproject.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class SchedulerController {
    private final ScheduleService scheduleService;
    private final String[] sortSchedule = {"modified_date", "name"};

    public SchedulerController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // POST: 새로운 스케줄 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.createSchedule(requestDto), HttpStatus.CREATED);
    }

    // GET: 전체 일정 조회
    // query String: modified_date, name, modifiedDate&name
    @GetMapping
    public List<ScheduleResponseDto> getAllSchedules(@RequestParam(defaultValue = "modified_date") String sort) {
        return scheduleService.findAllSchedules(sort);
    }

    // GET: 단건 조회
    @GetMapping("/{id}")
    public ScheduleResponseDto getSchedule(@PathVariable Long id) {
        scheduleService.findScheduleById(id);
        return scheduleService.findScheduleById(id);
    }

    // PATCH: 일정 수정
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.updateSchedule(id, requestDto.getName(), requestDto.getTitle(), requestDto.getContents(), requestDto.getModifiedDate(), requestDto.getPassword()), HttpStatus.OK);
    }

    // DELETE: 일정 삭제
    @DeleteMapping("/{id}")
    public void deleteSchedule(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto
    ) {
        scheduleService.deleteSchedule(id, requestDto.getPassword());
    }
}
