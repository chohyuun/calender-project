package com.emaple.calenderproject.repository;

import com.emaple.calenderproject.dto.ScheduleResponseDto;
import com.emaple.calenderproject.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcTemplateScheduleRepository implements ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ScheduleResponseDto createSchedule(Schedule schedule) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        Date now = new Date();
        String dateString = dateFormat.format(now);
        Timestamp dateParse = Timestamp.valueOf(dateString);

        insert.withTableName("schedule").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("name", schedule.getName());
        parameters.put("password", schedule.getPassword());
        parameters.put("title", schedule.getTitle());
        parameters.put("contents", schedule.getContents());
        parameters.put("create_date", dateParse);
        parameters.put("modified_date", dateParse);

        Number id = insert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new ScheduleResponseDto(id.longValue(), schedule.getName(), schedule.getCreateDate(), schedule.getModifiedDate(), schedule.getTitle(), schedule.getContents());
    }
}
