package com.emaple.calenderproject.service;

import com.emaple.calenderproject.dto.ScheduleRequestDto;
import com.emaple.calenderproject.dto.ScheduleResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto);
    List<ScheduleResponseDto> findAllSchedules(String sortType);
    ScheduleResponseDto findScheduleById(Long id);
    ScheduleResponseDto updateSchedule(Long id, String name, String title, String contents, String modifiedDate);
    void deleteSchedule(Long id, String password);
}
