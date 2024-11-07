package com.emaple.calenderproject.service;

import com.emaple.calenderproject.dto.ScheduleRequestDto;
import com.emaple.calenderproject.dto.ScheduleResponseDto;
import com.emaple.calenderproject.entity.Schedule;
import com.emaple.calenderproject.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule =
                new Schedule(scheduleRequestDto.getName(), scheduleRequestDto.getPassword(), scheduleRequestDto.getTitle(), scheduleRequestDto.getContents(), scheduleRequestDto.getCreateDate(), scheduleRequestDto.getModifiedDate());
        return scheduleRepository.createSchedule(schedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules(String sortSchedule) {
        return scheduleRepository.findAllSchedules(sortSchedule);
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        ScheduleResponseDto schedule = scheduleRepository.findScheduleById(id);

        return schedule;
    }

    @Override
    public ScheduleResponseDto updateSchedule(Long id, String name, String title, String contents, String modifiedDate) {
        return null;
    }

    @Override
    public void deleteSchedule(Long id, String password) {
        scheduleRepository.deleteSchedule(id, password);
    }
}
