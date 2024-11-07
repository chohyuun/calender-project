package com.emaple.calenderproject.repository;

import com.emaple.calenderproject.dto.ScheduleResponseDto;
import com.emaple.calenderproject.entity.Schedule;

public interface ScheduleRepository {
    ScheduleResponseDto createSchedule(Schedule schedule);
}
