package com.emaple.calenderproject.service;

import com.emaple.calenderproject.dto.ScheduleRequestDto;
import com.emaple.calenderproject.dto.ScheduleResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ScheduleService {
    ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto);
}
