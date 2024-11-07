package com.emaple.calenderproject.service;

import com.emaple.calenderproject.dto.ScheduleRequestDto;
import com.emaple.calenderproject.dto.ScheduleResponseDto;
import com.emaple.calenderproject.entity.Schedule;
import com.emaple.calenderproject.repository.ScheduleRepository;
import org.springframework.stereotype.Service;


@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule =
                new Schedule(scheduleRequestDto.getName(), scheduleRequestDto.getPassword(), scheduleRequestDto.getCreateDate(), scheduleRequestDto.getModifiedDate(), scheduleRequestDto.getContents(), scheduleRequestDto.getTitle());
        return scheduleRepository.createSchedule(schedule);
    }
}
