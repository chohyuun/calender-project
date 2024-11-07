package com.emaple.calenderproject.repository;
import com.emaple.calenderproject.dto.ScheduleResponseDto;
import com.emaple.calenderproject.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {
    ScheduleResponseDto createSchedule(Schedule schedule);

    List<ScheduleResponseDto> findAllSchedules(String sortSchedule);

    ScheduleResponseDto findScheduleById(Long id);

    Schedule updateSchedule(Schedule schedule);

    void deleteSchedule(Long id, String password);
}
