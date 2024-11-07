package com.emaple.calenderproject.repository;
import com.emaple.calenderproject.dto.ScheduleResponseDto;
import com.emaple.calenderproject.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {
    ScheduleResponseDto createSchedule(Schedule schedule);
    List<ScheduleResponseDto> findAllSchedules(String sortSchedule);
    ScheduleResponseDto findScheduleById(Long id);
    void updateSchedule(Long id, String name, String title, String contents, String modifiedDate, String password);
    void deleteSchedule(Long id, String password);
}
